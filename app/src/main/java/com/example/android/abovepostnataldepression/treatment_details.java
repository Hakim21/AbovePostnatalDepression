package com.example.android.abovepostnataldepression;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.android.abovepostnataldepression.repo.TreatmentRepo;


public class treatment_details extends AppCompatActivity implements android.view.View.OnClickListener {


    Button btnSave ,  btnDelete;
    Button btnClose;
    EditText editTextTreatmentName;
    EditText editTextTreatmentType;
    EditText editTextTreatmentNumber;

    private int _Treatment_Id=0;
    private DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment_details);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item){
                return true;
            }
        });
        myToolbar.inflateMenu(R.menu.menu);

/*
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
        editTextTreatmentNumber.setText(String.valueOf(treatment.editTextTreatmentNumber));*/



    }


    public void onClick(View v) {
        if (v.getId() == R.id.btnSave) {
            TreatmentRepo repo = new TreatmentRepo(this);
            Treatment treatment = new Treatment();

            editTextTreatmentName = (EditText) findViewById(R.id.editTextTreatmentName);
            editTextTreatmentType = (EditText) findViewById(R.id.editTextTreatmentType);
            editTextTreatmentNumber = (EditText) findViewById(R.id.editTextTreatmentNumber);
            btnSave = (Button) findViewById(R.id.btnSave);
            btnSave.setOnClickListener(this);

            int treatmentNumber = Integer.parseInt(editTextTreatmentNumber.getText().toString());
            String treatmentType = editTextTreatmentType.getText().toString();
            String treatmentName = editTextTreatmentName.getText().toString();


            treatment.setEditTextTreatmentNumber(treatmentNumber);
            treatment.setEditTextTreatmentName(treatmentName);
            treatment.setEditTextTreatmentType(treatmentType);

            if(treatment != null) {

                repo.insert(treatment);

                Toast.makeText(this, "Additional Treatment Insert", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            }
            else{

                Toast.makeText(this, "Could not save Treatment ", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, Register.class));
            }

        }else if (v.getId() == R.id.btnDelete){
            TreatmentRepo repo = new TreatmentRepo(this);
            repo.delete(_Treatment_Id);
            Toast.makeText(this, "Treatment Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (v.getId() == R.id.btnClose){
            finish();
        }




    }


/*    public void onClick(View view) {
        if (view == findViewById(R.id.btnSave)){
            TreatmentRepo repo = new TreatmentRepo(this);
            Treatment treatment = new Treatment();
            treatment.editTextTreatmentNumber = Integer.parseInt(editTextTreatmentNumber.getText().toString());
            treatment.editTextTreatmentType = editTextTreatmentType.getText().toString();
            treatment.editTextTreatmentName = editTextTreatmentName.getText().toString();
            treatment.treatment_ID=_Treatment_Id;

            if (_Treatment_Id==0){
                _Treatment_Id = repo.insert(treatment);

                Toast.makeText(this,"New Treatment Insert",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, MainActivity.class));
            }else{

                repo.update(treatment);
                Toast.makeText(this,"Treatment Record updated",Toast.LENGTH_SHORT).show();
            }
        }else if (view== findViewById(R.id.btnDelete)){
            TreatmentRepo repo = new TreatmentRepo(this);
            repo.delete(_Treatment_Id);
            Toast.makeText(this, "Treatment Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.btnClose)){
            finish();
        }


    }*/



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


}
