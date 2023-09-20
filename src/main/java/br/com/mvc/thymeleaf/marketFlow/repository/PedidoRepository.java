package br.com.mvc.thymeleaf.marketFlow.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mvc.thymeleaf.marketFlow.enums.StatusPedido;
import br.com.mvc.thymeleaf.marketFlow.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	List<Pedido> findByStatus(StatusPedido pedido);
	
	@Query(value = "SELECT * FROM pedidos p JOIN users u WHERE u.userName = :user", nativeQuery = true)
	List<Pedido> findAllByUser(@Param("user") String user);
	
}
