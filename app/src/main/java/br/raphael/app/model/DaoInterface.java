package br.raphael.app.model;

import android.support.annotation.NonNull;
import java.util.ArrayList;

public interface DaoInterface<Model> {
    boolean insert(@NonNull Model model);
    ArrayList<Model> list();
    boolean delete(@NonNull int id);
    boolean update(@NonNull int id, @NonNull Model model);
}
