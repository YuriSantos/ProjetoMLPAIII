package br.unipe.cc.fachada;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import br.unipe.cc.modelo.Clientes;

public class TabelaCheck extends AbstractTableModel{
	 
	 private static final int colunaCheckBox = 5;
	 private final int NumID = 0;
	 private final int NOME = 1;
	 private final int NUMERO_DA_CONTA = 2;
	 private final int SALDO = 3;
	 private final int TRANSAÇÕES = 4;
	 private final int SELECIONE = 5;
	 
	 String [] coluna = {"NumID","NOME","NUMERO_CONTA","SALDO","TRANSAÇÕES","SELEC"};//fazer isso em outra classe
	 List<Clientes> dados;
	//construtor
	 public TabelaCheck(List<Clientes> dados) {
	        //seta os dados no construtor
	        this.dados = dados;
	 }
	 
	    
//		@Override
	    public int getColumnCount() {
	        //retorna o total de colunas
	        return coluna.length;
	    }
	 
//	    @Override
	    public int getRowCount() {
	        //retorna o total de linhas na tabela
	        return dados.size();
	    }
	    
//	    @Override
	    public Class<?> getColumnClass(int columnIndex) {
	        //retorna o tipo de dado, para cada coluna
	        switch (columnIndex) {
	        case NumID:
	            return int.class;
	        case NOME:
	            return String.class;
	        case NUMERO_DA_CONTA:
	            return String.class;
	        case SALDO:
	            return double.class;
	        case TRANSAÇÕES:
	            return String.class;
	        case SELECIONE:
	            return Boolean.class;
	        default:
	            throw new IndexOutOfBoundsException("Coluna Inválida!!!");
	        }
	    }
	 
 	// @Override
	    public String getColumnName(int columnIndex) {
	        return coluna[columnIndex];
	    }

		
	 
//	    @Override
	    public Object getValueAt(int rowIndex, int columnIndex) {
	        //retorna o valor conforme a coluna e linha
	 
	        //pega o dados corrente da linha
	        Clientes clientes = dados.get(rowIndex);

	        //retorna o valor da coluna
	        switch (columnIndex) {
	        case NumID:
	            return clientes.getNumID();
	        case NOME:
	            return clientes.getNome();
	        case NUMERO_DA_CONTA:
	            return clientes.getNumeroConta();
	        case SALDO:
	            return clientes.getSaldo();
	        case TRANSAÇÕES:
	            return clientes.getTransacao();
	        case SELECIONE:
	            return clientes.getSelecine();
	        default:
	            throw new IndexOutOfBoundsException("Coluna Inválida!!!");
	        }
	    }
	 
//	    @Override
	    public boolean isCellEditable(int rowIndex, int columnIndex) {
	        //metodo identifica qual coluna é editavel
	 
	        //só iremos editar a coluna BENEFICIO,
	        //que será um checkbox por ser boolean
	        if(columnIndex == SELECIONE)
	            return true;
	 
	        return false;
	    }
	 
//	    @Override
	    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	        Clientes cliente = dados.get(rowIndex);
	 
	        if(columnIndex == SELECIONE){
	            cliente.setSelecine(((boolean)aValue));
	        }
	    }
	 
}
