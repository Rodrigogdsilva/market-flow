package br.com.mvc.thymeleaf.marketFlow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mvc.thymeleaf.marketFlow.enums.StatusPedido;
import br.com.mvc.thymeleaf.marketFlow.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatus(StatusPedido pedido);
	
}
