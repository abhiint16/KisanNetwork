package abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import abhishekint.com.kisannetwork.R;
import butterknife.BindView;

/**
 * Created by abhishek on 09-06-2018.
 */

public class FirstTabFragment extends Fragment {
    @BindView(R.id.common_recycler)
    RecyclerView recyclerView;

    RecyclerView.LayoutManager layoutManager;
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.recyclerview_common,container,false);
        initLayoutManager();
        initRecycler();
        return view;
    }

    private void initLayoutManager() {
        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
    }

    private void initRecycler() {
        recyclerView.setLayoutManager(layoutManager);
    }
}
