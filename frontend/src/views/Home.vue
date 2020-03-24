<template>
  <div>
    <h2>Home</h2>
    <div class="explainations">
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
        <ul>
          <li>
            -les critères à suivre -la fréquence de partage autour de votre état de santé    
          </li>
          <li>
            -le format de mise à jour (chacun online, ou point visio...) d'ici le ....
          </li>
        </ul>
        <!-- TODO: evolve explainations -->
      </p>
      <p>
        Rules:
        <!-- TODO: add customized Squad Health Check rules -->
      </p>
    </div>
    <Button :action="start">Start</Button>
  </div>
</template>

<script>
import Button from "@/components/Button";

export default {
  components: {
    Button
  },
  methods: {
    start() {
      this.$router.push("/step0");
    }
  }
};
</script>

<style scoped>
.explainations {
  margin: auto;
  width: 66%;
  text-align: center;
}
</style>
