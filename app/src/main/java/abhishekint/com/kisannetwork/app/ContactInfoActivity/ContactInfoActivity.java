package abhishekint.com.kisannetwork.app.ContactInfoActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import abhishekint.com.kisannetwork.R;
import abhishekint.com.kisannetwork.app.ComposeActivity.ComposeActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.Component;

/**
 * Created by abhishek on 10-06-2018.
 */

public class ContactInfoActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.activity_contactinfo_name)
    TextView activity_contactinfo_name;
    @BindView(R.id.activity_contactinfo_phone)
    TextView activity_contactinfo_phone;
    @BindView(R.id.activity_contactinfo_btn)
    Button activity_contactinfo_btn;
    Unbinder unbinder;
    String firstname,lastname;
    Long phone;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactinfo);
        unbinder= ButterKnife.bind(this);
        getIntentValues();
        setTextValues();
        setBtnOnClick();
    }

    private void setTextValues() {
        activity_contactinfo_name.setText(firstname+" "+lastname);
        activity_contactinfo_phone.setText(""+phone);
    }

    private void setBtnOnClick() {
        activity_contactinfo_btn.setOnClickListener(this);
    }

    private void getIntentValues() {
        firstname=getIntent().getStringExtra("firstname");
        lastname=getIntent().getStringExtra("lastname");
        phone=getIntent().getLongExtra("phoneno",0);
    }

    @Override
    public void onClick(View view) {
        Intent intent=new Intent(ContactInfoActivity.this, ComposeActivity.class);
        intent.putExtra("phoneno",phone);
        intent.putExtra("firstname",firstname);
        intent.putExtra("lastname",lastname);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
