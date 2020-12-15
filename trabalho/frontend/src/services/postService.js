import {ApiService} from './api.service'


const postService =  {

    listar: async() => {
        return ApiService.get('post/listarTodos');
    },

    getPost: async(id) => {
        return ApiService.get(`post/get/${id}`);
    },

    listarPorUser: async(idUsuario) => {
        return ApiService.get(`post/${idUsuario}/listar`);
    },

    cadastrar: async(post) => {
        return ApiService.post(`post/cadastrar`, post);
    },

    editar: async(post, id) => {
        return ApiService.put(`post/${id}/editar`, post);
    },

    deletar: async(id) => {
        return ApiService.delete(`post/${id}/deletar`);
    },

}

export default postService;