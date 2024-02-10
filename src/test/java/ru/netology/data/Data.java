package ru.netology.data;


import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import ru.netology.data.constructor.CreditConstructor;
import ru.netology.data.constructor.PaymentConstructor;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Data {
    private Data() {
}
    private static final String schemas = System.getProperty("schemas");

    @SneakyThrows
    public static Connection connectToSQL() {
        String url = System.getProperty("db.url");
        String user = System.getProperty("db.user");
        String password = System.getProperty("db.password");
        return DriverManager.getConnection(url, user, password);

    }
    @SneakyThrows
    public static void cleanUpDB() {
        var runner = new QueryRunner();
        var payment_entitySQL = "DELETE FROM " + schemas + ".payment_entity;";
        var credit_request_entitySQL = "DELETE FROM " + schemas + ".credit_request_entity;";
        var order_entitySQL = "DELETE FROM " + schemas + ".order_entity;";
        try (
                var conn = connectToSQL()
        ) {
            runner.update(conn, payment_entitySQL);
            runner.update(conn, credit_request_entitySQL);
            runner.update(conn, order_entitySQL);
        }
    }

    @SneakyThrows
    public static String countAll() {
        var runner = new QueryRunner();
        var countCreditSQL = "SELECT COUNT(*) FROM " + schemas + ".credit_request_entity;";
        var countPaymentSQL = "SELECT COUNT(*) FROM " + schemas + ".payment_entity;";
        var countOrderSQL = "SELECT COUNT(*) FROM " + schemas + ".order_entity;";
        try (
                var conn = connectToSQL()
        ) {
            var countCreditTb = runner.query(conn, countCreditSQL, new ScalarHandler<>());
            var countPaymentTb = runner.query(conn, countPaymentSQL, new ScalarHandler<>());
            var countOrderTb = runner.query(conn, countOrderSQL, new ScalarHandler<>());
            return countCreditTb.toString() + countPaymentTb.toString() + countOrderTb.toString();
        }

    }

    @SneakyThrows
    public static PaymentConstructor paymentData() {
        var runner = new QueryRunner();
        var dataPaymentSQL = "SELECT * FROM " + schemas + ".payment_entity;";
        try (
                var conn = connectToSQL()
        ) {
            var allPaymentDataSQL = runner.query(conn, dataPaymentSQL, new BeanHandler<>(PaymentConstructor.class));
            return allPaymentDataSQL;
        }
    }

    @SneakyThrows
    public static CreditConstructor creditData() {
        var runner = new QueryRunner();
        var dataCreditSQL = "SELECT * FROM " + schemas + ".credit_request_entity;";
        try (
                var conn = connectToSQL()
        ) {
            var allCreditDataSQL = runner.query(conn, dataCreditSQL, new BeanHandler<>(CreditConstructor.class));
            return allCreditDataSQL;
        }
    }

}