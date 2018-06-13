package abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.View.Adapter;

import java.util.List;

import abhishekint.com.kisannetwork.sqlite_database.SqlLiteInit;

/**
 * Created by abhishek on 10-06-2018.
 */

public interface SecondViewLayer {
    void updateData(List<SqlLiteInit> sqlLiteInits);
}
