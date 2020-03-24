import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Step0 from '../views/Step0.vue'
import Step1 from '../views/Step1.vue'

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
    {
        path: '/step1',
        name: 'Step1',
        component: Step1,
    },
]

const router = new VueRouter({
    routes,
})

export default router
