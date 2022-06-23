package br.com.alura.debug.debugStore;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.alura.debug.debugStore.modelo.Categoria;
import br.com.alura.debug.debugStore.modelo.Produto;

public class EfetuarComparTest {
	
	@Before
	public void configurarCompra(){
		Categoria categoria = new Categoria("PERFUMARIA");
		Produto produto = new Produto("212 Blue", new BigDecimal("30.00"), categoria);
		
	}
	
	@Test
	public void comprarPerfume(){
		
	}

}
