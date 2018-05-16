package bwei.com.rxjava.View;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import bwei.com.rxjava.Model.BeanUtils.NBABean;
import bwei.com.rxjava.Model.ModelImpl;
import bwei.com.rxjava.Model.MyAdapter;
import bwei.com.rxjava.Presenter.PresenterImpl;
import bwei.com.rxjava.R;

public class MainActivity extends AppCompatActivity implements IMainView {

    private static final String TAG = "MainActivity===";
    private XRecyclerView xrecyclerview;
    private int num = 10;
    private MyAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }



    private void initView() {
        xrecyclerview = (XRecyclerView) findViewById(R.id.XRecyclerView);
        xrecyclerview.setLayoutManager(new LinearLayoutManager(this));
        xrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                num++;
                initData();
                adapter.notifyDataSetChanged();
                xrecyclerview.refreshComplete();
            }

            @Override
            public void onLoadMore() {
                num++;
                initData();
                adapter.notifyDataSetChanged();
                xrecyclerview.loadMoreComplete();
            }
        });
    }

    private void initData() {
        PresenterImpl presenter = new PresenterImpl();
        presenter.formDateToJsonView(new ModelImpl(presenter),this);
    }

    @Override
    public void getJsonToViewSuccess(List<NBABean.NewslistBean> list) {
        adapter = new MyAdapter(MainActivity.this,list);
        xrecyclerview.setAdapter(adapter);
    }

    @Override
    public void getJsonToViewError(String error) {
        Log.d(TAG, "getJsonToViewError: "+error);
    }

    @Override
    public String getNum() {
        return num+"";
    }
}
