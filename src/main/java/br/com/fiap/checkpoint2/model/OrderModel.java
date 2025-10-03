package br.com.fiap.checkpoint2.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderModel {
    private long id;
    private String clientName;
    private LocalDate orderDate;
    private BigDecimal totalValue;
}
