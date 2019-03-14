package in.ac.darshan.www.ielts.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import in.ac.darshan.www.ielts.R;
import in.ac.darshan.www.ielts.Util;
import in.ac.darshan.www.ielts.dbhelper.DBHelper;

/**
 * Created by Infiniti on 9/16/2018.
 */

public class GENERAL_MARK_TO_BAND extends AppCompatActivity {

    Button btn_gncob,btn_genlist,btn_genred;
    EditText et_genlist,et_genread;
    LinearLayout lay_main_container;
    private TextView tv_gen_mb_list_result,tv_gen_mb_read_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_mark_to_band);
        setTitle("Mark To Band");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        btn_genred= findViewById(R.id.btn_genred);
        et_genread = findViewById(R.id.et_genread);
        lay_main_container =findViewById(R.id.lay_main_container);
        tv_gen_mb_list_result =findViewById(R.id.tv_gen_mb_list_result);
        tv_gen_mb_read_result =findViewById(R.id.tv_gen_mb_read_result);

        EditText et = (EditText) findViewById(R.id.et_genlist);
        et.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "40")});

        EditText et1 = (EditText) findViewById(R.id.et_genread);
        et.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "40")});

//        et_genlist.setFilters(new InputFilter[]{new InputFilter.LengthFilter(9)});
//        et_genread.setFilters(new InputFilter[]{new InputFilter.LengthFilter(9)});

        tv_gen_mb_list_result.setVisibility(View.GONE);
        tv_gen_mb_read_result.setVisibility(View.GONE);

        btn_genred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_gen_mb_read_result.setVisibility(View.VISIBLE);

                String marks = et_genread.getText().toString().trim();
                Util.hideKeyBoard(et_genread);
                if(TextUtils.isEmpty(marks)){
                    tv_gen_mb_read_result.setText("Please enter you marks!");
                    return;
                }
                float band = DBHelper.getBandByMarks(GENERAL_MARK_TO_BAND.this,"READING","GENERAL", marks);
                if(band==-1){
                    tv_gen_mb_read_result.setText("Invalid Marks Entry!");
                    return;
                }
                tv_gen_mb_read_result.setText("Band:" + band);
            }
        });

        et_genread.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()==0){
                    tv_gen_mb_read_result.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_genlist= findViewById(R.id.btn_genlist);
        et_genlist = findViewById(R.id.et_genlist);
        btn_genlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_gen_mb_list_result.setVisibility(View.VISIBLE);

                String marks = et_genlist.getText().toString().trim();
                Util.hideKeyBoard(et_genlist);

                if(TextUtils.isEmpty(marks)){
                    tv_gen_mb_list_result.setText("Please enter you marks!");
                    return;
                }
                float band = DBHelper.getBandByMarks(GENERAL_MARK_TO_BAND.this,"LISTENING","GENERAL", marks);
                if(band==-1){
                    tv_gen_mb_list_result.setText("Invalid Marks Entry!");
                    return;
                }
                tv_gen_mb_list_result.setText("Band:" + band);

            }
        });

        et_genlist.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()==0){
                    tv_gen_mb_list_result.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    private void showSnackbar(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
//
//        Snackbar snackbar = Snackbar.make(lay_main_container, text, Snackbar.LENGTH_SHORT);
//        View sbView = snackbar.getView();
//        sbView.setBackgroundColor(Color.RED);
//        snackbar.show();
    }

    void insetUser() {
        ContentValues cv = new ContentValues();
        cv.put(DBHelper._COMPONENT, String.valueOf(et_genlist.getText()));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        int id = item.getItemId();
        switch (id) {
            case R.id.action_ac_mb:
                Intent in=new Intent(GENERAL_MARK_TO_BAND.this,ACADEMIC_MARK_TO_BAND.class);
                startActivity(in);
                return true;
            case R.id.action_gen_mb:

                return true;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mark_band_menu,menu);
        return true;
    }

}
