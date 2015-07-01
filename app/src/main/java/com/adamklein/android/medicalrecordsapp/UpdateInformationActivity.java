package com.adamklein.android.medicalrecordsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateInformationActivity extends AppCompatActivity {



    private Button btnSubmitUpdatedInfo;

    EditText id, firstName, middleName, lastName, email, socialSecurity, phoneNumber, houseNumber,
            street, city, state, zip, age, gender, ethnicity;

    String str_id, first_name, middle_name, last_name, email_address, street_name, city_name,
            state_name, gender_identity, ethnicity_type;
    int house_number, zip_code, age_in_years;
    long phone_number, social_security;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_information);

        id = (EditText)findViewById(R.id.editText_ID);
        firstName = (EditText)findViewById(R.id.editText_first_name_update);
        middleName = (EditText)findViewById(R.id.editText_middle_name_update);
        lastName = (EditText)findViewById(R.id.editText_last_name_update);
        email = (EditText)findViewById(R.id.editText_email_update);
        socialSecurity = (EditText)findViewById(R.id.editText_social_security_update);
        phoneNumber = (EditText)findViewById(R.id.editText_phone_number_update);
        houseNumber = (EditText)findViewById(R.id.editText_house_number_update);
        street = (EditText)findViewById(R.id.editText_street_update);
        city = (EditText)findViewById(R.id.editText_city_update);
        state = (EditText)findViewById(R.id.editText_state_update);
        zip = (EditText)findViewById(R.id.editText_zip_update);
        age = (EditText)findViewById(R.id.editText_age_update);
        gender = (EditText)findViewById(R.id.editText_gender_update);
        ethnicity = (EditText)findViewById(R.id.editText_ethnicity_update);

        btnSubmitUpdatedInfo = (Button)findViewById(R.id.button_submit_updated_info);
        btnSubmitUpdatedInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                str_id = id.getText().toString();
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

                boolean isUpdated = MainActivity.myDB.updateData(str_id, first_name, middle_name,
                        last_name, email_address, social_security,
                        phone_number, house_number, street_name, city_name, state_name, zip_code,
                        age_in_years, gender_identity, ethnicity_type);

                if(isUpdated) {
                    Toast.makeText(UpdateInformationActivity.this, R.string.data_updated_toast,
                            Toast.LENGTH_SHORT).show();
                }
                    else {
                    Toast.makeText(UpdateInformationActivity.this, R.string.data_not_updated_toast,
                            Toast.LENGTH_SHORT).show();
                }
                finish();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_update_informtion, menu);
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
