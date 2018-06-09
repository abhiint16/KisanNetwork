package abhishekint.com.kisannetwork;

import android.app.Application;

import abhishekint.com.kisannetwork.modules.ApplicationContext;

/**
 * Created by abhishek on 09-06-2018.
 */

public class MainApplication extends Application{
    ModuleComponent moduleComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        moduleComponent=DaggerModuleComponent.builder()
                .applicationContext(new ApplicationContext(this)).build();
    }

    public ModuleComponent getModuleComponent() {
        return moduleComponent;
    }
}
