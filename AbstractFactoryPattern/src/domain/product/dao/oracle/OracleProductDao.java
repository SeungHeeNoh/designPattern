package domain.product.dao.oracle;

import domain.product.Product;
import domain.product.dao.ProductDao;

public class OracleProductDao implements ProductDao {
    @Override
    public void insertProduct(Product product) {
        System.out.println("OracleProductDao.insertProduct");
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("OracleProductDao.updateProduct");
    }

    @Override
    public void deleteProduct(long id) {
        System.out.println("OracleProductDao.deleteProduct");
    }
}
