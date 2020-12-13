import { ApiService } from './api.service'

const animalService = {

    listar: async() => {
        return ApiService.get('animal/listar');
    },

    cadastrar: async(animal) => {
        return ApiService.post('animal/cadastrar', animal);
    }
}

export default animalService;