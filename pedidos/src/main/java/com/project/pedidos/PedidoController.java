package com.project.pedidos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PedidoController {

	@GetMapping("/pedidos")
	public String helloPedidos() {
		return "Serviço de Pedidos da Loja Veloz rodando com sucesso na versão 1.0!";
	}
}
