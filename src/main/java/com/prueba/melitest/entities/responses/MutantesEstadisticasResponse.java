package com.prueba.melitest.entities.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MutantesEstadisticasResponse {

     private int count_mutant_dna;
     private int count_human_dna;
     private double radio;
}
