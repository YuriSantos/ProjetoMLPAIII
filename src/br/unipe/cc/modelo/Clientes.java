package br.unipe.cc.modelo;

public class Clientes {
	 
	private String  nome, numeroConta;
	private boolean selecine;
	private double saldo;
	private int numID, transacao;
	
	public int getNumID() {
		return numID;
	}
	public void setNumID(int numID) {
		this.numID = numID;
	}
	public int getTransacao() {
		return transacao;
	}
	public void setTransacao(int transacao) {
		this.transacao = transacao;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNumeroConta() {
		return numeroConta;
	}
	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}
	public boolean getSelecine() {
		return selecine;
	}
	public void setSelecine(boolean selecine) {
		this.selecine = selecine;
	}
	
	 
}
