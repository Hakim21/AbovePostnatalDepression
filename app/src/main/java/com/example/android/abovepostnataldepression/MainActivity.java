package com.example.android.abovepostnataldepression;


import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import com.example.android.abovepostnataldepression.repo.TreatmentRepo;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements android.view.View.OnClickListener {


        Button btnAdd,btnGetAll,btnLogin,newTreatment;
        ListView list;
        TextView treatment_Id;


        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.btnAdd){

                Intent intent = new Intent(this,view_treatment_details.class);
                intent.putExtra("treatment_Id",0);
                startActivity(intent);

            }else{

                TreatmentRepo repo = new TreatmentRepo(this);

                ArrayList<HashMap<String, String>> treatmentList =  repo.getTreatmentList();
                if(treatmentList.size()!=0) {
                    ListView listview = (ListView) findViewById(R.id.list);
                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,int position, long treatment_ID) {
                            treatment_Id = (TextView) view.findViewById(R.id.treatment_Id);
                            String treatmentId = treatment_Id.getText().toString();
                            Intent objIndent = new Intent(getApplicationContext(),view_treatment_details.class);
                            objIndent.putExtra("treatment_Id", Integer.parseInt( treatmentId));
                            startActivity(objIndent);
                        }
                    });
                    ListAdapter adapter = new SimpleAdapter( MainActivity.this,treatmentList, R.layout.activity_view_treatment_entry, new String[] { "TreatmentId","TreatmentName"}, new int[] {R.id.treatment_Id, R.id.treatment_name});
                    listview.setAdapter(adapter);
                }else{
                    Toast.makeText(this,"No Treatment!",Toast.LENGTH_SHORT).show();
                }

            }
            if (view.getId() == R.id.btnLogin) {

                Intent objIndent = new Intent(getApplicationContext(),Register.class);
                startActivity(objIndent);
            }
            else{
                Toast.makeText(this,"No Treatment!",Toast.LENGTH_SHORT).show();
            }



        }

    private void insertSampleData(){

        TreatmentRepo treatmentRepo   = new TreatmentRepo(this);

/*

        //Insert Sample data if the table is empty
        Treatment treatment = new Treatment();

        treatment.setTreatmentName("CBT");
        treatment.setTreatmentType("CBT-Type");
        treatment.setTreatmentNumber(9);
        treatment.setTreatment_ID(01);
//        treatmentRepo.insert(treatment);

        treatment.setTreatmentName("CCBT");
        treatment.setTreatmentType("Pschyo");
        treatment.setTreatmentNumber(8);
        treatment.setTreatment_ID(02);
//        treatmentRepo.insert(treatment);

        treatment.setTreatmentName("Medication");
        treatment.setTreatmentType("Antidepressant");
        treatment.setTreatmentNumber(7);
        treatment.setTreatment_ID(03);
//        treatmentRepo.insert(treatment);
*/


    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item){
                return true;
            }
        });
        myToolbar.inflateMenu(R.menu.menu);


        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(this);

        btnGetAll = (Button) findViewById(R.id.btnGetAll);
        btnGetAll.setOnClickListener(this);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);

//        insertSampleData();
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
            case R.id.newRegistration:

                Intent regIndent = new Intent(getApplicationContext(), Register.class);
                startActivity(regIndent);
                break;
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
