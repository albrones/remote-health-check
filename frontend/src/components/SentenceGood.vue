<template>
    <div class="level" @click="action">
        <div class="level-item sentence">
            <p>
                <strong>+</strong>
                <br />
                <slot />
            </p>
        </div>

        <div class="level-item">
            <Dot color="green" />
            <!-- TODO: test with emojie instead -->
        </div>

        <div class="level-item">
            <figure class="image is-64x64">
                <Arrow class="increase" />
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
.sentence {
    width: 15%;
}
</style>
