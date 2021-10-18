package br.com.menu.aplicacao;

import java.util.Date;

import br.com.menu.dao.PedidoDao;
import br.com.menu.model.Pedido;

public class Main {
	 public static void main(String[] args) {
		 
		PedidoDao pedidoDao=new PedidoDao();
 
		Pedido pedido= new Pedido();
		pedido.setNome("Feijoada");
		pedido.setId(1);
		pedido.setDataCadastro(new Date());
	 
		pedidoDao.save(pedido);
	 }
}