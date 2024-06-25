package db;

import domain.product.dao.ProductDao;
import domain.product.dao.mysql.MysqlProductDao;
import domain.user.dao.UserDao;
import domain.user.dao.mysql.MysqlUserDao;

public class MysqlDaoFactory implements DaoFactory {
    @Override
    public UserDao getUserDao() {
        return new MysqlUserDao();
    }

    @Override
    public ProductDao getProductDao() {
        return new MysqlProductDao();
    }

    @Override
    public boolean isSupportDBDriver(String driver) {
        return "mysql".equalsIgnoreCase(driver);
    }
}
