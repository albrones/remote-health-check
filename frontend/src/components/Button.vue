<template>
    <div class="buttons">
        <button
            class="button is-primary is-medium is-fullwidth"
            @click="action"
            :disabled="!enabled"
        >
            <slot />
        </button>
    </div>
</template>

<script>
export default {
    props: {
        action: {
            type: Function,
            required: true,
        },
        isDisabled: {
            type: Boolean,
            required: false,
            default: false,
        },
    },
    computed: {
        enabled() {
            return !this.isDisabled
        },
    },
}
</script>

<style scoped></style>
