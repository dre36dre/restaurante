package br.com.menu.dao;

import br.com.menu.model.Pedido;

public class PedidoDao {
	
	//criar crud= criar ler atualizar e deletar
	
	public void save(Pedido pedido) {
		String sql="INSERT INTO pedido(nome,quantidade,preco,tamanho) VALUES(?,?,?,?)";
	}
}
