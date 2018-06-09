package abhishekint.com.kisannetwork.app.LandingActivity.MainActivity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.FirstTabFragment;
import abhishekint.com.kisannetwork.app.LandingActivity.SecondTabFrag.SecondTabFragment;

/**
 * Created by abhishek on 09-06-2018.
 */

public class MainAdapter extends FragmentStatePagerAdapter {

    List<String> list=new ArrayList<>();

    public MainAdapter(FragmentManager fm) {
        super(fm);
        list.add("First Tab");
        list.add("Second Tab");
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            FirstTabFragment firstTabFragment=new FirstTabFragment();
            return  firstTabFragment;
        } else if (position == 1) {
            SecondTabFragment secondTabFragment=new SecondTabFragment();
            return  secondTabFragment;
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
