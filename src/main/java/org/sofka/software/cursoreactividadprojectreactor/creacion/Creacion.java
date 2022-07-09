package org.sofka.software.cursoreactividadprojectreactor.creacion;

import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sofka.software.cursoreactividadprojectreactor.model.Persona;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

public class Creacion {

  private static Logger log = LoggerFactory.getLogger(Creacion.class);

  public void justFrom() {}

  public void empty() {
    Mono.empty();
    Flux.empty();
    Observable.empty();
  }

  public void range() {
    Flux.range(1, 3).doOnNext(i -> log.info("i : " + i)).subscribe();
  }

  public void repeat(){
    List<Persona> personas = new ArrayList<>();
    personas.add(new Persona(1, "John", 23));
    personas.add(new Persona(2, "Luisa", 20));

    Flux.fromIterable(personas)
            .repeat(3)
            .subscribe( p -> log.info(p.toString()));
  }

}
