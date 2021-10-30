package br.com.menu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.menu.factory.ConnectionFactory;
import br.com.menu.model.Pedido;

public class PedidoDao
{
	
	//criar CRUD= criar ler atualizar e deletar
	
	public void save(Pedido pedido) {
		String sql=
				"INSERT INTO pedido(nome,quantidade,preco,tamanho,dataCadastro) VALUES(?, ?, ?, ? , ?)";
	Connection conn =null;
	PreparedStatement pstm =null;
	
	
	try {//cria uma conexão com banco de dados
		conn = ConnectionFactory.createConnectSql();
	    pstm= (PreparedStatement) conn.prepareStatement(sql);  
	    pstm.setString(1,pedido.getNome());
	    pstm.setInt(2,pedido.getQuantidade());
	    pstm.setDouble(3,pedido.getPreco());
	    pstm.setString(4,pedido.getTamanho());
	    pstm.setDate(5, new Date(pedido.getDataCadastro().getTime() ));
	    
	    //Executa a query
	   pstm.execute();
	   System.out.println("Pedido salvo com sucesso !");
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		
		//fecha as conexões
		try {
			if(pstm !=null) {
				pstm.close();
			}
				if(conn !=null) {
					conn.close();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	}//save
	public void upDate(Pedido pedido) {
		String sql="UPDATE pedidos  SET nome= ?, preco= ? , dataCadastro= ? "+
		"WHERE id= ? ";
		Connection conn= null;
		PreparedStatement pstm=null;
		
		try {
			//Cria a conexão com o banco
			conn=ConnectionFactory.createConnectSql();
			pstm=(PreparedStatement) conn.prepareStatement(sql);
		//Adiciona os valores para atualizar
				pstm.setString(1, pedido.getNome());
				pstm.setDouble(2, pedido.getPreco());
				pstm.setDate(3,new Date(pedido.getDataCadastro().getTime()));
				
				//Qual o id do registro que depois atualizar?
				pstm.setInt(4, pedido.getId());
		//Executar a query
				pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm !=null) {
					pstm.close();
				}
				if(conn !=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public List<Pedido> getPedido(){
		String sql= "SELECT * FROM  pedido";
		
		List<Pedido> pedidos= new ArrayList<Pedido>();
		
		
		Connection conn=null;
		com.mysql.jdbc.PreparedStatement pstm=null;
		//Classe que vai recuperar dados do banco
		ResultSet rset=null;
		
		try {
			conn=ConnectionFactory.createConnectSql();
			pstm=(com.mysql.jdbc.PreparedStatement)conn.prepareStatement(sql);
			rset=pstm.executeQuery();
			
			while(rset.next()) {
			
			Pedido pedido= new Pedido();
			//recupera o id
			pedido.setId(rset.getInt("id"));
			//recupera o nome
			pedido.setNome(rset.getString("nome"));
			//recupera a quantidade
			pedido.setQuantidade(rset.getInt("quantidade"));
			//recupera o preco
			pedido.setPreco(rset.getDouble("preco"));
			//recupera a dataCadastro
		pedido.setDataCadastro(rset.getDate("dataCadastro") );
		
		pedidos.add(pedido);
			}
					}catch (Exception e ) {
						e.printStackTrace();
					}finally {
						try {
						if(rset !=null) {
							rset.close();
						}
						if(pstm !=null) {
							pstm.close();
						}
						if(conn !=null) {
							conn.close();
						}
					}catch (Exception e) {
						e.printStackTrace();
					}
					}
	
		return pedidos;
	
}
}
