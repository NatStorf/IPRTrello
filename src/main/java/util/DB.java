package util;

import org.apache.commons.codec.digest.DigestUtils;
import java.sql.*;

public class DB {
    public static void main(String[]args){
        connectAndWritePass();
    }

    public static void connectAndWritePass() {
        Connection connection;
        Statement statement;
            try {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Test1", "postgres", "hello");
                connection.setAutoCommit(false);
                System.out.println("-- Opened database successfully");
                String sql;
                statement = connection.createStatement();
                sql = "INSERT INTO date  (login, pass) VALUES ('Storf1@yandex.ru','" + hashPass() + "');";
                statement.executeUpdate(sql);
                System.out.println("в ДБ добавленны данные: Storf1@yandex.ru "+hashPass());
            } catch (Exception ex) {
                System.out.println("Connection failed...");

                System.out.println(ex);
            }
        }


    private static String hashPass(){
        String pass= "90idASwda1Y2";
        return DigestUtils.md5Hex(pass);
    }
}
