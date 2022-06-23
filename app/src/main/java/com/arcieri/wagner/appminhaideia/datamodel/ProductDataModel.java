package com.arcieri.wagner.appminhaideia.datamodel;

public class ProductDataModel {

    public static final String TABLE = "product_tbl";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DEALER = "dealer";

    public static String createTable() {

        String queryCreateTable = "";

        queryCreateTable += "CREATE TABLE " + TABLE + " (";
        queryCreateTable += NAME + " text,";
        queryCreateTable += DEALER + " text";
        queryCreateTable += ")";

        return queryCreateTable;
    }


}
