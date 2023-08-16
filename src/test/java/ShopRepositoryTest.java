import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    @Test
    public void testRemoveProduct() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Молоко", 50);
        Product product2 = new Product(2, "Книга", 300);
        Product product3 = new Product(3, "Ноутбук", 300_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.remove(2);

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }
    //@Test
    // public void testRemoveWhenNotProduct () {
    //    ShopRepository repo = new ShopRepository();

    //  Product product1 = new Product(1, "Молоко", 50);
    //  Product product2 = new Product(2, "Книга", 300);
    //   Product product3 = new Product(3, "Ноутбук", 300_000);

    //  repo.add(product1);
    //  repo.add(product2);
    //  repo.add(product3);
    //   repo.remove(4);

    //   Product[] actual = repo.findAll();
    //   Product[] expected = {product1, product2, product3};

    //   Assertions.assertArrayEquals(expected, actual);
    // }
    @Test
    public void testRemoveWhenNotProduct() {
        ShopRepository repo = new ShopRepository();

        Product product1 = new Product(1, "Молоко", 50);
        Product product2 = new Product(2, "Книга", 300);
        Product product3 = new Product(3, "Ноутбук", 300_000);

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class,
                () -> repo.remove(44)
        );
    }

}