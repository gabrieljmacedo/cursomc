package com.br.gabriel.cursomc.services;

import com.br.gabriel.cursomc.domain.Cliente;
import com.br.gabriel.cursomc.domain.Cliente;
import com.br.gabriel.cursomc.dto.ClienteDTO;
import com.br.gabriel.cursomc.repositories.ClienteRepository;
import com.br.gabriel.cursomc.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repo;

    public Cliente find(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: "
        + id + ", Tipo " + Cliente.class.getName()));
    }

    public Cliente update(Cliente obj) {
        find(obj.getId());
        return repo.save(obj);
    }

    public void deleteById(Integer id) {
        find(id);
        try {
            repo.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw  new com.br.gabriel.cursomc.services.exception.DataIntegrityViolationException("Não é possível excluir " +
                    "uma Cliente que possui produtos!");
        }
    }

    public List<Cliente> findAll() {

        return repo.findAll();

    }

    public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);
    }

    public Cliente fromDTO(ClienteDTO objDto) {
        throw new UnsupportedOperationException();
    }

}
