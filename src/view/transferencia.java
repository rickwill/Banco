package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import model.domain.Conta;

public class transferencia extends JFrame {

	private JPanel contentPane;
	private JTextField tf_NmConta;
	private JTextField tf_ValorTrans;
	private JTextField tf_Saldo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transferencia frame = new transferencia();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public transferencia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNumeroConta = new JLabel("Numero Conta");
		
		tf_NmConta = new JTextField();
		tf_NmConta.setColumns(10);
		
		tf_ValorTrans = new JTextField();
		tf_ValorTrans.setColumns(10);
		
		JLabel lblValorTransferencia = new JLabel("Valor Transferencia");
		
		tf_Saldo = new JTextField();
		tf_Saldo.setEditable(false);
		tf_Saldo.setColumns(10);
		
		JLabel lblSaldoAtual = new JLabel("Saldo Atual");
		
		JButton btnTransfere = new JButton("Transfere");
		btnTransfere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Conta c1 = new Conta();
				Conta c2 = new Conta();
				c1.depositar(2000);
				c1.setNumeroConta(1);
                                //c1.setCpfTitular("123");
				c2.setNumeroConta(2);
				tf_Saldo.setText(""+c1.getSaldo());
				
				//System.out.println("tf :["+tf_NmConta.getText().trim()+"] c2 :["+c2.getNumeroConta().trim()+"]");	
				if(tf_NmConta.getText().trim().equals(c2.getNumeroConta().trim()) || !tf_ValorTrans.getText().isEmpty()){
                                    
                                    
                                    c1.transferencia(c2, Double.parseDouble(tf_ValorTrans.getText()));
                                    
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "Opera��o n�o realizada!");
                                }
				
				
				
			}
		});
		
		JButton btnVoltar = new JButton("Voltar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblValorTransferencia)
						.addComponent(tf_ValorTrans, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(tf_NmConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNumeroConta))
							.addGap(58)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblSaldoAtual)
								.addComponent(tf_Saldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnTransfere)
									.addGap(10)
									.addComponent(btnVoltar)))))
					.addContainerGap(83, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumeroConta)
						.addComponent(lblSaldoAtual))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tf_NmConta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(tf_Saldo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(lblValorTransferencia)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(tf_ValorTrans, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTransfere)
						.addComponent(btnVoltar))
					.addGap(20))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
