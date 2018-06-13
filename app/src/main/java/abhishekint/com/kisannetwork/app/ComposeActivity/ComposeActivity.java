package abhishekint.com.kisannetwork.app.ComposeActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.inject.Inject;

import abhishekint.com.kisannetwork.MainApplication;
import abhishekint.com.kisannetwork.R;
import abhishekint.com.kisannetwork.sqlite_database.SqLiteHelper;
import abhishekint.com.kisannetwork.utils.SixDigitRandomNo;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by abhishek on 10-06-2018.
 */

public class ComposeActivity extends AppCompatActivity implements ComposeActivityInterface, View.OnClickListener {
    @BindView(R.id.activity_compose_btn)
    Button activity_compose_btn;
    @BindView(R.id.activity_compose_tv)
    TextView activity_compose_tv;

    @Inject
    SixDigitRandomNo sixDigitRandomNo;
    @Inject
    SqLiteHelper sqLiteHelper;

    Unbinder unbinder;
    ComposePresenterInterface composePresenterInterface;
    int otp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compose);
        ((MainApplication)getApplicationContext()).getModuleComponent().composeActivity(this);
        unbinder= ButterKnife.bind(this);
        initPresenter();
        setBtnOnClick();
    }

    private void setBtnOnClick() {
        activity_compose_btn.setOnClickListener(this);
    }

    private void initPresenter() {
        composePresenterInterface=new ComposeActivityPresenter(sixDigitRandomNo,this,sqLiteHelper);
        composePresenterInterface.getOTP();
    }


    @Override
    public void setText(int otp) {
        this.otp=otp;
        activity_compose_tv.setText("Hi. Your OTP is: "+otp);
    }

    public void resultOnSuccess() {
        composePresenterInterface.saveData(getApplicationContext(),otp,getIntent().getStringExtra("firstname")+" "+
                getIntent().getStringExtra("lastname"));
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + getIntent().getLongExtra("phoneno",0)));
        intent.putExtra("sms_body", "Hi. Your OTP is: "+otp);
        startActivity(intent);
        resultOnSuccess();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
