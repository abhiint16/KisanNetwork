package abhishekint.com.kisannetwork;

import abhishekint.com.kisannetwork.app.ComposeActivity.ComposeActivity;
import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.View.FirstTabFragment;
import abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.View.SecondTabFragment;
import abhishekint.com.kisannetwork.modules.ApplicationContext;
import abhishekint.com.kisannetwork.modules.ClientModule;
import abhishekint.com.kisannetwork.modules.SqliteModule;
import dagger.Component;

/**
 * Created by abhishek on 09-06-2018.
 */

@Component(modules = {ApplicationContext.class, ClientModule.class, SqliteModule.class})
public interface ModuleComponent {
    void tabOne(FirstTabFragment firstTabFragment);
    void tabTwo(SecondTabFragment secondTabFragment);
    void composeActivity(ComposeActivity composeActivity);
}
