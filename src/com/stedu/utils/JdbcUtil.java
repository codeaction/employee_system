package com.stedu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
/**
 * 封装重复代码，简化JDBC操作
 *
 * 解析配置文件，加载四大参数 加载一次
 */
public class JdbcUtil {
    private static DataSource dataSource;
    //private static Connection connection;
    private static ThreadLocal<Connection> tl = new ThreadLocal<>(); //事务处理中，使用的公共的连接，只能在事务处理中使用

    static {
        try {
            Properties prop = new Properties();
            InputStream in = JdbcUtil.class.getResourceAsStream("/jdbc.properties");
            prop.load(in);
            //创建连接池
            dataSource = DruidDataSourceFactory.createDataSource(prop);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    //开启事务
    public static void beginTransaction() throws SQLException {
        Connection connection = tl.get();
        if(connection != null) { //当前已经开启事务了
            throw new SQLException("当前已经处于事务中，不能重复开启事务");
        }

        connection = getConnection();
        connection.setAutoCommit(false);
        tl.set(connection);
    }

    public static void beginTransactionSerializable() throws SQLException {
        Connection connection = tl.get();
        if(connection != null) { //当前已经开启事务了
            throw new SQLException("当前已经处于事务中，不能重复开启事务");
        }

        connection = getConnection();
        connection.setAutoCommit(false);
        connection.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
        tl.set(connection);
    }

    //提交事务
    public static void commitTransaction() throws SQLException {
        Connection connection = tl.get();
        if(connection == null) {
            throw new SQLException("当前没有在事务中，无法提交");
        }

        connection.commit();
        connection.close();
        tl.remove();
    }

    //回滚事务
    public static void rollbackTransaction() throws SQLException {
        Connection connection = tl.get();
        if(connection == null) {
            throw new SQLException("当前没有在事务中，无法回滚");
        }

        connection.rollback();
        connection.close();
        tl.remove();
    }

    //获取连接
    public static Connection getConnection() throws SQLException {
        Connection connection = tl.get();
        if(connection != null) {
            return connection;
        }

        return dataSource.getConnection();
    }

    //关闭资源
    public static void close(ResultSet rset, PreparedStatement statement, Connection conn) {
        if(rset != null) {
            try {
                rset.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
