<template>
    <section class="body">
        <TopBar></TopBar>
        <PrimaryMenu></PrimaryMenu>

        <section class="geral-container">
            <section class="img-form">
                <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/4/4d/Saint_Jerome_Writing-Caravaggio_%281605-6%29.jpg/1280px-Saint_Jerome_Writing-Caravaggio_%281605-6%29.jpg"
                    alt="" srcset="">
            </section>
            <SignUpForm></SignUpForm>
        </section>
    </section>
</template>

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

<script>
export default {
    auth: false,

    name: "SignPage",

    components: { TopBar, PrimaryMenu, SignUpForm },
    head() {
        return {
            title: 'Se cadastre',
        }
    }


}

import TopBar from "~/components/TopBar.vue";
import PrimaryMenu from "~/components/PrimaryMenu.vue";
import SignUpForm from "~/components/SignUpForm.vue";
</script>

