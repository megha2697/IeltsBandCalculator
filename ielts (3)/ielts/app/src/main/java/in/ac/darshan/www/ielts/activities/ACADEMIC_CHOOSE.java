package in.ac.darshan.www.ielts.activities;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import in.ac.darshan.www.ielts.R;

/**
 * Created by Infiniti on 12/21/2018.
 */

public class ACADEMIC_CHOOSE extends AppCompatActivity {

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
                Intent intent = new Intent(ACADEMIC_CHOOSE.this,ACADEMIC_MARK_TO_BAND.class);
                startActivity(intent);
            }
        });

        btn_bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ACADEMIC_CHOOSE.this,ACADEMIC_BAND_TO_MARK.class);
                startActivity(intent);
            }
        });


    }
}
