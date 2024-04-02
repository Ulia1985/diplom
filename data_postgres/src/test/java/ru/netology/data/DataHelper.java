package ru.netology.data;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import lombok.SneakyThrows;
public class DataHelper {
    private static final QueryRunner QUERY_RUNNER = new QueryRunner();
    private DataHelper() {
    }
    private static Connection getConn() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "app", "pass");
    }
    @SneakyThrows
    public static String getStatusPayment() {
        var status = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return QUERY_RUNNER.query(conn, status, new ScalarHandler<String>());

    }
    @SneakyThrows
    public static String getStatusCredit() {
        var status = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return QUERY_RUNNER.query(conn, status, new ScalarHandler<String>());

    }
    @SneakyThrows
    public static String getStatusOrderCredit() {
        var id = "SELECT credit_id FROM order_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return QUERY_RUNNER.query(conn, id, new ScalarHandler<String>());

      }

    @SneakyThrows
    public static String getStatusOrderPayment() {
        var id = "SELECT payment_id FROM order_entity ORDER BY created DESC LIMIT 1";
        var conn = getConn();
        return QUERY_RUNNER.query(conn, id, new ScalarHandler<String>());

   }
   @SneakyThrows
   public static void cleanDB() {
       var connection = getConn();
       QUERY_RUNNER.execute(connection, "DELETE FROM credit_request_entity");
       QUERY_RUNNER.execute(connection, "DELETE FROM payment_entity");
       QUERY_RUNNER.execute(connection, "DELETE FROM order_entity");
    }

}