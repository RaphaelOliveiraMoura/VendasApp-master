package br.raphael.app.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public abstract class BaseFragment<Binding extends ViewDataBinding> extends Fragment {

    protected Context context;
    protected Binding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, setLayoutResource(), container, false);
        View view = binding.getRoot();
        context = view.getContext();

        onCreateView(view, savedInstanceState);

        return view;
    }

    public abstract int setLayoutResource();
    public abstract void onCreateView(View view, Bundle savedInstanceState);

    public Context getContext(){
        return context;
    }

}
