package br.com.contatos.contatos.services;

import br.com.contatos.contatos.interfaces.IContatosService;
import br.com.contatos.contatos.models.Contatos;
import br.com.contatos.contatos.repository.ContatosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContatosService implements IContatosService {

    @Autowired
    ContatosRepository contatosRepository;

    private Contatos findContById(Long idContato){

        return contatosRepository.findFirstById(idContato);
    }

    @Override
    public List<Contatos> listar() {

        return contatosRepository.findAll();
    }

    @Override
    public Contatos cadastrar(Contatos contato) {

        return contatosRepository.save(contato);
    }

    @Override
    public Contatos listarContatoUnico(Long idContato) {

        return findContById(idContato);
    }
}
