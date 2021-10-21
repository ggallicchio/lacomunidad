package edu.it;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

interface Servicio {
	void realizarSequencia();
}

@Component
class ServicioB implements Servicio {
	public void realizarSequencia() {
		System.out.println("Realizando sequencia... ");
	}	
}

@Component
class ServicioA {
	private ServicioB servicioB;

	public ServicioA(ServicioB servicioB) {
		this.servicioB = servicioB;
	}
	public void metodoUtil() {
		servicioB.realizarSequencia();
	}
}


@Component
public class Init implements CommandLineRunner {
	private ServicioA servicioa;
	
	public Init(ServicioA servicioa) {
		this.servicioa = servicioa;
	}

	public void run(String... args) throws Exception {
		System.out.println("Bienvenidos al curso de Spring");
		servicioa.metodoUtil();
	}
}
