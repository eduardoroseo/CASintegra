package br.cas.views;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.cas.model.ResultadoModel;

public class RelatorioView extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	
	private ArrayList<ResultadoModel> dados;
	
	/**
	 * Create the panel.
	 */
	
	public RelatorioView(ArrayList<ResultadoModel> result) {
		this.dados = result;
		setBorder(UIManager.getBorder("Tree.editorBorder"));
		
		table = new JTable(modelo);
		modelo.addColumn("CNPJ/CPF");
		modelo.addColumn("Razão Social");
		table.getColumnModel().getColumn(0).setPreferredWidth(120);
		table.getColumnModel().getColumn(1).setPreferredWidth(120);
		pesquisar(modelo);
		add(table);

	}
	
	
	public void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		dados = new ArrayList<ResultadoModel>();
		
		for(ResultadoModel result : dados) {
			modelo.addRow(new Object[] {result.getCnpj_cpf(), result.getRazaosocial()});
		}
	}

}
