package com.prueba.melitest.entities.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * clase para devolver las estadísticas
 * @author Stiven Castro Arias
 * @since 08/08/2022
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MutantesEstadisticasResponse {

     private int count_mutant_dna;
     private int count_human_dna;
     private double radio;
}
