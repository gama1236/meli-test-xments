package com.prueba.melitest.service;

import com.prueba.melitest.components.EsMuntante;
import com.prueba.melitest.entities.modelbd.Registros;
import com.prueba.melitest.exceptions.FoundException;
import com.prueba.melitest.repository.MutantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MutanteAdaptadorService {

    private final EsMuntante esMuntante;

    private final MutantRepository mutantRepository;

    @Autowired
    public MutanteAdaptadorService(EsMuntante esMuntante,
                                   MutantRepository mutantRepository) {
        this.esMuntante = esMuntante;
        this.mutantRepository = mutantRepository;
    }

    public Boolean vefirifacarMutante(List<String> dna) throws FoundException {
        String[] dnas = new String[dna.size()];
        dna.toArray(dnas);
        String dnass  =  convertirDnaACadena(dna);

        validarSiExisteDNARepetido(dnass);

        boolean isMutant = esMuntante.isMutant(dnas);
        if (!isMutant) {
            mutantRepository.save( Registros.builder()
                            .rtipo(1)
                            .rdna(dnass)
                    .build());
        } else {
            mutantRepository.save( Registros.builder()
                            .rtipo(2)
                            .rdna(dnass)
                    .build());
        }
        return isMutant;
    }

    private String convertirDnaACadena(List<String> dnas){
        StringBuilder strDnas = new StringBuilder();
        for (String dna: dnas) {
            strDnas.append(dna);
        }
        return strDnas.toString();
    }

    private void  validarSiExisteDNARepetido(String cadenaDna) throws FoundException {
        Registros dnaConsultado = mutantRepository.findAllByRdna(cadenaDna);

        if (Objects.nonNull(dnaConsultado)){
            throw new FoundException("ya existe un dna similar en base de datos");
        }

    }
}
