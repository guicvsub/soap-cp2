package br.com.fiap.checkpoint2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class OrderModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Getter
    private long id;

    @Setter
    @Getter
    @NotEmpty(message = "preenchimento do nome é obrigatório")
    private String clientName;

    @Setter
    @Getter
    private LocalDate orderDate;
    @Setter
    @Getter
    @DecimalMin(value= "0.0", message = "o valor não pode ser negativo;")
    @Positive
    private BigDecimal totalValue;

    @PrePersist
    public void prePersist(){
        if(orderDate==null){
            LocalDate orderDate = LocalDate.now();

        }

    }

}


