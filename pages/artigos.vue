<template>
    <section class="body">
        <TopBar></TopBar>
        <section class="geral">
            <h2>Explore novos Artigos</h2>
            <section class="articles">
                <section :key="card" v-for="card in response">
                    <CardJava v-bind:title="`${card.titulo}`" v-bind:resumo="`${card.resumo}`"
                        v-bind:img="`${card.imagens}`" :id="card.id"></CardJava>
                </section>
            </section>
        </section>
    </section>
</template>

<script>
export default {
    async asyncData({ $axios }) {
        const response = await $axios.$get("/paginas");
        return { response };
    },

    components: { TopBar, MobileNav, PrimaryMenu, CardJava },
};

import TopBar from "~/components/TopBar.vue";
import MobileNav from "~/components/MobileNav.vue";
import PrimaryMenu from "~/components/PrimaryMenu.vue";
import CardJava from "../components/CardJava.vue";
</script>

<style scoped>
section.body {
    background-color: #f3f3f3;
}

section.geral{
    padding-top: 5em;
}

h2{
    margin-left: 2.8em;
}

section.articles {
    padding: 1.5em;
    display: flex;
    align-items: center;
    flex-direction: row;
    /* grid-gap: 2.5em; */
    gap: 2.5em;
    background-color: #F3F3F3;
    background-color: var(--grey);
    flex-wrap: wrap;
    justify-content: center;
}
</style>