package br.cas.views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import br.cas.controllers.ResultadoController;
import br.cas.model.ResultadoModel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ResultadoView {

	private JFrame frmCasConsulta;
	private JTextField txtIe;
	private ArrayList<ResultadoModel> res;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResultadoView window = new ResultadoView();
					window.frmCasConsulta.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ResultadoView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCasConsulta = new JFrame();
		frmCasConsulta.setTitle("CAS - Consulta Automatizada ao Sintegra");
		frmCasConsulta.setBounds(100, 100, 413, 229);
		frmCasConsulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCasConsulta.getContentPane().setLayout(null);
		
		txtIe = new JTextField();
		txtIe.setBounds(129, 88, 152, 31);
		frmCasConsulta.getContentPane().add(txtIe);
		txtIe.setColumns(15);
		
		JLabel lblNewLabel = new JLabel("Insira a Inscri\u00E7\u00E3o Estadual para \r\nconsultar no Sintegra");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(38, 11, 338, 88);
		frmCasConsulta.getContentPane().add(lblNewLabel);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				ResultadoController busca = new ResultadoController();
				
				ResultadoModel consulta = busca.consultaInscricaoEstadual(txtIe.getText());
				
				res = new ArrayList<ResultadoModel>();
				res.add(consulta);
				
				RelatorioFrame frame = new RelatorioFrame(res);
				frame.setVisible(true);
				frame.show(true);
//				RelatorioView relatorio = new RelatorioView(res);
//				relatorio.setVisible(true);
//				relatorio.show(true);
				
				busca.printAll(consulta);
				
				
				
				
			}
		});
		btnConsultar.setBounds(190, 130, 91, 23);
		frmCasConsulta.getContentPane().add(btnConsultar);
	}
}
