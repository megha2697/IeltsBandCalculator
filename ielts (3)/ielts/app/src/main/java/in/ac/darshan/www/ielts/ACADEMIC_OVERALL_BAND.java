package in.ac.darshan.www.ielts;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Infiniti on 9/16/2018.
 */

public class ACADEMIC_OVERALL_BAND extends AppCompatActivity {

    Spinner sp_aclist,sp_acread,sp_acwrite,sp_acspeak;
    Button btn_acd_submit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acd_totalband);

        sp_aclist= findViewById(R.id.sp_aclist);
        sp_acread= findViewById(R.id.sp_acread);
        sp_acwrite= findViewById(R.id.sp_acwrite);
        sp_acspeak= findViewById(R.id.sp_acspeak);
       // btn_acd_submit= findViewById(R.id.btn_acd_submit);

        String  num1= sp_aclist.getSelectedItem().toString();
        String  num2= sp_acread.getSelectedItem().toString();
        String  num3= sp_acwrite.getSelectedItem().toString();
        String  num4= sp_acspeak.getSelectedItem().toString();




//        btn_acd_submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                Toast.makeText(ACADEMIC_OVERALL_BAND.this,
//                        "Total : " +
//                                (
//                                "\nSpinner 1 : "+ String.valueOf(sp_aclist.getSelectedItem()) +
//                                "\nSpinner 1 : "+ String.valueOf(sp_acwrite.getSelectedItem()) +
//                                "\nSpinner 1 : "+ String.valueOf(sp_acspeak.getSelectedItem()) +
//                                "\nSpinner 2 : "+ String.valueOf(sp_acread.getSelectedItem())
//                                ),
//                        Toast.LENGTH_SHORT).show();
//
//
//            }
//            });
    }
}
