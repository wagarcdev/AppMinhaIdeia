package com.arcieri.wagner.appminhaideia.controller;

import static com.arcieri.wagner.appminhaideia.api.AppUtil.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.arcieri.wagner.appminhaideia.datamodel.ClientDataModel;
import com.arcieri.wagner.appminhaideia.datasource.AppDataBase;
import com.arcieri.wagner.appminhaideia.model.Client;

import java.util.List;

public class ClientController extends AppDataBase implements ICrud<Client> {

    ContentValues objectValues;

    public ClientController(Context context) {
        super(context);

        Log.i(TAG, "ClientController: CONNECTED");
    }

    @Override
    public boolean include(Client object) {

        objectValues = new ContentValues();

        objectValues.put(ClientDataModel.NAME, object.getName());
        objectValues.put(ClientDataModel.EMAIL, object.getEmail());
        objectValues.put(ClientDataModel.AGE, object.getAge());
        objectValues.put(ClientDataModel.TELEPHONE, object.getTelephone());
        objectValues.put("gender", object.isGender());

        return insert(ClientDataModel.TABLE, objectValues);

    }

    @Override
    public List<Client> retrieve() {



        return getAllClients(ClientDataModel.TABLE);

    }

    @Override
    public boolean update(Client object) {

        objectValues = new ContentValues();

        objectValues.put(ClientDataModel.ID, object.getID());
        objectValues.put(ClientDataModel.NAME, object.getName());
        objectValues.put(ClientDataModel.EMAIL, object.getEmail());
        objectValues.put(ClientDataModel.AGE, object.getAge());
        objectValues.put(ClientDataModel.TELEPHONE, object.getTelephone());
        objectValues.put("gender", object.isGender());

        return updateByID(ClientDataModel.TABLE, objectValues);
    }

    @Override
    public boolean delete(int id) {
        return removeByID(ClientDataModel.TABLE, id);
    }
}
