package com.Discount.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class Grupo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Oferta oferta;

    @ManyToMany
    private List<Usuario> participantes;

    private Boolean fechado = false;
}

