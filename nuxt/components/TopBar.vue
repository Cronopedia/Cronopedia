
<template>
  <nav class="top-bar">
    <div class="menu">
      <button
        class="menu-button"
        v-on:click="
          menuView();
          menuBTn();
        "
      ></button>
    </div>
    <div class="logo">
      <router-link to="/" style="text-decoration: none; color: inherit">
        <h1>cronopédia.</h1>
      </router-link>
    </div>
    <div class="perfil">
      <section class="search">
        <input
          type="search"
          name="search-bar"
          id="search-bar-top"
          placeholder="Pesquise algo..."
          v-model="search"
          autocomplete="off"
        />
        <label for="search-bar" class="label-search"></label>
        <section class="search-results-dropdown" data-visible="false">
          <router-link
            :key="resultado"
            v-for="resultado in resultados"
            :to="`/artigos/${resultado.id}`"
            style="text-decoration: none; color: inherit"
          >
            <div class="article-link">
              <p class="link-title">{{ resultado.titulo }}</p>
              <p class="link-description">{{ resultado.resumo }}</p>
              <p class="link-topic">Tópicos: {{ resultado.assuntos }}</p>
            </div>
          </router-link>
        </section>
      </section>
      <button class="buttons btn-perfil">
        <i class="bx bxs-user-circle bx-sm"></i>
      </button>
    </div>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      search: "",
      resultados: [],
    };
  },
  watch: {
    search(value) {
      this.doSearch(value);
    },
  },
  methods: {
    menuBTn() {
      const btn = document.querySelector("button.menu-button");
      btn.classList.contains("clicado")
        ? btn.classList.remove("clicado")
        : btn.classList.add("clicado");
    },

    menuView() {
      const primaryNav = document.querySelector("ul.primary-menu");
      var visi = primaryNav.getAttribute("data-visible");
      visi == "false"
        ? primaryNav.setAttribute("data-visible", "true")
        : primaryNav.setAttribute("data-visible", "false");
    },
    doSearch(value) {
      // Verificar se tem um texto válido (pro REGEX não bugar e entrgar todas as páginas que existem)
      if (String(value).trim() != "") {
        this.$axios
          .get("/paginas/" + this.search)
          .then((response) => {
            this.resultados = response.data;
          })
          .catch((e) => console.log(e));
      } else {
        // ocultar os resultados quando a barra de pesquisa estiver vazia
        this.resultados = [];
      }
    },
  },
};
</script>

<style scoped>
@import "~/static/css/form.css";
@import "~/static/css/geral.css";
@import "~/static/css/layout.css";
@import "~/static/css/menu.css";
@import "~/static/css/elements.css";
@import "~/static/css/top.css";
@import "~/static/css/input.css";
</style>
  
<style>

</style>
