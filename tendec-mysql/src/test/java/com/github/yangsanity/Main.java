package com.github.yangsanity;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Properties;

/**
 * @author yangjie
 */
public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    @Test
    public void getCount() {
        Long limit = null;
        String countSql = "select count(*), max(id) from t_exercise_plan_item_answer";
        if (Objects.nonNull(limit)) {
            countSql += " where id <= " + limit;
        }
        try (Connection conn = connection();
             PreparedStatement ps = conn.prepareStatement(countSql);
             ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                Pair<Long, Long> pair = Pair.of(rs.getLong(1), rs.getLong(2));
                LOG.debug("count: {}, maxId: {}", pair.getLeft(), pair.getRight());
            }
        } catch (Exception e) {
            LOG.warn("getCount error.", e);
        }
    }

    private Connection connection() throws Exception {
        String url = "jdbc:mysql://172.26.130.75:4000/spring-exam?useSSL=false&rewriteBatchedStatements=true";
        Class<Driver> driverClazz = (Class<Driver>) Class.forName("com.mysql.cj.jdbc.Driver", true, this.getClass().getClassLoader());
        java.sql.Driver driver = driverClazz.getDeclaredConstructor().newInstance();
        Properties props = new Properties();
        props.put("user", "yn_usr");
        props.put("password", "seal_admin");
//        props.put("useCursorFetch", "true");
        return driver.connect(url, props);
    }
}
