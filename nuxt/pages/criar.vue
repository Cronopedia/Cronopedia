<template>
  <section class="body">
    <TopBar></TopBar>
    <PrimaryMenu></PrimaryMenu>

    <section class="article-creation">
      <section class="article-content">
        <div class="container">
          <input
            placeholder="Titulo"
            name="titulo"
            id="titulo"
            maxlength="36"
          />
          <Editor></Editor>

          <button @click="salvar()" id="save">Salvar</button>
        </div>
      </section>
      <section class="article-imagens">
        <button class="newIMG">
          <i class="bx bx-image-add"></i>
        </button>
      </section>
    </section>
  </section>
</template>

<script>
export default {
  name: "Criação",
  methods: {
    async salvar() {
      var textarea = document.querySelector(
        "div.tox-sidebar-wrap div.tox-edit-area iframe"
      ).contentDocument;
      var conteudo = textarea.querySelector("body p").innerText;
      var titulo = document.querySelector("div #titulo").value;

      const a = await this.$axios
        .$post("/paginas/add/", {
          titulo: titulo,
          autor: "Desconhecido",
          resumo: "Testando a aplicação!",
          conteudo: conteudo,
          assuntos: [titulo],
          url: "http://jncseguranca.com.br/wp-content/uploads/2016/07/img-teste-300x300.jpg",
        })
        .then(() => {
          alert("Criado!");
        });
    },
  },
};
</script>

<style>
@import "~/static/css/geral.css";
@import "~/static/css/layout.css";
@import "~/static/css/menu.css";
@import "~/static/css/buttons.css";
@import "~/static/css/elements.css";
@import '~/static/css/input.css';

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
@import '~/static/css/article-2.css';
@import "~/static/css/article.css";
</style>