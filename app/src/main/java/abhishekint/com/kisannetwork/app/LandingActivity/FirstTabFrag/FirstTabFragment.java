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

import javax.inject.Inject;

import abhishekint.com.kisannetwork.MainApplication;
import abhishekint.com.kisannetwork.R;
import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Model.TabOneJsonClient;
import abhishekint.com.kisannetwork.modules.ApplicationContext;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by abhishek on 09-06-2018.
 */

public class FirstTabFragment extends Fragment {
    @BindView(R.id.common_recycler)
    RecyclerView recyclerView;

    @Inject
    TabOneJsonClient tabOneJsonClient;

    RecyclerView.LayoutManager layoutManager;
    FirstTabFragPresenterInterface firstTabFragPresenterInterface;
    FirstTabFragmentRecyclerAdapter firstTabFragmentRecyclerAdapter;
    View view;
    Unbinder unbinder;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.recyclerview_common,container,false);
        ((MainApplication)getActivity().getApplicationContext()).getModuleComponent().tabOne(this);
        unbinder= ButterKnife.bind(this,view);
        initLayoutManager();
        initPresenter();
        initRecyclerAdapter();
        initRecycler();
        getJsonData();
        return view;
    }

    private void getJsonData() {
        firstTabFragPresenterInterface.getJsonDataForTabOne(firstTabFragmentRecyclerAdapter);
    }

    private void initRecyclerAdapter() {
        firstTabFragmentRecyclerAdapter=new FirstTabFragmentRecyclerAdapter(firstTabFragPresenterInterface,getActivity());
    }

    private void initPresenter() {
        firstTabFragPresenterInterface=new FirstTabFragPresenter(tabOneJsonClient);
    }

    private void initLayoutManager() {
        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
    }

    private void initRecycler() {
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(firstTabFragmentRecyclerAdapter);
    }

    @Override
    public void onStop() {
        super.onStop();
        unbinder.unbind();
    }
}
