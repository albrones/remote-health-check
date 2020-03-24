<template>
    <div class="level" @click="action">
        <div class="level-item sentence">
            <p>
                <strong>{{ symbol }}</strong>
                <br />
                <slot />
            </p>
        </div>

        <div class="level-item">
            <Dot :color="colorValue" />
            <!-- TODO: test with emojie instead -->
        </div>

        <div class="level-item">
            <figure class="image is-64x64">
                <Arrow :class="directionValue" />
            </figure>
        </div>
    </div>
</template>

<script>
import Dot from '@/components/Dot'
import Arrow from '@/components/Arrow'

export default {
    components: {
        Dot,
        Arrow,
    },
    props: {
        type: {
            type: String,
            required: true,
        },
    },
    computed: {
        symbol() {
            return type === 'good' ? '+' : type === 'bad' ? '-' : '='
        },
        colorValue() {
            return type === 'good' ? 'green' : type === 'bad' ? 'red' : 'orange'
        },
        directionValue() {
            return type === 'good'
                ? 'increase'
                : type === 'bad'
                ? 'decrease'
                : ''
        },
    },
    methods: {
        action() {
            alert('action')
        },
    },
}
</script>

<style>
.increase {
    transform: rotate(-45deg);
}
.decrease {
    transform: rotate(45deg);
}
.sentence {
    width: 15%;
}
</style>
