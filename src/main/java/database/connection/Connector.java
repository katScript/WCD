package database.connection;

import java.sql.Connection;
import com.mysql.cj.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connector {
    private String urlConnection;
    private String user;
    private String password;

    private Connection con;

    public Connector() {
        this.urlConnection = "jdbc:mysql://localhost:3306/wcd";
        this.user = "root";
        this.password = "18072001@Kat";

        this.connector();
    }

    public Connector(String urlConnection, String user, String password) {
        this.urlConnection = urlConnection;
        this.user = user;
        this.password = password;

        this.connector();
    }

    public String getUrlConnection() {
        return urlConnection;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Connection getConnection() {
        return this.con;
    }

    private void setConnection(Connection con) {
        this.con = con;

    }

    private void connector() {
        try {
            new Driver();
            Connection con = DriverManager.getConnection(this.getUrlConnection(), this.getUser(), this.getPassword());
            this.setConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
