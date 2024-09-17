package br.com.folhaPag.arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import br.com.folhaPag.entity.Dependente;
import br.com.folhaPag.entity.Funcionario;
import br.com.folhaPag.enums.Parentesco;

public class LeitorDeArquivo {

	/**
	 * 
	 * @param caminhoArquivo
	 * @return ListDeFuncionario
	 */
	public List<Funcionario> lerFuncionarios(String caminhoArquivo) {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		List<Dependente> dependentes = new ArrayList<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

		try (FileReader fr = new FileReader(caminhoArquivo); BufferedReader br = new BufferedReader(fr)) {

			while (br.ready()) {
				String linha = br.readLine();
				if (!linha.isEmpty()) {
					String dados[] = linha.split(";");
					String nome = dados[0];
					String cpf = dados[1];
					LocalDate dataNasc = LocalDate.parse(dados[2], formatter);
					Double salario = Double.parseDouble(dados[3]);

					Funcionario funcionario = new Funcionario(nome, cpf, dataNasc, salario, dependentes);
					funcionarios.add(funcionario);
				}

				while (br.ready()) {
					linha = br.readLine();
					if (linha.isEmpty()) {
						break;
					}

					String dadosdp[] = linha.split(";");
					String nome = dadosdp[0];
					String cpf = dadosdp[1];
					LocalDate dataNasc = LocalDate.parse(dadosdp[2], formatter);
					Parentesco parentesco = Parentesco.valueOf(dadosdp[3]);
					Dependente dependente = new Dependente(nome, cpf, dataNasc, parentesco);
					dependentes.add(dependente);
				}
			}

		} catch (Exception e) {
			System.out.println("Erro na leitura do arquivo");
			e.printStackTrace();
		}

		return funcionarios;
	}
}
