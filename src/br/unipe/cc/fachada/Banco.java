package br.unipe.cc.fachada;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import br.unipe.cc.modelo.Clientes;
import br.unipe.cc.modelo.DadosClientes;
import br.unipe.cc.modelo.VerificaCliente;
import br.unipe.cc.modelo.VerificaGerente;
import br.unipe.cc.persistencia.ArquivoTxt;
import br.unipe.cc.persistencia.EsvaziaBD;
import br.unipe.cc.persistencia.ExibeSaldo;
import br.unipe.cc.persistencia.SalvaDadosBD;
import br.unipe.cc.persistencia.TransacoesBD;

public class Banco extends DadosClientes{  

	
	String nome = "", numero = "";
	
	private static TableModel tabelacheck = null;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void BancoInterface() {
		
		
		//cria o frame	
		final JFrame frame = new JFrame("Sistema de contas");		
		tabelacheck = new TabelaCheck(ListaClientes());
		//configurando a label com imagens
		Icon planofundo = new ImageIcon("cadeadoFechado.jpg");  
		Icon planofundo1= new ImageIcon("cadeadoAberto.jpg");
		final JLabel label = new JLabel(planofundo);
		label.setBounds(0, 0, 594, 371);
		final JLabel label1 = new JLabel(planofundo1);
		label1.setBounds(0, 0, 594, 371);
		
		//configurando os botï¿½es
		JButton button1 = new JButton("Adicionar Conta");
		button1.setBounds(58, 56, 134, 32);
		JButton button2 = new JButton("Sair");
		button2.setBounds(10, 328, 100, 32);
		JButton button3 = new JButton("Creditos");
		button3.setBounds(494, 0, 100, 32);
		JButton button4 = new JButton("Clientes");
		button4.setBounds(178, 148, 121, 32);
		JButton button5 = new JButton("Esvaziar lista do Banco de Dados");
		button5.setBounds(219, 198, 231, 34);
		JButton button6 = new JButton("Listar Contas");
		button6.setBounds(105, 103, 129, 34);
		
		//configurando a tabela
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		frame.getContentPane().add(button3);
		frame.getContentPane().add(button4); 
		frame.getContentPane().add(button5); 
		frame.getContentPane().add(button6);
		
		frame.getContentPane().add(label);
		frame.setSize(600,400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	 
		//eventos-------
		ActionListener button1Listener = new ActionListener() {
		        @Override
		        public void actionPerformed(ActionEvent e) {
		        	boolean v = new VerificaGerente().Verifica();
		        	if(v ==true)
		        	{
		        	SalvaDadosBD dados = new SalvaDadosBD();//salva nome e numero do cliente no banco da dados
					dados.Cadastro();
					frame.setVisible(false);
					BancoInterface();  
		        	}
		        }
		};
		ActionListener button2Listener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	System.exit(0); 
	        	
	        }
		};
		ActionListener button3Listener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	JOptionPane.showMessageDialog(null,"Programa feito por Yuri Barbosa Santos e Victor Bessa!");
	        	
	        }
		};
		ActionListener button4Listener = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	        	
	    		    		
	    		nome = JOptionPane.showInputDialog("Digite o nome de  identificação");
	    		numero = JOptionPane.showInputDialog("Agora digite sua senha");
	        	
	        	boolean v = new VerificaCliente().Verifica(nome, numero);
	        	
	        	if(v ==true)
	        	{
	        	ClienteFachada();
				frame.setVisible(false);
				  
	        	}
	        	
	       }
	        
		};
		
		ActionListener button5Listener = new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				boolean v = new VerificaGerente().Verifica();
				if(v==true)
				{
					EsvaziaBD dados = new EsvaziaBD();
					dados.Esvaziar();
					frame.setVisible(false);
					BancoInterface();
				}
	        }
		};
		
		ActionListener button6Listener = new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				TabelaFachada();
			}
		};
		
		
		//adicionando eventos aos botï¿½es
		 button1.addActionListener(button1Listener);
		 button2.addActionListener(button2Listener);
		 button3.addActionListener(button3Listener);
		 button4.addActionListener(button4Listener);
		 button5.addActionListener(button5Listener);
		 button6.addActionListener(button6Listener);
		 
	}
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void ClienteFachada() {
		
		Icon planofundo = new ImageIcon("cadeadoFechado.jpg"); 
		JLabel label = new JLabel(planofundo);
		label.setBounds(0, 0, 594, 371);
		final JFrame frame = new JFrame("Menu - Clientes");
		JButton button1 = new JButton("SALDO");
		button1.setBackground(Color.YELLOW);
		button1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button1.setBounds(310, 48, 242, 93);
		JButton button2 = new JButton("CREDITAR");
		button2.setBackground(Color.YELLOW);
		button2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button2.setBounds(37, 48, 242, 93);
		JButton button3 = new JButton("TRANSFER\u00CANCIA");
		button3.setBackground(Color.YELLOW);
		button3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button3.setBounds(310, 164, 242, 93);
		JButton button4 = new JButton("EMPR\u00C9STIMO");
		button4.setBackground(Color.YELLOW);
		button4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		button4.setBounds(37, 164, 242, 93);
		JButton button5 = new JButton("Voltar");
		button5.setBackground(Color.WHITE);
		button5.setBounds(10, 326, 84, 34);
		frame.getContentPane().setLayout(null);
		
		
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		frame.getContentPane().add(button3);
		frame.getContentPane().add(button4);
		frame.getContentPane().add(button5);	
		frame.getContentPane().add(label);
		frame.setSize(600,400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//eventoos
		ActionListener button1Listener = new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				ExibeSaldo exibe = new ExibeSaldo();
				exibe.exibir(nome, numero);
				
			}
		};
		
		ActionListener button2Listener = new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				TransacoesBD creditar = new TransacoesBD();
				creditar.creditar(nome, numero);
				frame.setVisible(false);
				ClienteFachada();
			}
		};
		ActionListener button3Listener = new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				
					TransacoesBD creditar = new TransacoesBD();
					creditar.transferencia(nome, numero);
					frame.setVisible(false);
					ClienteFachada();
				
				
			}
		};
		ActionListener button4Listener = new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {

					TransacoesBD creditar = new TransacoesBD();
					creditar.emprestimo(nome, numero);
					frame.setVisible(false);
					ClienteFachada();
				
			}
		};
		ActionListener button5Listener = new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				BancoInterface();
			}
		};
		//adicionando eventos aos botï¿½es
		 button1.addActionListener(button1Listener);
		 button2.addActionListener(button2Listener);
		 button3.addActionListener(button3Listener);
		 button4.addActionListener(button4Listener);
		 button5.addActionListener(button5Listener);
		 
}
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void TabelaFachada(){
	
		Icon planofundo = new ImageIcon("cadeadoFechado.jpg"); 
		JLabel label = new JLabel(planofundo);
		label.setBounds(0, 0, 594, 371);
		JTable table = new JTable();
		table.setModel(tabelacheck);
		table.getColumnModel().getColumn(0).setPreferredWidth(1); 
		table.getColumnModel().getColumn(5).setPreferredWidth(1); 
		JScrollPane barraRolagem = new JScrollPane(table);
		
		barraRolagem.setBounds(23, 27, 547, 219);
		final JFrame frame = new JFrame("Lista de Contas - Clientes");
		JButton button1 = new JButton("Gerar Relatorio");
		button1.setBounds(227, 270, 129, 34);
		JButton button2 = new JButton("Sair");
		button2.setBounds(10, 323, 129, 34);
		frame.getContentPane().setLayout(null);
		
		
		frame.getContentPane().add(button1);
		frame.getContentPane().add(button2);
		frame.getContentPane().add(barraRolagem);
		frame.getContentPane().add(label);
		frame.setSize(600,400);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		//eventoos
		ActionListener button1Listener = new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				
				int tamanho = tabelacheck.getRowCount(), contador = 0; 
	        	List<Clientes> selecionados = new ArrayList<Clientes>();//cria uma nova lista de clientes	        	
	        	
	        	for(int i = 0; i<tamanho; i++){//varrer a coluna de check 
	        		Object valorTabela =  tabelacheck.getValueAt(i, 5);// o (i) sera as linhas,a e o (2) a coluna fixa que esta o check
	        		if(valorTabela.equals(true)){
	        			Clientes  clienteSelecionado = new Clientes();
	        			clienteSelecionado.setNumID((int)(tabelacheck.getValueAt(i, 0)));
	        			clienteSelecionado.setNome((String)(tabelacheck.getValueAt(i, 1)));//retorna o nome da conta seliconada
	        			clienteSelecionado.setNumeroConta((String)tabelacheck.getValueAt(i, 2));//retorna o numero da conta selecionada
	        			clienteSelecionado.setSaldo((double)tabelacheck.getValueAt(i, 3));
	        			clienteSelecionado.setTransacao((int)tabelacheck.getValueAt(i, 4));
	        			selecionados.add(clienteSelecionado);//adiciona os clientes selecionados em uma nova lista
	        			contador++;
	        		}
	        	}
	           	//arquivoooooooooooooooo
	        	try {
	        		if(contador == 0){
	        			JOptionPane.showMessageDialog(null,"Nenhum item selecionado, é impossivel gerar um relatorio");
	        		}
	        		else{
		        		frame.setVisible(false);
		        		ArquivoTxt arquivo = new ArquivoTxt();
		        		arquivo.ArquivoTxtClientes(selecionados);
		        		JOptionPane.showMessageDialog(null,"Relatório gerado com sucesso!");
	        		}
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
			}
		};
		
		ActionListener button2Listener = new ActionListener() {
			@Override
	        public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		};
		//adicionando eventos aos botï¿½es
		 button1.addActionListener(button1Listener);
		 button2.addActionListener(button2Listener);
	}
}

