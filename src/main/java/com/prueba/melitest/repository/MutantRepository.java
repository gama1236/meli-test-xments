package com.prueba.melitest.repository;

import com.prueba.melitest.entities.modelbd.Registros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interfaz que me permite
 * @author Stiven Castro Arias
 * @since 08/08/2022
 * */
@Repository
public interface MutantRepository extends JpaRepository<Registros, Integer> {

    Registros findAllByRdna(String dna);
    Integer countByRtipo(int tipo);
}
