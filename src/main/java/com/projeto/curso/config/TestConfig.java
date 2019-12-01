package com.projeto.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projeto.curso.entidades.Categoria;
import com.projeto.curso.entidades.ItemPedido;
import com.projeto.curso.entidades.Pedido;
import com.projeto.curso.entidades.Produto;
import com.projeto.curso.entidades.Usuario;
import com.projeto.curso.entidades.enums.PedidoStatus;
import com.projeto.curso.repositories.CategoriaRepository;
import com.projeto.curso.repositories.ItemPedidoRepository;
import com.projeto.curso.repositories.PedidoRepository;
import com.projeto.curso.repositories.ProdutoRepository;
import com.projeto.curso.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Categoria c1 = new Categoria(null,"Eletrônicos");
		Categoria c2 = new Categoria(null,"Livros");
		Categoria c3 = new Categoria(null,"Computadores");
		
		Produto pr1 = new Produto(null, "O senhor dos Anéis", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pr5 = new Produto(null, "Java Como Programar", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"), PedidoStatus.Pago, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"), PedidoStatus.AguardandoPagamento, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"), PedidoStatus.AguardandoPagamento ,u1);
		
		
		categoriaRepository.saveAll(Arrays.asList(c1,c2,c3));
		produtoRepository.saveAll(Arrays.asList(pr1,pr2,pr3,pr4,pr5));
		
		pr1.getCategorias().add(c2);
		pr2.getCategorias().add(c1);
		pr2.getCategorias().add(c3);
		pr3.getCategorias().add(c3);
		pr4.getCategorias().add(c3);
		pr5.getCategorias().add(c2);
		
		produtoRepository.saveAll(Arrays.asList(pr1,pr2,pr3,pr4,pr5));
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		pedidoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		ItemPedido ip1 = new ItemPedido(p1, pr1, 2, pr1.getPreco());
		ItemPedido ip2 = new ItemPedido(p1, pr3, 1, pr3.getPreco());
		ItemPedido ip3 = new ItemPedido(p2, pr3, 2, pr3.getPreco());
		ItemPedido ip4 = new ItemPedido(p3, pr5, 2, pr5.getPreco());
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3,ip4));

	}
	
	
}
