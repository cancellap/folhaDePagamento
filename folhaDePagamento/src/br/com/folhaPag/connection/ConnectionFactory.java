package br.com.folhaPag.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	//conexao com o banco de dados LOCAL para fins de apredizagem;
	String url = "jdbc:postgresql://localhost:5432/folhaDePagamento";
	String usuario = "postgres";
	String senha = "1234";
	
	private Connection conexao;

	public Connection getConnection() {
		System.out.println("Conectantdo");
		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			if (conexao != null) {
				System.out.println("Autenticacao Ok");
			}else {
				System.out.println("Falha na autenticacao");
			}
			
		} catch (SQLException e) {
			System.err.println("Nao conectado");
		}
		return conexao;
	}
	
	
}
