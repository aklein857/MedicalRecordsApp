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

    EditText firstName, middleName, lastName, email, socialSecurity, phoneNumber, houseNumber,
                street, city, state, zip, age, gender, ethnicity;
    Button submitInfoButton;
    String first_name, middle_name, last_name, email_address, street_name, city_name,
            state_name, gender_identity, ethnicity_type;
    int house_number, zip_code, age_in_years;
    long phone_number, social_security;
    Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_patient_info);

        //set EditText fields to the return value of their ID's and typecast to EditText

        firstName = (EditText)findViewById(R.id.editText_first_name);
        middleName = (EditText)findViewById(R.id.editText_middle_name);
        lastName = (EditText)findViewById(R.id.editText_last_name);
        email = (EditText)findViewById(R.id.editText_email);
        socialSecurity = (EditText)findViewById(R.id.editText_social_security);
        phoneNumber = (EditText)findViewById(R.id.editText_phone_number);
        houseNumber = (EditText)findViewById(R.id.editText_house_number);
        street = (EditText)findViewById(R.id.editText_street);
        city = (EditText)findViewById(R.id.editText_city);
        state = (EditText)findViewById(R.id.editText_state);
        zip = (EditText)findViewById(R.id.editText_zip);
        age = (EditText)findViewById(R.id.editText_age);
        gender = (EditText)findViewById(R.id.editText_gender);
        ethnicity = (EditText)findViewById(R.id.editText_ethnicity);



        submitInfoButton = (Button)findViewById(R.id.button_submit_info);

        //action listener for button
        submitInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //set strings to String values of EditText objects

                first_name = firstName.getText().toString();
                middle_name = middleName.getText().toString();
                last_name = lastName.getText().toString();
                email_address = email.getText().toString();
                social_security = Long.parseLong(socialSecurity.getText().toString());
                phone_number = Long.parseLong(phoneNumber.getText().toString());
                house_number = Integer.parseInt(houseNumber.getText().toString());
                street_name = street.getText().toString();
                city_name = city.getText().toString();
                state_name = state.getText().toString();
                zip_code = Integer.parseInt(zip.getText().toString());
                age_in_years = Integer.parseInt(age.getText().toString());
                gender_identity = gender.getText().toString();
                ethnicity_type = ethnicity.getText().toString();



                //insert info into database
                //create a new object of DatabaseOperations class and pass it the Context object
                DatabaseOperations db = new DatabaseOperations(ctx);
                db.putInformation(db, first_name, middle_name, last_name, email_address, social_security,
                        phone_number, house_number, street_name, city_name, state_name, zip_code,
                        age_in_years, gender_identity, ethnicity_type);

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
