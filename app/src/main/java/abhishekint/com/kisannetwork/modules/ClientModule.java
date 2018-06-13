package abhishekint.com.kisannetwork.modules;

import android.content.Context;

import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Model.TabOneJsonClient;
import abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.Model.DataTab2;
import abhishekint.com.kisannetwork.sqlite_database.SqLiteHelper;
import abhishekint.com.kisannetwork.utils.JsonToString;
import abhishekint.com.kisannetwork.utils.SixDigitRandomNo;
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

    @Provides
    SixDigitRandomNo providesRandomNoObject()
    {
        return new SixDigitRandomNo();
    }

    @Provides
    DataTab2 providesJsonList(SqLiteHelper sqLiteHelper)
    {
        return new DataTab2(sqLiteHelper);
    }
}
