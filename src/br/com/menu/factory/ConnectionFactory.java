package br.com.menu.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.concurrent.ExecutionException;

public class ConnectionFactory {
	//nome do usuário mysql
	private static final String USERNAME= "root";
	
	//senha do banco 
	private static final String PASSWORD= "";
	
	//CAMINHO DO BANCO DE DADOS
	private static final String 
	DATABASE_URL="jdbc:mysql://localhost:3306/menu";
	
	//conexão com o banco
	public static Connection createConnectSql() throws Exception	 {
		
		//faz com o que classe seja carregada pela JVM
		Class.forName("com.mysql.jdbc.DRIVER");
		Connection connection=
		DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
		return connection;
	}
	public static void main(String[] args) throws Exception {
		//recupera uma conexao com o banco de dados
		Connection con=createConnectSql();
		//testa se a conexão é nula
		if(con!=null) {
			System.out.println("Conexão obtida com sucesso");
			con.close();
		}
	}
}
