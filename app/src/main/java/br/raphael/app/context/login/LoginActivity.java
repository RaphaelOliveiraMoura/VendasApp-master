package br.raphael.app.context.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import br.raphael.app.R;
import br.raphael.app.base.BaseActivity;
import br.raphael.app.databinding.ActivityLoginBinding;
import hari.bounceview.BounceView;

public class LoginActivity extends BaseActivity<ActivityLoginBinding>
        implements LoginPresenter.LoginViewInterface {

    private LoginPresenterInterface presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setViewLayout(R.layout.activity_login);

        presenter = new LoginPresenter(this);

        BounceView.addAnimTo(binding.btnGoogleLogin);
        BounceView.addAnimTo(binding.btnFacebookLogin);
        BounceView.addAnimTo(binding.btnSignUp);

        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.btnLogin.startAnimation();
                binding.btnLogin.setBackgroundColor(getResources().getColor(R.color.white));
                validateLogin();
            }
        });
    }

    @Override
    public void showLoadDialog() {

    }

    @Override
    public void dimissLoadDialog() {

    }

    @Override
    public void setLoginError() {
        binding.etLogin.setError("Login/Email inválido");
    }

    @Override
    public void setPasswordError() {
        binding.etPassword.setError("Senha inválida");
    }

    @Override
    public void validateLogin() {
        presenter.validate(
                binding.etLogin.getText().toString(),
                binding.etPassword.getText().toString());
    }

    @Override
    public void goToSignUpScreen() {
        startActivity(new Intent());
    }
}

