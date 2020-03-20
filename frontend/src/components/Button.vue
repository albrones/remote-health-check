<template>
  <button class="button" @click="action"><slot /></button>
</template>

<script>
export default {
  props: {
    action: {
      type: Function,
      required: true
    }
  }
};
</script>

<style scoped>
.button {
  width: 100px;
  /* font-size: 16px; */
}
</style>
