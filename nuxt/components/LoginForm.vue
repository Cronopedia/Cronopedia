<template>
  <form action="" class="login-form" @submit.prevent="efetuarLogin">
    <h2>Log in</h2>

    <label for="email" id="email-label" class="label-login">
      <h4>Email</h4>
    </label>
    <input
      type="text"
      name="email"
      id="email"
      class="input-style-1"
      placeholder="email@example.com"
      v-model="login.username"
    />
    <small class="mensagem-erro email">E-email inválido</small>

    <label for="password" id="password-label" class="label-login">
      <h4>Senha</h4>
    </label>
    <input
      type="password"
      name="password"
      id="password"
      class="input-style-1"
      placeholder="Insira sua senha"
      v-model="login.password"
    />
    <small class="mensagem-erro senha">Senha inválida</small>

    <button type="submit" class="primary"></button>
  </form>
</template>

<script>
export default {
  name: "LoginForm",

  data() {
    return {
      login: {
        username: "",
        password: "",
      },
    };
  },

  methods: {
    menuBTn() {
      const btn = document.querySelector("button.menu-button");
      btn.classList.contains("clicado")
        ? btn.classList.remove("clicado")
        : btn.classList.add("clicado");
    },

    GerarID: function () {
      return parseInt(Math.random() * 100000000);
    },

    async setAuthToken(data) {
      const authHeader = "Bearer " + data.token;

      this.$auth.setUserToken(authHeader, null);
      this.$axios.setHeader("Authorization", authHeader);

      const response = await this.$auth.get("/user/me");
      this.$auth.setUser(response.data);
    },

    async efetuarLogin() {
      event.preventDefault();
      try {
        let response = await this.$auth.loginWith("local", {
          data: {
            username: this.login.username,
            password: this.login.password,
          },
        });

        console.log(response);

        if (this.$auth.loggedIn) {
          console.log("Sucesso");
          console.log(this.$auth.strategy.token);
          console.log(this.$auth.strategy);
          this.$router.push("/");
        }
      } catch (error) {
        console.log(error);

        alert("deu algo errado aí");
      }
    },

    // validar() {
    //   event.preventDefault();
    //   this.validarEmail();
    //   this.validarSenha();

    //   if (this.validarSenha() == false || this.validarEmail() == false) {
    //     return false;
    //   } else {
    //     alert("Sucesso");
    //     return true;
    //   }
    // },
    // validarEmail() {
    //   const email = document.querySelector("input#email");
    //   const msg = document.querySelector("small.email");

    //   if (email.value != "admin") {
    //     email.classList.add("erro");
    //     msg.classList.add("vis");
    //     return false;
    //   } else {
    //     email.classList.remove("erro");
    //     msg.classList.remove("vis");
    //     return true;
    //   }
    // },

    // validarSenha() {
    //   const senha = document.querySelector("input#password");
    //   const msg = document.querySelector("small.senha");

    //   if (senha.value != "admin") {
    //     senha.classList.add("erro");
    //     msg.classList.add("vis");
    //     return false;
    //   } else {
    //     senha.classList.remove("erro");
    //     msg.classList.remove("vis");
    //     return true;
    //   }
    // },
  },
};
</script>

<style scoped>
@import "~/static/css/input.css";
@import "~/static/css/geral.css";
@import "~/static/css/layout.css";
@import "~/static/css/menu.css";
@import "~/static/css/elements.css";
@import "~/static/css/style.css";
@import "~/static/css/buttons.css";
@import "~/static/css/top.css";
@import "~/static/css/form.css";
</style>