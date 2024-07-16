package by.digitalchief.ordermanagement.ordermanagement.service;

import by.digitalchief.ordermanagement.ordermanagement.model.OrderItem;
import by.digitalchief.ordermanagement.ordermanagement.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
public class OrderItemService {

    private final ProductService productService;

    public Map<Long, Integer> consolidateProducts(Map<Long, Integer> products) {
        Map<Long, Integer> consolidatedProducts = new HashMap<>();
        for (Map.Entry<Long, Integer> entry : products.entrySet()) {
            consolidatedProducts.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
        return consolidatedProducts;
    }

    public List<OrderItem> createOrderItems(Map<Long, Integer> consolidatedProducts) {
        List<OrderItem> orderItems = new ArrayList<>();
        for (Map.Entry<Long, Integer> entry : consolidatedProducts.entrySet()) {
            Product product = productService.getById(entry.getKey());
            Integer quantity = entry.getValue();
            BigDecimal totalPrice = product.getPrice().multiply(BigDecimal.valueOf(quantity));
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(product);
            orderItem.setQuantity(quantity);
            orderItem.setTotalPrice(totalPrice);
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    public BigDecimal calculateOrderTotal(List<OrderItem> orderItems) {
        BigDecimal orderTotal = BigDecimal.ZERO;
        for (OrderItem orderItem : orderItems) {
            orderTotal = orderTotal.add(orderItem.getTotalPrice());
        }
        return orderTotal;
    }
}
