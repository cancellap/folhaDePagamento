package br.com.folhaPag;

import java.util.List;

import br.com.folhaPag.arquivo.GravacaoArquivo;
import br.com.folhaPag.arquivo.LeitorDeArquivo;
import br.com.folhaPag.entity.Funcionario;

public class Teste {

	public static void main(String[] args) {

		LeitorDeArquivo leitor = new LeitorDeArquivo();
		List<Funcionario> funcionarios = leitor.lerFuncionarios("src./br/com/folhaPag/csv/funcionarios.csv");

		for (Funcionario funcionario : funcionarios) {
			funcionario.calculoInss();
			funcionario.calculoIR();
			System.out.println(funcionario);
		}

		GravacaoArquivo ga = new GravacaoArquivo();
		ga.escreverArquivo("src./br/com/folhaPag/csv/funcionariossaida.csv", funcionarios);

	}

}