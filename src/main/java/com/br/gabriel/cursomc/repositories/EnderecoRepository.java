package com.br.gabriel.cursomc.repositories;

import com.br.gabriel.cursomc.domain.Cliente;
import com.br.gabriel.cursomc.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
