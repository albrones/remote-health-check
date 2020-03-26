<template>
    <div class="level">
        <div class="level-item sentence">
            <p>
                <strong>{{ symbol }}</strong>
                <br />
                <slot />
            </p>
        </div>

        <div
            class=" level-tiem "
            :class="{ selected: activeDot }"
            @click="action1"
        >
            <Dot :color="colorValue" />
            <!-- TODO: test with emojie instead -->
        </div>

        <div
            class="level-tiem"
            :class="{ selected: activeArrow }"
            @click="action2"
        >
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
    data() {
        return {
            activeDot: false,
            activeArrow: false,
        }
    },
    computed: {
        symbol() {
            return this.type === 'good' ? '+' : this.type === 'bad' ? '-' : '='
        },
        colorValue() {
            return this.type === 'good'
                ? 'green'
                : this.type === 'bad'
                ? 'red'
                : 'orange'
        },
        directionValue() {
            return this.type === 'good'
                ? 'increase'
                : this.type === 'bad'
                ? 'decrease'
                : ''
        },
    },
    methods: {
        action1() {
            this.activeDot = !this.activeDot
        },
        action2() {
            this.activeArrow = !this.activeArrow
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
.selected {
    border: #00d1b2 3px solid;
}
.separation {
    border-left: whitesmoke 2px solid;
}
</style>
