<template>
    <div>
        <h1>Step 0</h1>
        <h3>Enter your name please.</h3>
        <div>
            <label for="name"></label>
            <input id="name" type="text" />
        </div>
        <Button :action="next">Next</Button>
    </div>
</template>

<script>
import Button from '@/components/Button'

export default {
    components: {
        Button,
    },
    methods: {
        next: function() {
            //TODO : getName from input and save in store
            this.$router.push('/')
        },
    },
}
</script>

<style>
/* TODO: Design input in component */
</style>
