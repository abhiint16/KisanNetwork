package abhishekint.com.kisannetwork.app.LandingActivity.MainActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import abhishekint.com.kisannetwork.R;
import butterknife.BindView;

/**
 * Created by abhishek on 09-06-2018.
 */

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.main_activity_tab)
    TabLayout tabLayout;
    @BindView(R.id.main_activity_viewpager)
    ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
}
