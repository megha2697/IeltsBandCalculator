package in.ac.darshan.www.ielts;

import android.content.ContentValues;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import in.ac.darshan.www.ielts.dbhelper.DBHelper;

/**
 * Created by Infiniti on 3/2/2019.
 */

public class ACADEMIC_BAND_TO_MARK extends AppCompatActivity {

    Button btn1_acdlist,btn1_acdred;
    EditText et1_aclist,et1_acread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_band_to_mark);


        btn1_acdlist= findViewById(R.id.btn1_acdlist);
        btn1_acdred= findViewById(R.id.btn1_acdred);

        et1_aclist = findViewById(R.id.et1_aclist);
        et1_acread = findViewById(R.id.et1_acread);


    }

    void insetUser()
    {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper._COMPONENT, String.valueOf(et1_aclist.getText()));
    }
}
