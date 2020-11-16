package br.com.contatos.contatos.interfaces;

import br.com.contatos.contatos.models.Contatos;

import java.util.List;

public interface IContatosService {
    List<Contatos> listar();

    Contatos cadastrar(Contatos contato);

    Contatos editar(Contatos contato);

    void deletar(Contatos contato);

    Contatos listarContatoUnico(Long idContato);
}
