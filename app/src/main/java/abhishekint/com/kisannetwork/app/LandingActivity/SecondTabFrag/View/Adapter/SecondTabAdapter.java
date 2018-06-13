package abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.View.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import abhishekint.com.kisannetwork.R;
import abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.Presenter.SecondTabPresenterInterface;
import abhishekint.com.kisannetwork.sqlite_database.SqlLiteInit;

/**
 * Created by abhishek on 10-06-2018.
 */

public class SecondTabAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements SecondViewLayer{
    SecondTabPresenterInterface secondTabPresenterInterface;
    List<SqlLiteInit> sqlLiteInits;

    public SecondTabAdapter(SecondTabPresenterInterface secondTabPresenterInterface) {
        this.secondTabPresenterInterface = secondTabPresenterInterface;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==0)
        {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_second_tab_recycler_nodata,parent,false);
            return new ViewHolder0(view);
        }
        else
        {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_second_tab_recycler,parent,false);
            return new ViewHolder1(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType()==1)
        {
            ((ViewHolder1)holder).item_sec_tab_recycler_name.setText(sqlLiteInits.get(position).getName());
            ((ViewHolder1)holder).item_sec_tab_recycler_otp.setText(sqlLiteInits.get(position).getOtp());
            ((ViewHolder1)holder).item_sec_tab_recycler_time.setText(sqlLiteInits.get(position).getTimestamp());
        }
    }

    @Override
    public int getItemCount() {
        return (sqlLiteInits!=null&&sqlLiteInits.size()!=0)?sqlLiteInits.size():1;
    }

    @Override
    public int getItemViewType(int position) {
        if (sqlLiteInits==null||sqlLiteInits.size()==0)
            return 0;
        else return 1;
    }

    @Override
    public void updateData(List<SqlLiteInit> sqlLiteInits) {
        this.sqlLiteInits=sqlLiteInits;
        notifyDataSetChanged();
    }

    public class ViewHolder0 extends RecyclerView.ViewHolder {
        public ViewHolder0(View itemView) {
            super(itemView);
        }
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {
        TextView item_sec_tab_recycler_name,item_sec_tab_recycler_otp,item_sec_tab_recycler_time;
        public ViewHolder1(View itemView) {
            super(itemView);
            item_sec_tab_recycler_name=(TextView)itemView.findViewById(R.id.item_sec_tab_recycler_name);
            item_sec_tab_recycler_otp=(TextView)itemView.findViewById(R.id.item_sec_tab_recycler_otp);
            item_sec_tab_recycler_time=(TextView)itemView.findViewById(R.id.item_sec_tab_recycler_time);
        }
    }
}
