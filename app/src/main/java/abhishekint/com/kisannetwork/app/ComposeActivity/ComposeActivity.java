package abhishekint.com.kisannetwork.app.ComposeActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import abhishekint.com.kisannetwork.MainApplication;
import abhishekint.com.kisannetwork.R;
import abhishekint.com.kisannetwork.utils.SixDigitRandomNo;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by abhishek on 10-06-2018.
 */

public class ComposeActivity extends AppCompatActivity implements ComposeActivityInterface {
    @BindView(R.id.activity_compose_btn)
    Button activity_compose_btn;
    @BindView(R.id.activity_compose_tv)
    TextView activity_compose_tv;

    @Inject
    SixDigitRandomNo sixDigitRandomNo;

    Unbinder unbinder;
    ComposePresenterInterface composePresenterInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        ((MainApplication)getApplicationContext()).getModuleComponent().composeActivity(this);
        unbinder= ButterKnife.bind(this);
        initPresenter();
    }

    private void initPresenter() {
        composePresenterInterface=new ComposeActivityPresenter(sixDigitRandomNo,this);
        composePresenterInterface.getOTP();
    }


    @Override
    public void setText(int otp) {
        activity_compose_tv.setText("Hi. Your OTP is: "+otp);
    }
}
