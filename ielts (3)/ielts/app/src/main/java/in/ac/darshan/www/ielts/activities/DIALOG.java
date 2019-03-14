package in.ac.darshan.www.ielts.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import in.ac.darshan.www.ielts.R;

/**
 * Created by Infiniti on 2/12/2019.
 */

public class DIALOG extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);

        //Get the widgets reference from XML layout
        final TextView tv_lst = (TextView) findViewById(R.id.tv_lst);
        NumberPicker np_ac_lst = (NumberPicker) findViewById(R.id.np_ac_lst);
        final TextView tv_red = (TextView) findViewById(R.id.tv_red);
        NumberPicker np_ac_red = (NumberPicker) findViewById(R.id.np_ac_red);
        final TextView tv_sep = (TextView) findViewById(R.id.tv_sep);
        NumberPicker np_ac_sep = (NumberPicker) findViewById(R.id.np_ac_sep);
        final TextView tv_write = (TextView) findViewById(R.id.tv_write);
        NumberPicker np_ac_write = (NumberPicker) findViewById(R.id.np_ac_write);

        //Set TextView text color
        tv_lst.setTextColor(Color.parseColor("#ffd32b3b"));
        tv_red.setTextColor(Color.parseColor("#ffd32b3b"));
        tv_sep.setTextColor(Color.parseColor("#ffd32b3b"));
        tv_write.setTextColor(Color.parseColor("#ffd32b3b"));

        //Populate NumberPicker values from minimum and maximum value range
        //Set the minimum value of NumberPicker

        np_ac_lst.setMinValue(0);
        np_ac_red.setMinValue(0);
        np_ac_sep.setMinValue(0);
        np_ac_write.setMinValue(0);
        //Specify the maximum value/number of NumberPicker
        np_ac_lst.setMaxValue(9);
        np_ac_red.setMaxValue(9);
        np_ac_sep.setMaxValue(9);
        np_ac_write.setMaxValue(9);
        //Gets whether the selector wheel wraps when reaching the min/max value.

        np_ac_lst.setWrapSelectorWheel(true);
        np_ac_red.setWrapSelectorWheel(true);
        np_ac_sep.setWrapSelectorWheel(true);
        np_ac_write.setWrapSelectorWheel(true);

        //Set a value change listener for NumberPicker
        np_ac_lst.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                tv_lst.setText("Selected Number : " + newVal);
            }
        });

        np_ac_red.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                tv_red.setText("Selected Number : " + newVal);
            }
        });

        np_ac_sep.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                tv_sep.setText("Selected Number : " + newVal);
            }
        });
        np_ac_write.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal){
                //Display the newly selected number from picker
                tv_write.setText("Selected Number : " + newVal);
            }
        });

    }
}

