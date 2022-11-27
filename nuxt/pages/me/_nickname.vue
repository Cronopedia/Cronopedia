<template>
  <section class="profile">
    <TopBar></TopBar>
    <PrimaryMenu></PrimaryMenu>

    <header class="header">
      <div class="details">
        <img
          :src="`${usuario.profileURL}`"
          :alt="`${usuario.nickname}`"
          class="profile-pic"
        />
        <h1 class="heading">{{ usuario.nome }}</h1>
        <p class="nickname">{{ usuario.nickname }}</p>
        <div class="location">
          <svg width="18" height="18" viewBox="0 0 24 24" fill="currentColor">
            <path
              d="M12,11.5A2.5,2.5 0 0,1 9.5,9A2.5,2.5 0 0,1 12,6.5A2.5,2.5 0 0,1 14.5,9A2.5,2.5 0 0,1 12,11.5M12,2A7,7 0 0,0 5,9C5,14.25 12,22 12,22C12,22 19,14.25 19,9A7,7 0 0,0 12 ,2Z"
            ></path>
          </svg>
          <p>São Paulo - Brasil</p>
        </div>
        <div class="stats">
          <div class="col-4">
            <h4>{{ usuario.paginas.length }}</h4>
            <p>Páginas</p>
          </div>
          <div class="col-4">
            <h4>10</h4>
            <p>estatistica bolada</p>
          </div>
          <div class="col-4">
            <h4>100</h4>
            <p>Outra estatistica bolada</p>
          </div>
        </div>
      </div>
    </header>
  </section>
</template>

<script>
export default {
  name: "profile",

  components: { TopBar, MobileNav, PrimaryMenu },

  head() {
    return {
      title: "Cronopédia - @" + this.usuario.nickname,
    };
  },

  async asyncData({ $axios, $auth }) {
    $axios.setHeader("Authorization", $auth.strategy.token);
    const usuario = await $axios.$get("/user/me");
    return { usuario };
  },
};

import TopBar from "~/components/TopBar.vue";
import MobileNav from "~/components/MobileNav.vue";
import PrimaryMenu from "~/components/PrimaryMenu.vue";
</script>

<style scoped>
@import "~/static/css/profile.css";
@import "~/static/css/buttons.css";
@import "~/static/css/form.css";
@import "~/static/css/geral.css";
@import "~/static/css/layout.css";
@import "~/static/css/menu.css";
@import "~/static/css/elements.css";
@import "~/static/css/top.css";
@import "~/static/css/input.css";
</style>

<!-- this.$auth.hasScope('admin') -->