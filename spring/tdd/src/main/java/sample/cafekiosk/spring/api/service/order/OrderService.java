package sample.cafekiosk.spring.api.service.order;

import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.api.controller.order.request.OrderCreateRequest;
import sample.cafekiosk.spring.api.controller.order.response.OrderResponse;

@Service
public class OrderService {

    //private final OrderRespository orderRespository;

    public OrderResponse createOrder(OrderCreateRequest request) {
    }
}
