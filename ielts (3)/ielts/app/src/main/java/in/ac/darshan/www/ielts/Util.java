package in.ac.darshan.www.ielts;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Util {

    // This method will get data from json file from assets and convert in JSONArray.
    public static JSONArray getJsonFromFile(Context context, String fileName) {
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            if (null != inputStream) {
                StringBuilder response = new StringBuilder();
                BufferedReader buReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"), 50000);
                String line;
                while ((line = buReader.readLine()) != null) {
                    response.append(line);
                }
                return new JSONArray(response.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void hideKeyBoard(EditText editText) {
        InputMethodManager imm = (InputMethodManager)editText.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(editText.getWindowToken(), InputMethodManager.HIDE_IMPLICIT_ONLY);
    }
}
