package abhishekint.com.kisannetwork.modules;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by abhishek on 09-06-2018.
 */

@Module
public class ApplicationContext {
    Context applicationContext;

    public ApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Provides
    public Context getApplicationContext() {
        return applicationContext;
    }
}
