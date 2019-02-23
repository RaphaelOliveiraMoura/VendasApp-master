package br.raphael.app.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import java.util.List;

import br.raphael.app.R;
import br.raphael.app.base.BaseRecyclerViewAdapter;
import br.raphael.app.databinding.FragmentProductsBinding;
import br.raphael.app.model.Product;

public class ProductsAdapter extends BaseRecyclerViewAdapter<Product, FragmentProductsBinding> {

    public ProductsAdapter(Context context, @NonNull List<Product> list) {
        super(context, list);
    }

    @Override
    public int setLayoutResource() {
        return R.layout.fragment_products;
    }

    @Override
    public void setViews(FragmentProductsBinding binding, int position) {
        
    }
}
