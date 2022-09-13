<template>
  <section class="body">
    <TopBar></TopBar>
    <MobileChange></MobileChange>
    <PrimaryMenu></PrimaryMenu>

    <section class="article-view" :id="`${article.id}`">
      <section class="article-content">
        <form>
          <Editor :conteudo="`${article.conteudo}`"></Editor>

          <button @click="salvar()">Salvar</button>
          <button @click="deletar()">Deletar</button>
        </form>
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
import tinyEditor from "@tinymce/tinymce-vue";
import MobileChange from "~/components/MobileChange.vue";

export default {
  name: "EdicaoArtigo",
  components: {
    editor: tinyEditor,
    MobileChange,
  },
  head() {
    return {
      title: "Editando Artigo",
    };
  },
  async asyncData({ params, $axios }) {
    const article = await $axios.$get("/paginas/id/" + params.key);
    return { article };
  },
  methods: {
    async salvar() {
      var textarea = document.querySelector(
        "div.tox-sidebar-wrap div.tox-edit-area iframe"
      ).contentDocument;
      var mudanca = textarea.querySelector("body").innerHTML;
      const a = await this.$axios.$put(
        "/paginas/atualizar/3/" + this.article.id,
        {
          mudanca,
        }
      );
    },
    async deletar() {
      await this.$axios
        .$delete("/paginas/deletar/" + this.article.id)
        .then(() => {
          this.$router.push("/");
        });
    },
  },
};
</script>

<style>
@import "~/static/css/article.css";
</style>
