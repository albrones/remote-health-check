<template>
    <div id="app">
        <router-link class="home-btn" to="/">
            <h1>Remote Heath Check</h1>
        </router-link>
        <router-view />
    </div>
</template>

<style scoped>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
}
.home-btn {
    text-decoration: none;
    color: rgb(16, 124, 124);
}
</style>
