package com.example.android.abovepostnataldepression; /**
 * Created by bolaadeyeyeomisade on 31/08/2017.
 */


import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import com.example.android.abovepostnataldepression.DBHelper;
import com.example.android.abovepostnataldepression.Treatment;
import com.example.android.abovepostnataldepression.repo.TreatmentRepo;

import java.util.ArrayList;
public class TreatmentDetail extends AppCompatActivity implements android.view.View.OnClickListener {


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


        }


/*
        public void onClick(View view) {
            if (view == findViewById(R.id.btnSave)){
                TreatmentRepo repo = new TreatmentRepo(this);
                Treatment treatment = new Treatment();
                treatment.treatmentNumber= Integer.parseInt(editTextTreatmentNumber.getText().toString());
                treatment.treatmentType=editTextTreatmentType.getText().toString();
                treatment.treatmentName=editTextTreatmentName.getText().toString();
                treatment.treatment_ID=_Treatment_Id;

                if (_Treatment_Id==0){
                    _Treatment_Id = repo.insert(treatment);

                    Toast.makeText(this,"New Student Insert",Toast.LENGTH_SHORT).show();
                }else{

                    repo.update(treatment);
                    Toast.makeText(this,"Student Record updated",Toast.LENGTH_SHORT).show();
                }
            }else if (view== findViewById(R.id.btnDelete)){
                TreatmentRepo repo = new TreatmentRepo(this);
                repo.delete(_Treatment_Id);
                Toast.makeText(this, "Student Record Deleted", Toast.LENGTH_SHORT);
                finish();
            }else if (view== findViewById(R.id.btnClose)){
                finish();
            }


        }*/

/*
    public void onClick(View view) {
        if (view.getId() == R.id.btnSave) {


            editTextTreatmentName = (EditText) findViewById(R.id.editTextTreatmentName);
            editTextTreatmentType = (EditText) findViewById(R.id.editTextTreatmentType);
            editTextTreatmentNumber = (EditText) findViewById(R.id.editTextTreatmentNumber);

            btnSave = (Button) findViewById(R.id.btnSave);
            btnDelete = (Button) findViewById(R.id.btnDelete);
            btnClose = (Button) findViewById(R.id.btnClose);

            btnSave.setOnClickListener(this);
            btnDelete.setOnClickListener(this);
            btnClose.setOnClickListener(this);
            Treatment treatment = new Treatment();


*//*            _Treatment_Id =0;
            Intent intent = getIntent();
            _Treatment_Id =intent.getIntExtra("treatment_Id", 0);
            TreatmentRepo repo = new TreatmentRepo(this);
            Treatment treatment = new Treatment();
            treatment = repo.getTreatmentById(_Treatment_Id);*//*

 *//*           editTextTreatmentNumber.setText(String.valueOf(treatment.treatmentNumber));
            editTextTreatmentName.setText(treatment.treatmentName);
            editTextTreatmentType.setText(treatment.treatmentType);
            TreatmentRepo repo = new TreatmentRepo(this);*//*

            TreatmentRepo repo = new TreatmentRepo(this);

            int treatmentNumber = Integer.parseInt(editTextTreatmentNumber.getText().toString());
            String treatmentType = editTextTreatmentType.getText().toString();
            String treatmentName = editTextTreatmentName.getText().toString();
//            int treatment_ID = _Treatment_Id;
            if (treatmentName.isEmpty()) {
                Toast.makeText(this,"Treatment name cannot be empty!",Toast.LENGTH_SHORT).show();


            } else {

                treatment.setTreatmentNumber(treatmentNumber);
                treatment.setTreatmentName(treatmentName);
                treatment.setTreatmentType(treatmentType);

                repo.insert(treatment);

                Toast.makeText(this, "New Treatment Insert", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, view_treatment_entry.class));


*//*            if (_Treatment_Id == 0){

                treatment.setTreatmentNumber(treatmentNumber);
                treatment.setTreatmentName(treatmentName);
                treatment.setTreatmentType(treatmentType);


                _Treatment_Id = repo.insert(treatment);

                Toast.makeText(this,"New Student Insert",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, view_treatment_entry.class));
            }else{

                repo.update(treatment);
                Toast.makeText(this,"Student Record updated",Toast.LENGTH_SHORT).show();
            }*//*
            }
        }
        else{
            Toast.makeText(this,"No Treatment!",Toast.LENGTH_SHORT).show();
        }

 *//*       else if (view== findViewById(R.id.btnDelete)){
            TreatmentRepo repo = new TreatmentRepo(this);
            repo.deleteID(_Treatment_Id);
            Toast.makeText(this, "Student Record Deleted", Toast.LENGTH_SHORT);
            finish();
        }else if (view== findViewById(R.id.btnAdd)){
            TreatmentRepo repo = new TreatmentRepo(this);
            Treatment treatment = new Treatment();
            repo.delete();
            finish();
        }
*//*

    }*/


    public void onClick(View v) {
        if (v.getId() == R.id.btnSave) {
            TreatmentRepo repo = new TreatmentRepo(this);


            editTextTreatmentName = (EditText) findViewById(R.id.editTextTreatmentName);
            editTextTreatmentType = (EditText) findViewById(R.id.editTextTreatmentType);
            editTextTreatmentNumber = (EditText) findViewById(R.id.editTextTreatmentNumber);
            btnSave = (Button) findViewById(R.id.btnSave);
            btnSave.setOnClickListener(this);

            int treatmentNumber = Integer.parseInt(editTextTreatmentNumber.getText().toString());
            String treatmentType = editTextTreatmentType.getText().toString();
            String treatmentName = editTextTreatmentName.getText().toString();

            Treatment treatment = new Treatment();
            treatment.setEditTextTreatmentNumber(treatmentNumber);
            treatment.setEditTextTreatmentName(treatmentName);
            treatment.setEditTextTreatmentType(treatmentType);

            repo.insert(treatment);

            Toast.makeText(this, "New Treatment Insert", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, view_treatment_entry.class));






/*            if (treatmentName.isEmpty())
            {

                Toast.makeText(this,"Treatment name cannot be empty!",Toast.LENGTH_SHORT).show();

            }
            else
            {

                Treatment treatment = new Treatment();
                treatment.setTreatmentNumber(treatmentNumber);
                treatment.setTreatmentName(treatmentName);
                treatment.setTreatmentType(treatmentType);

                repo.insert(treatment);

                Toast.makeText(this, "New Treatment Insert", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, view_treatment_entry.class));

            }*/


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


}
