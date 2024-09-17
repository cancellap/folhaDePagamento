package br.com.folhaPag;

import java.util.List;

import br.com.folhaPag.arquivo.LeitorDeArquivo;
import br.com.folhaPag.entity.Funcionario;

public class Teste {

	public static void main(String[] args) {

		LeitorDeArquivo leitor = new LeitorDeArquivo();
		List<Funcionario> funcionarios = leitor.lerFuncionarios("C:/curso/funcionarios.csv");
		
		for (Funcionario funcionario : funcionarios) {
			System.out.println(funcionario);
		}
	}

}
