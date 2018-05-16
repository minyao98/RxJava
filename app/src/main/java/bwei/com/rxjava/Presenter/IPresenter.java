package bwei.com.rxjava.Presenter;

import java.util.List;

import bwei.com.rxjava.Model.BeanUtils.NBABean;
import bwei.com.rxjava.Model.IModel;
import bwei.com.rxjava.View.IMainView;

public interface IPresenter {
    void formDateToJsonView(IModel iModel, IMainView iMainView);

    void getJsonSuccess(List<NBABean.NewslistBean> newslist);

    void getJsonError(String error);
}
