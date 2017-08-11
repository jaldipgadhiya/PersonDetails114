package com.android.acadgild.persondetails114.utils;

import android.content.Context;

import com.android.acadgild.persondetails114.database.DBHelper;


/**
 * Created by Jal on 28-07-2017.
 */

public class CommonUtilities {

    /**
     * Check if singleton object of DB is null and not open; in the case
     * reinitialize and open DB.
     *
     * @param mContext
     */
    public static DBHelper getDBObject(Context mContext) {
        DBHelper dbhelper = DBHelper.getInstance(mContext);
        return dbhelper;
    }
}
