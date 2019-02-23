package br.raphael.app.context.products;

import java.util.ArrayList;
import java.util.List;

import br.raphael.app.model.Product;

public class ProductsPresenter implements ProductsPresenterInterface{

    private ProductsViewInterface view;

    public ProductsPresenter(ProductsViewInterface view){
        this.view = view;
    }

    @Override
    public void setList() {
        view.setList(new ArrayList<Product>());
    }

    public interface ProductsViewInterface{
        void showLoadDialog();
        void dimissLoadDialog();
        void refershList();
        void setList(List<Product> list);
    }
}
