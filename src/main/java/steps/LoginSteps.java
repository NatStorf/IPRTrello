package steps;

import pages.LoginPage;

public class LoginSteps {
    public static void login(String email, String pass) throws InterruptedException {
        LoginPage.login().sendKeys(email);
        LoginPage.btnLogin().click();
        Thread.sleep(1000);
        LoginPage.password().sendKeys(pass);
        LoginPage.loginSubmit().click();
        Thread.sleep(10000);
    }
}