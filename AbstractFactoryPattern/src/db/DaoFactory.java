package db;

import domain.product.dao.ProductDao;
import domain.user.dao.UserDao;

public interface DaoFactory {
    UserDao getUserDao();
    ProductDao getProductDao();
    boolean isSupportDBDriver(String driver);
}
