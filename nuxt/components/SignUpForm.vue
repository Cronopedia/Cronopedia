<template>
  <form action="" class="login-form sign" @submit.prevent="">
    <h2>Sign Up</h2>
    <label for="nome" id="name-label" class="label-login">
      <h4>Nome</h4>
    </label>
    <input
      type="text"
      name="nome"
      id="nome"
      class="input-style-1"
      placeholder="Nome"
      v-on:input="validaNome()"
      v-model="user.nome"
    />
    <small class="mensagem-erro nome"> Nome vazio </small>

    <label for="email" id="email-label" class="label-login">
      <h4>Email</h4>
    </label>
    <input
      type="email"
      name="email"
      id="email"
      class="input-style-1"
      placeholder="exemplo@gmail.com"
      v-on:input="validaEmail()"
      v-model="user.email"
    />
    <small class="mensagem-erro email"> Email vazio </small>

    <label for="senha" id="password-label" class="label-login">
      <h4>Senha</h4>
    </label>
    <input
      type="password"
      name="senha"
      id="senha"
      class="input-style-1"
      placeholder="Insira sua senha"
      v-on:input="validaSenha()"
      v-model="user.senha"
    />
    <small class="mensagem-erro senha"> Senha vazia </small>

    <label for="nickname" id="nickname-label" class="label-login">
      <h4>Nickname</h4>
    </label>
    <input
      type="text"
      name="nickname"
      id="nickname"
      class="input-style-1"
      placeholder="Nome de usuário"
      v-on:input="validaNick()"
      v-model="user.nickname"
    />
    <small class="mensagem-erro nickname"> Nickname vazio </small>

    <label for="data" id="data-label" class="label-login">
      <h4>Data de Nascimento</h4>
    </label>
    <input
      type="date"
      name="data"
      id="data"
      class="input-style-1"
      placeholder="Data"
      v-on:input="validaData()"
      v-model="user.dataNascimento"
    />
    <small class="mensagem-erro data"> Data vazia </small>

    <button
      type="submit"
      class="primary sign-up"
      v-on:click="validar()"
    ></button>
  </form>
</template>

<script>
export default {
  auth: false,

  name: "SignUp",
  data() {
    return {
      user: {
        nickname: "",
        nome: "",
        senha: "",
        email: "",
        dataNascimento: "",
      },
    };
  },
  methods: {
    validar() {
      event.preventDefault();
      this.validaNome();
      this.validaEmail();
      this.validaSenha();
      this.validaNick();
      var par1 = false;
      var par2 = false;

      this.validaNome() && this.validaEmail() ? (par1 = true) : (par1 = false);
      this.validaSenha() && this.validaNick() ? (par2 = true) : (par2 = false);

      par1 && par2 ? this.send() : alert("Algum dos campos está vazio!");
    },

    validaNome() {
      const inpt = document.querySelector("input#" + "nome");
      const msg = document.querySelector("small." + "nome");
      if (inpt.value == "") {
        inpt.classList.add("erro");
        msg.classList.add("vis");
        return false;
      } else {
        inpt.classList.remove("erro");
        msg.classList.remove("vis");

        return true;
      }
    },
    validaEmail() {
      const inpt = document.querySelector("input#email");
      const msg = document.querySelector("small.email");
      if (inpt.value == "") {
        inpt.classList.add("erro");
        msg.classList.add("vis");
        return false;
      } else {
        inpt.classList.remove("erro");
        msg.classList.remove("vis");

        return true;
      }
    },
    validaSenha() {
      const inpt = document.querySelector("input#" + "senha");
      const msg = document.querySelector("small." + "senha");
      if (inpt.value == "") {
        inpt.classList.add("erro");
        msg.classList.add("vis");
        return false;
      } else {
        inpt.classList.remove("erro");
        msg.classList.remove("vis");

        return true;
      }
    },
    validaNick() {
      const inpt = document.querySelector("input#" + "nickname");
      const msg = document.querySelector("small." + "nickname");
      if (inpt.value == "") {
        inpt.classList.add("erro");
        msg.classList.add("vis");
        return false;
      } else {
        inpt.classList.remove("erro");
        msg.classList.remove("vis");

        return true;
      }
    },

    validaData() {
      var valido = true;
      return valido;
    },

    send() {
      const x = this.$axios
        .$post("/user", this.user)
        .then(this.$router.push("/login"));
    },
  },
};
</script>

<style>
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