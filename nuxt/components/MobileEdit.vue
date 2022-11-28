<template>
  <section class="mobile-nav">
    <router-link :to="`/artigos/editar/${article.id}`">
          <ButtonEdit></ButtonEdit>
    </router-link>

  </section>
</template>

<script>
export default {
  name: "MobileEdit",
};
</script>

<style scoped>
@import "~/static/css/input.css";
@import "~/static/css/form.css";
@import "~/static/css/geral.css";
@import "~/static/css/layout.css";
@import "~/static/css/menu.css";
@import "~/static/css/elements.css";
</style>