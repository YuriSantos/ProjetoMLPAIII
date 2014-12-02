package br.unipe.cc.modelo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.unipe.cc.persistencia.ConexaoBD;

public class DadosClientes {
	
	
	public List<Clientes> ListaClientes(){
		List<Clientes> clientes = new ArrayList<Clientes>();
		ResultSet rs= null;
		Connection conn = ConexaoBD.conexaoBD();
		try{
			Statement stmt = conn.createStatement();
			String query = "select *from conta1";
			rs = stmt.executeQuery(query);
			
			while(rs.next())
			{
				Clientes cliente = new Clientes();
				cliente.setNumID(rs.getInt(1));
				cliente.setNome(rs.getString(2));
				cliente.setNumeroConta(rs.getString(3));
				cliente.setSaldo(rs.getDouble(4));
				cliente.setTransacao(rs.getInt(5));
				clientes.add(cliente);
			}
			
		} catch (SQLException e)
		{
			e.printStackTrace();
		}		
		return clientes;
	}
	public List<Clientes> ListaClientesSelecionados(Clientes [] selecionados){
		
		List<Clientes> clientesSelecionados = new ArrayList<Clientes>();
		int tam = 0;
		tam = selecionados.length;
		
		for(int i = 0; i<tam; i++){
			clientesSelecionados.add(selecionados[i]);
		}
		return clientesSelecionados;	
	}
}
