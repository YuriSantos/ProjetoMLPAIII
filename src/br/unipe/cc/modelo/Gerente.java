package br.unipe.cc.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.unipe.cc.persistencia.ConexaoBD;

public class Gerente {
	private String [] id = {"Victor", "Yuri"};
	private String [] senha = {"237237","723723"};
	
	
	public static Connection conexaoGerenteBD(String usuario, String senha)
	{
		Connection conn = null;
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/jdbc";
			conn = DriverManager.getConnection(url, usuario, senha);
			
			}
		 catch (ClassNotFoundException e){
			e.printStackTrace();
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Erro de comunicação com o Banco de dados! Verifique a conexão ou se o usuario e senha foram inseridos corretamente!","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}
	
	public void SalvandoGerenteBD(){
		
		for(int i = 0; i<2; i++){
			Connection conn = conexaoGerenteBD("root","");
			try{
					String query = "INSERT INTO gerente (id,senha) VALUES (?,?)";
					PreparedStatement stmt = conn.prepareStatement(query);		  
				    stmt.setString(1, id[i]);
				    stmt.setString(2, senha[i]);    	
					boolean st = stmt.execute();
			        stmt.close();
			        conn.close();
		   
			}catch (SQLException o){
				 JOptionPane.showMessageDialog(null,"Erro ao concluir cadastro de gerente","ERRO",JOptionPane.ERROR_MESSAGE);
			}
		}	
	}
	
	public boolean IdentificaGerente(String id, String senha){
		
		ResultSet rs= null;
		boolean test = false;
		Connection conn = ConexaoBD.conexaoBD();
			try{
				Statement stmt = conn.createStatement();
				String query = "select *from gerente";
				rs = stmt.executeQuery(query);
				
				while(rs.next())
				{
					int i = 1;
					if((id.equals(rs.getString(i++)) && (senha.equals(rs.getString(i++))))){
						test = true;
						break;
					}
				}
				
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			return test;		
		
		}
	
	public void EsvaziaGerenteBD(){
		Connection conn = ConexaoBD.conexaoBD();
		try{
			String query = "TRUNCATE gerente";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.executeUpdate(query);
	        stmt.close();
	        JOptionPane.showMessageDialog(null,"Lista do gerente esvaziada com sucesso!!","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
	        
	        
	   
		}catch (SQLException o){
			 JOptionPane.showMessageDialog(null,"Erro ao esvaziar a lista!","ERRO",JOptionPane.ERROR_MESSAGE);
		}
	}

	
	
}
