package br.unipe.cc.ui;

import br.unipe.cc.fachada.Banco;
import br.unipe.cc.modelo.Gerente;
import br.unipe.cc.persistencia.ConexaoBD;

public class Principal {

	public static void main(String[] args) {
		
		new Banco().BancoInterface();
		
	}

}
