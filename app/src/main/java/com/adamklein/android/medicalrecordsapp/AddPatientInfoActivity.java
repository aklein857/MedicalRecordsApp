package com.adamklein.android.medicalrecordsapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPatientInfoActivity extends AppCompatActivity {

    EditText firstName, middleName, lastName;
    Button submitInfoButton;
    String first_name, middle_name, last_name;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_info);

        //set EditText fields to the return value of their ID's and typecast to EditText

        firstName = (EditText)findViewById(R.id.editText_first_name);
        middleName = (EditText)findViewById(R.id.editText_middle_name);
        lastName = (EditText)findViewById(R.id.editText_last_name);


        submitInfoButton = (Button)findViewById(R.id.button_submit_info);

        //action listener for button
        submitInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set strings to String values of EditText objects

                first_name = firstName.getText().toString();
                middle_name = middleName.getText().toString();
                last_name = lastName.getText().toString();


                //insert info into database
                //create a new object of DatabaseOperations class and pass it the Context object
                DatabaseOperations db = new DatabaseOperations(ctx);
                db.putInformation(db, first_name, middle_name, last_name);

                Toast.makeText(AddPatientInfoActivity.this, R.string.info_submitted_toast, Toast.LENGTH_SHORT).show();
                finish();

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_patient_info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
