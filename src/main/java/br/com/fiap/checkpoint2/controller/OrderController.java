package br.com.fiap.checkpoint2.controller;

import br.com.fiap.checkpoint2.model.OrderModel;
import br.com.fiap.checkpoint2.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping
    public ResponseEntity<Object> createOrder(@Valid @RequestBody OrderModel order) {
        try {
            OrderModel orderModel = orderService.createOrder(order);

            return new ResponseEntity<>(orderModel, HttpStatus.CREATED);
        }
        catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping
public List<OrderModel> readOrders(){
        return orderService.readAllOrders();
    }
    @GetMapping("/{code}")
    public ResponseEntity<Object> getOrder(@PathVariable Long id ) {
        try {

            OrderModel orderModel = orderService.readOrderById(id);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);
        }
        catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{code}")
    public ResponseEntity<Object> updateOrder(@PathVariable Long id, @Valid @RequestBody OrderModel order) {
        try {
            OrderModel orderModel = orderService.updateOrder(id, order);
            return new ResponseEntity<>(orderModel, HttpStatus.OK);

        }
        catch (EntityNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        }
    }
}
