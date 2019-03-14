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
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import in.ac.darshan.www.ielts.*;
import in.ac.darshan.www.ielts.dbhelper.DBHelper;

/**
 * Created by Infiniti on 12/23/2018.
 */
import android.view.View.OnClickListener;
import android.widget.Toolbar;

public class ACADEMIC_BAND_TO_MARK extends AppCompatActivity {

    private Button btn1_acdlist, btn1_acdred;
    private EditText et1_aclist, et1_acread;
    LinearLayout lay_main_container;
    private TextView tv1_ad_bm_list_result, tv2_ad_bm_list_result, tv1_ad_bm_red_result, tv2_ad_bm_red_result;
    public TextView  tv_ac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);

            setContentView(R.layout.activity_acd_band_to_mark);
            setTitle("Band To Mark");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

            et1_aclist = findViewById(R.id.et1_aclist);
            lay_main_container = findViewById(R.id.lay_main_container);
            tv_ac = findViewById(R.id.tv_ac);
            et1_acread = findViewById(R.id.et1_acread);
            btn1_acdred = findViewById(R.id.btn1_acdred);
            tv1_ad_bm_list_result = findViewById(R.id.tv1_ad_bm_list_result);
            tv2_ad_bm_list_result = findViewById(R.id.tv2_ad_bm_list_result);
            tv1_ad_bm_red_result = findViewById(R.id.tv1_ad_bm_red_result);
            tv2_ad_bm_red_result = findViewById(R.id.tv2_ad_bm_red_result);
            tv1_ad_bm_red_result.setVisibility(View.GONE);
            tv2_ad_bm_red_result.setVisibility(View.GONE);
            tv1_ad_bm_list_result.setVisibility(View.GONE);
            tv2_ad_bm_list_result.setVisibility(View.GONE);

            EditText et = (EditText) findViewById(R.id.et1_aclist);
            et.setFilters(new InputFilter[]{new InputFilterMinMax("0", "9")});

            EditText et1 = (EditText) findViewById(R.id.et1_acread);
            et1.setFilters(new InputFilter[]{new InputFilterMinMax("0", "9")});



            btn1_acdred.setOnClickListener(new View.OnClickListener() {
                String band = et1_acread.getText().toString().trim();

                @Override
                public void onClick(View view) {

                    tv1_ad_bm_red_result.setVisibility(View.VISIBLE);
                    tv2_ad_bm_red_result.setVisibility(View.VISIBLE);

                    String band = et1_acread.getText().toString().trim();
                    Util.hideKeyBoard(et1_acread);
                    if (TextUtils.isEmpty(band)) {
                        tv1_ad_bm_red_result.setText("Please enter you bands!");
                        tv2_ad_bm_red_result.setText(" ");
                        return;
                    }
                    int minmarks = DBHelper.getMinMarksByBand(ACADEMIC_BAND_TO_MARK.this, "READING", "ACADEMIC", band);
                    int maxmarks = DBHelper.getMaxMarksByBand(ACADEMIC_BAND_TO_MARK.this, "READING", "ACADEMIC", band);
                    if (minmarks == -1 || maxmarks == -1) {

                        tv1_ad_bm_red_result.setText("Invalid Band Entry!");
                        tv2_ad_bm_red_result.setText(" ");
                        return;
                    }
//                if (maxmarks == -1) {
//
//                    tv2_ad_bm_red_result.setText("Invalid Band Entry!");
//
//                    return;
//                }
                    tv1_ad_bm_red_result.setText("Max Marks:" + maxmarks);
                    tv2_ad_bm_red_result.setText("Min Marks:" + minmarks);


                }
            });

            et1_acread.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {


                    if (s.toString().length() == 0) {
                        tv1_ad_bm_red_result.setVisibility(View.GONE);
                        tv2_ad_bm_red_result.setVisibility(View.GONE);
                    }

                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });


            btn1_acdlist = findViewById(R.id.btn1_acdlist);
            btn1_acdlist.setOnClickListener(new View.OnClickListener() {
                String band = et1_aclist.getText().toString().trim();

                @Override
                public void onClick(View view) {

                    tv1_ad_bm_list_result.setVisibility(View.VISIBLE);
                    tv2_ad_bm_list_result.setVisibility(View.VISIBLE);

                    Util.hideKeyBoard(et1_aclist);
                    String band = et1_aclist.getText().toString().trim();
                    if (TextUtils.isEmpty(band)) {
                        tv1_ad_bm_list_result.setText("Please do Band Entry!");
                        tv2_ad_bm_list_result.setText("");
                        return;
                    }
                    int minmarks = DBHelper.getMinMarksByBand(ACADEMIC_BAND_TO_MARK.this, "LISTENING", "ACADEMIC", band);
                    int maxmarks = DBHelper.getMaxMarksByBand(ACADEMIC_BAND_TO_MARK.this, "LISTENING", "ACADEMIC", band);
                    if (minmarks == -1 || maxmarks == -1) {
                        tv1_ad_bm_list_result.setText("Invalid Band Entry!");
                        tv2_ad_bm_list_result.setText("");
                        return;
                    }
//                if (maxmarks == -1) {
//                    tv2_ad_bm_list_result.setText("Invalid Band Entry!");
//                    return;
//                }
                    tv1_ad_bm_list_result.setText("Min Marks:" + minmarks);
                    tv2_ad_bm_list_result.setText("Max Marks:" + maxmarks);
                }
            });

            et1_aclist.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    if (s.toString().length() == 0) {
                        tv1_ad_bm_list_result.setVisibility(View.GONE);
                        tv2_ad_bm_list_result.setVisibility(View.GONE);
                    }
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });

//        finish();
        }




    public void general() {


        setContentView(R.layout.activity_acd_band_to_mark);

        et1_aclist = findViewById(R.id.et1_aclist);
        lay_main_container = findViewById(R.id.lay_main_container);
        tv_ac = findViewById(R.id.tv_ac);
        et1_acread = findViewById(R.id.et1_acread);
        btn1_acdred = findViewById(R.id.btn1_acdred);
        tv1_ad_bm_list_result = findViewById(R.id.tv1_ad_bm_list_result);
        tv2_ad_bm_list_result = findViewById(R.id.tv2_ad_bm_list_result);
        tv1_ad_bm_red_result = findViewById(R.id.tv1_ad_bm_red_result);
        tv2_ad_bm_red_result = findViewById(R.id.tv2_ad_bm_red_result);
        tv1_ad_bm_red_result.setVisibility(View.GONE);
        tv2_ad_bm_red_result.setVisibility(View.GONE);
        tv1_ad_bm_list_result.setVisibility(View.GONE);
        tv2_ad_bm_list_result.setVisibility(View.GONE);

        tv_ac.setText("GENERAL");


        EditText et = (EditText) findViewById(R.id.et1_aclist);
        et.setFilters(new InputFilter[]{new InputFilterMinMax("0", "9")});

        EditText et1 = (EditText) findViewById(R.id.et1_acread);
        et1.setFilters(new InputFilter[]{new InputFilterMinMax("0", "9")});

        btn1_acdred.setOnClickListener(new View.OnClickListener() {

            String band = et1_acread.getText().toString().trim();

            @Override
            public void onClick(View view) {

                tv1_ad_bm_red_result.setVisibility(View.VISIBLE);
                tv2_ad_bm_red_result.setVisibility(View.VISIBLE);

                String band = et1_acread.getText().toString().trim();
                Util.hideKeyBoard(et1_acread);
                if (TextUtils.isEmpty(band)) {
                    tv1_ad_bm_red_result.setText("Please enter you bands!");

                    return;
                }
                int minmarks = DBHelper.getMinMarksByBand(ACADEMIC_BAND_TO_MARK.this, "READING", "GENERAL", band);
                int maxmarks = DBHelper.getMaxMarksByBand(ACADEMIC_BAND_TO_MARK.this, "READING", "GENERAL", band);
                if (minmarks == -1) {

                    tv1_ad_bm_red_result.setText("Invalid Band Entry!");
                    return;
                }
                if (maxmarks == -1) {

                    tv2_ad_bm_red_result.setText("Invalid Band Entry!");

                    return;
                }
                tv1_ad_bm_red_result.setText("Max Marks:" + maxmarks);
                tv2_ad_bm_red_result.setText("Min Marks:" + minmarks);
            }
        });
        et1_acread.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() == 0) {
                    tv1_ad_bm_red_result.setVisibility(View.GONE);
                    tv2_ad_bm_red_result.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn1_acdlist.setOnClickListener(new View.OnClickListener() {
            String band = et1_aclist.getText().toString().trim();

            @Override
            public void onClick(View view) {

                tv1_ad_bm_list_result.setVisibility(View.VISIBLE);
                tv2_ad_bm_list_result.setVisibility(View.VISIBLE);

                Util.hideKeyBoard(et1_aclist);
                String band = et1_aclist.getText().toString().trim();
                if (TextUtils.isEmpty(band)) {
                    tv1_ad_bm_list_result.setText("Please do Band Entry!");
                    return;
                }
                int minmarks = DBHelper.getMinMarksByBand(ACADEMIC_BAND_TO_MARK.this, "LISTENING", "GENERAL", band);
                int maxmarks = DBHelper.getMaxMarksByBand(ACADEMIC_BAND_TO_MARK.this, "LISTENING", "GENERAL", band);
                if (minmarks == -1) {
                    tv1_ad_bm_list_result.setText("Invalid Band Entry!");
                    return;
                }
                if (maxmarks == -1) {
                    tv2_ad_bm_list_result.setText("Invalid Band Entry!");
                    return;
                }
                tv1_ad_bm_list_result.setText("Min Marks:" + minmarks);
                tv2_ad_bm_list_result.setText("Max Marks:" + maxmarks);
            }
        });
        et1_aclist.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() == 0) {
                    tv1_ad_bm_list_result.setVisibility(View.GONE);
                    tv2_ad_bm_list_result.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

//        finish();

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
        cv.put(DBHelper._COMPONENT, String.valueOf(et1_aclist.getText()));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
           onBackPressed();
        }

        int id = item.getItemId();
        switch (id) {
            case R.id.action_ac_bm:

            case R.id.action_gen_bm:
//                int flag=1;
                general();
                break;
//                return true;
//                ACADEMIC_TOTAL_BAND m=new ACADEMIC_TOTAL_BAND();
//                m.go();
//                Intent in=new Intent(ACADEMIC_BAND_TO_MARK.this,GENERAL_BAND_TO_MARK.class);
//                startActivity(in);
//                return true;
//                finish();



        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.dashboard_menu,menu);
        return true;

    }



}






