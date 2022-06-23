package com.arcieri.wagner.appminhaideia.datasource;

import static com.arcieri.wagner.appminhaideia.api.AppUtil.TAG;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.arcieri.wagner.appminhaideia.datamodel.ClientDataModel;
import com.arcieri.wagner.appminhaideia.datamodel.ProductDataModel;
import com.arcieri.wagner.appminhaideia.model.Client;
import com.arcieri.wagner.appminhaideia.model.Product;

import java.util.ArrayList;
import java.util.List;

public class AppDataBase extends SQLiteOpenHelper {

    public static final String DB_NAME = "AppMinhaIdeia.sqlite";
    public static final int DB_VERSION = 1;

    SQLiteDatabase sqLiteDatabase;


    public AppDataBase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);

        Log.d(TAG, "AppDataBase: Creating Database... ");

        sqLiteDatabase = getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
            sqLiteDatabase.execSQL(ClientDataModel.createTable());

            Log.d(
                    TAG, "onCreate: Clients table created...:\n"
                    +ClientDataModel.createTable()
            );

        } catch (SQLException e) {Log.e(TAG, "onCreate: "+e.getLocalizedMessage()); }


        try {
            sqLiteDatabase.execSQL(ProductDataModel.createTable());

            Log.d(
                    TAG, "onCreate: Products table created...:\n"
                    +ProductDataModel.createTable()
            );

        } catch (SQLException e) {Log.e(TAG, "onCreate: "+e.getLocalizedMessage()); }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public boolean insert(String table, ContentValues data) {

        sqLiteDatabase = getWritableDatabase();

        boolean queryReturn = false;

        try {
            queryReturn = sqLiteDatabase.insert(table, null, data) > 0;
        } catch (Exception e) {
            Log.e(TAG, "insert: " +e.getLocalizedMessage() );
        }

        return queryReturn;
    }

    public boolean removeByID(String table, int id) {

        sqLiteDatabase = getWritableDatabase();

        boolean queryReturn = false;

        try {
            queryReturn = sqLiteDatabase.delete(
                    table,
                    "id = ?",
                    new String[] {String.valueOf(id)}) > 0;

        } catch (Exception e) {
            Log.e(TAG, "removeByID: " +e.getLocalizedMessage() );
        }

        return queryReturn;
    }

    public boolean updateByID(String table, ContentValues data) {

        sqLiteDatabase = getWritableDatabase();

        boolean queryReturn = false;

        try {
            queryReturn = sqLiteDatabase.update(
                    table,
                    data,
                    "id = ?",
                    new String[] { String.valueOf(data.get("id"))} )> 0;

        } catch (Exception e) {
            Log.e(TAG, "updateByID: "+e.getLocalizedMessage() );
        }



        return queryReturn;
    }

    @SuppressLint("Range")
    public List<Client> getAllClients(String table) {

        sqLiteDatabase = getWritableDatabase();

        List<Client> clients = new ArrayList<>();

        Client client;

        String sqlQuery = "SELECT * FROM "+table;

        Cursor cursor = sqLiteDatabase.rawQuery(sqlQuery, null);

        if (cursor.moveToFirst()) {
            do{
                client = new Client();
                client.setID(cursor.getInt(cursor.getColumnIndex(ClientDataModel.ID)));
                client.setName(cursor.getString(cursor.getColumnIndex(ClientDataModel.NAME)));
                client.setEmail(cursor.getString(cursor.getColumnIndex(ClientDataModel.EMAIL)));
                client.setAge(cursor.getInt(cursor.getColumnIndex(ClientDataModel.AGE)));
                client.setGender(cursor.getInt(cursor.getColumnIndex(ClientDataModel.GENDER)) > 0);

                clients.add(client);

                Log.i("CLIENT_LIST", "getAllClients: "+client.getName()+" retrieved");

            } while(cursor.moveToNext());
        }


        return clients;
    }

public List<Product> getAllProducts(String table){

        sqLiteDatabase = getWritableDatabase();

        boolean queryReturn = false;

//        try {
//            queryReturn = sqLiteDatabase.rawQuery()
//        }

        return null;
    }


}
