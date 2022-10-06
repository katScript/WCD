package user.controller;

import layout.controller.AbstractController;

import javax.servlet.annotation.WebServlet;

@WebServlet(name="user", urlPatterns = {"/user/login"})
public class Login extends AbstractController {
    public Login() {
        super();

        this.userValidate.setLoginRequire(false);
        this.viewControllerRegistry
                .setViewController("/views/user/login.jsp");

        this.pageContentRegistry.setTitle("Login");
    }
}
