package com.prueba.melitest.entities.modelbd;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/*
 *   clase que se encarga de almacenar datos en la base de datos
 *  Stiven Castro Arias
 * @since 08/08/2022
 **/
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "registros")
public class Registros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rid")
    private Integer rid;

    @Column(name = "rtipo")
    private Integer rtipo;

    @Column(name = "rdna")
    private String rdna;

}
