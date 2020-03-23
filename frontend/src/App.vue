<template>
    <div id="app">
        <section class="section">
            <div class="container">
                <h1 class="title is-1">
                    <router-link class="home-btn" to="/">
                        Remote Heath Check
                    </router-link>
                </h1>
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
