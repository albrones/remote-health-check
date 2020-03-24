<template>
    <div>
        <h2 class="title is-2">Step {{ index }}</h2>
        <h3 class="subtitle is-5">
            Check this criteria:
            <br />
            <strong>{{ title }}</strong>
        </h3>

        <div class="box">
            <div class="content">
                <Sentence type="good">{{ sentences.good }}</Sentence>
                <Sentence type="medium">{{ sentences.medium }}</Sentence>
                <Sentence type="bad">{{ sentences.bad }}</Sentence>
            </div>
        </div>
        <Button :action="next" :isDisabled="isChecked">Next</Button>
    </div>
</template>

<script>
import Button from '@/components/Button'
import Sentence from '@/components/Sentence'

export default {
    components: {
        Button,
        Sentence,
    },
    props: {
        index: {
            type: Number,
            required: true,
        },
        title: {
            type: String,
            required: true,
        },
        sentences: {
            type: Object,
            required: true,
            default: () => ({ good: '', medium: '', bad: '' }),
        },
    },
    methods: {
        next() {
            // TODO: check if level & evolution checked
            // TODO: store data from step
            // this.$store.commit('setStep', this.index, this.values)
            this.$router.push(`/${this.index}`)
        },
    },
    computed: {
        isChecked() {
            return false // TODO: check if level & evolution checked
        },
    },
}
</script>

<style scoped></style>
