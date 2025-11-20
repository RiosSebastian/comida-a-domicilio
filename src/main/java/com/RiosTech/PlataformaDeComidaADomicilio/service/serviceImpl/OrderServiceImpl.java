package com.RiosTech.PlataformaDeComidaADomicilio.service.serviceImpl;

import com.RiosTech.PlataformaDeComidaADomicilio.dto.OrderDtoRes;
import com.RiosTech.PlataformaDeComidaADomicilio.dto.dtoReq.OrderDtoReq;
import com.RiosTech.PlataformaDeComidaADomicilio.entity.*;
import com.RiosTech.PlataformaDeComidaADomicilio.mapper.OrderItemMapper;
import com.RiosTech.PlataformaDeComidaADomicilio.mapper.OrderMapper;
import com.RiosTech.PlataformaDeComidaADomicilio.repository.MenuItemRepository;
import com.RiosTech.PlataformaDeComidaADomicilio.repository.OrderRepository;
import com.RiosTech.PlataformaDeComidaADomicilio.service.OrderService;
import com.RiosTech.PlataformaDeComidaADomicilio.service.RestaurantService;
import com.RiosTech.PlataformaDeComidaADomicilio.service.UserService;
import com.RiosTech.PlataformaDeComidaADomicilio.util.OrderStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserService userService;
    private final RestaurantService restaurantService;
    private final MenuItemRepository menuItemRepository;

    @Override
    public OrderDtoRes createOrder(OrderDtoReq dto) {

        User client = userService.findById(dto.clientId());
        Restaurant restaurant = restaurantService.findById(dto.restaurantId());

        Order order = OrderMapper.toEntity(dto);
        order.setClient(client);
        order.setRestaurant(restaurant);
        order.setStatus(OrderStatus.PENDING);

        List<OrderItem> items = dto.items().stream()
                .map(req -> {
                    OrderItem item = OrderItemMapper.toEntity(req);
                    MenuItem menuItem = menuItemRepository.findById(req.menuItemId())
                            .orElseThrow(() -> new RuntimeException("Plato no encontrado"));
                    item.setItem(menuItem);
                    item.setOrder(order);
                    return item;
                })
                .toList();

        order.setItems(items);

        orderRepository.save(order);

        return OrderMapper.toDto(order);
    }

    @Override
    public OrderDtoRes acceptOrder(Long orderId) {
        Order order = findOrder(orderId);
        order.setStatus(OrderStatus.ACCEPTED);
        orderRepository.save(order);
        return OrderMapper.toDto(order);
    }

    @Override
    public OrderDtoRes assignDriver(Long orderId, Long driverId) {
        Order order = findOrder(orderId);
        User driver = userService.findById(driverId);

        order.setDriver(driver);
        order.setStatus(OrderStatus.ASSIGNED);
        orderRepository.save(order);

        return OrderMapper.toDto(order);
    }

    @Override
    public OrderDtoRes markOnTheWay(Long orderId) {
        Order order = findOrder(orderId);
        order.setStatus(OrderStatus.ON_THE_WAY);
        orderRepository.save(order);
        return OrderMapper.toDto(order);
    }

    @Override
    public OrderDtoRes markDelivered(Long orderId) {
        Order order = findOrder(orderId);
        order.setStatus(OrderStatus.DELIVERED);
        orderRepository.save(order);
        return OrderMapper.toDto(order);
    }

    private Order findOrder(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }
}
