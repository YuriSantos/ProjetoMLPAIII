package br.unipe.cc.modelo.teste;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import br.unipe.cc.modelo.Clientes;

public class DadosClienteTeste extends TestCase{
	List<Clientes> clientes = new ArrayList<Clientes>();
	Clientes cliente = new Clientes();
	
	public void testColecaoVazia()
	{
		assertTrue(clientes.isEmpty());
	}
	
	public void testColecaoComUmItem(){
		
		
		cliente.setNome("Testando 1,2,3...");
		clientes.add(cliente);
		
		assertEquals(1, clientes.size());
	}
}
