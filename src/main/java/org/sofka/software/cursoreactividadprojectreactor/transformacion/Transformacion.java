package org.sofka.software.cursoreactividadprojectreactor.transformacion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sofka.software.cursoreactividadprojectreactor.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Transformacion {
    private static final Logger log = LoggerFactory.getLogger(Transformacion.class);

    public void map(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "John", 23));
        personas.add(new Persona(2, "Luisa", 20));

        Flux.fromIterable(personas).map(p -> {
            p.edad(p.edad()+ 10);
            return p;
        }).subscribe(p -> log.info(p.toString()));

    }

    public void flatMap(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "John", 23));
        personas.add(new Persona(2, "Luisa", 20));

        Flux.fromIterable(personas).flatMap(p -> {
            p.edad(p.edad()+ 10);
            return Mono.just(p);
        }).subscribe(p -> log.info(p.toString()));

    }

    public void groupBy(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "John", 23));
        personas.add(new Persona(1, "Esteban", 23));
        personas.add(new Persona(2, "Luisa", 20));

        Flux.fromIterable(personas)
                .groupBy(Persona::idPersona)
                .flatMap(idFlux -> idFlux.collectList())
                .subscribe(p -> log.info(p.toString()));

    }

}
