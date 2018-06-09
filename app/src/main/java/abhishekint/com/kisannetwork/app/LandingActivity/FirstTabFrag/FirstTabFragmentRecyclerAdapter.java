package abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import abhishekint.com.kisannetwork.R;
import abhishekint.com.kisannetwork.app.ContactInfoActivity.ContactInfoActivity;
import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Model.Data;

/**
 * Created by abhishek on 09-06-2018.
 */

public class FirstTabFragmentRecyclerAdapter extends RecyclerView.Adapter<FirstTabFragmentRecyclerAdapter.ViewHolder> implements AdapterViewLayer {
    FirstTabFragPresenterInterface firstTabFragPresenterInterface;
    Data data;
    Context context;

    public FirstTabFragmentRecyclerAdapter(FirstTabFragPresenterInterface firstTabFragPresenterInterface, Context context) {
        this.firstTabFragPresenterInterface = firstTabFragPresenterInterface;
        this.context=context;
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView item_first_tab_recycler_tv;
        public ViewHolder(View itemView) {
            super(itemView);
            item_first_tab_recycler_tv=itemView.findViewById(R.id.item_first_tab_recycler_tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent=new Intent(context, ContactInfoActivity.class);
            intent.putExtra("firstname",data.getFirstname().get(getAdapterPosition()));
            intent.putExtra("lastname",data.getLastname().get(getAdapterPosition()));
            intent.putExtra("phoneno",data.getPhone().get(getAdapterPosition()));
            context.startActivity(intent);
        }
    }
}
