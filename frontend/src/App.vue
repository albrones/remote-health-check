<template>
    <div id="app">
        <section class="section">
            <div class="container">
                <router-link class="home-btn" to="/">
                    <h1 class="title">Remote Heath Check</h1>
                </router-link>
                <router-view />
            </div>
        </section>
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
