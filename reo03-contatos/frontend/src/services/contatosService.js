import {ApiService} from './api.service'


const contatoService =  {

    listar: async() => {
        return ApiService.get('contatos/listar');
    },

    getContato: async(id) => {
        return ApiService.get(`contatos/${id}/buscar`);
    },

    cadastrar: async(contato) => {
        return ApiService.post(`contatos/cadastrar`, contato);
    },

    editar: async(contato, id) => {
        return ApiService.put(`contatos/${id}/editar`, contato);
    },

    deletar: async(contato, id) => {
        return ApiService.delete(`contatos/${id}/deletar`, contato);
    },

}

export default contatoService;