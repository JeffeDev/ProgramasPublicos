package br.com.wmw.cleancode.nomenclaturas;

import br.com.wmw.cleancode.nomenclaturas.model.Cliente;
import br.com.wmw.cleancode.nomenclaturas.repository.ClienteRepository;

public class ClienteService {

	private ClienteRepository repositoryCliente;

	public ClienteService(final ClienteRepository cliente) {
		this.repositoryCliente = cliente;
	}

	public Cliente Consultar(final Cliente cliente) {
		return this.repositoryCliente.FindById(cliente.getIdCliente());
	}

}
