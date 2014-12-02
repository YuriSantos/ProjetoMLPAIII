package br.unipe.cc.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class EsvaziaBD {
	public void Esvaziar(){
		Connection conn = ConexaoBD.conexaoBD();
		try{
			String query = "TRUNCATE conta1";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeUpdate(query);
	        stmt.close();
	        JOptionPane.showMessageDialog(null,"Lista esvaziada com sucesso!!","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
	        
	        
	   
		}catch (SQLException o){
			 JOptionPane.showMessageDialog(null,"Erro ao esvaziar a lista!","ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}
}

