<template>
  <section class="body">
    <TopBar></TopBar>
    <router-link :to="`/artigos/editar/${article.id}`"> </router-link>

    <PrimaryMenu></PrimaryMenu>

    <section class="article-view" :id="`${article.id}`">
      <section class="article-content">
        <router-link :to="`/artigos/editar/${article.id}`">
          <ButtonEdit></ButtonEdit>
        </router-link>
        <h2 v-html="`${article.titulo}`"></h2>
        <p v-html="`${article.conteudo}`"></p>
        <br />
        <p
          v-html="
            `Publicado por <b>${article.autor}</b> em <b>${article.dataPublicacao}</b>`
          "
        ></p>
      </section>
      <section class="article-imagens">
        <ArticleImage
          :key="i"
          v-for="i in article.imagensURL"
          :url="i"
        ></ArticleImage>
      </section>
    </section>
  </section>
</template>

<script>
import MobileEdit from "~/components/MobileEdit.vue";
import MobileNav from "~/components/MobileNav.vue";
export default {
  name: "artigo",
  head() {
    return {
      title: "Artigo - " + this.article.titulo,
    };
  },
  components: {
    MobileEdit,
    MobileNav,
  },
  asyncData({ params }) {
    return {
      ID: params.id,
      article: {},
    };
  },
  methods: {},

  async mounted() {
    const response = await this.$axios.get("/paginas/id/" + this.ID);
    this.article = response.data;

    this.article.dataPublicacao = String(this.article.dataPublicacao).split(
      "T"
    )[0];
  },
};
</script>

<style>
@import "~/static/css/geral.css";
@import "~/static/css/layout.css";
@import "~/static/css/menu.css";
@import "~/static/css/elements.css";
@import "~/static/css/input.css";
@import "~/static/css/article.css";
</style>