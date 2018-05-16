package bwei.com.rxjava.Http;

import java.util.Map;

import bwei.com.rxjava.Model.BeanUtils.NBABean;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by ASUS on 2018/5/16.
 */

public interface RetrofitService {
    @POST("nba")
    Observable<NBABean> getRequest(@QueryMap Map<String, String> params);
}
