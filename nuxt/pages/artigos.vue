<template>
    <section class="body">
        <TopBar></TopBar>
        <section class="geral geral-article">
            <h2>Explore novos Artigos</h2>
            <section class="articles">
                <section class="article">
                    <section :key="card" v-for="card in response">
                        <CardJava v-bind:title="`${card.titulo}`" v-bind:resumo="`${card.resumo}`"
                            v-bind:img="`${card.imagens}`" :id="card.id"></CardJava>
                    </section>
                </section>
            </section>
        </section>
    </section>
</template>
<style>
    @import "~/static/css/geral.css";
    @import "~/static/css/layout.css";
    @import "~/static/css/menu.css";
    @import "~/static/css/elements.css";
    @import '~/static/css/input.css';
    @import '~/static/css/article.css';
</style>

<script>

export default {
    auth: false,

    async asyncData({ $axios }) {
        const response = await $axios.$get("/paginas");
        return { response };
    },

    components: { TopBar, MobileNav, PrimaryMenu, CardJava, MobileEdit },
};

import TopBar from "~/components/TopBar.vue";
import MobileNav from "~/components/MobileNav.vue";
import PrimaryMenu from "~/components/PrimaryMenu.vue";
import CardJava from "../components/CardJava.vue";
import MobileEdit from "~/components/MobileEdit.vue";
</script>

