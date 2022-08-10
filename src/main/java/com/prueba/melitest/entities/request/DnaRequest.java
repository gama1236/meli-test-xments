package com.prueba.melitest.entities.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
/**
 * clase para recibir las cadenas de dna
 * @author Stiven Castro Arias
 * @since 08/08/2022
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DnaRequest {

    private List<String> dna;

}
