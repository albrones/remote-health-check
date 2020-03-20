<template>
  <div id="home">
    <h2>Home</h2>
    <div class="explanations">
      <p>
        En cette période un peu spéciale, nous découvrons le télétravail à la
        maison, je vous propose de mettre en place un outil du style squad
        health check (mettre le lien exemple) pour suivre le bon fonctionnement
        de ce mode de travail, tout au long de cette période et de pouvoir
        mettre en place des actions collectives pour améliorer votre quotidien
        et en tirer des enseignements lors d’un retour à la normale.
      </p>
      <p>
        Votre première mission, si vous l'acceptez, sera de me transmettre :
        -les critères à suivre -la fréquence de partage autour de votre état de
        santé -le format de mise à jour (chacun online, ou point visio...) d'ici
        le ....
      </p>
      <p>Rules:</p>
    </div>
    <button class="starter" @click="start">Start</button>
  </div>
</template>

<script>
export default {
  methods: {
    start: function() {
      this.$router.push("/step0");
    }
  }
};
</script>

<style scoped>
#home {
  display: flex;
  justify-content: center;
  flex-direction: column;
  align-items: center;
}
.explanations {
  margin: auto;
  width: 66%;
  text-align: center;
}
.starter {
  width: 100px;
  /* font-size: 16px; */
}
</style>
