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

public class ACADEMIC_MARK_TO_BAND extends AppCompatActivity {

    private Button btn_acdlist, btn_acdred;
    private EditText et_aclist, et_acread;
    LinearLayout lay_main_container;
    private TextView tv_ad_mb_list_result,tv_ad_mb_read_result;
    public TextView  tv_ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acd_mark_to_band);
        setTitle("Mark To Band");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        et_aclist = findViewById(R.id.et_aclist);
        lay_main_container =findViewById(R.id.lay_main_container);
        tv_ad_mb_list_result =findViewById(R.id.tv_ad_mb_list_result);
        tv_ad_mb_read_result =findViewById(R.id.tv_ad_mb_read_result);

        tv_ad_mb_list_result.setVisibility(View.GONE);
        tv_ad_mb_read_result.setVisibility(View.GONE);

        EditText et = (EditText) findViewById(R.id.et_aclist);
        et.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "40")});

        EditText et1 = (EditText) findViewById(R.id.et_acread);
        et1.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "40")});

//        et_aclist.setFilters(new InputFilter[]{new InputFilter.LengthFilter(40)});
//        et_acread.setFilters(new InputFilter[]{new InputFilter.LengthFilter(40)});

        et_acread = findViewById(R.id.et_acread);
        btn_acdred = findViewById(R.id.btn_acdred);
        btn_acdred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_ad_mb_read_result.setVisibility(View.VISIBLE);

                String marks = et_acread.getText().toString().trim();
                Util.hideKeyBoard(et_acread);

                if(TextUtils.isEmpty(marks)){
                    tv_ad_mb_read_result.setText("Please enter you marks!");
                    return;
                }

                float band = DBHelper.getBandByMarks(ACADEMIC_MARK_TO_BAND.this,"READING","ACADEMIC", marks);
                if(band==-1){
                    tv_ad_mb_read_result.setText("Invalid Marks Entry!");
                    return;
                }
                tv_ad_mb_read_result.setText("Band:" + band);

            }
        });

        et_acread.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()==0){
                    tv_ad_mb_read_result.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_acdlist = findViewById(R.id.btn_acdlist);
        btn_acdlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_ad_mb_list_result.setVisibility(View.VISIBLE);

                String marks = et_aclist.getText().toString().trim();
                Util.hideKeyBoard(et_aclist);

                if(TextUtils.isEmpty(marks)){
                    tv_ad_mb_list_result.setText("Please enter you marks!");
                    return;
                }
                float band = DBHelper.getBandByMarks(ACADEMIC_MARK_TO_BAND.this,"LISTENING","ACADEMIC", marks);
                if(band==-1){
                    tv_ad_mb_list_result.setText("Invalid Marks Entry!");
                    return;
                }
                tv_ad_mb_list_result.setText("Band:" + band);

            }
        });

        et_aclist.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()==0){
                    tv_ad_mb_list_result.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });




    }

    public void general()
    {
        setContentView(R.layout.activity_acd_mark_to_band);
        tv_ac = findViewById(R.id.tv_ac);
        tv_ac.setText("GENERAL");
        et_aclist = findViewById(R.id.et_aclist);
        lay_main_container =findViewById(R.id.lay_main_container);
        tv_ad_mb_list_result =findViewById(R.id.tv_ad_mb_list_result);
        tv_ad_mb_read_result =findViewById(R.id.tv_ad_mb_read_result);

        tv_ad_mb_list_result.setVisibility(View.GONE);
        tv_ad_mb_read_result.setVisibility(View.GONE);

        EditText et = (EditText) findViewById(R.id.et_aclist);
        et.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "40")});

        EditText et1 = (EditText) findViewById(R.id.et_acread);
        et1.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "40")});

        et_acread = findViewById(R.id.et_acread);
        btn_acdred = findViewById(R.id.btn_acdred);


        btn_acdred.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_ad_mb_read_result.setVisibility(View.VISIBLE);

                String marks = et_acread.getText().toString().trim();
                Util.hideKeyBoard(et_acread);

                if(TextUtils.isEmpty(marks)){
                    tv_ad_mb_read_result.setText("Please enter you marks!");
                    return;
                }
                float band = DBHelper.getBandByMarks(ACADEMIC_MARK_TO_BAND.this,"READING","GENERAL", marks);
                if(band==-1){
                    tv_ad_mb_read_result.setText("Invalid Marks Entry!");
                    return;
                }
                tv_ad_mb_read_result.setText("Band:" + band);

            }
        });

        et_acread.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()==0){
                    tv_ad_mb_read_result.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btn_acdlist = findViewById(R.id.btn_acdlist);
        btn_acdlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tv_ad_mb_list_result.setVisibility(View.VISIBLE);

                String marks = et_aclist.getText().toString().trim();
                Util.hideKeyBoard(et_aclist);

                if(TextUtils.isEmpty(marks)){
                    tv_ad_mb_list_result.setText("Please enter you marks!");
                    return;
                }

                float band = DBHelper.getBandByMarks(ACADEMIC_MARK_TO_BAND.this,"LISTENING","GENERAL", marks);

                if(band==-1){
                    tv_ad_mb_list_result.setText("Invalid Marks Entry!");
                    return;
                }
                tv_ad_mb_list_result.setText("Band:" + band);

            }
        });

        et_aclist.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()==0){
                    tv_ad_mb_list_result.setVisibility(View.GONE);
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
        cv.put(DBHelper._COMPONENT, String.valueOf(et_aclist.getText()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        int id = item.getItemId();
        switch (id) {
            case R.id.action_ac_mb:

                return true;
            case R.id.action_gen_mb:
                general();


//                Intent in=new Intent(ACADEMIC_MARK_TO_BAND.this,GENERAL_MARK_TO_BAND.class);
//                startActivity(in);
//                return true;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mark_band_menu,menu);
        return true;
    }
}