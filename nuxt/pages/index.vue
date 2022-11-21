

<template>
  <!--
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Playfair+Display:wght@600;700&family=Spectral:ital,wght@0,400;0,600;0,700;1,300;1,400&display=swap" rel="stylesheet">
  -->

  <section class="body">
    <TopBar></TopBar>
    <MobileNav></MobileNav>
    <PrimaryMenu></PrimaryMenu>
    <section class="geral">
      <section class="home">
        <section class="init">
          <h1>Explore novos temas.</h1>
          <p>Centenas de artigos te esperam</p>
          <form action="">
            <input
              type="search"
              name="search"
              id="search"
              placeholder="Descubra algo novo..."
              autocomplete="off"
            />
            <button type="submit" id="search-submit"> Pesquisar </button>
          </form>
        </section>

        <div class="img"></div>
      </section>

      <section class="articles">
        <section class="article day">
          <h2>Artigo do Dia</h2>
          <!-- <CardJava
            v-bind:title="`${response[random].titulo}`"
            v-bind:resumo="`${response[random].resumo}`"
            v-bind:img="`${response[random].imagens}`"
            :id="response[random].id"
          ></CardJava> -->
        </section>

        <section class="article day">
          <h2>Explorar Artigos</h2>
        </section>
        <section :key="card" v-for="card in response">  
          <CardJava
            v-bind:title="`${card.titulo}`"
            v-bind:resumo="`${card.resumo}`"
            v-bind:img="`${card.imagens}`"
            :id="card.id"
          ></CardJava>
        </section>
      </section>
    </section>
  </section>
</template>


<style>
@import "~/static/css/geral.css";
@import "~/static/css/layout.css";
@import "~/static/css/menu.css";
@import "~/static/css/elements.css";
@import '~/static/css/input.css'
</style>

<script>
export default {
  name: "IndexPage",
  data(){
    return{
      
    };
  },
  head() {
    return {
      title: "Explore novos temas.",
    };
  },

  methods: {
  },

  async asyncData({ $axios }) {
    const response = await $axios.$get("/paginas");
    const random = await $axios.$get("/paginas/daily");
    return { response, random };
  },

  components: { TopBar, MobileNav, PrimaryMenu, CardJava },
};

import TopBar from "~/components/TopBar.vue";
import MobileNav from "~/components/MobileNav.vue";
import PrimaryMenu from "~/components/PrimaryMenu.vue";
import CardJava from "../components/CardJava.vue";
</script>

