package bwei.com.rxjava.Presenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bwei.com.rxjava.Model.BeanUtils.NBABean;
import bwei.com.rxjava.Model.IModel;
import bwei.com.rxjava.View.IMainView;

public class PresenterImpl implements IPresenter{

    private IMainView iMainView;

    @Override
    public void formDateToJsonView(IModel iModel, IMainView iMainView) {
        this.iMainView = iMainView;
        Map<String,String> params = new HashMap<>();
        params.put("key","71e58b5b2f930eaf1f937407acde08fe");
        params.put("num",iMainView.getNum());
        iModel.getJsonDateForm(null,params);
    }

    @Override
    public void getJsonSuccess(List<NBABean.NewslistBean> newslist) {
        iMainView.getJsonToViewSuccess(newslist);
    }

    @Override
    public void getJsonError(String error) {
        iMainView.getJsonToViewError(error);
    }
}
