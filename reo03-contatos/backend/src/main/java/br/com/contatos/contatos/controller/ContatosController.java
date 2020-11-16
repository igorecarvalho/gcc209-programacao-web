package br.com.contatos.contatos.controller;

import br.com.contatos.contatos.interfaces.IContatosService;
import br.com.contatos.contatos.models.Contatos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/contatos")
public class ContatosController {

    @Autowired
    IContatosService contatosService;

    @GetMapping("/listar")
    public ResponseEntity<List> listar(){

        return new ResponseEntity<>(contatosService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{idContato}/buscar")
    public ResponseEntity<Contatos> listarContatoUnico(@PathVariable(value="idContato") Long idContato){
        return new ResponseEntity<>(contatosService.listarContatoUnico(idContato), HttpStatus.OK);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Contatos> cadastrar(@RequestBody Contatos contato) {

        return new ResponseEntity<>(contatosService.cadastrar(contato), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping("/editar")
    public ResponseEntity<Contatos> editar(@RequestBody Contatos contato){

        return new ResponseEntity<>(contatosService.editar(contato), HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping("/{id}/deletar")
    public void deletar(@RequestBody Contatos contato) {

        contatosService.deletar(contato);
    }


}
