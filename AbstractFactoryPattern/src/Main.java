import db.DaoFactory;
import db.MysqlDaoFactory;
import db.OracleDaoFactory;
import domain.product.Product;
import domain.product.dao.ProductDao;
import domain.user.User;
import domain.user.dao.UserDao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        List<DaoFactory> daoFactories = List.of(new MysqlDaoFactory(), new OracleDaoFactory());
        UserDao userDao;
        ProductDao productDao;

        try(FileInputStream fileInputStream = new FileInputStream("datasource.properties")) {
            Properties properties = new Properties();
            properties.load(fileInputStream);

            String driver = properties.getProperty("driver");
            DaoFactory targetdaoFactory = daoFactories.stream().filter(daoFactory -> daoFactory.isSupportDBDriver(driver)).findFirst().orElseThrow(() -> new IllegalArgumentException("지원하지 않는 db타입입니다."));

            userDao = targetdaoFactory.getUserDao();
            productDao = targetdaoFactory.getProductDao();

            userDao.insertUser(new User());
            userDao.updateUser(new User());
            userDao.deleteUser("1");

            productDao.insertProduct(new Product());
            productDao.updateProduct(new Product());
            productDao.deleteProduct(5);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}