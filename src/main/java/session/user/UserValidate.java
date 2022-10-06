package session.user;

import layout.controller.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UserValidate {
    protected boolean loginRequire = true;

    public boolean validate(HttpServletRequest request) {
        if (this.getLoginRequire()) {
            HttpSession session = request.getSession();
            Object usrToken = session.getAttribute("usrToken");

            return usrToken != null;
        }

        return true;
    }

    public boolean getLoginRequire() {
        return this.loginRequire;
    }

    public UserValidate setLoginRequire(boolean status) {
        this.loginRequire = status;

        return this;
    }
}
