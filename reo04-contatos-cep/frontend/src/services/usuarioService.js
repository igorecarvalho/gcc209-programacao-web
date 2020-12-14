import {ApiService} from './api.service'


const usuarioService =  {

    listar: async() => {
        return ApiService.get('usuario/listarTodos');
    },

    getUsuario: async(idUsuario) => {
        return ApiService.get(`usuario/${idUsuario}/listar`);
    },

    cadastrar: async(usuario) => {
        return ApiService.post(`usuario/cadastrar`, usuario);
    },

    editar: async(usuario, idUsuario) => {
        return ApiService.put(`usuario/${idUsuario}/editar`, usuario);
    },

    deletar: async(idUsuario) => {
        return ApiService.delete(`usuario/${idUsuario}/deletar`);
    },

}

export default usuarioService;