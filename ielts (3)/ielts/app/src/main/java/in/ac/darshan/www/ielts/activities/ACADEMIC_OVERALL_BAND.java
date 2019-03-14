package in.ac.darshan.www.ielts.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import in.ac.darshan.www.ielts.R;

/**
 * Created by Infiniti on 9/16/2018.
 */

public class ACADEMIC_OVERALL_BAND extends AppCompatActivity {

    private Spinner sp_aclist, sp_acread, sp_acwrite, sp_acspeak;
    private Button btn_acd_submit;
    private TextView tvResult;
    private String[] strlist, strread, strwrite, strspeak;
    LinearLayout lay_main_container;
    Button btn_mb, btn_bm;
    public TextView tv_ac;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acd_totalband);



        lay_main_container = findViewById(R.id.lay_main_container);

        tv_ac = findViewById(R.id.tv_ac);

        btn_mb = findViewById(R.id.btn_mb);
        btn_bm = findViewById(R.id.btn_bm);
        sp_aclist = findViewById(R.id.sp_aclist);
        sp_acread = findViewById(R.id.sp_acread);
        sp_acwrite = findViewById(R.id.sp_acwrite);
        sp_acspeak = findViewById(R.id.sp_acspeak);
        // btn_acd_submit = findViewById(R.id.btn_acd_submit);
        tvResult = findViewById(R.id.tv_result);


        strlist = getResources().getStringArray(R.array.strlist);
        strread = getResources().getStringArray(R.array.strread);
        strwrite = getResources().getStringArray(R.array.strwrite);
        strspeak = getResources().getStringArray(R.array.strspeak);


        ArrayAdapter<String> listspinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item,
                        strlist);
        listspinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        sp_aclist.setAdapter(listspinnerArrayAdapter);

        ArrayAdapter<String> readspinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        strread);
        readspinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        sp_acread.setAdapter(readspinnerArrayAdapter);

        ArrayAdapter<String> writespinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        strwrite);
        writespinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        sp_acwrite.setAdapter(writespinnerArrayAdapter);

        ArrayAdapter<String> speakspinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        strspeak);
        speakspinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        sp_acspeak.setAdapter(speakspinnerArrayAdapter);

        String acListValue = sp_aclist.getSelectedItem().toString();
        String acReadValue = sp_acread.getSelectedItem().toString();
        String acWriteValue = sp_acwrite.getSelectedItem().toString();
        String acSpeakValue = sp_acspeak.getSelectedItem().toString();
        Float acList, acRead, acWrite, acSpeak;
        acList = Float.parseFloat(acListValue);
        acRead = Float.parseFloat(acReadValue);
        acWrite = Float.parseFloat(acWriteValue);
        acSpeak = Float.parseFloat(acSpeakValue);

        double avg = (acList + acRead + acWrite + acSpeak) / 4;
        if (acList == 9 && acRead == 9 && acWrite == 9 && acSpeak == 9) {
            tvResult.setText("OVERALL BAND: " + (9));
        }


        sp_acspeak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                String acListValue = sp_aclist.getSelectedItem().toString();
                String acReadValue = sp_acread.getSelectedItem().toString();
                String acWriteValue = sp_acwrite.getSelectedItem().toString();
                String acSpeakValue = sp_acspeak.getSelectedItem().toString();
                Float acList, acRead, acWrite, acSpeak;
                acList = Float.parseFloat(acListValue);
                acRead = Float.parseFloat(acReadValue);
                acWrite = Float.parseFloat(acWriteValue);
                acSpeak = Float.parseFloat(acSpeakValue);
                double avg = (acList + acRead + acWrite + acSpeak) / 4;

                if (acList != 0 && acRead != 0 && acWrite != 0 && acSpeak != 0)

                {

//                    if (isValidUser()) {
//                        String acListValue = sp_aclist.getSelectedItem().toString();
//                        String acReadValue = sp_acread.getSelectedItem().toString();
//                        String acWriteValue = sp_acwrite.getSelectedItem().toString();
//                        String acSpeakValue = sp_acspeak.getSelectedItem().toString();
//                        Float acList, acRead, acWrite, acSpeak;
//                        acList = Float.parseFloat(acListValue);
//                        acRead = Float.parseFloat(acReadValue);
//                        acWrite = Float.parseFloat(acWriteValue);
//                        acSpeak = Float.parseFloat(acSpeakValue);
//                        double avg = (acList + acRead + acWrite + acSpeak) / 4;

                    if (avg < 0.25) {
                        tvResult.setText("OVERALL BAND: " + (0));
                    } else if (avg >= 0.25 && avg < 0.75) {
                        tvResult.setText("OVERALL BAND: " + (0.5));
                    } else if (avg >= 0.75 && avg < 1.25) {
                        tvResult.setText("OVERALL BAND: " + (1));
                    } else if (avg >= 1.25 && avg < 1.75) {
                        tvResult.setText("OVERALL BAND: " + (1.5));
                    } else if (avg >= 1.75 && avg < 2.25) {
                        tvResult.setText("OVERALL BAND: " + (2));
                    } else if (avg >= 2.25 && avg < 2.75) {
                        tvResult.setText("OVERALL BAND: " + (2.5));
                    } else if (avg >= 2.75 && avg < 3.25) {
                        tvResult.setText("OVERALL BAND: " + (3));
                    } else if (avg >= 3.25 && avg < 3.75) {
                        tvResult.setText("OVERALL BAND: " + (3.5));
                    } else if (avg >= 3.75 && avg < 4.25) {
                        tvResult.setText("OVERALL BAND: " + (4));
                    } else if (avg >= 4.25 && avg < 4.75) {
                        tvResult.setText("OVERALL BAND: " + (4.5));
                    } else if (avg >= 4.75 && avg < 5.25) {
                        tvResult.setText("OVERALL BAND: " + (5));
                    } else if (avg >= 5.25 && avg < 5.75) {
                        tvResult.setText("OVERALL BAND: " + (5.5));
                    } else if (avg >= 5.75 && avg < 6.25) {
                        tvResult.setText("OVERALL BAND: " + (6));
                    } else if (avg >= 6.25 && avg < 6.75) {
                        tvResult.setText("OVERALL BAND: " + (6.5));
                    } else if (avg >= 6.75 && avg < 7.25) {
                        tvResult.setText("OVERALL BAND: " + (7));
                    } else if (avg >= 7.25 && avg < 7.75) {
                        tvResult.setText("OVERALL BAND: " + (7.5));
                    } else if (avg >= 7.75 && avg < 8.25) {
                        tvResult.setText("OVERALL BAND: " + (8));
                    } else if (avg >= 8.25 && avg < 8.75) {
                        tvResult.setText("OVERALL BAND: " + (8.5));
                    } else if (avg >= 8.75 && avg <= 9) {
                        tvResult.setText("OVERALL BAND: " + (9));
                    }


                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here


            }

        });


        sp_aclist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here

                String acListValue = sp_aclist.getSelectedItem().toString();
                String acReadValue = sp_acread.getSelectedItem().toString();
                String acWriteValue = sp_acwrite.getSelectedItem().toString();
                String acSpeakValue = sp_acspeak.getSelectedItem().toString();
                Float acList, acRead, acWrite, acSpeak;
                acList = Float.parseFloat(acListValue);
                acRead = Float.parseFloat(acReadValue);
                acWrite = Float.parseFloat(acWriteValue);
                acSpeak = Float.parseFloat(acSpeakValue);
                double avg = (acList + acRead + acWrite + acSpeak) / 4;

                if (acList != 0 && acRead != 0 && acWrite != 0 && acSpeak != 0) {

//                    if (isValidUser()) {
//                        String acListValue = sp_aclist.getSelectedItem().toString();
//                        String acReadValue = sp_acread.getSelectedItem().toString();
//                        String acWriteValue = sp_acwrite.getSelectedItem().toString();
//                        String acSpeakValue = sp_acspeak.getSelectedItem().toString();
//                        Float acList, acRead, acWrite, acSpeak;
//                        acList = Float.parseFloat(acListValue);
//                        acRead = Float.parseFloat(acReadValue);
//                        acWrite = Float.parseFloat(acWriteValue);
//                        acSpeak = Float.parseFloat(acSpeakValue);
//                        double avg = (acList + acRead + acWrite + acSpeak) / 4;

                    if (avg < 0.25) {
                        tvResult.setText("OVERALL BAND: " + (0));
                    } else if (avg >= 0.25 && avg < 0.75) {
                        tvResult.setText("OVERALL BAND: " + (0.5));
                    } else if (avg >= 0.75 && avg < 1.25) {
                        tvResult.setText("OVERALL BAND: " + (1));
                    } else if (avg >= 1.25 && avg < 1.75) {
                        tvResult.setText("OVERALL BAND: " + (1.5));
                    } else if (avg >= 1.75 && avg < 2.25) {
                        tvResult.setText("OVERALL BAND: " + (2));
                    } else if (avg >= 2.25 && avg < 2.75) {
                        tvResult.setText("OVERALL BAND: " + (2.5));
                    } else if (avg >= 2.75 && avg < 3.25) {
                        tvResult.setText("OVERALL BAND: " + (3));
                    } else if (avg >= 3.25 && avg < 3.75) {
                        tvResult.setText("OVERALL BAND: " + (3.5));
                    } else if (avg >= 3.75 && avg < 4.25) {
                        tvResult.setText("OVERALL BAND: " + (4));
                    } else if (avg >= 4.25 && avg < 4.75) {
                        tvResult.setText("OVERALL BAND: " + (4.5));
                    } else if (avg >= 4.75 && avg < 5.25) {
                        tvResult.setText("OVERALL BAND: " + (5));
                    } else if (avg >= 5.25 && avg < 5.75) {
                        tvResult.setText("OVERALL BAND: " + (5.5));
                    } else if (avg >= 5.75 && avg < 6.25) {
                        tvResult.setText("OVERALL BAND: " + (6));
                    } else if (avg >= 6.25 && avg < 6.75) {
                        tvResult.setText("OVERALL BAND: " + (6.5));
                    } else if (avg >= 6.75 && avg < 7.25) {
                        tvResult.setText("OVERALL BAND: " + (7));
                    } else if (avg >= 7.25 && avg < 7.75) {
                        tvResult.setText("OVERALL BAND: " + (7.5));
                    } else if (avg >= 7.75 && avg < 8.25) {
                        tvResult.setText("OVERALL BAND: " + (8));
                    } else if (avg >= 8.25 && avg < 8.75) {
                        tvResult.setText("OVERALL BAND: " + (8.5));
                    } else if (avg >= 8.75 && avg <= 9) {
                        tvResult.setText("OVERALL BAND: " + (9));
                    }


                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
//                tvResult.setText("OVERALL BAND: " + (9));
            }

        });

        sp_acwrite.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here

                String acListValue = sp_aclist.getSelectedItem().toString();
                String acReadValue = sp_acread.getSelectedItem().toString();
                String acWriteValue = sp_acwrite.getSelectedItem().toString();
                String acSpeakValue = sp_acspeak.getSelectedItem().toString();
                Float acList, acRead, acWrite, acSpeak;
                acList = Float.parseFloat(acListValue);
                acRead = Float.parseFloat(acReadValue);
                acWrite = Float.parseFloat(acWriteValue);
                acSpeak = Float.parseFloat(acSpeakValue);
                double avg = (acList + acRead + acWrite + acSpeak) / 4;

                if (acList != 0 && acRead != 0 && acWrite != 0 && acSpeak != 0) {

//                    if (isValidUser()) {
//                        String acListValue = sp_aclist.getSelectedItem().toString();
//                        String acReadValue = sp_acread.getSelectedItem().toString();
//                        String acWriteValue = sp_acwrite.getSelectedItem().toString();
//                        String acSpeakValue = sp_acspeak.getSelectedItem().toString();
//                        Float acList, acRead, acWrite, acSpeak;
//                        acList = Float.parseFloat(acListValue);
//                        acRead = Float.parseFloat(acReadValue);
//                        acWrite = Float.parseFloat(acWriteValue);
//                        acSpeak = Float.parseFloat(acSpeakValue);
//                        double avg = (acList + acRead + acWrite + acSpeak) / 4;

                    if (avg < 0.25) {
                        tvResult.setText("OVERALL BAND: " + (0));
                    } else if (avg >= 0.25 && avg < 0.75) {
                        tvResult.setText("OVERALL BAND: " + (0.5));
                    } else if (avg >= 0.75 && avg < 1.25) {
                        tvResult.setText("OVERALL BAND: " + (1));
                    } else if (avg >= 1.25 && avg < 1.75) {
                        tvResult.setText("OVERALL BAND: " + (1.5));
                    } else if (avg >= 1.75 && avg < 2.25) {
                        tvResult.setText("OVERALL BAND: " + (2));
                    } else if (avg >= 2.25 && avg < 2.75) {
                        tvResult.setText("OVERALL BAND: " + (2.5));
                    } else if (avg >= 2.75 && avg < 3.25) {
                        tvResult.setText("OVERALL BAND: " + (3));
                    } else if (avg >= 3.25 && avg < 3.75) {
                        tvResult.setText("OVERALL BAND: " + (3.5));
                    } else if (avg >= 3.75 && avg < 4.25) {
                        tvResult.setText("OVERALL BAND: " + (4));
                    } else if (avg >= 4.25 && avg < 4.75) {
                        tvResult.setText("OVERALL BAND: " + (4.5));
                    } else if (avg >= 4.75 && avg < 5.25) {
                        tvResult.setText("OVERALL BAND: " + (5));
                    } else if (avg >= 5.25 && avg < 5.75) {
                        tvResult.setText("OVERALL BAND: " + (5.5));
                    } else if (avg >= 5.75 && avg < 6.25) {
                        tvResult.setText("OVERALL BAND: " + (6));
                    } else if (avg >= 6.25 && avg < 6.75) {
                        tvResult.setText("OVERALL BAND: " + (6.5));
                    } else if (avg >= 6.75 && avg < 7.25) {
                        tvResult.setText("OVERALL BAND: " + (7));
                    } else if (avg >= 7.25 && avg < 7.75) {
                        tvResult.setText("OVERALL BAND: " + (7.5));
                    } else if (avg >= 7.75 && avg < 8.25) {
                        tvResult.setText("OVERALL BAND: " + (8));
                    } else if (avg >= 8.25 && avg < 8.75) {
                        tvResult.setText("OVERALL BAND: " + (8.5));
                    } else if (avg >= 8.75 && avg <= 9) {
                        tvResult.setText("OVERALL BAND: " + (9));
                    }


                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
//                tvResult.setText("OVERALL BAND: " + (9));
            }

        });

        sp_acread.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here

                String acListValue = sp_aclist.getSelectedItem().toString();
                String acReadValue = sp_acread.getSelectedItem().toString();
                String acWriteValue = sp_acwrite.getSelectedItem().toString();
                String acSpeakValue = sp_acspeak.getSelectedItem().toString();
                Float acList, acRead, acWrite, acSpeak;
                acList = Float.parseFloat(acListValue);
                acRead = Float.parseFloat(acReadValue);
                acWrite = Float.parseFloat(acWriteValue);
                acSpeak = Float.parseFloat(acSpeakValue);
                double avg = (acList + acRead + acWrite + acSpeak) / 4;

                if (acList != 0 && acRead != 0 && acWrite != 0 && acSpeak != 0) {

//                    if (isValidUser()) {
//                        String acListValue = sp_aclist.getSelectedItem().toString();
//                        String acReadValue = sp_acread.getSelectedItem().toString();
//                        String acWriteValue = sp_acwrite.getSelectedItem().toString();
//                        String acSpeakValue = sp_acspeak.getSelectedItem().toString();
//                        Float acList, acRead, acWrite, acSpeak;
//                        acList = Float.parseFloat(acListValue);
//                        acRead = Float.parseFloat(acReadValue);
//                        acWrite = Float.parseFloat(acWriteValue);
//                        acSpeak = Float.parseFloat(acSpeakValue);
//                        double avg = (acList + acRead + acWrite + acSpeak) / 4;

                    if (avg < 0.25) {
                        tvResult.setText("OVERALL BAND: " + (0));
                    } else if (avg >= 0.25 && avg < 0.75) {
                        tvResult.setText("OVERALL BAND: " + (0.5));
                    } else if (avg >= 0.75 && avg < 1.25) {
                        tvResult.setText("OVERALL BAND: " + (1));
                    } else if (avg >= 1.25 && avg < 1.75) {
                        tvResult.setText("OVERALL BAND: " + (1.5));
                    } else if (avg >= 1.75 && avg < 2.25) {
                        tvResult.setText("OVERALL BAND: " + (2));
                    } else if (avg >= 2.25 && avg < 2.75) {
                        tvResult.setText("OVERALL BAND: " + (2.5));
                    } else if (avg >= 2.75 && avg < 3.25) {
                        tvResult.setText("OVERALL BAND: " + (3));
                    } else if (avg >= 3.25 && avg < 3.75) {
                        tvResult.setText("OVERALL BAND: " + (3.5));
                    } else if (avg >= 3.75 && avg < 4.25) {
                        tvResult.setText("OVERALL BAND: " + (4));
                    } else if (avg >= 4.25 && avg < 4.75) {
                        tvResult.setText("OVERALL BAND: " + (4.5));
                    } else if (avg >= 4.75 && avg < 5.25) {
                        tvResult.setText("OVERALL BAND: " + (5));
                    } else if (avg >= 5.25 && avg < 5.75) {
                        tvResult.setText("OVERALL BAND: " + (5.5));
                    } else if (avg >= 5.75 && avg < 6.25) {
                        tvResult.setText("OVERALL BAND: " + (6));
                    } else if (avg >= 6.25 && avg < 6.75) {
                        tvResult.setText("OVERALL BAND: " + (6.5));
                    } else if (avg >= 6.75 && avg < 7.25) {
                        tvResult.setText("OVERALL BAND: " + (7));
                    } else if (avg >= 7.25 && avg < 7.75) {
                        tvResult.setText("OVERALL BAND: " + (7.5));
                    } else if (avg >= 7.75 && avg < 8.25) {
                        tvResult.setText("OVERALL BAND: " + (8));
                    } else if (avg >= 8.25 && avg < 8.75) {
                        tvResult.setText("OVERALL BAND: " + (8.5));
                    } else if (avg >= 8.75 && avg <= 9) {
                        tvResult.setText("OVERALL BAND: " + (9));
                    }


                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here

//                if (sp_aclist.getSelectedItemPosition() == 9 && sp_acwrite.getSelectedItemPosition() == 9
//                        && sp_acread.getSelectedItemPosition() == 9 && sp_acspeak.getSelectedItemPosition() == 9)
//                {
//                    tvResult.setText("OVERALL BAND: " + (9));
//                }

            }

        });


        btn_mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ACADEMIC_OVERALL_BAND.this, ACADEMIC_MARK_TO_BAND.class);
                startActivity(intent);
            }
        });

        btn_bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ACADEMIC_OVERALL_BAND.this, ACADEMIC_BAND_TO_MARK.class);
                startActivity(intent);
            }
        });
    }

    public void general()
    {

//        ACADEMIC_BAND_TO_MARK cls2 = new ACADEMIC_BAND_TO_MARK();
//        cls2.general();
//
//
//        ACADEMIC_MARK_TO_BAND cls3 = new ACADEMIC_MARK_TO_BAND();
//        cls3.general();

        setContentView(R.layout.activity_acd_totalband);
        lay_main_container = findViewById(R.id.lay_main_container);

        tv_ac = findViewById(R.id.tv_ac);


        tv_ac.setText("GENERAL");



        btn_mb = findViewById(R.id.btn_mb);
        btn_bm = findViewById(R.id.btn_bm);
        sp_aclist = findViewById(R.id.sp_aclist);
        sp_acread = findViewById(R.id.sp_acread);
        sp_acwrite = findViewById(R.id.sp_acwrite);
        sp_acspeak = findViewById(R.id.sp_acspeak);
        // btn_acd_submit = findViewById(R.id.btn_acd_submit);
        tvResult = findViewById(R.id.tv_result);


        strlist = getResources().getStringArray(R.array.strlist);
        strread = getResources().getStringArray(R.array.strread);
        strwrite = getResources().getStringArray(R.array.strwrite);
        strspeak = getResources().getStringArray(R.array.strspeak);


        ArrayAdapter<String> listspinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_dropdown_item,
                        strlist);
        listspinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        sp_aclist.setAdapter(listspinnerArrayAdapter);

        ArrayAdapter<String> readspinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        strread);
        readspinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        sp_acread.setAdapter(readspinnerArrayAdapter);

        ArrayAdapter<String> writespinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        strwrite);
        writespinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        sp_acwrite.setAdapter(writespinnerArrayAdapter);

        ArrayAdapter<String> speakspinnerArrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,
                        strspeak);
        speakspinnerArrayAdapter.setDropDownViewResource(android.R.layout
                .simple_spinner_dropdown_item);
        sp_acspeak.setAdapter(speakspinnerArrayAdapter);

        String acListValue = sp_aclist.getSelectedItem().toString();
        String acReadValue = sp_acread.getSelectedItem().toString();
        String acWriteValue = sp_acwrite.getSelectedItem().toString();
        String acSpeakValue = sp_acspeak.getSelectedItem().toString();
        Float acList, acRead, acWrite, acSpeak;
        acList = Float.parseFloat(acListValue);
        acRead = Float.parseFloat(acReadValue);
        acWrite = Float.parseFloat(acWriteValue);
        acSpeak = Float.parseFloat(acSpeakValue);

        double avg = (acList + acRead + acWrite + acSpeak) / 4;
        if (acList == 9 && acRead == 9 && acWrite == 9 && acSpeak == 9) {
            tvResult.setText("OVERALL BAND: " + (9));
        }


        sp_acspeak.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here
                String acListValue = sp_aclist.getSelectedItem().toString();
                String acReadValue = sp_acread.getSelectedItem().toString();
                String acWriteValue = sp_acwrite.getSelectedItem().toString();
                String acSpeakValue = sp_acspeak.getSelectedItem().toString();
                Float acList, acRead, acWrite, acSpeak;
                acList = Float.parseFloat(acListValue);
                acRead = Float.parseFloat(acReadValue);
                acWrite = Float.parseFloat(acWriteValue);
                acSpeak = Float.parseFloat(acSpeakValue);
                double avg = (acList + acRead + acWrite + acSpeak) / 4;

                if (acList != 0 && acRead != 0 && acWrite != 0 && acSpeak != 0)

                {

//                    if (isValidUser()) {
//                        String acListValue = sp_aclist.getSelectedItem().toString();
//                        String acReadValue = sp_acread.getSelectedItem().toString();
//                        String acWriteValue = sp_acwrite.getSelectedItem().toString();
//                        String acSpeakValue = sp_acspeak.getSelectedItem().toString();
//                        Float acList, acRead, acWrite, acSpeak;
//                        acList = Float.parseFloat(acListValue);
//                        acRead = Float.parseFloat(acReadValue);
//                        acWrite = Float.parseFloat(acWriteValue);
//                        acSpeak = Float.parseFloat(acSpeakValue);
//                        double avg = (acList + acRead + acWrite + acSpeak) / 4;

                    if (avg < 0.25) {
                        tvResult.setText("OVERALL BAND: " + (0));
                    } else if (avg >= 0.25 && avg < 0.75) {
                        tvResult.setText("OVERALL BAND: " + (0.5));
                    } else if (avg >= 0.75 && avg < 1.25) {
                        tvResult.setText("OVERALL BAND: " + (1));
                    } else if (avg >= 1.25 && avg < 1.75) {
                        tvResult.setText("OVERALL BAND: " + (1.5));
                    } else if (avg >= 1.75 && avg < 2.25) {
                        tvResult.setText("OVERALL BAND: " + (2));
                    } else if (avg >= 2.25 && avg < 2.75) {
                        tvResult.setText("OVERALL BAND: " + (2.5));
                    } else if (avg >= 2.75 && avg < 3.25) {
                        tvResult.setText("OVERALL BAND: " + (3));
                    } else if (avg >= 3.25 && avg < 3.75) {
                        tvResult.setText("OVERALL BAND: " + (3.5));
                    } else if (avg >= 3.75 && avg < 4.25) {
                        tvResult.setText("OVERALL BAND: " + (4));
                    } else if (avg >= 4.25 && avg < 4.75) {
                        tvResult.setText("OVERALL BAND: " + (4.5));
                    } else if (avg >= 4.75 && avg < 5.25) {
                        tvResult.setText("OVERALL BAND: " + (5));
                    } else if (avg >= 5.25 && avg < 5.75) {
                        tvResult.setText("OVERALL BAND: " + (5.5));
                    } else if (avg >= 5.75 && avg < 6.25) {
                        tvResult.setText("OVERALL BAND: " + (6));
                    } else if (avg >= 6.25 && avg < 6.75) {
                        tvResult.setText("OVERALL BAND: " + (6.5));
                    } else if (avg >= 6.75 && avg < 7.25) {
                        tvResult.setText("OVERALL BAND: " + (7));
                    } else if (avg >= 7.25 && avg < 7.75) {
                        tvResult.setText("OVERALL BAND: " + (7.5));
                    } else if (avg >= 7.75 && avg < 8.25) {
                        tvResult.setText("OVERALL BAND: " + (8));
                    } else if (avg >= 8.25 && avg < 8.75) {
                        tvResult.setText("OVERALL BAND: " + (8.5));
                    } else if (avg >= 8.75 && avg <= 9) {
                        tvResult.setText("OVERALL BAND: " + (9));
                    }


                }


            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here


            }

        });


        sp_aclist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here

                String acListValue = sp_aclist.getSelectedItem().toString();
                String acReadValue = sp_acread.getSelectedItem().toString();
                String acWriteValue = sp_acwrite.getSelectedItem().toString();
                String acSpeakValue = sp_acspeak.getSelectedItem().toString();
                Float acList, acRead, acWrite, acSpeak;
                acList = Float.parseFloat(acListValue);
                acRead = Float.parseFloat(acReadValue);
                acWrite = Float.parseFloat(acWriteValue);
                acSpeak = Float.parseFloat(acSpeakValue);
                double avg = (acList + acRead + acWrite + acSpeak) / 4;

                if (acList != 0 && acRead != 0 && acWrite != 0 && acSpeak != 0) {

//                    if (isValidUser()) {
//                        String acListValue = sp_aclist.getSelectedItem().toString();
//                        String acReadValue = sp_acread.getSelectedItem().toString();
//                        String acWriteValue = sp_acwrite.getSelectedItem().toString();
//                        String acSpeakValue = sp_acspeak.getSelectedItem().toString();
//                        Float acList, acRead, acWrite, acSpeak;
//                        acList = Float.parseFloat(acListValue);
//                        acRead = Float.parseFloat(acReadValue);
//                        acWrite = Float.parseFloat(acWriteValue);
//                        acSpeak = Float.parseFloat(acSpeakValue);
//                        double avg = (acList + acRead + acWrite + acSpeak) / 4;

                    if (avg < 0.25) {
                        tvResult.setText("OVERALL BAND: " + (0));
                    } else if (avg >= 0.25 && avg < 0.75) {
                        tvResult.setText("OVERALL BAND: " + (0.5));
                    } else if (avg >= 0.75 && avg < 1.25) {
                        tvResult.setText("OVERALL BAND: " + (1));
                    } else if (avg >= 1.25 && avg < 1.75) {
                        tvResult.setText("OVERALL BAND: " + (1.5));
                    } else if (avg >= 1.75 && avg < 2.25) {
                        tvResult.setText("OVERALL BAND: " + (2));
                    } else if (avg >= 2.25 && avg < 2.75) {
                        tvResult.setText("OVERALL BAND: " + (2.5));
                    } else if (avg >= 2.75 && avg < 3.25) {
                        tvResult.setText("OVERALL BAND: " + (3));
                    } else if (avg >= 3.25 && avg < 3.75) {
                        tvResult.setText("OVERALL BAND: " + (3.5));
                    } else if (avg >= 3.75 && avg < 4.25) {
                        tvResult.setText("OVERALL BAND: " + (4));
                    } else if (avg >= 4.25 && avg < 4.75) {
                        tvResult.setText("OVERALL BAND: " + (4.5));
                    } else if (avg >= 4.75 && avg < 5.25) {
                        tvResult.setText("OVERALL BAND: " + (5));
                    } else if (avg >= 5.25 && avg < 5.75) {
                        tvResult.setText("OVERALL BAND: " + (5.5));
                    } else if (avg >= 5.75 && avg < 6.25) {
                        tvResult.setText("OVERALL BAND: " + (6));
                    } else if (avg >= 6.25 && avg < 6.75) {
                        tvResult.setText("OVERALL BAND: " + (6.5));
                    } else if (avg >= 6.75 && avg < 7.25) {
                        tvResult.setText("OVERALL BAND: " + (7));
                    } else if (avg >= 7.25 && avg < 7.75) {
                        tvResult.setText("OVERALL BAND: " + (7.5));
                    } else if (avg >= 7.75 && avg < 8.25) {
                        tvResult.setText("OVERALL BAND: " + (8));
                    } else if (avg >= 8.25 && avg < 8.75) {
                        tvResult.setText("OVERALL BAND: " + (8.5));
                    } else if (avg >= 8.75 && avg <= 9) {
                        tvResult.setText("OVERALL BAND: " + (9));
                    }


                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
//                tvResult.setText("OVERALL BAND: " + (9));
            }

        });

        sp_acwrite.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here

                String acListValue = sp_aclist.getSelectedItem().toString();
                String acReadValue = sp_acread.getSelectedItem().toString();
                String acWriteValue = sp_acwrite.getSelectedItem().toString();
                String acSpeakValue = sp_acspeak.getSelectedItem().toString();
                Float acList, acRead, acWrite, acSpeak;
                acList = Float.parseFloat(acListValue);
                acRead = Float.parseFloat(acReadValue);
                acWrite = Float.parseFloat(acWriteValue);
                acSpeak = Float.parseFloat(acSpeakValue);
                double avg = (acList + acRead + acWrite + acSpeak) / 4;

                if (acList != 0 && acRead != 0 && acWrite != 0 && acSpeak != 0) {

//                    if (isValidUser()) {
//                        String acListValue = sp_aclist.getSelectedItem().toString();
//                        String acReadValue = sp_acread.getSelectedItem().toString();
//                        String acWriteValue = sp_acwrite.getSelectedItem().toString();
//                        String acSpeakValue = sp_acspeak.getSelectedItem().toString();
//                        Float acList, acRead, acWrite, acSpeak;
//                        acList = Float.parseFloat(acListValue);
//                        acRead = Float.parseFloat(acReadValue);
//                        acWrite = Float.parseFloat(acWriteValue);
//                        acSpeak = Float.parseFloat(acSpeakValue);
//                        double avg = (acList + acRead + acWrite + acSpeak) / 4;

                    if (avg < 0.25) {
                        tvResult.setText("OVERALL BAND: " + (0));
                    } else if (avg >= 0.25 && avg < 0.75) {
                        tvResult.setText("OVERALL BAND: " + (0.5));
                    } else if (avg >= 0.75 && avg < 1.25) {
                        tvResult.setText("OVERALL BAND: " + (1));
                    } else if (avg >= 1.25 && avg < 1.75) {
                        tvResult.setText("OVERALL BAND: " + (1.5));
                    } else if (avg >= 1.75 && avg < 2.25) {
                        tvResult.setText("OVERALL BAND: " + (2));
                    } else if (avg >= 2.25 && avg < 2.75) {
                        tvResult.setText("OVERALL BAND: " + (2.5));
                    } else if (avg >= 2.75 && avg < 3.25) {
                        tvResult.setText("OVERALL BAND: " + (3));
                    } else if (avg >= 3.25 && avg < 3.75) {
                        tvResult.setText("OVERALL BAND: " + (3.5));
                    } else if (avg >= 3.75 && avg < 4.25) {
                        tvResult.setText("OVERALL BAND: " + (4));
                    } else if (avg >= 4.25 && avg < 4.75) {
                        tvResult.setText("OVERALL BAND: " + (4.5));
                    } else if (avg >= 4.75 && avg < 5.25) {
                        tvResult.setText("OVERALL BAND: " + (5));
                    } else if (avg >= 5.25 && avg < 5.75) {
                        tvResult.setText("OVERALL BAND: " + (5.5));
                    } else if (avg >= 5.75 && avg < 6.25) {
                        tvResult.setText("OVERALL BAND: " + (6));
                    } else if (avg >= 6.25 && avg < 6.75) {
                        tvResult.setText("OVERALL BAND: " + (6.5));
                    } else if (avg >= 6.75 && avg < 7.25) {
                        tvResult.setText("OVERALL BAND: " + (7));
                    } else if (avg >= 7.25 && avg < 7.75) {
                        tvResult.setText("OVERALL BAND: " + (7.5));
                    } else if (avg >= 7.75 && avg < 8.25) {
                        tvResult.setText("OVERALL BAND: " + (8));
                    } else if (avg >= 8.25 && avg < 8.75) {
                        tvResult.setText("OVERALL BAND: " + (8.5));
                    } else if (avg >= 8.75 && avg <= 9) {
                        tvResult.setText("OVERALL BAND: " + (9));
                    }


                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
//                tvResult.setText("OVERALL BAND: " + (9));
            }

        });

        sp_acread.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // your code here

                String acListValue = sp_aclist.getSelectedItem().toString();
                String acReadValue = sp_acread.getSelectedItem().toString();
                String acWriteValue = sp_acwrite.getSelectedItem().toString();
                String acSpeakValue = sp_acspeak.getSelectedItem().toString();
                Float acList, acRead, acWrite, acSpeak;
                acList = Float.parseFloat(acListValue);
                acRead = Float.parseFloat(acReadValue);
                acWrite = Float.parseFloat(acWriteValue);
                acSpeak = Float.parseFloat(acSpeakValue);
                double avg = (acList + acRead + acWrite + acSpeak) / 4;

                if (acList != 0 && acRead != 0 && acWrite != 0 && acSpeak != 0) {

//                    if (isValidUser()) {
//                        String acListValue = sp_aclist.getSelectedItem().toString();
//                        String acReadValue = sp_acread.getSelectedItem().toString();
//                        String acWriteValue = sp_acwrite.getSelectedItem().toString();
//                        String acSpeakValue = sp_acspeak.getSelectedItem().toString();
//                        Float acList, acRead, acWrite, acSpeak;
//                        acList = Float.parseFloat(acListValue);
//                        acRead = Float.parseFloat(acReadValue);
//                        acWrite = Float.parseFloat(acWriteValue);
//                        acSpeak = Float.parseFloat(acSpeakValue);
//                        double avg = (acList + acRead + acWrite + acSpeak) / 4;

                    if (avg < 0.25) {
                        tvResult.setText("OVERALL BAND: " + (0));
                    } else if (avg >= 0.25 && avg < 0.75) {
                        tvResult.setText("OVERALL BAND: " + (0.5));
                    } else if (avg >= 0.75 && avg < 1.25) {
                        tvResult.setText("OVERALL BAND: " + (1));
                    } else if (avg >= 1.25 && avg < 1.75) {
                        tvResult.setText("OVERALL BAND: " + (1.5));
                    } else if (avg >= 1.75 && avg < 2.25) {
                        tvResult.setText("OVERALL BAND: " + (2));
                    } else if (avg >= 2.25 && avg < 2.75) {
                        tvResult.setText("OVERALL BAND: " + (2.5));
                    } else if (avg >= 2.75 && avg < 3.25) {
                        tvResult.setText("OVERALL BAND: " + (3));
                    } else if (avg >= 3.25 && avg < 3.75) {
                        tvResult.setText("OVERALL BAND: " + (3.5));
                    } else if (avg >= 3.75 && avg < 4.25) {
                        tvResult.setText("OVERALL BAND: " + (4));
                    } else if (avg >= 4.25 && avg < 4.75) {
                        tvResult.setText("OVERALL BAND: " + (4.5));
                    } else if (avg >= 4.75 && avg < 5.25) {
                        tvResult.setText("OVERALL BAND: " + (5));
                    } else if (avg >= 5.25 && avg < 5.75) {
                        tvResult.setText("OVERALL BAND: " + (5.5));
                    } else if (avg >= 5.75 && avg < 6.25) {
                        tvResult.setText("OVERALL BAND: " + (6));
                    } else if (avg >= 6.25 && avg < 6.75) {
                        tvResult.setText("OVERALL BAND: " + (6.5));
                    } else if (avg >= 6.75 && avg < 7.25) {
                        tvResult.setText("OVERALL BAND: " + (7));
                    } else if (avg >= 7.25 && avg < 7.75) {
                        tvResult.setText("OVERALL BAND: " + (7.5));
                    } else if (avg >= 7.75 && avg < 8.25) {
                        tvResult.setText("OVERALL BAND: " + (8));
                    } else if (avg >= 8.25 && avg < 8.75) {
                        tvResult.setText("OVERALL BAND: " + (8.5));
                    } else if (avg >= 8.75 && avg <= 9) {
                        tvResult.setText("OVERALL BAND: " + (9));
                    }


                }
            }


            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here

//                if (sp_aclist.getSelectedItemPosition() == 9 && sp_acwrite.getSelectedItemPosition() == 9
//                        && sp_acread.getSelectedItemPosition() == 9 && sp_acspeak.getSelectedItemPosition() == 9)
//                {
//                    tvResult.setText("OVERALL BAND: " + (9));
//                }

            }

        });


        btn_mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ACADEMIC_OVERALL_BAND.this, ACADEMIC_MARK_TO_BAND.class);
                startActivity(intent);
            }
        });

        btn_bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ACADEMIC_OVERALL_BAND.this, ACADEMIC_BAND_TO_MARK.class);
                startActivity(intent);
            }
        });


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


//                break;
                return true;
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
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;

    }


}


//            btn_acd_submit.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    if (isValidUser()) {
//                        String acListValue = sp_aclist.getSelectedItem().toString();
//                        String acReadValue = sp_acread.getSelectedItem().toString();
//                        String acWriteValue = sp_acwrite.getSelectedItem().toString();
//                        String acSpeakValue = sp_acspeak.getSelectedItem().toString();
//                        Float acList, acRead, acWrite, acSpeak;
//                        acList = Float.parseFloat(acListValue);
//                        acRead = Float.parseFloat(acReadValue);
//                        acWrite = Float.parseFloat(acWriteValue);
//                        acSpeak = Float.parseFloat(acSpeakValue);
//                        double avg = (acList + acRead + acWrite + acSpeak) / 4;
//
//                        if (avg < 0.25) {
//                            tvResult.setText("Result: " + (0));
//                        } else if (avg >= 0.25 && avg < 0.75) {
//                            tvResult.setText("Result: " + (0.5));
//                        } else if (avg >= 0.75 && avg < 1.25) {
//                            tvResult.setText("Result: " + (1));
//                        } else if (avg >= 1.25 && avg < 1.75) {
//                            tvResult.setText("Result: " + (1.5));
//                        } else if (avg >= 1.75 && avg < 2.25) {
//                            tvResult.setText("Result: " + (2));
//                        } else if (avg >= 2.25 && avg < 2.75) {
//                            tvResult.setText("Result: " + (2.5));
//                        } else if (avg >= 2.75 && avg < 3.25) {
//                            tvResult.setText("Result: " + (3));
//                        } else if (avg >= 3.25 && avg < 3.75) {
//                            tvResult.setText("Result: " + (3.5));
//                        } else if (avg >= 3.75 && avg < 4.25) {
//                            tvResult.setText("Result: " + (4));
//                        } else if (avg >= 4.25 && avg < 4.75) {
//                            tvResult.setText("Result: " + (4.5));
//                        } else if (avg >= 4.75 && avg < 5.25) {
//                            tvResult.setText("Result: " + (5));
//                        } else if (avg >= 5.25 && avg < 5.75) {
//                            tvResult.setText("Result: " + (5.5));
//                        } else if (avg >= 5.75 && avg < 6.25) {
//                            tvResult.setText("Result: " + (6));
//                        } else if (avg >= 6.25 && avg < 6.75) {
//                            tvResult.setText("Result: " + (6.5));
//                        } else if (avg >= 6.75 && avg < 7.25) {
//                            tvResult.setText("Result: " + (7));
//                        } else if (avg >= 7.25 && avg < 7.75) {
//                            tvResult.setText("Result: " + (7.5));
//                        } else if (avg >= 7.75 && avg < 8.25) {
//                            tvResult.setText("Result: " + (8));
//                        } else if (avg >= 8.25 && avg < 8.75) {
//                            tvResult.setText("Result: " + (8.5));
//                        } else if (avg >= 8.75 && avg <= 9) {
//                            tvResult.setText("Result: " + (9));
//                        }
//
//
//                    }
//                }
//            });
//        }

//    boolean isValidUser() {
//        if (sp_aclist.getSelectedItemPosition() == 0) {
//            showSnackbar("Please select Listening band");
//            return false;
//        }
//        if (sp_acread.getSelectedItemPosition() == 0) {
//            showSnackbar("Please select Reading band");
//            return false;
//        }
//        if (sp_acwrite.getSelectedItemPosition() == 0) {
//            showSnackbar("Please select Writing band");
//            return false;
//        }
//        if (sp_acspeak.getSelectedItemPosition() == 0) {
//            showSnackbar("Please select Speaking band");
//            return false;
//        }
//        return true;
//
//    }
//    private void showSnackbar(String text) {
//        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
//
//        Snackbar snackbar = Snackbar.make(lay_main_container, text, Snackbar.LENGTH_SHORT);
//        View sbView = snackbar.getView();
//        sbView.setBackgroundColor(Color.RED);
//        snackbar.show();


