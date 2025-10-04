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
    //@Positive(message = "O número só pode ser positivo") // Equivalente ao passo 21 do roteiro
//@DecimalMin(value = "0.0") // Equivalente ao passo 20 do roteiro
// Observação: @Positive já impede o valor zero (pois zero não é positivo),
// enquanto @DecimalMin(value = "0.0") permite o zero.
// Portanto, usar as duas juntas acaba sendo redundante.
// A melhor opção neste caso é usar apenas @PositiveOrZero,
// que expressa de forma simples que o valor pode ser zero ou positivo.
    @PositiveOrZero(message = "O valor total não pode ser negativo")
    private BigDecimal totalValue;


    @PrePersist
    public void prePersist() {
        if (orderDate == null) {
            this.orderDate = LocalDate.now();
        }
    }

}




