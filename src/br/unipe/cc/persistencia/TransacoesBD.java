package br.unipe.cc.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
//esta classe salva as transações no banco de dados
public class TransacoesBD {
	
	public void creditar(String nome, String numero){
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
					
					String saldo = JOptionPane.showInputDialog("Bem Vindo(a) "+nome+" Digite o valor do seu deposito");//nao fazer com optionpane fazer no botao creditar
					double saldoD = Double.parseDouble(saldo);
					double saldoAnt = 0;
					JOptionPane.showMessageDialog(null,"Valor foi depositado com Sucesso: "+saldoD);
					String query = "UPDATE conta1 SET  saldo=? WHERE nome = ?";
					PreparedStatement stmt = conn.prepareStatement(query);					
					
					saldoAnt = rs.getDouble(4);
					stmt.setDouble(1,saldoD+saldoAnt);
					stmt.setString(2,nome);
					boolean st = stmt.execute();
			        stmt.close();
			        
			        System.out.println("Depositado com sucesso!");
			        JOptionPane.showMessageDialog(null,"Valor foi depositado com Sucesso","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
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
	public void emprestimo(String nome, String numero)
	{
		ResultSet rs= null;
		Connection conn = ConexaoBD.conexaoBD();
		try{
			boolean verifica = true;
			
			//criar a senha aqui
			
			Statement stmt1 = conn.createStatement();
			String query1 = "select *from conta1";
			rs = stmt1.executeQuery(query1);
			while(rs.next())
			{
				if(nome.equals(rs.getString(2)) && numero.equals(rs.getString(3))){
					verifica = false;
					
					String saldo = JOptionPane.showInputDialog("Bem Vindo(a) "+nome+" Digite o valor o valor a ser emprestado:");//nao fazer com optionpane fazer no botao creditar
					double saldoA=rs.getDouble(4);
					double saldoD = Double.parseDouble(saldo);
					int tran = rs.getInt(5);
					JOptionPane.showMessageDialog(null,"Valor foi depositado com Sucesso: "+saldoD);
					String query = "UPDATE conta1 SET  saldo=?, transacoes=? WHERE nome = ?";
					
					saldoD = saldoA + saldoD;
					PreparedStatement stmt = conn.prepareStatement(query);					
					tran++;
					stmt.setDouble(1,saldoD);
					stmt.setInt(2,tran);
					stmt.setString(3,nome);
					boolean st = stmt.execute();
			        stmt.close();
			        
			        System.out.println("Depositado com sucesso!");
			        JOptionPane.showMessageDialog(null,"Valor foi depositado com Sucesso","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
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
	public void transferencia(String nome, String numero)
	{
		ResultSet rs= null;
		Connection conn = ConexaoBD.conexaoBD();
		double saldoD = 0;
		double saldoAnt = 0;
		boolean test = false;
		try{
			boolean verifica = true;
			String nome1 = JOptionPane.showInputDialog("Digite nome");
			String numero1 = JOptionPane.showInputDialog("Digite o numero da sua conta");
			//criar a senha aqui
			Statement stmt1 = conn.createStatement();
			String query1 = "select *from conta1";
			rs = stmt1.executeQuery(query1);
			while(rs.next())
			{
				if(nome.equals(rs.getString(2)) && numero.equals(rs.getString(3))){
					verifica = false;
					if(rs.getDouble(4) > 0){
						String saldo = JOptionPane.showInputDialog("Digite o valor o valor a ser transferido:");//nao fazer com optionpane fazer no botao creditar
						saldoD = Double.parseDouble(saldo);
						double saldoA = rs.getDouble(4);
						saldoAnt = saldoD;
						if(saldoD > saldoA){
							JOptionPane.showMessageDialog(null,"Saldo insuficiente! Operação impossivel!!!");
						}else{
							String query = "UPDATE conta1 SET  saldo=? WHERE nome = ?";
							saldoD = saldoA - saldoD;
							PreparedStatement stmt = conn.prepareStatement(query);					
							
							stmt.setDouble(1,saldoD);
							stmt.setString(2,nome);
						
							boolean st = stmt.execute();
							test = true;
						}
					}else{
						JOptionPane.showMessageDialog(null,"Seu saldo esta negativo! Operação impossivel!!!");
					}
						
			      
			        
					break;
				}
			}
			
			if(verifica){
				JOptionPane.showMessageDialog(null,"Cliente não encontrado, por favor tente novamente ou contate o gerente para abrir uma conta!!!");
			}
			
			if(test){
				while(rs.next())
				{
					if(nome1.equals(rs.getString(2)) && numero1.equals(rs.getString(3))){
						verifica = false;
						double saldoA = rs.getDouble(4);
						System.out.println(rs.getDouble(4));
						JOptionPane.showMessageDialog(null,"Valor foi tranferido com Sucesso: "+saldoAnt);
						String query = "UPDATE conta1 SET  saldo=? WHERE nome = ?";
						saldoA = saldoA + saldoAnt;
						PreparedStatement stmt = conn.prepareStatement(query);					
						
						stmt.setDouble(1,saldoA);
						stmt.setString(2,nome1);
									
						boolean st = stmt.execute();
				        stmt.close();
				        
				        JOptionPane.showMessageDialog(null,"Valor foi trasnferido com Sucesso","Sucesso!",JOptionPane.INFORMATION_MESSAGE);
				        conn.close();
						break;
					}
				}
			}
			
			
	   
		}catch (SQLException o){
			 JOptionPane.showMessageDialog(null,"Erro ao concluir a trasnferência!","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		
	}

}

