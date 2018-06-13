package abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.Presenter;

import java.util.List;

import abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.Model.DataTab2;
import abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.View.Adapter.SecondViewLayer;
import abhishekint.com.kisannetwork.sqlite_database.SqlLiteInit;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by abhishek on 10-06-2018.
 */

public class SecondTabPresenter implements SecondTabPresenterInterface {
    DataTab2 dataTab2;

    public SecondTabPresenter(DataTab2 dataTab2) {
        this.dataTab2 = dataTab2;
    }

    @Override
    public void getRecyclerData(final SecondViewLayer viewLayer) {
        dataTab2.getData()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<List<SqlLiteInit>>() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onNext(List<SqlLiteInit> sqlLiteInits) {
                viewLayer.updateData(sqlLiteInits);
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
