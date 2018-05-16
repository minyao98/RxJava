package bwei.com.rxjava.Model;

import android.util.Log;

import java.util.Map;

import bwei.com.rxjava.Http.RetrofitService;
import bwei.com.rxjava.Http.RetrofitUtils;
import bwei.com.rxjava.Model.BeanUtils.NBABean;
import bwei.com.rxjava.Presenter.IPresenter;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ModelImpl implements IModel{

    public static final String TAG = "ModelImpl====";
    private final IPresenter iPresenter;

    public ModelImpl(IPresenter iPresenter) {
        this.iPresenter = iPresenter;
    }


    @Override
    public void getJsonDateForm(String url, Map<String, String> params) {
        RetrofitUtils retrofitUtils = RetrofitUtils.getRetrofitUtils();
        RetrofitService service = retrofitUtils.createRequest(RetrofitService.class);
        rx.Observable<NBABean> observable = service.getRequest(params);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<NBABean>() {


                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, "onError: "+e.getMessage());
                        iPresenter.getJsonError(e.getMessage());
                    }

                    @Override
                    public void onNext(NBABean nbaBean) {
                        Log.d(TAG, "onNext: "+nbaBean.getMsg());
                        iPresenter.getJsonSuccess(nbaBean.getNewslist());
                    }
                });
    }
}
