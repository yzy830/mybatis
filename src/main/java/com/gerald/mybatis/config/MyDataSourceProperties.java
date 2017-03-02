package com.gerald.mybatis.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix=MyDataSourceProperties.DS,ignoreUnknownFields = false)
public class MyDataSourceProperties {
    
    private String driverClassName ="com.mysql.jdbc.Driver";
    public final static String DS="mysqldb.datasource"; 
    
    //对应配置文件里的配置键
    private String url; 
    private String username;
    private String password;
    private String catalog;
    private int maxActive;
    private int maxIdle;
    private int minIdle;
    private int initialSize;

    private boolean defaultAutoCommit;
    private String validationQuery;//<!-- 验证连接是否可用，使用的SQL语句 -->
    private boolean testWhileIdle;//指明连接是否被空闲连接回收器(如果有)进行检验.如果检测失败,则连接将被从池中去除.
    private boolean testOnBorrow;//<!-- 借出连接时不要测试，否则很影响性能 -->
    private boolean testOnReturn;
    
    private int validationInterval;
    private int timeBetweenEvictionRunsMillis;//<!-- 每60秒运行一次空闲连接回收器 -->
    private int minEvictableIdleTimeMillis;//<!-- 池中的连接空闲30分钟后被回收,默认值就是30分钟 -->
    private int numTestsPerEvictionRun ;//<!-- 在每次空闲连接回收器线程(如果有)运行时检查的连接数量，默认值是3. -->
    private boolean removeAbandoned;
    private int removeAbandonedTimeout;
    private boolean logAbandoned;
    private int defaultTransactionIsolation;
    
    public String getDriverClassName() {
        return driverClassName;
    }
    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getCatalog() {
        return catalog;
    }
    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }
    public int getMaxActive() {
        return maxActive;
    }
    public void setMaxActive(int maxActive) {
        this.maxActive = maxActive;
    }
    public int getMaxIdle() {
        return maxIdle;
    }
    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }
    public int getMinIdle() {
        return minIdle;
    }
    public void setMinIdle(int minIdle) {
        this.minIdle = minIdle;
    }
    public int getInitialSize() {
        return initialSize;
    }
    public void setInitialSize(int initialSize) {
        this.initialSize = initialSize;
    }
    public boolean isDefaultAutoCommit() {
        return defaultAutoCommit;
    }
    public void setDefaultAutoCommit(boolean defaultAutoCommit) {
        this.defaultAutoCommit = defaultAutoCommit;
    }
    public String getValidationQuery() {
        return validationQuery;
    }
    public void setValidationQuery(String validationQuery) {
        this.validationQuery = validationQuery;
    }
    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }
    public void setTestWhileIdle(boolean testWhileIdle) {
        this.testWhileIdle = testWhileIdle;
    }
    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }
    public void setTestOnBorrow(boolean testOnBorrow) {
        this.testOnBorrow = testOnBorrow;
    }
    public boolean isTestOnReturn() {
        return testOnReturn;
    }
    public void setTestOnReturn(boolean testOnReturn) {
        this.testOnReturn = testOnReturn;
    }
    public int getValidationInterval() {
        return validationInterval;
    }
    public void setValidationInterval(int validationInterval) {
        this.validationInterval = validationInterval;
    }
    public int getTimeBetweenEvictionRunsMillis() {
        return timeBetweenEvictionRunsMillis;
    }
    public void setTimeBetweenEvictionRunsMillis(int timeBetweenEvictionRunsMillis) {
        this.timeBetweenEvictionRunsMillis = timeBetweenEvictionRunsMillis;
    }
    public int getMinEvictableIdleTimeMillis() {
        return minEvictableIdleTimeMillis;
    }
    public void setMinEvictableIdleTimeMillis(int minEvictableIdleTimeMillis) {
        this.minEvictableIdleTimeMillis = minEvictableIdleTimeMillis;
    }
    public int getNumTestsPerEvictionRun() {
        return numTestsPerEvictionRun;
    }
    public void setNumTestsPerEvictionRun(int numTestsPerEvictionRun) {
        this.numTestsPerEvictionRun = numTestsPerEvictionRun;
    }
    public boolean isRemoveAbandoned() {
        return removeAbandoned;
    }
    public void setRemoveAbandoned(boolean removeAbandoned) {
        this.removeAbandoned = removeAbandoned;
    }
    public int getRemoveAbandonedTimeout() {
        return removeAbandonedTimeout;
    }
    public void setRemoveAbandonedTimeout(int removeAbandonedTimeout) {
        this.removeAbandonedTimeout = removeAbandonedTimeout;
    }
    public boolean isLogAbandoned() {
        return logAbandoned;
    }
    public void setLogAbandoned(boolean logAbandoned) {
        this.logAbandoned = logAbandoned;
    }
    public int getDefaultTransactionIsolation() {
        return defaultTransactionIsolation;
    }
    public void setDefaultTransactionIsolation(int defaultTransactionIsolation) {
        this.defaultTransactionIsolation = defaultTransactionIsolation;
    }
}