package br.com.menu.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import br.com.menu.factory.ConnectionFactory;
import br.com.menu.model.Pedido;

public class PedidoDao
{
	
	//criar CRUD= criar ler atualizar e deletar
	
	public void save(Pedido pedido) {
		String sql="INSERT INTO pedido"
		+ "(nome,quantidade,preco,tamanho,data) VALUES(?, ?, ?, ? ,?)";
	Connection conn =null;
	PreparedStatement pstm =null;
	
	
	try {
		conn = ConnectionFactory.createConnectSql();
	    pstm= (PreparedStatement)  conn.prepareStatement(sql);
	    pstm.setString(1,pedido.getNome());
	    pstm.setInt(2,pedido.getQuantidade());
	    pstm.setDouble(3,pedido.getPreco());
	    pstm.setString(4,pedido.getTamanho());
	    pstm.setDate(5, 
	    		new Date(pedido.getDataCadastro().getTime()));
	    
	   pstm.execute();
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
	}
}
