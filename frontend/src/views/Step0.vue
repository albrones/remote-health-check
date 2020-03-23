<template>
    <div>
        <h2 class="title is-2">Step 0</h2>
        <h3 class="subtitle is-5">Enter your name please.</h3>

        <div class="field">
            <div class="control">
                <input
                    class="input is-primary"
                    type="text"
                    placeholder="Name"
                    v-model="name"
                />
            </div>
        </div>
        <Button :action="next" :isDisabled="hasntName">Next</Button>
    </div>
</template>

<script>
import Button from '@/components/Button'

export default {
    components: {
        Button,
    },
    data: function() {
        return {
            name: '',
            // hasName: true,
        }
    },
    methods: {
        next: function() {
            //TODO : getName from input and save in store
            this.$store.commit('setUserName', this.name)
            this.$router.push('/')
        },
    },
    computed: {
        hasntName: function() {
            return this.name === ''
        },
    },
}
</script>

<style>
/* TODO: Design input in component */
</style>
