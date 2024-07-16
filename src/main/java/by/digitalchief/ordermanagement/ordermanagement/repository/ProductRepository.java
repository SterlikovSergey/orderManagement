package by.digitalchief.ordermanagement.ordermanagement.repository;

import by.digitalchief.ordermanagement.ordermanagement.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
