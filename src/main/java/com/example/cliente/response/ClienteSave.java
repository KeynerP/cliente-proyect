package com.example.cliente.response;

import com.example.cliente.domain.entities.Cliente;
import com.example.cliente.service.ClienteSaveService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@AllArgsConstructor
@Service
public class ClienteSave {

  private final ClienteSaveService clienteSaveService;

  public Cliente saveCliente(Cliente cliente)
  {return clienteSaveService.save(cliente);}
}
