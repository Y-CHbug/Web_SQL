package com.ServletMethod;

import bean.messageboard;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.util.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.List;
import java.util.Properties;

public class ServletMethod2 {
    public static int insert(messageboard mb){
        Properties properties = new Properties();
        int i = 0;
        try {
            InputStream is = ServletMethod2.class.getClassLoader().getResourceAsStream("druid.properties");

            properties.load(is);

            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            Connection connection = dataSource.getConnection();

            QueryRunner queryRunner = new QueryRunner();

            String sql = "insert into messageboard(`username`, `time`, `message`) values(?, ?, ?)";

            i = queryRunner.update(connection, sql, mb.getUsername(), mb.getTime(), mb.getMessage());

            JdbcUtils.close(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return i;
    }

    // 查询表
    public static List<messageboard> query() {
        Properties properties = new Properties();

        List<messageboard> list = null;
        try {
            InputStream is = ServletMethod2.class.getClassLoader().getResourceAsStream("druid.properties");

            properties.load(is);

            DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

            Connection connection = dataSource.getConnection();

            QueryRunner queryRunner = new QueryRunner();

            String sql = "select * from messageboard";
            BeanListHandler<messageboard> beanListHandler = new BeanListHandler(messageboard.class);
            list = queryRunner.query(connection, sql, beanListHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
