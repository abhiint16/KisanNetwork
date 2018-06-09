package abhishekint.com.kisannetwork.app.LandingActivity.FirstTabFrag.Model;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import abhishekint.com.kisannetwork.utils.JsonToString;
import io.reactivex.Observable;

import static java.lang.Integer.parseInt;

/**
 * Created by abhishek on 09-06-2018.
 */

public class TabOneJsonClient {
    JsonToString jsonToString;
    public TabOneJsonClient(JsonToString jsonToString) {
        this.jsonToString=jsonToString;
    }

    public Observable<Data> getData()
    {
        String dataString=jsonToString.loadJSONFromAsset();
        Log.e("check for data",""+dataString);
        Data data=new Data();
        try {
            JSONObject obj = new JSONObject(dataString);
            JSONArray jArray = obj.getJSONArray("Contact");

            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jo_inside = jArray.getJSONObject(i);
                String firstname = jo_inside.getString("firstname");
                String lastname = jo_inside.getString("lastname");
                Long phoneno = jo_inside.getLong("phoneno");

                data.firstname.add(firstname);
                data.lastname.add(lastname);
                data.phone.add(phoneno);
            }
            return Observable.just(data);
        } catch (JSONException e) {
            e.printStackTrace();
            return Observable.fromIterable((Iterable<? extends Data>) data);
        }
    }
}
