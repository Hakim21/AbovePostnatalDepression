package com.example.android.abovepostnataldepression;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;
import android.app.TimePickerDialog;

import java.util.Calendar;
import com.example.android.abovepostnataldepression.repo.TreatmentRepo;

public class view_treatment_details extends AppCompatActivity implements android.view.View.OnClickListener {


    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextTreatmentName;
    EditText editTextTreatmentType;
    EditText editTextTreatmentNumber;
    EditText time;

    private int _Treatment_Id=0;
    private DBHelper dbHelper;
    TimePicker alarmTimePicker;
    PendingIntent pendingIntent;
    AlarmManager alarmManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_treatment_details);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item){
                return true;
            }
        });
        myToolbar.inflateMenu(R.menu.menu);
        /*alarmTimePicker = (TimePicker) findViewById(R.id.timePicker);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);*/



        btnSave = (Button) findViewById(R.id.btnSave);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnClose = (Button) findViewById(R.id.btnClose);

        editTextTreatmentName = (EditText) findViewById(R.id.editTextTreatmentName);
        editTextTreatmentType = (EditText) findViewById(R.id.editTextTreatmentType);
        editTextTreatmentNumber = (EditText) findViewById(R.id.editTextTreatmentNumber);


        btnSave.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
        btnClose.setOnClickListener(this);


        _Treatment_Id =0;
        Intent intent = getIntent();
        _Treatment_Id =intent.getIntExtra("treatment_Id", 0);
        TreatmentRepo repo = new TreatmentRepo(this);
        Treatment treatment = new Treatment();
        treatment = repo.getTreatmentById(_Treatment_Id);

        editTextTreatmentName.setText(treatment.editTextTreatmentName);
        editTextTreatmentType.setText(treatment.editTextTreatmentType);
        editTextTreatmentNumber.setText(String.valueOf(treatment.editTextTreatmentNumber));

        time = (EditText) findViewById(R.id.time);
        // perform click event listener on edit text
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(view_treatment_details.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        time.setText(selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, true);//Yes 24 hour time
                mTimePicker.setTitle("Select Time");
                mTimePicker.show();

            }
        });



    }



        public void onClick(View view) {
            if (view == findViewById(R.id.btnSave)){
                TreatmentRepo repo = new TreatmentRepo(this);
                Treatment treatment = new Treatment();
                treatment.editTextTreatmentNumber = Integer.parseInt(editTextTreatmentNumber.getText().toString());
                treatment.editTextTreatmentType = editTextTreatmentType.getText().toString();
                treatment.editTextTreatmentName = editTextTreatmentName.getText().toString();
                treatment.treatment_ID = _Treatment_Id;

                if (_Treatment_Id==0){
                    _Treatment_Id = repo.insert(treatment);

                    Toast.makeText(this,"New Treatment Insert",Toast.LENGTH_SHORT).show();
                }else{

                    repo.update(treatment);
                    Toast.makeText(this,"Treatment Record updated",Toast.LENGTH_SHORT).show();
                }
            }else if (view== findViewById(R.id.btnDelete)){
                TreatmentRepo repo = new TreatmentRepo(this);
                repo.delete(_Treatment_Id);
                Toast.makeText(this, "Student Record Deleted", Toast.LENGTH_SHORT);
                finish();
            }else if (view== findViewById(R.id.btnClose)){
                finish();
            }


        }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.newTreatment:
                Intent objIndent = new Intent(getApplicationContext(),treatment_details.class);
                startActivity(objIndent);
                break;
            case R.id.action_refresh:
                // another startActivity, this is for item with id "menu_item2"
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }

    public void OnToggleClicked(View view)
    {
        long time;
        if (((ToggleButton) view).isChecked())
        {


            /*Toast.makeText(this,"ALARM ON",Toast.LENGTH_SHORT).show();
            Calendar calendar = Calendar.getInstance();
            if (Build.VERSION.SDK_INT >= 23 )
                alarmTimePicker.getHour();
            else
                alarmTimePicker.getCurrentHour();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);

            calendar.set(Calendar.HOUR_OF_DAY, alarmTimePicker.getMinute());
            calendar.set(Calendar.MINUTE, alarmTimePicker.getCurrentMinute());

            Intent intent = new Intent(this, AlarmReceiver.class);
            pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);

            time=(calendar.getTimeInMillis()-(calendar.getTimeInMillis()%60000));
            if(System.currentTimeMillis()>time)
            {
                if (calendar.AM_PM == 0)
                    time = time + (1000*60*60*12);
                else
                    time = time + (1000*60*60*24);
            }
            alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, time, 10000, pendingIntent);*/

        }
        else
        {
            alarmManager.cancel(pendingIntent);
            Toast.makeText(this,"ALARM OFF",Toast.LENGTH_SHORT).show();

        }
    }


}
