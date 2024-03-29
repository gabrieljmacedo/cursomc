package com.br.gabriel.cursomc.services;

import com.br.gabriel.cursomc.domain.Cliente;
import com.br.gabriel.cursomc.domain.Pedido;
import com.br.gabriel.cursomc.repositories.ClienteRepository;
import com.br.gabriel.cursomc.repositories.PedidoRepository;
import com.br.gabriel.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repo;

    public Pedido find(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "
        + id + ", Tipo " + Pedido.class.getName()));
    }

}
