import {ApiService} from './api.service'


const comentarioService =  {

    listar: async() => {
        return ApiService.get('comentarios/listarTodos');
    },

    listarPorPostagem: async(idPost) => {
        return ApiService.get(`comentarios/${idPost}/listar`);
    },

    cadastrar: async(comentario) => {
        return ApiService.post(`comentarios/cadastrar`, comentario);
    },

    editar: async(idComentarios, comentarios) => {
        return ApiService.put(`comentarios/${idComentarios}/editar`, comentarios);
    },

    deletar: async(idComentarios) => {
        return ApiService.delete(`comentarios/${idComentarios}/deletar`);
    },

}

export default comentarioService;