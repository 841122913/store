package com.cy.store;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

@SpringBootTest
class StoreApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }
    @Test
    /**
     * HikariProxyConnection@1472659178 wrapping com.mysql.cj.jdbc.ConnectionImpl@3b57f915
     */
    void getConnection() throws SQLException {
        System.err.println(dataSource.getConnection());
    }

}
