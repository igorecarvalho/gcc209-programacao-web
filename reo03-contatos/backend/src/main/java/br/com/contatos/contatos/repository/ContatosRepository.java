package br.com.contatos.contatos.repository;

import br.com.contatos.contatos.models.Contatos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatosRepository extends JpaRepository<Contatos, Long> {
    Contatos findFirstById(Long id);
}
