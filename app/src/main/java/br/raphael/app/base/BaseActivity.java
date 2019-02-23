package br.raphael.app.base;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity<Binding extends ViewDataBinding> extends AppCompatActivity {

    protected Binding binding;

    public void setViewLayout(int layoutResID) {
        binding = DataBindingUtil.setContentView(this, layoutResID);
    }

    public Activity getActivity(){
        return this;
    }
}
