package com.prueba.melitest.service;

import com.prueba.melitest.entities.responses.MutantesEstadisticasResponse;
import com.prueba.melitest.repository.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstadisticasMutantesService {


    private final MutantRepository mutantRepository;

    @Autowired
    public EstadisticasMutantesService(MutantRepository mutantRepository) {
        this.mutantRepository = mutantRepository;
    }


    public MutantesEstadisticasResponse mostrarEstadisticas(){

        return  MutantesEstadisticasResponse.builder()
                .count_human_dna(mutantRepository.countByRtipo(1))
                .count_mutant_dna(mutantRepository.countByRtipo(2))
                .radio(mutantRepository.countByRtipo(2)/ mutantRepository.countByRtipo(1))
                .build();
    }
}
