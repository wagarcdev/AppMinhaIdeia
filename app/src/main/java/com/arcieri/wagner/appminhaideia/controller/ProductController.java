package com.arcieri.wagner.appminhaideia.controller;

import static com.arcieri.wagner.appminhaideia.api.AppUtil.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import com.arcieri.wagner.appminhaideia.datamodel.ProductDataModel;
import com.arcieri.wagner.appminhaideia.datasource.AppDataBase;
import com.arcieri.wagner.appminhaideia.model.Product;

import java.util.List;

public class ProductController extends AppDataBase implements ICrud<Product>{

    ContentValues objectValues;

    public ProductController(Context context) {
        super(context);

        Log.i(TAG, "ProductController: CONNECTED");
    }

    @Override
    public boolean include(Product object) {

        objectValues = new ContentValues();

        objectValues.put(ProductDataModel.ID, object.getID());
        objectValues.put(ProductDataModel.NAME, object.getName());
        objectValues.put(ProductDataModel.DEALER, object.getDealer());

        return insert(ProductDataModel.TABLE, objectValues);
    }

    @Override
    public List<Product> retrieve() {

        return getAllProducts(ProductDataModel.TABLE);
    }

    @Override
    public boolean update(Product object) {

        objectValues = new ContentValues();

        objectValues.put(ProductDataModel.ID, object.getID());
        objectValues.put(ProductDataModel.NAME, object.getName());
        objectValues.put(ProductDataModel.DEALER, object.getDealer());

        return updateByID(ProductDataModel.TABLE, objectValues);

    }

    @Override
    public boolean delete(int id) {
        return removeByID(ProductDataModel.TABLE, id);
    }
}
