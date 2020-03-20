<template>
  <div class="about">
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
import Button from "@/components/Button";

export default {
  components: {
    Button
  },
  methods: {
    next: function() {
      this.$router.push("/");
    }
  }
};
</script>

<style></style>
