package com.br.gabriel.cursomc.dto;

import com.br.gabriel.cursomc.domain.Cliente;
import com.br.gabriel.cursomc.services.validation.ClienteUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@ClienteUpdate
public class ClienteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotEmpty(message = "Prenchimento obrigatório")
    @Length(min = 5, max = 120, message = "O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;
    @NotEmpty(message = "Prenchimento obrigatório")
    @Email(message = "E-mail inválido")
    private String email;

    public ClienteDTO() {

    }

    public ClienteDTO(Cliente obj) {
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
