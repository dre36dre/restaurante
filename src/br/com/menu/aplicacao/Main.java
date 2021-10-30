package br.com.menu.aplicacao;

import java.util.Date;

import br.com.menu.dao.PedidoDao;
import br.com.menu.model.Pedido;

public class Main {
	 public static void main(String[] args) {
		 
		PedidoDao pedidoDao=new PedidoDao();
 
		Pedido pedido= new Pedido();
		pedido.setNome("feijoada");
		pedido.setQuantidade(1);	
		pedido.setPreco(29);
		pedido.setDataCadastro(new Date());
	 
		//pedidoDao.save(pedido); 
		
		//Atualiza o pedido
		Pedido p1=new Pedido();
		p1.setNome("Macarronada");
		p1.setPreco(31);
		p1.setDataCadastro(new Date());
		
		p1.setId(1);//è o numero que esta no banco de dados da pk

		//pedidoDao.upDate(p1);
		
		//remover pedido pelo numero de id
		pedidoDao.deleteByid(1);
		
		//Visualização dos dados
		for( Pedido p: pedidoDao.getPedido() ) {
			System.out.println("Nome: "+p.getNome());
			
		}
	 }
}
