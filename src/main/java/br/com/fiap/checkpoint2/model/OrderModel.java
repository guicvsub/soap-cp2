package br.com.fiap.checkpoint2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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
    @Getter
    private long id;
    @Setter
    @Getter
    private String clientName;
    @Setter
    @Getter
    private LocalDate orderDate;
    @Setter
    @Getter
    private BigDecimal totalValue;


    public void prePersist(){
        if(orderDate==null){
            LocalDate orderDate = LocalDate.now();

        }

    }

}


