package by.digitalchief.ordermanagement.ordermanagement.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
@Data
public class OrderRequestDTO {
    private Long customerId;
    private Map<Long, Integer> products;
}
