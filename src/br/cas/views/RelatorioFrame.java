package br.cas.views;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.cas.model.ResultadoModel;

public class RelatorioFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	private ArrayList<ResultadoModel> dados;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RelatorioFrame frame = new RelatorioFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public RelatorioFrame(ArrayList<ResultadoModel> result) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		this.dados = result;
		
		table = new JTable(modelo);
		modelo.addColumn("CNPJ/CPF");
		modelo.addColumn("Razão Social");
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		pesquisar(modelo);
		contentPane.add(table);
	}
	
	public void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		dados = new ArrayList<ResultadoModel>();
		
		for(ResultadoModel result : dados) {
			modelo.addRow(new Object[] {result.getCnpj_cpf(), result.getRazaosocial()});
		}
	}

}
