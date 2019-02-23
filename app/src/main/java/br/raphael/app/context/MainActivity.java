package br.raphael.app.context;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;

import br.raphael.app.R;
import br.raphael.app.base.BaseActivity;
import br.raphael.app.context.login.LoginActivity;
import br.raphael.app.databinding.ActivityMainBinding;


public class MainActivity extends BaseActivity<ActivityMainBinding>
        implements BottomNavigationView.OnNavigationItemSelectedListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewLayout(R.layout.activity_main);

        startActivity(new Intent(this, LoginActivity.class));

        binding.bottomNavigation.navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                return true;
            case R.id.navigation_dashboard:
                return true;
            case R.id.navigation_notifications:
                return true;
        }
        return false;
    }
}
