package abhishekint.com.kisannetwork.app.ComposeActivity;

import android.content.Context;

/**
 * Created by abhishek on 10-06-2018.
 */

public interface ComposePresenterInterface {
    void getOTP();
    void saveData(Context context,int otp,String name);
}
