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
                <div class="level">
                    <div class="level-item sentence">
                        <p>
                            <strong>-</strong>
                            <br />
                            {{ sentences.bad }}
                        </p>
                    </div>

                    <div class="level-item">
                        <Dot color="red" />
                    </div>

                    <div class="level-item">
                        <figure class="image is-64x64">
                            <Arrow class="increase" />
                        </figure>
                    </div>
                </div>
                <div class="level">
                    <div class="level-item sentence">
                        <p>
                            <strong>=</strong>
                            <br />
                            {{ sentences.medium }}
                        </p>
                    </div>

                    <div class="level-item">
                        <Dot color="orange" />
                    </div>
                    <div class="level-item">
                        <figure class="image is-64x64">
                            <Arrow />
                        </figure>
                    </div>
                </div>
                <div class="level">
                    <div class="level-item sentence">
                        <p>
                            <strong>+</strong>
                            <br />
                            {{ sentences.good }}
                        </p>
                    </div>

                    <div class="level-item">
                        <Dot color="green" />
                    </div>
                    <div class="level-item">
                        <figure class="image is-64x64">
                            <Arrow class="decrease" />
                        </figure>
                    </div>
                </div>
            </div>
        </div>

        <Button :action="next" :isDisabled="isChecked">Next</Button>
    </div>
</template>

<script>
import Button from '@/components/Button'
import Dot from '@/components/Dot'
import Arrow from '@/components/Arrow'

export default {
    components: {
        Button,
        Dot,
        Arrow,
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

<style scoped>
.increase {
    transform: rotate(-45deg);
}
.decrease {
    transform: rotate(45deg);
}
.centered {
    display: flex;
    flex-direction: column;
    justify-content: center;
}
.sentence {
    width: 15%;
}
/* .border {
    border: 2px solid #f5f5f5;
} */
</style>
