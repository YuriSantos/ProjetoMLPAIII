package br.unipe.cc.modelo;

import javax.swing.JOptionPane;

import br.unipe.cc.persistencia.SalvaDadosBD;

public class VerificaGerente {
 	public boolean Verifica(){
		
 		String id = "", senha = "";
		boolean verifica = false;
		
		id = JOptionPane.showInputDialog("Area do gerente!!! Digite o seu nome de  identificação");
		senha = JOptionPane.showInputDialog("Agora digite sua senha");
		verifica = new Gerente().IdentificaGerente(id, senha);
		
		if(verifica){
			JOptionPane.showMessageDialog(null,"Bem Vindo Senhor "+id);
		}
		else{
			JOptionPane.showMessageDialog(null,"Ops nome ou senha incorreto!!!");
		}
		return verifica;
 	}
}
