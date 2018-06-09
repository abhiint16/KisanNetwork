package abhishekint.com.kisannetwork.modules;

import android.content.Context;

import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Model.TabOneJsonClient;
import abhishekint.com.kisannetwork.utils.JsonToString;
import dagger.Module;
import dagger.Provides;

/**
 * Created by abhishek on 09-06-2018.
 */

@Module
public class ClientModule {

    @Provides
    TabOneJsonClient providesClient(Context context) {
        return new TabOneJsonClient(new JsonToString(context));
    }
}
