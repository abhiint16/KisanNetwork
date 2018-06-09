package abhishekint.com.kisannetwork.app.LandingActivity.MainActivity;

/**
 * Created by abhishek on 09-06-2018.
 */

public class MainPresenter implements MainPresenterInterface {

    MainActivityInterface mainActivityInterface;

    public MainPresenter(MainActivityInterface mainActivityInterface) {
        this.mainActivityInterface = mainActivityInterface;
    }

}
