package br.com.mvc.thymeleaf.marketFlow.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mvc.thymeleaf.marketFlow.dto.RequisicaoNovoPedidoDTO;
import br.com.mvc.thymeleaf.marketFlow.model.Pedido;
import br.com.mvc.thymeleaf.marketFlow.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@GetMapping("formulario")
	public String formulario(@ModelAttribute("requisicaoNovoPedidoDTO") RequisicaoNovoPedidoDTO requisicao) {
		return "pedido/formulario";
	}
	
	@PostMapping("novo")
	public String novo(@ModelAttribute("requisicaoNovoPedidoDTO") @Valid RequisicaoNovoPedidoDTO requisicao, BindingResult result) {
		
		if(result.hasErrors()) {
			return "pedido/formulario";
		}
		
		Pedido pedido = requisicao.toPedido();
		pedidoRepository.save(pedido);
		return "redirect:/home";
	}

}
