package db;

import domain.product.dao.ProductDao;
import domain.product.dao.oracle.OracleProductDao;
import domain.user.dao.UserDao;
import domain.user.dao.oracle.OracleUserDao;

public class OracleDaoFactory implements DaoFactory{
    @Override
    public UserDao getUserDao() {
        return new OracleUserDao();
    }

    @Override
    public ProductDao getProductDao() {
        return new OracleProductDao();
    }

    @Override
    public boolean isSupportDBDriver(String driver) {
        return "oracle".equalsIgnoreCase(driver);
    }
}
