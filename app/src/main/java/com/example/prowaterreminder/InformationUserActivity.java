package com.example.prowaterreminder;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Locale;

public class InformationUserActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_apdung;
    private CheckBox checkBoxMale;
    private CheckBox checkBoxFemale;
    private CheckBox checkBoxAnother;
    private EditText weightNumber;
    private TextView awakeTime;
    private TextView sleepTime;
    private String gender;
    int hourAwake = -1, minuteAwake = -1, hourSleep = -1, minuteSleep = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_user);

        btn_apdung = (Button) findViewById(R.id.btn_apdung);
        checkBoxMale = (CheckBox) findViewById(R.id.checkBoxMale);
        checkBoxFemale = (CheckBox) findViewById(R.id.checkBoxFemale);
        checkBoxAnother = (CheckBox) findViewById(R.id.checkBoxAnother);
        weightNumber = (EditText) findViewById(R.id.weightNumber);
        awakeTime = (TextView) findViewById(R.id.awakeTime);
        sleepTime = (TextView) findViewById(R.id.sleepTime);

        // Tạo event cho btn_apdung
        btn_apdung.setOnClickListener(this);

        // Tạo event cho checkbox
        checkBoxMale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                if (isCheck) {
                    checkBoxFemale.setChecked(false);
                    checkBoxAnother.setChecked(false);
                }
            }
        });
        checkBoxFemale.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                if (isCheck) {
                    checkBoxMale.setChecked(false);
                    checkBoxAnother.setChecked(false);
                }
            }
        });
        checkBoxAnother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheck) {
                if (isCheck) {
                    checkBoxMale.setChecked(false);
                    checkBoxFemale.setChecked(false);
                }
            }
        });
    }

    @Override
    public void onClick(View view) {
        if (view == btn_apdung) {
            if (!checkBoxMale.isChecked() && !checkBoxFemale.isChecked() && !checkBoxAnother.isChecked()) {
                Toast.makeText(this, "Hãy chọn giới tính của bạn", Toast.LENGTH_SHORT).show();
            }

            else if (weightNumber.getText().toString().isEmpty()) {
                Toast.makeText(this, "Hãy nhập cân nặng của bạn", Toast.LENGTH_SHORT).show();
            }

            else if (hourAwake == -1 || hourSleep == -1 || minuteAwake == -1 || minuteSleep == -1) {
                Toast.makeText(this, "Hãy nhập đủ thời gian thức dậy và đi ngủ của bạn", Toast.LENGTH_LONG).show();
            }

            else {
                if (checkBoxMale.isChecked() || checkBoxAnother.isChecked()) gender = "Nam";
                else gender = "Nữ";
                UserData userData = new UserData(Float.parseFloat(weightNumber.getText().toString()), gender, hourAwake, hourSleep, minuteAwake, minuteSleep);
                launchHomeScreen();
            }
        }
    }

    private void launchHomeScreen() {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        finish();
    }

    public void popTimeAwakePicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectHour, int selectMinute) {
                hourAwake = selectHour;
                minuteAwake = selectMinute;
                awakeTime.setText(String.format(Locale.getDefault(), "%02d:%02d", hourAwake, minuteAwake));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hourAwake, minuteAwake, true);
        timePickerDialog.setTitle("Giờ dậy");
        timePickerDialog.show();
    }

    public void popTimeSleepPicker(View view) {
        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int selectHour, int selectMinute) {
                hourSleep = selectHour;
                minuteSleep = selectMinute;
                sleepTime.setText(String.format(Locale.getDefault(), "%02d:%02d", hourSleep, minuteSleep));
            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hourSleep, minuteSleep, true);
        timePickerDialog.setTitle("Giờ ngủ");
        timePickerDialog.show();
    }


}