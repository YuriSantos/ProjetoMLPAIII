package br.unipe.cc.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import br.unipe.cc.persistencia.ConexaoBD;

public class VerificaCliente {
	
	public boolean Verifica(String nome, String numero){
			
			boolean verifica = false;
			
			//criar a senha aqui
			Connection conn = ConexaoBD.conexaoBD();
			ResultSet rs= null;
			
			try {
				Statement stmt1 =conn.createStatement();
				String query1 = "select *from conta1";
				rs = stmt1.executeQuery(query1);
				while(rs.next())
				{					
					if(nome.equals(rs.getString(2)) && numero.equals(rs.getString(3))){
						verifica = true;
					}
				}
				if(verifica == false){
					JOptionPane.showMessageDialog(null,"Cliente não encontrado, por favor tente novamente ou contate o gerente para abrir uma conta!!!");
				}
				
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"Erro de comunicação com o banco","ERRO",JOptionPane.ERROR_MESSAGE);
			}
			
			
			return verifica;
		}
 }