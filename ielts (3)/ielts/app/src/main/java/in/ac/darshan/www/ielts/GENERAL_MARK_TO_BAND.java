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

public class GENERAL_MARK_TO_BAND extends AppCompatActivity {

    Button btn_gncob,btn_genlist,btn_genred;
    EditText et_genlist,et_genread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_mark_to_band);


        btn_genlist= findViewById(R.id.btn_genlist);
        btn_genred= findViewById(R.id.btn_genred);

        et_genlist = findViewById(R.id.et_genlist);
        et_genread = findViewById(R.id.et_genread);


    }
    void insetUser()
    {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper._COMPONENT, String.valueOf(et_genlist.getText()));
    }
}
