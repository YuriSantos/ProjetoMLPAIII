package br.unipe.cc.fachada.teste;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import br.unipe.cc.modelo.Clientes;

public class BancoTeste extends TestCase {
	List<Clientes> selecionados = new ArrayList<Clientes>();
	Clientes  clienteSelecionado = new Clientes();
	
	public void testColecaoVazia(){
		assertTrue(selecionados.isEmpty());
	}
public void testColecaoComUmItem(){
		
		
		clienteSelecionado.setNome("Testando 1,2,3...");
		selecionados.add(clienteSelecionado);
		
		assertEquals(1, selecionados.size());
	}


}
