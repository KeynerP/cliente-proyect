package com.example.cliente.response;

import com.example.cliente.domain.entities.Cliente;
import com.example.cliente.service.ClienteGetService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClienteGet {

  private final ClienteGetService clienteGetService;

  public Cliente getCliente(Long id){
    return clienteGetService.get(id);
  }

}
