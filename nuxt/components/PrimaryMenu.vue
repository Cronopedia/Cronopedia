<template>
  <ul class="primary-menu" id="primary-nav" data-visible="false">
    <li><a href="/"> Home</a></li>
    <li><a href="/artigos"> Artigos</a></li>
    <li><a href="/criar"> Criar</a></li>
    <li><a :href="`/artigo/${randArtigo}`"> Surpreenda-me!</a></li>
    <li v-if="!this.$auth.loggedIn" id="login"><a href="/login"> Log in</a></li>
    <button
      v-if="this.$auth.loggedIn"
      v-on:click="logout()"
      class="primary"
      id="logout"
    ></button>
  </ul>
</template>

<script>
export default {
  auth: false,
  name: "PrimaryMenu",
  data() {
    return {
      randArtigo: Math.floor(Math.random() * 6),
    };
  },

  methods: {
    async logout() {
      const logout = await this.$auth.logout();
    },
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
@import "~/static/css/top.css";
@import "~/static/css/style.css";
</style>