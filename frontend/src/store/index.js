import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
    state: {
        userName: '',
    },
    mutations: {
        setUserName: (state, name) => (state.name = name),
        resetUserName: state => (state.name = ''),
    },
    actions: {},
    modules: {},
})

// TODO: Add stepState, stepsValues
