package com.arcieri.wagner.appminhaideia.controller;

import java.util.List;

public interface ICrud<T> {

    public boolean include(T object);

    public List<T> retrieve();

    public boolean update(T object);

    public boolean delete(int id);


}
