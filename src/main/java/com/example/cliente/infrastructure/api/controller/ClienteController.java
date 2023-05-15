package com.example.cliente.infrastructure.api.controller;

import com.example.cliente.domain.entities.Cliente;
import com.example.cliente.exceptions.ResourceNotFoundExceptions;
import com.example.cliente.response.ClienteDelete;
import com.example.cliente.response.ClienteGet;
import com.example.cliente.response.ClienteSave;
import com.example.cliente.repository.ClienteRepository;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

  private final ClienteSave clienteSave;

  private final ClienteGet clienteGet;

  private final ClienteDelete clienteDelete;


  @Autowired
  private ClienteRepository repository;

  //Este metodo sirve para listar todos los clientes
  @GetMapping
  public List<Cliente> listarTodosLosClientes(){
    return repository.findAll();
  }

  //Este metodo es para añadir a los clientes
  @PostMapping
  public ResponseEntity<Cliente> addCliente(@RequestBody Cliente cliente){
    return new ResponseEntity<>(clienteSave.saveCliente(cliente), HttpStatus.CREATED);
  }

  //Este metodo sirve para buscar a un cliente
  @GetMapping("/buscar/{id}")
  public ResponseEntity<Cliente> getCliente(@PathVariable Long id){
    Cliente cliente = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("No existe el cliente con el ID" + id));
    return ResponseEntity.ok(clienteGet.getCliente(id));
  }

  //Este metodo sirve para actualizar un cliente
  @PutMapping("/editar/{id}")
  public ResponseEntity updateCliente(@PathVariable Long id, @RequestBody Cliente detallesCliente){
    Cliente cliente = repository.findById(id).orElseThrow(() -> new ResourceNotFoundExceptions("No existe el cliente con el ID : " + id));
    cliente.setNombre(detallesCliente.getNombre());
    cliente.setDireccion(detallesCliente.getDireccion());
    cliente.setTelefono(detallesCliente.getTelefono());

    Cliente clienteActualizado = repository.save(cliente);
    return  ResponseEntity.ok(clienteActualizado);
  }

  @DeleteMapping("/eliminar/{id}")
  public void delete(@PathVariable Long id){
    clienteDelete.deleteCliente(id);
  }
}
