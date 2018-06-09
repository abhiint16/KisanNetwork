package abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag;

import android.content.Context;

import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Model.Data;
import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Model.TabOneJsonClient;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abhishek on 09-06-2018.
 */

public class FirstTabFragPresenter implements FirstTabFragPresenterInterface {
    TabOneJsonClient tabOneJsonClient;

    public FirstTabFragPresenter(TabOneJsonClient tabOneJsonClient) {
        this.tabOneJsonClient = tabOneJsonClient;
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

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
