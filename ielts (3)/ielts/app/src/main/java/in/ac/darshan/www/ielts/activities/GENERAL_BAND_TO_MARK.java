package in.ac.darshan.www.ielts.activities;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

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

import com.google.android.material.snackbar.Snackbar;

import in.ac.darshan.www.ielts.R;
import in.ac.darshan.www.ielts.Util;
import in.ac.darshan.www.ielts.dbhelper.DBHelper;

/**
 * Created by Infiniti on 12/23/2018.
 */

public class GENERAL_BAND_TO_MARK extends AppCompatActivity {

    private Button  btn1_genlist, btn1_genred;
    private EditText et1_genlist, et1_genread;
    LinearLayout lay_main_container;
    private TextView tv1_gen_bm_list_result,tv2_gen_bm_list_result,tv1_gen_bm_red_result,tv2_gen_bm_red_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_band_to_mark);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        et1_genlist = findViewById(R.id.et1_genlist);
        lay_main_container = findViewById(R.id.lay_main_container);

        et1_genread = findViewById(R.id.et1_genread);
        btn1_genred = findViewById(R.id.btn1_genred);
        tv1_gen_bm_list_result=findViewById(R.id.tv1_gen_bm_list_result);
        tv2_gen_bm_list_result=findViewById(R.id.tv2_gen_bm_list_result);
        tv1_gen_bm_red_result=findViewById(R.id.tv1_gen_bm_red_result);
        tv2_gen_bm_red_result=findViewById(R.id.tv2_gen_bm_red_result);

        tv1_gen_bm_list_result.setVisibility(View.GONE);
        tv2_gen_bm_list_result.setVisibility(View.GONE);
        tv1_gen_bm_red_result.setVisibility(View.GONE);
        tv2_gen_bm_red_result.setVisibility(View.GONE);

        EditText et = (EditText) findViewById(R.id.et1_genlist);
        et.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "9")});

        EditText et1 = (EditText) findViewById(R.id.et1_genread);
        et.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "9")});

//        et1_genlist.setFilters(new InputFilter[]{new InputFilter.LengthFilter(9)});
//        et1_genread.setFilters(new InputFilter[]{new InputFilter.LengthFilter(9)});

        btn1_genred.setOnClickListener(new View.OnClickListener() {
            String band = et1_genread.getText().toString().trim();
            @Override
            public void onClick(View view) {

                tv1_gen_bm_red_result.setVisibility(View.VISIBLE);
                tv2_gen_bm_red_result.setVisibility(View.VISIBLE);

                String band = et1_genread.getText().toString().trim();
                Util.hideKeyBoard(et1_genread);
                if(TextUtils.isEmpty(band)){
                    showSnackbar("Please enter you bands!");
                    return;
                }
                int minmarks = DBHelper.getMinMarksByBand(GENERAL_BAND_TO_MARK.this,"READING","GENERAL", band);
                int maxmarks = DBHelper.getMaxMarksByBand(GENERAL_BAND_TO_MARK.this,"READING","GENERAL", band);
                if(minmarks==-1){
                    tv1_gen_bm_red_result.setText("Invalid Band Entry!");
                    return;
                }
                if(maxmarks==-1){
                    tv2_gen_bm_red_result.setText("Invalid Band Entry!");
                    return;
                }
                tv1_gen_bm_red_result.setText("Max Marks:" + maxmarks);
                tv2_gen_bm_red_result.setText("Min Marks:" + minmarks);
            }
        });

        et1_genread.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()==0){
                    tv1_gen_bm_red_result.setVisibility(View.GONE);
                    tv2_gen_bm_red_result.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        btn1_genlist = findViewById(R.id.btn1_genlist);
        btn1_genlist.setOnClickListener(new View.OnClickListener() {
            String band = et1_genlist.getText().toString().trim();
            @Override
            public void onClick(View view) {

                tv1_gen_bm_list_result.setVisibility(View.VISIBLE);
                tv2_gen_bm_list_result.setVisibility(View.VISIBLE);


                Util.hideKeyBoard(et1_genlist);
                String band = et1_genlist.getText().toString().trim();
                if(TextUtils.isEmpty(band)){
                    showSnackbar("Please enter you bands!");
                    return;
                }
                int minmarks = DBHelper.getMinMarksByBand(GENERAL_BAND_TO_MARK.this,"LISTENING","GENERAL", band);
                int maxmarks = DBHelper.getMaxMarksByBand(GENERAL_BAND_TO_MARK.this,"LISTENING","GENERAL", band);
                if(minmarks==-1){
                    tv1_gen_bm_list_result.setText("Invalid Band Entry!");
                    return;
                }
                if(maxmarks==-1){
                    tv1_gen_bm_list_result.setText("Invalid Band Entry!");
                    return;
                }
                tv1_gen_bm_list_result.setText("Max Marks:" + maxmarks);
                tv2_gen_bm_list_result.setText("Min Marks:" + minmarks);

            }
        });

        et1_genlist.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().length()==0){
                    tv1_gen_bm_list_result.setVisibility(View.GONE);
                    tv2_gen_bm_list_result.setVisibility(View.GONE);
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
        cv.put(DBHelper._COMPONENT, String.valueOf(et1_genlist.getText()));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }

        int id = item.getItemId();
        switch (id) {
            case R.id.action_ac_bm:
                Intent in=new Intent(GENERAL_BAND_TO_MARK.this,ACADEMIC_BAND_TO_MARK.class);
                startActivity(in);
                return true;
            case R.id.action_gen_bm:

                return true;


        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu,menu);
        return true;
    }
}


