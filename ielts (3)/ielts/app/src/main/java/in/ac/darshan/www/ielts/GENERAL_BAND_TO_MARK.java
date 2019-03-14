package in.ac.darshan.www.ielts;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import in.ac.darshan.www.ielts.dbhelper.DBHelper;

/**
 * Created by Infiniti on 1/11/2019.
 */

public class GENERAL_BAND_TO_MARK extends AppCompatActivity {

    Button btn1_genlist,btn1_genred;
    EditText et1_genlist,et1_genread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_band_to_mark);


        btn1_genlist= findViewById(R.id.btn1_genlist);
        btn1_genred= findViewById(R.id.btn1_genred);

        et1_genlist = findViewById(R.id.et1_genlist);
        et1_genread = findViewById(R.id.et1_genread);


    }

    void insetUser()
    {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper._COMPONENT, String.valueOf(et1_genlist.getText()));
    }
}
