package br.com.mvc.thymeleaf.marketFlow.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import br.com.mvc.thymeleaf.marketFlow.enums.StatusPedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(staticName = "of")
@Entity(name = "pedidos")
public class Pedido {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull
	private String nomeProduto;
	private BigDecimal valorNegociado;
	private LocalDate dataDaEntrega;
	
	@NotNull
	private String urlProduto;
	
	@NotNull
	private String urlImagem;
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusPedido status;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;
}
