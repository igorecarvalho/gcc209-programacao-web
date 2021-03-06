import Vue from 'vue'
import VueRouter from 'vue-router'
import ListarContatos from '../views/Contatos/Listar.vue'
import CasdastrarContato from '../views/Contatos/Cadastrar.vue'
import EditarContato from '../views/Contatos/Editar.vue'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Bem Vindo',
        component: Home
    },
    {
        path: '/cadastrar-contato',
        name: 'Cadastro de Contato',
        component: CasdastrarContato
    },
    {
        path: '/listar-contatos',
        name: 'Listagem de contatos',
        component: ListarContatos
    },
    {
        path: '/contato/editar/:id',
        name: 'Editar Contato',
        component: EditarContato
    },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
