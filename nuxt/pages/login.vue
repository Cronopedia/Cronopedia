<template>
  <section class="body">
    <TopBar></TopBar>
    <PrimaryMenu></PrimaryMenu>

    <section class="geral">
      <section class="img-form">
        <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d9/Crucifixion_of_Saint_Peter-Caravaggio_%28c.1600%29.jpg/800px-Crucifixion_of_Saint_Peter-Caravaggio_%28c.1600%29.jpg" alt="" srcset="">
      </section>
      <LoginForm></LoginForm>
    </section>
  </section>
</template>


<script>
export default {
  name: "LoginPage",

  components: { TopBar, MobileNav, PrimaryMenu, LoginForm },
  head() {
    return {
      title: "Login",
    };
  },
};

import TopBar from "~/components/TopBar.vue";
import MobileNav from "~/components/MobileNav.vue";
import PrimaryMenu from "~/components/PrimaryMenu.vue";
import LoginForm from "~/components/LoginForm.vue";
</script>

<style>
@import "~/static/css/input.css";

@import "~/static/css/geral.css";
@import "~/static/css/layout.css";
@import "~/static/css/menu.css";
@import "~/static/css/elements.css";
@import "~/static/css/top.css";
@import "~/static/css/buttons.css";
@import "~/static/css/form.css";
</style>