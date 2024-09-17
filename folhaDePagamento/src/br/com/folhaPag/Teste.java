package br.com.folhaPag;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.folhaPag.entity.Dependente;
import br.com.folhaPag.entity.Funcionario;
import br.com.folhaPag.enums.Parentesco;

public class Teste {

	public static void main(String[] args) {

		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		List<Dependente> dependentes = new ArrayList<Dependente>();
		try {

			FileReader fr = new FileReader("C:\\Users\\PUBLICO\\Desktop\\serratec\\funcionarios.csv");// classe que faz
																										// a leitura de
																										// arquivo.
			BufferedReader br = new BufferedReader(fr);

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
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
			System.out.println("Deu ruim");
			e.printStackTrace();
		}
		System.out.println(dependentes);

	}

}
