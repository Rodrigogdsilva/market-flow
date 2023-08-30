package br.com.mvc.thymeleaf.marketFlow.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPedido {

	AGUARDANDO("AGUARDANDO"),
	APROVADO("APROVADO"),
	ENTREGUE("ENTREGUE");
	
	private String nome;
	
}
