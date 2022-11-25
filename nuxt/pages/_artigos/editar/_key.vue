<template>
  <section class="body">
    <TopBar></TopBar>

    <PrimaryMenu></PrimaryMenu>

    <section class="article-view" :id="`${article.id}`">
      <section class="article-content">
        <form>
          <Editor :conteudo="`${article.conteudo}`"></Editor>

          <button @click="salvar()" id="save">Salvar</button>
          <button @click="deletar()" id="delete">Deletar</button>
        </form>
      </section>
      <section class="article-imagens">
        <ArticleImage :key="i" v-for="i in article.imagens" :url="i"></ArticleImage>
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
@import "~/static/css/geral.css";
@import "~/static/css/layout.css";
@import "~/static/css/menu.css";
@import "~/static/css/elements.css";
@import '~/static/css/input.css';
@import '~/static/css/buttons.css';

@import '~/components/skin-editor/skins/content/CUSTOM/content.css';
@import '~/components/skin-editor/skins/ui/CUSTOM/content.css';
@import '~/components/skin-editor/skins/ui/CUSTOM/content.inline.css';
@import '~/components/skin-editor/skins/ui/CUSTOM/content.inline.min.css';
@import '~/components/skin-editor/skins/ui/CUSTOM/content.min.css';
@import '~/components/skin-editor/skins/ui/CUSTOM/content.mobile.css';
@import '~/components/skin-editor/skins/ui/CUSTOM/content.mobile.min.css';
@import '~/components/skin-editor/skins/ui/CUSTOM/skin.css';
@import '~/components/skin-editor/skins/ui/CUSTOM/skin.min.css';
@import '~/components/skin-editor/skins/ui/CUSTOM/skin.mobile.css';
@import '~/components/skin-editor/skins/ui/CUSTOM/skin.mobile.min.css';
@import '~/static/css/article.css';
@import '~/static/css/article-2.css';

</style>
