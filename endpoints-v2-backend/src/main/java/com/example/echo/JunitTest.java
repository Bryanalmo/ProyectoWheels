package com.example.echo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitTest {

	@Test
	void test() {
		Facade facade = new Facade();
		facade.crearRuta("123", "23", 2, "ABC123", "123456", "78910", "9:10");
		
		Ruta ruta = facade.buscarRutas("123");
		
		assertTrue(ruta != null);
	}

}
