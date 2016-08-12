package cn.code.springboot.guides.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController("/customer")
public class CustomerController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    Logger logger = LoggerFactory.getLogger(getClass());

    //数据初始化
    @RequestMapping("/init")
    public void init() {
        List<Object[]> splitUpNames = new ArrayList<>();
        splitUpNames.add(new Object[]{"John", "Woo"});
        splitUpNames.add(new Object[]{"Jeff", "Dean"});
        splitUpNames.add(new Object[]{"Josh", "Bloch"});
        splitUpNames.add(new Object[]{"Josh", "Long"});
        jdbcTemplate.batchUpdate("INSERT INTO customers(first_name, last_name) VALUES (?,?)", splitUpNames);
    }

    @RequestMapping("/getData")
    public void getData() {
        logger.info("Querying for customer records where first_name = 'Jeff':");
        Customer customer = jdbcTemplate.queryForObject(
                "SELECT  first_name  ,last_name  FROM customers WHERE first_name = 'Jeff'", new RowMapper<Customer>() {
                    @Override
                    public Customer mapRow(ResultSet resultSet, int i) throws SQLException {
                        return new Customer(resultSet.getString("first_name"), resultSet.getString("last_name"));
                    }
                });
        System.out.println(customer.toString());
    }
}
