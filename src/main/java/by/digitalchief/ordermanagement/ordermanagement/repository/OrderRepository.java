package by.digitalchief.ordermanagement.ordermanagement.repository;

import by.digitalchief.ordermanagement.ordermanagement.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
