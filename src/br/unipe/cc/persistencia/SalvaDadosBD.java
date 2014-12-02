package br.unipe.cc.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class SalvaDadosBD {
	public int i= 0;
	
	public void Cadastro(){
		
		ResultSet rs= null;
		boolean verifica = true;
		Connection conn = ConexaoBD.conexaoBD();
		try{
			
			JOptionPane.showMessageDialog(null,"Cadastro de novo cliente!");
			String id = JOptionPane.showInputDialog("Digite o nome do cliente:");//o nome vai vir do botao cadastro
			String ct = JOptionPane.showInputDialog("Digite um novo numero de conta:");//o numero tbm
			int i = 0;
			Statement stmt1 = conn.createStatement();
			String query1 = "select *from conta1";
			rs = stmt1.executeQuery(query1);
			while(rs.next())
			{
				
				i = rs.getInt(1);
				if(ct.equals(rs.getString(3))){
					verifica = false;
					JOptionPane.showMessageDialog(null,"Senhor gerente, já existe um cliente com esse numero de conta!!!");
					break;
				}
			}
			
			if(verifica){
				String query = "INSERT INTO conta1 (id,nome,numero) VALUES (?,?,?)";
				PreparedStatement stmt = conn.prepareStatement(query);
			    
				
				
				stmt.setInt(1,1+i);
			    stmt.setString(2,id);
			    stmt.setString(3,ct);
				boolean st = stmt.execute();
		        stmt.close();

		        System.out.println("Gravado!");
		        JOptionPane.showMessageDialog(null,"Nome salvo com sucesso!!","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
		        conn.close();
			}
			
	   
		}catch (SQLException o){
			 JOptionPane.showMessageDialog(null,"Erro ao inserir o nome no banco!","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}
