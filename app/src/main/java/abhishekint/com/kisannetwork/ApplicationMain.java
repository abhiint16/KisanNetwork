package abhishekint.com.kisannetwork;

import android.app.Application;

/**
 * Created by abhishek on 09-06-2018.
 */

public class ApplicationMain extends Application{
    ModuleComponent moduleComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        moduleComponent=DaggerModuleComponent.builder().build();
    }
}
