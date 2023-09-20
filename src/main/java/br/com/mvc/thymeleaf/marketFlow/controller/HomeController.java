package br.com.mvc.thymeleaf.marketFlow.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.mvc.thymeleaf.marketFlow.enums.StatusPedido;
import br.com.mvc.thymeleaf.marketFlow.model.Pedido;
import br.com.mvc.thymeleaf.marketFlow.repository.PedidoRepository;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@GetMapping
	public String home(Model model, Principal principal) {
		
		List<Pedido> pedidos = pedidoRepository.findAllByUser(principal.getName());
		
		model.addAttribute("pedidos", pedidos);
		
		
		return "home";
	}
	
	@GetMapping("/{status}")
	public String verificaStatus(@PathVariable("status") String status, Model model) {
		
		List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
		
		model.addAttribute("pedidos", pedidos);
		model.addAttribute("status", status);
		
		
		return "home";
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String existeErro() {
		return "redirect:/home";
	}
}
