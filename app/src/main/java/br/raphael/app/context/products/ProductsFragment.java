package br.raphael.app.context.products;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.raphael.app.R;
import br.raphael.app.adapters.ProductsAdapter;
import br.raphael.app.base.BaseFragment;
import br.raphael.app.databinding.FragmentProductsBinding;
import br.raphael.app.model.Product;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends BaseFragment<FragmentProductsBinding>
        implements ProductsPresenter.ProductsViewInterface {

    private ProductsPresenterInterface presenter;

    private ProductsAdapter productsAdapter;

    public ProductsFragment() { }

    @Override
    public int setLayoutResource() {
        return R.layout.fragment_products;
    }

    @Override
    public void onCreateView(View view, Bundle savedInstanceState) {
        this.presenter = new ProductsPresenter(this);

        presenter.setList();
    }

    @Override
    public void showLoadDialog() {

    }

    @Override
    public void dimissLoadDialog() {

    }

    @Override
    public void refershList() {
        productsAdapter.refresh();
    }

    @Override
    public void setList(List<Product> list) {
        productsAdapter = new ProductsAdapter(getContext(), list);
        binding.rvProducts.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.rvProducts.setAdapter(productsAdapter);
    }
}
