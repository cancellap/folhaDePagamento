package br.com.folhaPag.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.com.folhaPag.connection.ConnectionFactory;
import br.com.folhaPag.entity.Dependente;
import br.com.folhaPag.entity.Funcionario;

public class FuncionarioDao {

	private Connection connection;

	public FuncionarioDao() {
		connection = new ConnectionFactory().getConnection();
	}

	public void inserir(Funcionario funcionario) {
		String sqlFuncionario = "INSERT INTO funcionario(nome, cpf, datanascimento, salarioBruto) VALUES (?, ?, ?, ?)" +
	"on conflict (cpf) do update set nome= excluded.nome , datanascimento= excluded.datanascimento, salarioBruto= excluded.salarioBruto";
		
		String sqlDependente = "INSERT INTO dependente(cpf, nome, datanascimento, id_funcionario) VALUES (?, ?, ?, ?)" + 
		 "on conflict (cpf) do update set nome= excluded.nome , datanascimento= excluded.datanascimento";
		
		try {
			PreparedStatement stmtFunc = connection.prepareStatement(sqlFuncionario, PreparedStatement.RETURN_GENERATED_KEYS);
			stmtFunc.setString(1, funcionario.getNome());
			stmtFunc.setString(2, funcionario.getCpf());
			stmtFunc.setObject(3, funcionario.getDataNascimento());
			stmtFunc.setDouble(4, funcionario.getSalarioBruto());
			stmtFunc.execute();
			//stmtFunc.close();
			// esse getGeneratekeys pega chave primariaa
			ResultSet pk = stmtFunc.getGeneratedKeys();

			if (pk.next()) {
				int funcionarioId = pk.getInt(1);

				List<Dependente> dependentes = funcionario.getDependentes();
	            if (dependentes != null) {
	                for (Dependente dependente : dependentes) {
	                	PreparedStatement stmtDependente = connection.prepareStatement(sqlDependente);
	                	stmtDependente.setString(1, dependente.getCpf());
	                    stmtDependente.setString(2, dependente.getNome());
	                    stmtDependente.setObject(3, dependente.getDataNascimento());
	                    stmtDependente.setInt(4, funcionarioId);
	                    stmtDependente.execute();
	                    stmtDependente.close();
	                }
	            }

			}
			//connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
