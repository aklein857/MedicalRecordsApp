package com.adamklein.android.medicalrecordsapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeletePatientInfo extends AppCompatActivity {

    private Button deleteDataButton;
    private EditText deleteDataEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_patient_info);

        deleteDataEditText = (EditText)findViewById(R.id.editText_id_to_be_deleted);
        deleteDataButton = (Button)findViewById(R.id.delete_patient_info_button);
        deleteDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int deletedRows = MainActivity.myDB.deleteData(deleteDataEditText.getText().toString());

                if(deletedRows > 0){
                    Toast.makeText(DeletePatientInfo.this, "Data deleted successfully",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DeletePatientInfo.this, "Failed to delete data",
                            Toast.LENGTH_SHORT).show();
                }

                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_delete_patient_info, menu);
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
