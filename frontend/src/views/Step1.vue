<template>
    <Step :index="1" title="Relation entre Z" :sentences="sentences" />
</template>

<script>
import Step from '@/components/Step'

export default {
    components: {
        Step,
    },
    data() {
        return {
            sentences: {
                good: `J'attends les prochains moments avec impatience ! 🤣`,
                medium: `Toujours au top les collègues 😉`,
                bad: `Ca va un peu moins bien en ce moment ... 😞`,
            },
        }
    },
}
</script>

<style scoped></style>
