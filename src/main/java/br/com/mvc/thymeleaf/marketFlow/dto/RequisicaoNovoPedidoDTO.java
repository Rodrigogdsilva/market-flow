package br.com.mvc.thymeleaf.marketFlow.dto;

import javax.validation.constraints.NotBlank;

import br.com.mvc.thymeleaf.marketFlow.enums.StatusPedido;
import br.com.mvc.thymeleaf.marketFlow.model.Pedido;
import lombok.Data;

@Data(staticConstructor = "of")
public class RequisicaoNovoPedidoDTO {
	
	@NotBlank(message = "{NotBlank.nomeProduto}")
	private String nomeProduto;
	
	@NotBlank
	private String urlProduto;
	
	@NotBlank
	private String urlImagem;
	
	private String descricao;
	
	public Pedido toPedido() {
		
		Pedido pedido = Pedido.of();
		
		pedido.setDescricao(descricao);
		pedido.setNomeProduto(nomeProduto);
		pedido.setUrlImagem(urlImagem);
		pedido.setUrlProduto(urlProduto);
		pedido.setStatus(StatusPedido.AGUARDANDO);
		
		return pedido;
	}
	
}
