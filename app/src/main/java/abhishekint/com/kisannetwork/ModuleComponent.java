package abhishekint.com.kisannetwork;

import abhishekint.com.kisannetwork.app.ComposeActivity.ComposeActivity;
import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.FirstTabFragment;
import abhishekint.com.kisannetwork.modules.ApplicationContext;
import abhishekint.com.kisannetwork.modules.ClientModule;
import dagger.Component;

/**
 * Created by abhishek on 09-06-2018.
 */

@Component(modules = {ApplicationContext.class, ClientModule.class})
public interface ModuleComponent {
    void tabOne(FirstTabFragment firstTabFragment);
    void composeActivity(ComposeActivity composeActivity);
}
