package domain.product.dao.mysql;

import domain.product.Product;
import domain.product.dao.ProductDao;

public class MysqlProductDao implements ProductDao {
    @Override
    public void insertProduct(Product product) {
        System.out.println("MysqlProductDao.insertProduct");
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("MysqlProductDao.updateProduct");
    }

    @Override
    public void deleteProduct(long id) {
        System.out.println("MysqlProductDao.deleteProduct");
    }
}
