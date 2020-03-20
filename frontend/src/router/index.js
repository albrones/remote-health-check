import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Step0 from '../views/Step0.vue'

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: Home,
    },
    {
        path: '/step0',
        name: 'Step0',
        component: Step0,
    },
    //TODO: add steps
]

const router = new VueRouter({
    routes,
})

export default router
