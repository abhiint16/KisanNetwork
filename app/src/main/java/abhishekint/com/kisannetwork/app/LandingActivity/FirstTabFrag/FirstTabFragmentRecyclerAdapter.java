package abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import abhishekint.com.kisannetwork.R;
import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Model.Data;

/**
 * Created by abhishek on 09-06-2018.
 */

public class FirstTabFragmentRecyclerAdapter extends RecyclerView.Adapter<FirstTabFragmentRecyclerAdapter.ViewHolder> implements AdapterViewLayer {
    FirstTabFragPresenterInterface firstTabFragPresenterInterface;
    Data data;

    public FirstTabFragmentRecyclerAdapter(FirstTabFragPresenterInterface firstTabFragPresenterInterface) {
        this.firstTabFragPresenterInterface = firstTabFragPresenterInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_first_tab_recycler,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.item_first_tab_recycler_tv.setText(data.getFirstname().get(position)+" "+data.getLastname().get(position));
    }

    @Override
    public int getItemCount() {
        return data==null?0:data.getFirstname().size();
    }

    @Override
    public void getBackData(Data data) {
        this.data=data;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView item_first_tab_recycler_tv;
        public ViewHolder(View itemView) {
            super(itemView);
            item_first_tab_recycler_tv=itemView.findViewById(R.id.item_first_tab_recycler_tv);
        }
    }
}
