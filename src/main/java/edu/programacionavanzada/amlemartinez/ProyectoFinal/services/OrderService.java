package edu.programacionavanzada.amlemartinez.ProyectoFinal.services;

import edu.programacionavanzada.amlemartinez.ProyectoFinal.domain.Order;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.model.dto.OrderDTO;
import edu.programacionavanzada.amlemartinez.ProyectoFinal.repositories.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    public List<OrderDTO> getAll() {
        return orderRepository.findAll().stream().map(Order::toDTO).collect(Collectors.toList());
    }

    public OrderDTO get(UUID id) {
        return orderRepository.findById(id).orElseThrow().toDTO();
    }
}
