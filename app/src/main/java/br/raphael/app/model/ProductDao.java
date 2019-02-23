package br.raphael.app.model;

import android.support.annotation.NonNull;

import java.util.ArrayList;

public class ProductDao implements DaoInterface<Product> {
    @Override
    public boolean insert(@NonNull Product product) {
        return false;
    }

    @Override
    public ArrayList<Product> list() {
        return null;
    }

    @Override
    public boolean delete(@NonNull int id) {
        return false;
    }

    @Override
    public boolean update(@NonNull int id, @NonNull Product product) {
        return false;
    }
}
