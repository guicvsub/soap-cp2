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
    //@Positive(message = "o numero so pode ser positivo") //esta linha esta representada na linha 35 equivalente a passo 21
    //@DecimalMin(value = "0.0") // prof eu acho que nao precisa dessa linha (mais ta no roteiro) equivalente a passo 20
    // porque a notacao @Positive garante que nao seja zero (porque zero nao e positivo),  enquanto a linha 32 garante o zero
    // nesse caso a melhor opcao e @PossitiveOrZero ai ta de boa
    @PositiveOrZero(message = "O valor total não pode ser negativo")
    private BigDecimal totalValue;


    @PrePersist
    public void prePersist() {
        if (orderDate == null) {
            this.orderDate = LocalDate.now();
        }
    }

}




