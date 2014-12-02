package br.unipe.cc.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
//esta classe salva as transações no banco de dados
public class ExibeSaldo {
	
	public void exibir(String nome, String numero){
		ResultSet rs= null;
		Connection conn = ConexaoBD.conexaoBD();
		try{
			boolean verifica = true;
					
			Statement stmt1 = conn.createStatement();
			String query1 = "select *from conta1";
			rs = stmt1.executeQuery(query1);
			while(rs.next())
			{
				if(nome.equals(rs.getString(2)) && numero.equals(rs.getString(3))){
					verifica = false;
			        JOptionPane.showMessageDialog(null,"Bem Vindo(a) "+nome+" O seu saldo é:  "+rs.getDouble(4)+" Reais","Saldo!",JOptionPane.INFORMATION_MESSAGE);
			        conn.close();
					break;
				}
			}
			
			if(verifica){
				JOptionPane.showMessageDialog(null,"Cliente não encontrado, por favor tente novamente ou contate o gerente para abrir uma conta!!!");
			}
			
			
	   
		}catch (SQLException o){
			 JOptionPane.showMessageDialog(null,"Erro ao concluir o deposito","ERRO",JOptionPane.ERROR_MESSAGE);
		}
	
	}

}
