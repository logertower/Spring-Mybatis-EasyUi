package com.liutf.mvc.dao.mysql;

import com.liutf.mvc.config.ByConfigUtils;
import com.liutf.mvc.config.SqlServerConfig;
import com.liutf.mvc.entity.mysql.Customer;
import com.liutf.mvc.entity.mysql.CustomerBalance;
import com.liutf.mvc.entity.mysql.CustomerLevelPoint;
import com.liutf.mvc.utils.MyThreadLocal;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户dao
 *
 * @author ltf
 * @create 2018-09-01 下午 11:31
 */
@Service
public class CustomerDao {

    public Customer getCustomerByCustomerId(Integer customerId) {

        JdbcTemplate jdbcTemplate = getSqlServerJdbcTemplate();

        String sql = "select * from customer where customer_id=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{customerId}, new BeanPropertyRowMapper<Customer>(Customer.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Customer getCustomerByIdCard(Integer idCard) {
        JdbcTemplate jdbcTemplate = getSqlServerJdbcTemplate();

        String sql = "select * from customer where idcard=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{idCard}, new BeanPropertyRowMapper<Customer>(Customer.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Customer getCustomerByMobile(String mobile) {
        JdbcTemplate jdbcTemplate = getSqlServerJdbcTemplate();

        String sql = "select * from customer where mobile=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{mobile}, new BeanPropertyRowMapper<Customer>(Customer.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Customer getCustomerByWechatUnionid(String wechatUionid) {
        JdbcTemplate jdbcTemplate = getSqlServerJdbcTemplate();

        String sql = "select * from customer where wechat_unionid=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{wechatUionid}, new BeanPropertyRowMapper<Customer>(Customer.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }

    }

    public Customer getCustomerByQqOpenId(String qqOpenId) {
        JdbcTemplate jdbcTemplate = getSqlServerJdbcTemplate();

        String sql = "select * from customer where qq_openid=?";
        try {
            return jdbcTemplate.queryForObject(sql, new Object[]{qqOpenId}, new BeanPropertyRowMapper<Customer>(Customer.class));
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public int delCustomerByCustomerId(Integer customerId) {
        JdbcTemplate jdbcTemplate = getSqlServerJdbcTemplate();

        StringBuilder sb = new StringBuilder();
        sb.append("update customer set mobile = mobile + '_test',openid = openid + '_test',wechat_unionid = wechat_unionid + '_test',qq_openid = qq_openid + '_test' where customer_id=?");
        String sql = sb.toString();
        return jdbcTemplate.update(sql, new Object[]{customerId});
    }

    public int updateMobileAndWechatUnionidToNullByCustomerId(Integer customerId) {
        JdbcTemplate jdbcTemplate = getSqlServerJdbcTemplate();

        StringBuilder sb = new StringBuilder();
        sb.append("update customer set mobile = '',wechat_unionid = wechat_unionid + '_test' where customer_id=?");
        String sql = sb.toString();
        return jdbcTemplate.update(sql, new Object[]{customerId});
    }

    public int updateMobileAndQqOpenIdToNullByCustomerId(Integer customerId) {
        JdbcTemplate jdbcTemplate = getSqlServerJdbcTemplate();

        StringBuilder sb = new StringBuilder();
        sb.append("update customer set mobile = '',qq_openid = qq_openid + '_test' where customer_id=?");
        String sql = sb.toString();
        return jdbcTemplate.update(sql, new Object[]{customerId});
    }

    public int updateCustomerLevelPointByCustomerId(int customerIdI, int levelId) {
        String levelName = "V";
        if (levelId > 0) {
            levelName = "V" + levelId;
        }

        JdbcTemplate jdbcTemplate = getMysqlJdbcTemplate("by_account");

        String getSql = "select * from customer_level_point where customer_id=?";
        CustomerLevelPoint customerLevelPoint = jdbcTemplate.queryForObject(getSql, new Object[]{customerIdI}, new BeanPropertyRowMapper<CustomerLevelPoint>(CustomerLevelPoint.class));
        if (customerLevelPoint != null) {
            if (levelId == customerLevelPoint.getLevelId()) {
                //无需修改
                return 0;
            } else {
                //需要修改
                String updateSql = "update customer_level_point set level_id=? ,level_name=? where customer_id=?";
                return jdbcTemplate.update(updateSql, new Object[]{levelId, levelName, customerIdI});
            }
        } else {
            long levelPoint = 0;
            if (levelId == 1) {
                levelPoint = 400;
            } else if (levelId == 2) {
                levelPoint = 800;
            } else if (levelId == 3) {
                levelPoint = 2000;
            } else if (levelId == 4) {
                levelPoint = 6000;
            } else if (levelId == 5) {
                levelPoint = 15000;
            }

            //需要添加
            String insertSql = "insert into customer_level_point (customer_id,level_point,level_id,level_name,create_time,update_time,level_update_time) values (?,?,?,?,?,?,?)";
            Date curDate = new Date();
            return jdbcTemplate.update(insertSql, new Object[]{customerIdI, levelPoint, levelId, levelName, curDate, curDate, curDate});
        }
    }

    public int updateCustomerBalanceByCustomerId(int customerIdI, BigDecimal balanceB) {
        JdbcTemplate jdbcTemplate = getMysqlJdbcTemplate("by_account");

        String getSql = "select * from customer_balance where customer_id=?";
        CustomerBalance customerBalance = jdbcTemplate.queryForObject(getSql, new Object[]{customerIdI}, new BeanPropertyRowMapper<CustomerBalance>(CustomerBalance.class));
        if (customerBalance != null) {
            if (balanceB.equals(customerBalance.getAccountWithdrawal())) {
                return 0;
            } else {
                //修改余额
                String updateSql = "UPDATE customer_balance SET account= (account+?), account_withdrawal=?, lost_time=? WHERE customer_id=?";
                return jdbcTemplate.update(updateSql, new Object[]{balanceB, balanceB, new Date(), customerIdI});
            }
        } else {
            //新增余额
            String insertSql = "INSERT INTO customer_balance (customer_id, account, account_withdrawal, account_withdrawal_unable, freeze_withdrawal, freeze_withdrawal_unable, create_time, lost_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            Date curDate = new Date();
            return jdbcTemplate.update(insertSql, new Object[]{customerIdI, balanceB, balanceB, 0, 0, 0, curDate, curDate});
        }
    }

    /**
     * 获取sqlserver datasource
     */
    private JdbcTemplate getSqlServerJdbcTemplate() {

        String environment = MyThreadLocal.get();

        SqlServerConfig sqlServerConfig = ByConfigUtils.get(environment).getSqlServerConfig();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        basicDataSource.setUrl(sqlServerConfig.getUrl());
        basicDataSource.setUsername(sqlServerConfig.getUsername());
        basicDataSource.setPassword(sqlServerConfig.getPassword());
        basicDataSource.setMaxActive(50);
        basicDataSource.setMaxIdle(50);
        basicDataSource.setMinIdle(6);
        basicDataSource.setMaxWait(60000);
        basicDataSource.setTestOnBorrow(true);

        return new JdbcTemplate(basicDataSource);
    }

    /**
     * 获取mysql by_account datasource
     */
    private JdbcTemplate getMysqlJdbcTemplate(String dataBase) {

        String environment = MyThreadLocal.get();

        SqlServerConfig sqlServerConfig = ByConfigUtils.get(environment).getSqlServerConfig();

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUrl(sqlServerConfig.getUrl() + "/" + dataBase);
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
