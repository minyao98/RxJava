package bwei.com.rxjava.Http;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.android.plugins.RxAndroidPlugins;

/**
 * Created by ASUS on 2018/5/16.
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils = null;
    private final Retrofit retrofit;

    public static RetrofitUtils getRetrofitUtils(){
        if (retrofitUtils==null){
            retrofitUtils = new RetrofitUtils();
        }
        return retrofitUtils;
    }
    public RetrofitUtils(){
        retrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.nba_url)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }


    public <T> T createRequest(Class<T> clz){
        T t = retrofit.create(clz);
        return t;
    }

}
