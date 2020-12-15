import Vue from 'vue'
import VueRouter from 'vue-router'
import CadastrarUsuario from '../views/Usuarios/Cadastrar.vue'
import Postagens from '../views/Usuarios/Postagens.vue'
import Login from '../views/Login.vue'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Login',
        component: Login
    },
    {
        path: '/home/:id',
        name: 'Pagina Inicial',
        component: Home
    },
    {
        path: '/minhas-postagens/:id',
        name: 'Minhas Postagens',
        component: Postagens
    },
    {
        path: '/cadastrar-usuario',
        name: 'Cadastro de usuario',
        component: CadastrarUsuario
    },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
