package abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by abhishek on 09-06-2018.
 */

public class FirstTabFragmentRecyclerAdapter extends RecyclerView.Adapter<FirstTabFragmentRecyclerAdapter.ViewHolder> implements AdapterViewLayer {
    FirstTabFragPresenterInterface firstTabFragPresenterInterface;

    public FirstTabFragmentRecyclerAdapter(FirstTabFragPresenterInterface firstTabFragPresenterInterface) {
        this.firstTabFragPresenterInterface = firstTabFragPresenterInterface;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
