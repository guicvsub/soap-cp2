package br.com.fiap.checkpoint2.service;

import br.com.fiap.checkpoint2.model.OrderModel;
import br.com.fiap.checkpoint2.repository.OrderRepository;
import jakarta.persistence.EntityNotFoundException;


import java.util.List;


public class OrderService {
    private OrderRepository orderRepository;


    public OrderModel createOrder(OrderModel order) {
        return orderRepository.save(order);

    }

    public List<OrderModel> readAllOrders() {
        return orderRepository.findAll();
    }

    public OrderModel readOrderById(Long id) {
        return orderRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("nao entrado  "));

    }

    public OrderModel updateOrder(Long id, OrderModel order) {
        // Tenta encontrar a entidade. Se presente, executa o map.
        return orderRepository.findById(id).map(existingOrder -> {
                    // Atualiza os atributos da entidade existente (managed by JPA)
                    // Usando os setters que o Lombok gerou para clientName e totalValue.

                    existingOrder.setClientName(order.getClientName()); // usa setClientName() do existingOrder
                    existingOrder.setTotalValue(order.getTotalValue()); // usa setTotalValue() do existingOrder

                    // Salva a entidade modificada e a retorna.
                    return orderRepository.save(existingOrder);
                })

                .orElseThrow(() -> new EntityNotFoundException("Pedido com o ID " + id + " não foi encontrado."));
    }


}


/*public OrderModel updateOrder(Long id, OrderModel order) {
    // Tenta encontrar a entidade. Se presente, executa o map.
    return orderRepository.findById(id)
            .map(existingOrder -> {
                // Atualiza os atributos da entidade existente (managed by JPA)
                // Usando os setters que o Lombok gerou para clientName e totalValue.

                existingOrder.setClientName(order.getClientName()); // usa setClientName() do existingOrder
                existingOrder.setTotalValue(order.getTotalValue()); // usa setTotalValue() do existingOrder

                // Salva a entidade modificada e a retorna.
                return orderRepository.save(existingOrder);
            })
            // Se o Optional estiver vazio, lança a exceção EntityNotFoundException
            .orElseThrow(() ->
                    new EntityNotFoundException("Pedido com o ID " + id + " não foi encontrado.")
            );
}*/