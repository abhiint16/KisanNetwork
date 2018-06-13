package abhishekint.com.kisannetwork.app.ComposeActivity;

import android.app.Activity;
import android.content.Context;

import java.util.Calendar;
import java.util.Date;

import abhishekint.com.kisannetwork.sqlite_database.SqLiteHelper;
import abhishekint.com.kisannetwork.utils.SixDigitRandomNo;

/**
 * Created by abhishek on 10-06-2018.
 */

public class ComposeActivityPresenter implements ComposePresenterInterface {
    SixDigitRandomNo sixDigitRandomNo;
    ComposeActivityInterface composeActivityInterface;
    SqLiteHelper sqLiteHelper;
    public ComposeActivityPresenter(SixDigitRandomNo sixDigitRandomNo, ComposeActivityInterface composeActivityInterface,
                                    SqLiteHelper sqLiteHelper) {
        this.sixDigitRandomNo = sixDigitRandomNo;
        this.composeActivityInterface = composeActivityInterface;
        this.sqLiteHelper=sqLiteHelper;
    }

    @Override
    public void getOTP() {
        int randmOtp = sixDigitRandomNo.getRandomOTP();
        composeActivityInterface.setText(randmOtp);
    }

    @Override
    public void saveData(Context context, int otp, String name) {
        sqLiteHelper.insertAll(name,Integer.toString(otp));
    }

}
