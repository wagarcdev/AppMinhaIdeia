package com.arcieri.wagner.appminhaideia.datamodel;

public class ClientDataModel {

    //Modelo Objeto Relacional

    // 1 - table name
    public static final String TABLE = "client_tbl";

    // 2 - attributes

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EMAIL = "email";
    public static final String AGE = "age";
    public static final String TELEPHONE = "telephone";
    public static final String GENDER = "gender";

    // 3 Query to create table

    // 4 - Method to generate Script to create table
    public static String createTable() {

        String queryCreateTable = "";

        queryCreateTable += "CREATE TABLE " + TABLE + " (";
        queryCreateTable += ID + " integer primary key autoincrement, ";
        queryCreateTable += NAME + " text, ";
        queryCreateTable += EMAIL + " text, ";
        queryCreateTable += AGE + " integer, ";
        queryCreateTable += TELEPHONE + " integer, ";
        queryCreateTable += GENDER + " boolean ";
        queryCreateTable += ")";

        return queryCreateTable;

    }


}
