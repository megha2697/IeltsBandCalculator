package in.ac.darshan.www.ielts;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import in.ac.darshan.www.ielts.dbhelper.DBHelper;

/**
 * Created by Infiniti on 9/16/2018.
 */

public class ACADEMIC_MARK_TO_BAND extends AppCompatActivity {

    Button btn_acdlist,btn_acdred;
    EditText et_aclist,et_acread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acd_mark_to_band);


        btn_acdlist= findViewById(R.id.btn_acdlist);
        btn_acdred= findViewById(R.id.btn_acdred);

        et_aclist = findViewById(R.id.et_aclist);
        et_acread = findViewById(R.id.et_acread);


    }
        void insetUser()
        {
            ContentValues cv = new ContentValues();
            cv.put(DBHelper._COMPONENT, String.valueOf(et_aclist.getText()));
        }
}