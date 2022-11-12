<template>
  <section class="body">
    <TopBar></TopBar>
    <router-link :to="`/artigos/editar/${article.id}`">
      <MobileEdit></MobileEdit>
    </router-link>

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
            `Publicado por <b>${article.autor}</b> em <b>${article.data}</b>`
          "
        ></p>
      </section>
      <section class="article-imagens">
        <ArticleImage
          :key="i"
          v-for="i in article.imagens"
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
  },
};
</script>

<style>
@import "~/static/css/article.css";
</style>