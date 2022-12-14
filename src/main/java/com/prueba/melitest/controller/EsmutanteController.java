package com.prueba.melitest.controller;


import com.prueba.melitest.entities.request.DnaRequest;
import com.prueba.melitest.entities.responses.MutantesEstadisticasResponse;
import com.prueba.melitest.service.EstadisticasMutantesService;
import com.prueba.melitest.service.MutanteAdaptadorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller que expone metodos
 * @author Stiven Castro Arias
 * @since 08/08/2022
 * */
@RestController
@RequestMapping()
public class EsmutanteController {


    private final MutanteAdaptadorService mutanteAdaptadorService;
    private final EstadisticasMutantesService estadisticasMutantesService;


    @Autowired
    public EsmutanteController(MutanteAdaptadorService mutanteAdaptadorService,
                               EstadisticasMutantesService estadisticasMutantesService) {
        this.mutanteAdaptadorService = mutanteAdaptadorService;
        this.estadisticasMutantesService = estadisticasMutantesService;
    }

    /**
     * metodo que verifica la secuencia de Dna.
     * @author Stiven Castro Arias
     * @since 08/08/2022
     * */
    //@ApiOperation(value = "Método para verificar si es mutante o no")
    @PostMapping("/mutant")
    public ResponseEntity<String> vefirifacarMutante(@RequestBody DnaRequest dna){

        if (Boolean.TRUE.equals(mutanteAdaptadorService.vefirifacarMutante(dna.getDna()))){
           return new ResponseEntity<>("200-OK", HttpStatus.OK);
        }

        return new ResponseEntity<>("403-Forbidden", HttpStatus.FORBIDDEN);
    }

    /**
     * metodo que expone las estadisticas
     * @author Stiven Castro Arias
     * @since 08/08/2022
     * */
    //@ApiOperation(value = "Método para ver estadisticas")
    @GetMapping("/stats")
    public ResponseEntity<MutantesEstadisticasResponse> obtenerEstadisticas(){
        return  new ResponseEntity<>(estadisticasMutantesService.mostrarEstadisticas(), HttpStatus.OK);
    }
}
