package com.Discount.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Oferta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Produto produto;

    private Double desconto;
    private Integer maxParticipantes;
}

