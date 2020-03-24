<template>
    <span class="circle" :style="{ 'background-color': color }"></span>
</template>

<script>
export default {
    props: {
        color: {
            type: String,
            required: true,
        },
    },
}
</script>

<style scoped>
.circle {
    display: block;
    height: 70px;
    width: 70px;
    border-radius: 50%;
    margin: 25px;
}
</style>
