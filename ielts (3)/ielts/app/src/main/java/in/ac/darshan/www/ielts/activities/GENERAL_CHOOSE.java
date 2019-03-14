package in.ac.darshan.www.ielts.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import in.ac.darshan.www.ielts.R;

/**
 * Created by Infiniti on 1/10/2019.
 */

public class GENERAL_CHOOSE extends AppCompatActivity {


        Button btn_mb,btn_bm;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_acd_choose);

            btn_mb = findViewById(R.id.btn_mb);
            btn_bm = findViewById(R.id.btn_bm);



            btn_mb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(GENERAL_CHOOSE.this,GENERAL_MARK_TO_BAND.class);
                    startActivity(intent);
                }
            });

            btn_bm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(GENERAL_CHOOSE.this,GENERAL_BAND_TO_MARK.class);
                    startActivity(intent);
                }
            });


        }
    }


