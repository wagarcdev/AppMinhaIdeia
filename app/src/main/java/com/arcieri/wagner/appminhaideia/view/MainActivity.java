package com.arcieri.wagner.appminhaideia.view;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.arcieri.wagner.appminhaideia.R;
import com.arcieri.wagner.appminhaideia.controller.ClientController;
import com.arcieri.wagner.appminhaideia.controller.ProductController;
import com.arcieri.wagner.appminhaideia.model.Client;

public class MainActivity extends AppCompatActivity {


    ClientController clientController;
    ProductController productController;
    Client client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clientController = new ClientController(getApplicationContext());
        productController = new ProductController(getApplicationContext());

        for (int i = 0; i < 69; i++) {
            client = new Client();
            client.setName("Wagner Arcieri "+(i+1));
            client.setEmail("wagner"+(i+1)+"@gmail.com");
            client.setAge(22+i);
            client.setTelephone("(48) 9 9999 9999");
            client.setGender(true);

            clientController.include(client);
        }





//        if (clientController.create(client)) {
//            Toast.makeText(
//                    this,
//                    "Client " + client.getName() + " successfully created",
//                    Toast.LENGTH_SHORT
//            ).show();
//            Log.i(TAG, "Client " + client.getName() + " successfully created");
//
//        } else {
//            Toast.makeText(
//                    this,
//                    "Client " + client.getName() + "  creation FAILED.",
//                    Toast.LENGTH_SHORT
//            ).show();
//            Log.e(TAG, "Client " + client.getName() + " creation FAILED");
//        }

//        if (clientController.update(client)) {
//            Toast.makeText(
//                    this,
//                    "Client " + client.getName() + " successfully Updated",
//                    Toast.LENGTH_SHORT
//            ).show();
//            Log.i(TAG, "Client " + client.getName() + " successfully Updated");
//
//        } else {
//            Toast.makeText(
//                    this,
//                    "Client " + client.getName() + "  update FAILED.",
//                    Toast.LENGTH_SHORT
//            ).show();
//            Log.e(TAG, "Client " + client.getName() + " update FAILED");
//        }

        for (Client client: clientController.retrieve()) {
            Log.i("RETURN", "onCreate: "+client.getID()+""+client.getName());
        }




    }


}