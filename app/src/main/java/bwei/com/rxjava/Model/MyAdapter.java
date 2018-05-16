package bwei.com.rxjava.Model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import bwei.com.rxjava.Model.BeanUtils.NBABean;
import bwei.com.rxjava.R;
import bwei.com.rxjava.View.MainActivity;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    private final List<NBABean.NewslistBean> list;

    public MyAdapter(Context context, List<NBABean.NewslistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.xrecycler_item,null);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String picUrl = list.get(position).getPicUrl();
        holder.getItem_simple().setImageURI(picUrl);
        holder.getItem_count().setText(list.get(position).getTitle());
        holder.getItem_time().setText(list.get(position).getCtime());
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder{

        private final SimpleDraweeView item_simple;
        private final TextView item_count;
        private final TextView item_time;

        public MyViewHolder(View itemView) {
            super(itemView);
            item_simple = itemView.findViewById(R.id.item_simple);
            item_count = itemView.findViewById(R.id.item_count);
            item_time = itemView.findViewById(R.id.item_time);
        }

        public SimpleDraweeView getItem_simple() {
            return item_simple;
        }

        public TextView getItem_count() {
            return item_count;
        }

        public TextView getItem_time() {
            return item_time;
        }
    }
}
