package com.android.acadgild.persondetails114;

import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.acadgild.persondetails114.database.DBHelper;
import com.android.acadgild.persondetails114.model.PersonData;
import com.android.acadgild.persondetails114.utils.CommonUtilities;
import com.android.acadgild.persondetails114.utils.Constants;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    DBHelper dbHelper;
    String recordDetails;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




    }

    //To insert Person Record
    public void insertPersonRecord(View v){

        dbHelper= CommonUtilities.getDBObject(this);

        EditText id = (EditText)findViewById(R.id.etId);
        EditText firstName = (EditText)findViewById(R.id.etFirstName);
        EditText lastName = (EditText)findViewById(R.id.etLastName);
        ContentValues vals = new ContentValues();
        vals.put(Constants.PERSON_ID, id.getText().toString());
        vals.put(Constants.PERSON_FIRST_NAME, firstName.getText().toString());
        vals.put(Constants.PERSON_LAST_NAME, lastName.getText().toString());
       long insId = dbHelper.insertContentVals(Constants.PERSON_RECORD, vals);

        if(insId != -1)
            Toast.makeText(MainActivity.this, "New row added, row id: " + insId, Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
    }

    //To Clear UI fields
    public void clearDetails(View v){

        EditText id = (EditText)findViewById(R.id.etId);
        EditText firstName = (EditText)findViewById(R.id.etFirstName);
        EditText lastName = (EditText)findViewById(R.id.etLastName);
        id.setText("");
        firstName.setText("");
        lastName.setText("");

    }

    //To show person details
    public void showDetails(View v){
        List<PersonData> dataList;
        dbHelper= CommonUtilities.getDBObject(this);
        Intent openNewActivity = new Intent(MainActivity.this, ShowDetails.class);
        dataList = dbHelper.getAllPersons();
        Log.e("sizemain", "= " + dataList.size());
        List<String> listTitle = new ArrayList<String>();
        //Forming String to display record on Screen
        for (int i = 0; i < dataList.size(); i++) {

            if (i == 0) {
                recordDetails = "Id:" + dataList.get(i).getPersonId() + ",First Name:" + dataList.get(i).getPersonFirstName() + ",Last Name:" + dataList.get(i).getPersonLastName();
            } else {
                recordDetails = recordDetails + "\n" + "Id:" + dataList.get(i).getPersonId() + ",First Name:" + dataList.get(i).getPersonFirstName() + ",Last Name:" + dataList.get(i).getPersonLastName();
            }
            //Creatig Bundle
            Bundle dataBundle = new Bundle();
            dataBundle.putString("BundleUserName", recordDetails);
            // openNewActivity.putExtra("isRegistered", true);
            openNewActivity.putExtras(dataBundle);

            startActivity(openNewActivity);
        }
    }


}
