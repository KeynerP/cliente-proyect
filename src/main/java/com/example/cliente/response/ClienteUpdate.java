package com.example.cliente.response;


import com.example.cliente.domain.entities.Cliente;
import com.example.cliente.service.ClienteGetService;
import com.example.cliente.service.ClienteUpdateService;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class ClienteUpdate {


  private final ClienteUpdateService clienteUpdateService;
  private final ClienteGetService clienteGetService;


  public void updateCliente(Cliente cliente) {
  Cliente cliente1 = clienteGetService.get(cliente.getId());
  if (Objects.isNull(cliente1)){
    log.info("EL CLIENTE CON ID {} NO ESTA REGISTRADO", cliente.getId());
    return;
  }
  cliente1.setNombre(cliente.getNombre());
  cliente1.setDireccion(cliente.getDireccion());
  cliente1.setTelefono(cliente.getTelefono());
  clienteUpdateService.update(cliente1);
  }
}
