package abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.Model;

import android.content.Context;

import java.util.List;

import abhishekint.com.kisannetwork.sqlite_database.SqLiteHelper;
import abhishekint.com.kisannetwork.sqlite_database.SqlLiteInit;
import io.reactivex.Observable;

/**
 * Created by abhishek on 10-06-2018.
 */

public class DataTab2 {
    SqLiteHelper sqLiteHelper;
    public DataTab2(SqLiteHelper sqLiteHelper) {
        this.sqLiteHelper=sqLiteHelper;
    }

    public Observable<List<SqlLiteInit>> getData()
    {
        List<SqlLiteInit> sqlLiteInits=sqLiteHelper.getAllData();
        return Observable.just(sqlLiteInits);
    }
}
