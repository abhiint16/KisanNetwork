package abhishekint.com.kisannetwork.modules;

import android.content.Context;

import abhishekint.com.kisannetwork.sqlite_database.SqLiteHelper;
import dagger.Module;
import dagger.Provides;

/**
 * Created by abhishek on 10-06-2018.
 */

@Module
public class SqliteModule {

    @Provides
    public SqLiteHelper providesSqliteContext(Context context)
    {
        return new SqLiteHelper(context);
    }
}
