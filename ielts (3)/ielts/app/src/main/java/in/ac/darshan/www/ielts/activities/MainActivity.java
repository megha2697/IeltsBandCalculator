package in.ac.darshan.www.ielts.activities;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import in.ac.darshan.www.ielts.R;

public class MainActivity extends AppCompatActivity {

    Button btn_acd,btn_gen,btn_accob,btn_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_acd = findViewById(R.id.btn_acd);
        btn_gen = findViewById(R.id.btn_gen);

        btn_accob = findViewById(R.id.btn_accob);
        btn_dialog = findViewById(R.id.btn_dialog);




        btn_acd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ACADEMIC_CHOOSE.class);
                startActivity(intent);
            }
        });

        btn_gen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GENERAL_CHOOSE.class);
                startActivity(intent);
            }
        });

        btn_accob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ACADEMIC_OVERALL_BAND.class);
                startActivity(intent);
            }
        });

        btn_dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,DIALOG.class);
                startActivity(intent);
            }
        });


    }
}
