package com.adamklein.android.medicalrecordsapp;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static DatabaseOperations myDB;

    private Button mAddPatientInfo;
    private Button mShowPatientInfo;
    private Button mUpdatePatientInfo;
    private Button mDeletePatientInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseOperations(this);


        mAddPatientInfo = (Button)findViewById(R.id.add_info_button);
        mAddPatientInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddPatientInfoActivity.class);
                startActivity(i);
            }
        });

        mShowPatientInfo = (Button)findViewById(R.id.show_info_button);
        mShowPatientInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor res = myDB.getAllData();
                if (res.getCount() == 0){
                    showMessage("Error", "No data was found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while(res.moveToNext()){

                    buffer.append("ID:  " + res.getString(0)+"\n");
                    buffer.append("First Name:  " + res.getString(1)+"\n");
                    buffer.append("Middle Name:  " + res.getString(2)+"\n");
                    buffer.append("Last Name:  " + res.getString(3)+"\n");
                    buffer.append("Email:  " + res.getString(4)+"\n");
                    buffer.append("Social Security:  " + res.getString(5)+"\n");
                    buffer.append("Phone Number:  " + res.getString(6)+"\n");
                    buffer.append("Address: " + res.getString(7) + " " + res.getString(8) + "\n"
                            + "                 " + res.getString(9) + ", " + res.getString(10)
                            + " " + res.getString(11) + "\n");
                    buffer.append("Age:  " + res.getString(12)+"\n");
                    buffer.append("Gender:  " + res.getString(13)+"\n");
                    buffer.append("Ethnicity:  " + res.getString(14)+"\n\n");
                }

                showMessage("Data", buffer.toString());

            }
        });

        mUpdatePatientInfo = (Button)findViewById(R.id.update_info_button);
        mUpdatePatientInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, UpdateInformationActivity.class);
                startActivity(i);

            }
        });

        mDeletePatientInfo = (Button)findViewById(R.id.delete_info_button);
        mDeletePatientInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this, DeletePatientInfo.class);
                startActivity(i);
                
            }
        });
    }

    public void showMessage(String title, String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
