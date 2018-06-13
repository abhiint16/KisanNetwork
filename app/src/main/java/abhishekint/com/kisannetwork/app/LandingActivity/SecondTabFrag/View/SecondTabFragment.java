package abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.View;

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
import abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.Model.DataTab2;
import abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.View.Adapter.SecondTabAdapter;
import abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.Presenter.SecondTabPresenter;
import abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.Presenter.SecondTabPresenterInterface;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by abhishek on 09-06-2018.
 */

public class SecondTabFragment extends Fragment {
    @BindView(R.id.common_recycler)
    RecyclerView recyclerView;

    @Inject
    DataTab2 dataTab2;

    RecyclerView.LayoutManager layoutManager;
    SecondTabPresenterInterface secondTabPresenterInterface;
    SecondTabAdapter secondTabAdapter;

    View view;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recyclerview_common, container, false);
        unbinder=ButterKnife.bind(this,view);
        ((MainApplication)getActivity().getApplicationContext()).getModuleComponent().tabTwo(this);
        initPresenter();
        initRecyclerAdapter();
        initRecycler();
        getAdapterData();
        return view;
    }

    private void getAdapterData() {
        secondTabPresenterInterface.getRecyclerData(secondTabAdapter);
    }

    private void initRecycler() {
        layoutManager=new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(secondTabAdapter);
    }

    private void initRecyclerAdapter() {
        secondTabAdapter=new SecondTabAdapter(secondTabPresenterInterface);
    }

    private void initPresenter() {
        secondTabPresenterInterface=new SecondTabPresenter(dataTab2);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
