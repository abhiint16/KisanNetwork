package abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Presenter;

import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.View.Adapter.AdapterViewLayer;
import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Model.Data;
import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Model.TabOneJsonClient;
import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.View.FirstTabFragmentInterface;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abhishek on 09-06-2018.
 */

public class FirstTabFragPresenter implements FirstTabFragPresenterInterface {
    TabOneJsonClient tabOneJsonClient;
    FirstTabFragmentInterface firstTabFragmentInterface;

    public FirstTabFragPresenter(TabOneJsonClient tabOneJsonClient,FirstTabFragmentInterface firstTabFragmentInterface) {
        this.tabOneJsonClient = tabOneJsonClient;
        this.firstTabFragmentInterface=firstTabFragmentInterface;
    }

    @Override
    public void getJsonDataForTabOne(final AdapterViewLayer adapterViewLayer) {
        tabOneJsonClient.getData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Data>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(Data data) {
                        adapterViewLayer.getBackData(data);
                    }

                    @Override
                    public void onError(Throwable e) {
                        firstTabFragmentInterface.makeToast(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
