package br.com.fiap.checkpoint2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name= "Pedidos")

public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "preenchimento do nome é obrigatório")
    private String clientName;
    private LocalDate orderDate;
    @DecimalMin(value = "0.0")
    @Positive(message = "O valor total não pode ser negativo")
    private BigDecimal totalValue;


    @PrePersist
    public void prePersist() {
        if (orderDate == null) {
            this.orderDate = LocalDate.now();
        }
    }

}




