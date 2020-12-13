import Vue from 'vue'
import VueRouter from 'vue-router'
import Inicio from '../view/Animal/Inicio.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Inicio',
        component: Inicio
    }
]

const router = new VueRouter({
    mode: 'history',
    base: process.env.BABEL_URL,
    routes
})

export default router