package com.example.cliente.response;

import com.example.cliente.service.ClienteDeleteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ClienteDelete {

  private final ClienteDeleteService clienteDeleteService;

  public void deleteCliente(Long id){
    clienteDeleteService.delete(id);
  }
}
