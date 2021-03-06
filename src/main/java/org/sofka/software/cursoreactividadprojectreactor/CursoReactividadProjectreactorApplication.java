package org.sofka.software.cursoreactividadprojectreactor;

import io.reactivex.Observable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.sofka.software.cursoreactividadprojectreactor.creacion.Creacion;
import org.sofka.software.cursoreactividadprojectreactor.model.Persona;
import org.sofka.software.cursoreactividadprojectreactor.transformacion.Transformacion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CursoReactividadProjectreactorApplication implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(CursoReactividadProjectreactorApplication.class);

	public void reactor(){
		Mono.just(new Persona(1,"John", 23))
				.doOnNext(p -> log.info("[Reactor] Persona: " + p))
				.subscribe(p -> log.info("[Reactor] Persona: "+ p));
	}

	public void rxjava2(){
		Observable.just(new Persona(1,"John", 23))
				.doOnNext(p -> log.info("[Reactor] Persona: " + p))
				.subscribe(p -> log.info("[RxJava2] Persona: "+ p));
	}

	public static void mono (){
		//mono representa un flujo de dato de tipo asíncrono.
		Mono.just(new Persona(1,"John", 23))
				.subscribe(p -> log.info(p.toString()));
	}


	public void  flux(){
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "John",   23));
		personas.add(new Persona(2, "Luisa",   20));

		Flux.fromIterable(personas).subscribe(p -> log.info(p.toString()));
	}

	//Transformar de flux a mono
	public void fluxMono(){
		List<Persona> personas = new ArrayList<>();
		personas.add(new Persona(1, "John",   23));
		personas.add(new Persona(2, "Luisa",   20));

		Flux<Persona> fx =Flux.fromIterable(personas);
		fx.collectList().subscribe( lista -> log.info(lista.toString()));
	}

	//Operaciones de Creación


	public static void main(String[] args) {
		SpringApplication.run(CursoReactividadProjectreactorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//reactor();
		//rxjava2();

		//mono();
		//flux();

		//fluxMono();

		//Creacion app = new Creacion();
		//app.range();
		//app.repeat();

		Transformacion app = new Transformacion();
		log.info("**************Map**************");
		app.map();
		log.info("**************FlatMap**************");
		app.flatMap();
		log.info("**************GoupBy**************");
		app.groupBy();

	}
}
