package karoumi.achraf.productmicroservices.repository;

import karoumi.achraf.productmicroservices.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product , String> {

}
