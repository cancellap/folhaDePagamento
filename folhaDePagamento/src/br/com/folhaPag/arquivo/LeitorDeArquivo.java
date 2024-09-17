package br.com.folhaPag.arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import br.com.folhaPag.entity.Dependente;
import br.com.folhaPag.entity.Funcionario;
import br.com.folhaPag.entity.Pessoa;
import br.com.folhaPag.enums.Parentesco;
import br.com.folhaPag.exception.CpfException;
import br.com.folhaPag.exception.DependenteException;

public class LeitorDeArquivo {

	public List<Funcionario> lerFuncionarios(String caminhoArquivo) {

		List<Funcionario> funcionarios = new ArrayList<>();
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

					List<Dependente> dependentes = new ArrayList<>();

					Funcionario funcionario = new Funcionario(nome, cpf, dataNasc, salario, dependentes);

					try {
						cpfRepetido(funcionarios, cpf);
						funcionarios.add(funcionario);
					} catch (CpfException erro) {
						System.err.println(erro.getMessage());
					}

					while (br.ready()) {
						linha = br.readLine();
						if (linha.isEmpty()) {
							break;
						}

						try {
							String dadosdp[] = linha.split(";");
							String nomeDp = dadosdp[0];
							String cpfDep = dadosdp[1];
							LocalDate dataNascDep = LocalDate.parse(dadosdp[2], formatter);
							Parentesco parentesco = Parentesco.valueOf(dadosdp[3]);
							
							Dependente dependente = new Dependente(nomeDp, cpfDep, dataNascDep, parentesco);
							dependente.calculoIdade(dataNascDep);
							cpfRepetido(funcionario.getDependentes(), cpfDep);
							funcionario.getDependentes().add(dependente);
						} catch (DependenteException erro) {
							System.err.println(erro.getMessage());
						} catch (CpfException erro) {
							System.err.println(erro.getMessage());
						}

					}
				}
			}

		} catch (Exception e) {
			System.err.println("Erro na leitura do arquivo");
		}

		return funcionarios;
	}

	public void cpfRepetido(List<? extends Pessoa> lista, String cpf) throws CpfException {
		for (Pessoa objeto : lista) {
			if (objeto.getCpf().equals(cpf)) {
				throw new CpfException("Exceção: Cpf " + cpf + " já cadastrado.");
			}
		}

	}
}
