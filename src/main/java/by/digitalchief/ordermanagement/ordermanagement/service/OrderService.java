package by.digitalchief.ordermanagement.ordermanagement.service;

import by.digitalchief.ordermanagement.ordermanagement.dto.OrderRequestDTO;
import by.digitalchief.ordermanagement.ordermanagement.exception.ResourceNotFoundException;
import by.digitalchief.ordermanagement.ordermanagement.model.Customer;
import by.digitalchief.ordermanagement.ordermanagement.model.Order;
import by.digitalchief.ordermanagement.ordermanagement.model.OrderItem;
import by.digitalchief.ordermanagement.ordermanagement.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class OrderService {

    private final CustomerService customerService;
    private final OrderItemService orderItemService;
    private final OrderRepository orderRepository;

    @Transactional
    public Order createOrder(OrderRequestDTO orderRequestDTO) {
        Customer customer = customerService.getById(orderRequestDTO.getCustomerId());

        Map<Long, Integer> consolidatedProducts = orderItemService.consolidateProducts(orderRequestDTO.getProducts());
        List<OrderItem> orderItems = orderItemService.createOrderItems(consolidatedProducts);
        BigDecimal orderTotal = orderItemService.calculateOrderTotal(orderItems);

        Order order = new Order();
        order.setOrderDate(LocalDate.now());
        order.setCustomer(customer);
        order.setOrderItems(orderItems);
        order.setOrderTotal(orderTotal);

        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(order);
        }

        return orderRepository.save(order);
    }


    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
    }

    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + id));
        orderRepository.delete(order);
    }
}
