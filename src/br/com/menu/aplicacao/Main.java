package br.com.menu.aplicacao;

import java.util.Date;

import br.com.menu.dao.PedidoDao;
import br.com.menu.model.Pedido;

public class Main {
	 public static void main(String[] args) {
		 
		PedidoDao pedidoDao=new PedidoDao();
 
		Pedido pedido= new Pedido();
		pedido.setNome("Pizza");
		pedido.setQuantidade(1);	
		pedido.setPreco(35);
		pedido.setDataCadastro(new Date());
	 
		pedidoDao.save(pedido); 
		
		//Visualização dos dados
		for( Pedido p: pedidoDao.getPedido() ) {
			System.out.println("Pedido"+p.getNome());
			
		}
	 }
}
