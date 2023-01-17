package com.br.gabriel.cursomc.repositories;

import com.br.gabriel.cursomc.domain.Categoria;
import com.br.gabriel.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Integer> {

}
