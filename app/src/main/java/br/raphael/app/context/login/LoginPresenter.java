package br.raphael.app.context.login;

public class LoginPresenter implements LoginPresenterInterface {

    private LoginViewInterface view;

    public LoginPresenter(LoginViewInterface view){
        this.view = view;
    }

    @Override
    public boolean validate(String login, String password) {
        return false;
    }

    public interface LoginViewInterface{
        void showLoadDialog();
        void dimissLoadDialog();
        void setLoginError();
        void setPasswordError();
        void validateLogin();
        void goToSignUpScreen();
    }
}
