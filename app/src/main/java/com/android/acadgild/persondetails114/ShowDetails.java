package com.android.acadgild.persondetails114;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.acadgild.persondetails114.database.DBHelper;
import com.android.acadgild.persondetails114.model.PersonData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jal on 28-07-2017.
 */

public class ShowDetails extends Activity {

    private TextView welcomeMsg;
    DBHelper dbHelper;
    List<PersonData> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_record);
        TextView tvShowDet = (TextView)findViewById(R.id.txtDisplayRecord);

        Intent intentObject = getIntent();


        String userNameBundle=intentObject.getExtras().getString("BundleUserName");



        tvShowDet.setText(userNameBundle);




    }
}
