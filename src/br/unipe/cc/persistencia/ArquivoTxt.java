package br.unipe.cc.persistencia;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.swing.JFileChooser;

import br.unipe.cc.modelo.Clientes;

public class ArquivoTxt {

public void ArquivoTxtClientes(List<Clientes> clientes) throws IOException{
		
	FileWriter fw = null;		
		try{
			int tamanho = clientes.size();
			
			int [] gravar1 =  new int[tamanho];
			String [] gravar2 =  new String[tamanho];
			String [] gravar3 =  new String[tamanho];
			double [] gravar4 =  new double[tamanho];
			int [] gravar5 =  new int[tamanho];
			
			String caminho = "";
			int cont = 0;
			
			
			JFileChooser fileChooser = new JFileChooser();  
			fileChooser.showSaveDialog(null);
			caminho = fileChooser.getSelectedFile().getAbsolutePath();
			
			fw = new FileWriter(caminho+".txt");
			PrintWriter gravarArq = new PrintWriter(fw);
			
			gravarArq.printf("-----------------------------CONTAS_DOS_CLIENTES----------------------------------");
			for (Clientes dados : clientes) {    
		        gravar1[cont] = dados.getNumID();
				gravar2[cont] = dados.getNome();
				gravar3[cont] = dados.getNumeroConta();
				gravar4[cont] = dados.getSaldo();
				gravar5[cont] = dados.getTransacao();
		        gravarArq.printf("%n-                          "+gravar1[cont]+"  ///  "+gravar2[cont]+"  ///  "+gravar3[cont]+"  ///  "+gravar4[cont]+"  ///  "+gravar5[cont]);
				cont++;
			}
			gravarArq.printf("%n----------------------------------------------------------------------------------");
		    fw.close();	
		}
		catch(IOException e){
			e.printStackTrace();
		}
		finally{
				if(fw != null)
				fw.close();
		}
	}
}

