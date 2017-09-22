package br.cas.controllers;
import java.io.IOException;
import java.nio.charset.Charset;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import br.cas.model.ResultadoModel;

public class ResultadoController extends ResultadoModel{
	
	String url = "http://www.sefaz.ce.gov.br/content/aplicacao/internet/servicos_online/sintegra/result.asp";
	Charset charset = Charset.forName("UTF-8");
	
	public ResultadoModel consultaInscricaoEstadual(String ie){
		
		Elements elements = buscaElementos(ie);
		ResultadoModel res = new ResultadoModel();
		
		if(elements != null) {
			
			//Preenchendo o objeto com o resultado da consulta
			res.setCnpj_cpf(elements.get(2).text());
			res.setIe(elements.get(4).text());
			res.setRazaosocial(elements.get(6).text());
			res.setLogradouro(elements.get(9).text());
			res.setNumero(elements.get(11).text());
			res.setComplemento(elements.get(12).text());
			res.setBairro(elements.get(15).text());
			res.setMunicipio(elements.get(17).text());
			res.setUf(elements.get(19).text());
			res.setCep(elements.get(21).text());
			res.setTelefone(elements.get(23).text());
			res.setCnae_fisc_prim(elements.get(26).text());
			res.setCnae_fisc_sec(elements.get(28).text());
			res.setSituacao(elements.get(30).text());
			res.setData_inicio_atividade(elements.get(32).text());
			res.setData_situacao_cadast(elements.get(34).text());
			res.setRegime_recolhimento(elements.get(36).text());
			res.setCredenciamento_antec(elements.get(38).text());
			res.setObrigado_nfe(elements.get(40).text());
			res.setData_obrig_nfe(elements.get(42).text());
			res.setObrigado_efd(elements.get(44).text());
			res.setData_obrig_efd(elements.get(46).text());
			res.setOpcao_simples(elements.get(48).text());
			res.setObrigado_cte(elements.get(50).text());
			res.setData_obrig_cte(elements.get(52).text());
			
			return res;
		}
		
		return null;
	}
	
	private Elements buscaElementos(String ie) {
		
		Document doc;
		
		try {
			
			System.out.println("Procurando ...");
			doc = Jsoup.connect(this.url)
					.data("cmbCampo","CGF").data("txtValor", ie).post();
			doc.charset(charset);
			
			System.out.println("Encontrei!");
			System.out.println("#########################");
			return doc.getElementsByAttributeValueContaining("size", "-1");
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	public void printAll(ResultadoModel model) {
		System.out.println("CNPJ/CPF: ");
		System.out.println(model.getCnpj_cpf());
		System.out.println("Incrição Estadual: ");
		System.out.println(model.getIe());
		System.out.println("Razão Social:");
		System.out.println(model.getRazaosocial());
		System.out.println("Endereço:");
		System.out.println("Logradouro");
		System.out.println(model.getLogradouro());
		System.out.println("Número:");
		System.out.println(model.getNumero());
		System.out.println("Complemento: ");
		System.out.println(model.getComplemento());
		System.out.println("Bairro: ");
		System.out.println(model.getBairro());
		System.out.println("Município: ");
		System.out.println(model.getMunicipio());
		System.out.println("UF: ");
		System.out.println(model.getUf());
		System.out.println("CEP ");
		System.out.println(model.getCep());
		System.out.println("Telefone: ");
		System.out.println(model.getTelefone());
		System.out.println("CNAE Fiscal Primário:");
		System.out.println(model.getCnae_fisc_prim());
		System.out.println("CNAE Fiscal Secundário:");
		System.out.println(model.getCnae_fisc_sec());
		System.out.println("Situação Cadastral Vigente: ");
		System.out.println(model.getSituacao());
		System.out.println("Data Inicio da Atividade:");
		System.out.println(model.getData_inicio_atividade());
		System.out.println("Data da Situação Cadastral:");
		System.out.println(model.getData_situacao_cadast());
		System.out.println("Regime de Recolhimento:");
		System.out.println(model.getRegime_recolhimento());
		System.out.println("Credenciamento Antecipado:");
		System.out.println(model.getCredenciamento_antec());
		System.out.println("Obrigado a NF-e:");
		System.out.println(model.getObrigado_nfe());
		System.out.println("Data da Obrigatoriedade NF-e:");
		System.out.println(model.getData_obrig_nfe());
		System.out.println("Obrigado a EFD:");
		System.out.println(model.getObrigado_efd());
		System.out.println("Data da Obrigatoriedade EFD:");
		System.out.println(model.getData_obrig_efd());
		System.out.println("Opção Simples:");
		System.out.println(model.getOpcao_simples());
		System.out.println("Obrigado a CTE:");
		System.out.println(model.getObrigado_cte());
		System.out.println("Data da Obrigatoriedade CTE:");
		System.out.println(model.getData_obrig_cte());
	}
}
