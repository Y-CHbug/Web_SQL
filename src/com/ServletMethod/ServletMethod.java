package com.ServletMethod;

import bean.ss_1;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class ServletMethod {
    // 插入一个用户
    public static int insert(String name, String password, String email) {
        // 创建连接
        InputStream is = null;
        Connection connection = null;
        int insertCount = 0;
        try {
            is = ServletMethod.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties pros = new Properties();
            pros.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);
            connection = dataSource.getConnection();


            QueryRunner runner = new QueryRunner();
            String sql = "insert into student(`name`, `password`, email) values(?, ?, ?)";
            insertCount = runner.update(connection, sql, name, password, email);
            return insertCount;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return 0;
    }

    // 查询用户
    public static ss_1 query(String name) {
        InputStream is = null;
        Connection connection = null;
        ss_1 user = null;
        try {
            // 创建连接
            is = ServletMethod.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties pros = new Properties();
            pros.load(is);
            DataSource dataSource = DruidDataSourceFactory.createDataSource(pros);
            connection = dataSource.getConnection();

            QueryRunner runner = new QueryRunner();
            String sql = "select `name`, `password`, `email` from student where `name` = ?";
            BeanHandler<ss_1> handler = new BeanHandler(ss_1.class);
            user = runner.query(connection, sql, handler, name);
            return user;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return null;
    }

    // 修改密码操作，需要传入新密码和用户名
    public static int UpdatePassword(String newpassword, String username) {
        int i = 0;
        try {
            Properties properties = new Properties();

            InputStream is = ServletMethod.class.getClassLoader().getResourceAsStream("druid.properties");

            properties.load(is);

            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            Connection connection = dataSource.getConnection();

            QueryRunner runner = new QueryRunner();

            String sql = "update `student` set `password` = ? where `name` = ?";
            i = runner.update(connection, sql, newpassword, username);
            JdbcUtils.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }

    // 删除用户
    public static int DelUser(String username)  {
        Properties properties = new Properties();

        InputStream is = ServletMethod.class.getClassLoader().getResourceAsStream("druid.properties");

        Connection connection = null;
        int i = 0;
        try {
            properties.load(is);

            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            connection = dataSource.getConnection();

            QueryRunner runner = new QueryRunner();

            String sql = "delete from student where name = ?";

            i = runner.update(connection, sql, username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        JdbcUtils.close(connection);

        return i;
    }

    @Test
    public void test() {
        ss_1 s = query("岳昌宏");

        System.out.println(s);
    }

    @Test
    public void test4() throws Exception {
//        DataSource source = new DruidDataSource();

        /**
         * @descriptions: 使用Druid（德鲁伊）实现数据的连接操作
         */
        

        /**
         * @descriptions: Apache-DBUtils实现CRUD操作,对jdbc进行简单的封装
         */


        QueryRunner runner = new QueryRunner();

        // 实现了插入操作
//        String sql = "insert into student(name, password, email) value (?, ?, ?)";
//        int i = runner.update(connection, sql, "admine", "123", "123@qq.com");
//        System.out.println("添加了" + i + "记录");
//        JdbcUtils.close(connection);

        // 实现了删除操作
//        String sql = "delete from student where name = ?";
//        int i = runner.update(connection, sql, "admine");
//        System.out.println("删除了" + i + "条记录");
//        JdbcUtils.close(connection);

        // 实现修改操作
//        String sql = "update student set password = ? where name = ?";
//        int i = runner.update(connection, sql, "6666", "张涛");
//        System.out.println("修改了" + i + "条记录");
//        JdbcUtils.close(connection);


        // 实现查询操作
//       String sql = "select `name`, `password`, `email` from student where `name` = ?";

        // 结果集的处理器 ResultSetHandler
//        BeanHandler<ss_1> handler = new BeanHandler(ss_1.class);
//        ss_1 s = runner.query(connection, sql, handler, "岳昌宏");

//        System.out.println(s);

//        JdbcUtils.close(connection);

//        ---
//        String sql = "select `name`, `password`, `email` from student";
//        BeanListHandler<ss_1> handler = new BeanListHandler<>(ss_1.class);
//
//        List<ss_1> s = runner.query(connection, sql, handler);
//
//        for (ss_1 ss_1 : s) {
//            System.out.println(ss_1);
//        }
//
//        JdbcUtils.close(connection);

//
//        String sql = "select count(*) from student";
//        ScalarHandler handler = new ScalarHandler();
//        Object i = runner.query(connection, sql, handler);
//        System.out.println(i.toString());
//
//        JdbcUtils.close(connection);

    }
}
