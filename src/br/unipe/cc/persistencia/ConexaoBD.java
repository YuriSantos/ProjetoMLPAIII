package br.unipe.cc.persistencia;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import javax.swing.JOptionPane;

public class ConexaoBD {
	public static Connection conexaoBD()
	{
		Properties props = new Properties();
		FileInputStream fis = null;
		Connection conn = null;
		try{
			fis = new FileInputStream("database.properties");
			props.load(fis);
			
			Class.forName(props.getProperty("DB_DRIVER_CLASS"));
			conn = DriverManager.getConnection(props.getProperty("DB_URL"),
					props.getProperty("DB_USERNAME"),
					props.getProperty("DB_PASSWORD"));
			
			
			}
		 catch (IOException|ClassNotFoundException e){
			 JOptionPane.showMessageDialog(null,"Erro de comunicação com o Banco de dados! Verifique a conexão ou se o usuario e senha foram inseridos corretamente!","ERRO",JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e){
			JOptionPane.showMessageDialog(null,"Erro de comunicação com o Banco de dados! Verifique a conexão ou se o usuario e senha foram inseridos corretamente!","ERRO",JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}
}