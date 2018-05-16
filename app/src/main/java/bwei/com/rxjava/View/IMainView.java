package bwei.com.rxjava.View;

import java.util.List;

import bwei.com.rxjava.Model.BeanUtils.NBABean;

public interface IMainView {
    void getJsonToViewSuccess(List<NBABean.NewslistBean> newslist);

    void getJsonToViewError(String error);

    String getNum();
}
