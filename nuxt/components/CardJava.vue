<template>
  <div class="card-article">
    <div class="img-article" :style="`background-image: url('${img}');`"></div>

    <article class="card-text">
        <h2 v-html="`${title}`">    </h2>
      <p v-html="`${resumo}`">
      </p>
      <!-- buttom o click -> goToArticle -->
      <router-link
        :to="`/artigos/${id}`"
        style="text-decoration: none; color: inherit"
      >
        <button class="primary icon"></button>
      </router-link>
    </article>
  </div>
</template>
<script>
export default {
  name: "Card",
  props: {
      title: String,
      resumo: String,
      img: String,
      id: Number
  },
  data() {
    return {
      
    };
  },
  methods: {
    
  },

};
</script>

<style scoped>
@import "~/static/css/input.css";
@import "~/static/css/form.css";
@import "~/static/css/geral.css";
@import "~/static/css/layout.css";
@import "~/static/css/menu.css";
@import "~/static/css/elements.css";
@import "~/static/css/style.css";
</style>
