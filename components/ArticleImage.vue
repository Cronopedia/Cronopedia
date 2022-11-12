<template>
  <section class="article-image">
    <!-- <img :src="`/static/img/artigos/${articleID}/${articleID}.jpg`" /> -->

    <div class="article-image-container">
      <img :style="`background-image: url('${url}');`" alt="" />
    </div>
    <span class="descricao"> Descrição: Algum dia nós colocamos</span>
  </section>
</template>

<style scoped>
section.article-image {
  margin: 4em auto;
  display: flex;
  flex-direction: column;
  align-items: center;
}
div.article-image-container {
  background-color: #fff;
  width: calc(450px * 0.8);
  height: calc(450px * 0.8);
}
img {
  width: 100%;
}

section.article-image span.descricao {
  font-family: "Spectral";
  font-style: italic;
  font-weight: 400;
  font-size: 16px;
  line-height: 24px;
  display: flex;
  align-items: center;
  text-align: center;
}
</style>

<script>
export default {
  name: "ArticleImage",
  props: {
    url: {
      type: String,
    },
  },
  methods: {},
};
</script>