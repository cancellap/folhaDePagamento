package br.com.folhaPag.arquivo;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

import br.com.folhaPag.entity.Funcionario;

public class GravacaoArquivo {

	public void escreverArquivo(String caminhoArquivo, List<Funcionario> lista) {

		try {

			PrintWriter pw = new PrintWriter(new FileWriter(caminhoArquivo));

			for (Funcionario funcionario : lista) {

				pw.println(funcionario.getNome() + ";" + funcionario.getCpf() + ";"
						+ String.format("%.2f", funcionario.getDescontoInss()) + ";"
						+ String.format("%.2f", funcionario.getDescontoIR()) + ";"
						+ String.format("%.2f", funcionario.calcularSalarioLiquido()));

			}

			pw.close();

		} catch (Exception e) {
			System.err.println("NÃO");
		}
	}

}
