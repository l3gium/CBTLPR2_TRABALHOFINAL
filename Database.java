package tp.gson;

import java.sql.*;

public class Database {
    private static final String CONNECTION_STRING = 
            "jdbc:sqlserver://DESKTOP-A7BJJV6\\SQLEXPRESS;Database=TRABALHO_FINAL;IntegratedSecurity=true;encrypt=true;trustServerCertificate=true";

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver not found");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONNECTION_STRING);
    }

    public static void main(String[] args) {
        try (Connection con = getConnection()) {
            System.out.println("Conexão OK");
        } catch (SQLException ex) {
            System.out.println("Erro na conexão com o banco de dados");
            ex.printStackTrace();
        }
    }
}
