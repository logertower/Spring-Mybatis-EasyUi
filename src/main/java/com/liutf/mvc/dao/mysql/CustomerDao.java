package com.liutf.mvc.dao.mysql;

import com.liutf.mvc.config.ByConfigUtils;
import com.liutf.mvc.config.SqlServerConfig;
import com.liutf.mvc.entity.mysql.Customer;
import com.liutf.mvc.utils.MyThreadLocal;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * 用户dao
 *
 * @author ltf
 * @create 2018-09-01 下午 11:31
 */
@Service
public class CustomerDao {

    public Customer getCustomerByCustomerId(Integer customerId) {

        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        String sql = "select * from customer where customer_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{customerId}, new BeanPropertyRowMapper<Customer>(Customer.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Customer getCustomerByIdCard(Integer idCard) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        String sql = "select * from customer where idcard=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{idCard}, new BeanPropertyRowMapper<Customer>(Customer.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Customer getCustomerByMobile(String mobile) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        String sql = "select * from customer where mobile=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{mobile}, new BeanPropertyRowMapper<Customer>(Customer.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Customer getCustomerByWechatUnionid(String wechatUionid) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        String sql = "select * from customer where wechat_unionid=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{wechatUionid}, new BeanPropertyRowMapper<Customer>(Customer.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public Customer getCustomerByQqOpenId(String qqOpenId) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        String sql = "select * from customer where qq_openid=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{qqOpenId}, new BeanPropertyRowMapper<Customer>(Customer.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int delCustomerByCustomerId(Integer customerId) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        StringBuilder sb = new StringBuilder();
        sb.append("update customer set mobile = mobile + '_test',openid = openid + '_test',wechat_unionid = wechat_unionid + '_test',qq_openid = qq_openid + '_test' where customer_id=?");
        String sql = sb.toString();
        return jdbcTemplate.update(sql, new Object[]{customerId});
    }

    public int updateMobileAndWechatUnionidToNullByCustomerId(Integer customerId) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        StringBuilder sb = new StringBuilder();
        sb.append("update customer set mobile = '',wechat_unionid = wechat_unionid + '_test' where customer_id=?");
        String sql = sb.toString();
        return jdbcTemplate.update(sql, new Object[]{customerId});
    }

    public int updateMobileAndQqOpenIdToNullByCustomerId(Integer customerId) {
        JdbcTemplate jdbcTemplate = getJdbcTemplate();

        StringBuilder sb = new StringBuilder();
        sb.append("update customer set mobile = '',qq_openid = qq_openid + '_test' where customer_id=?");
        String sql = sb.toString();
        return jdbcTemplate.update(sql, new Object[]{customerId});
    }

    public int updateCustomerLevelPointByCustomerId(int customerIdI) {

        没有msql数据库
    }

    /**
     * 获取datasource
     */
    private JdbcTemplate getJdbcTemplate() {

        String environment = MyThreadLocal.get();

        SqlServerConfig sqlServerConfig = ByConfigUtils.get(environment).getSqlServerConfig();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(sqlServerConfig.getUrl());
        basicDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        basicDataSource.setUsername(sqlServerConfig.getUsername());
        basicDataSource.setPassword(sqlServerConfig.getPassword());
        basicDataSource.setMaxActive(50);
        basicDataSource.setMaxIdle(50);
        basicDataSource.setMinIdle(6);
        basicDataSource.setMaxWait(60000);
        basicDataSource.setTestOnBorrow(true);

        return new JdbcTemplate(basicDataSource);
    }

}
