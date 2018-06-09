package abhishekint.com.kisannetwork.utils;

import java.util.Random;

/**
 * Created by abhishek on 10-06-2018.
 */

public class SixDigitRandomNo {

    public int getRandomOTP()
    {
        Random rnd = new Random();
        int n = 100000 + rnd.nextInt(900000);
        return n;
    }
}

