package abhishekint.com.kisannetwork.app.ComposeActivity;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;

import abhishekint.com.kisannetwork.utils.SixDigitRandomNo;

/**
 * Created by abhishek on 10-06-2018.
 */

public class ComposeActivityPresenter implements ComposePresenterInterface {
    SixDigitRandomNo sixDigitRandomNo;
    ComposeActivityInterface composeActivityInterface;

    public ComposeActivityPresenter(SixDigitRandomNo sixDigitRandomNo, ComposeActivityInterface composeActivityInterface) {
        this.sixDigitRandomNo = sixDigitRandomNo;
        this.composeActivityInterface = composeActivityInterface;
    }

    @Override
    public void getOTP() {
        int randmOtp = sixDigitRandomNo.getRandomOTP();
        composeActivityInterface.setText(randmOtp);
    }
}
