<template>
  <editor
    api-key="u19n8hdzwus3tpuaj01ao7t5z5jtwdvxyaouzt77iy5hn75j"
    :init="{
      height: 700,
      skin: 'naked',
      icons: 'thin',
      plugins: [
        'advlist',
        'autolink',
        'lists',
        'link',
        'image',
        'charmap',
        'preview',
        'anchor',
        'searchreplace',
        'fullscreen',
        'media',
        'table',
        'help',
        'wordcount',
      ],
      // Contexto (click no botão direito)
      contextmenu: 'link image table',

      // Contexto (seleção de conteudo)
      setup: (editor) => {
        editor.ui.registry.addContextToolbar('textselection', {
          predicate: (node) => !editor.selection.isCollapsed(),
          items: 'bold italic | blockquote',
          position: 'selection',
          scope: 'node',
        });
      },

      // Barra de Ferramentas
      toolbar:
        'undo redo fontselect fontsizeselect formatting aligns \
                list  outdent indent removeformat  a11ycheck  cancel save',

      // Grupos de ferramentas
      toolbar_groups: {
        formatting: {
          icon: 'format',
          tooltip: 'Format',
          items: 'bold italic underline | superscript subscript',
        },
        aligns: {
          icon: 'align-center',
          tooltip: 'Align',
          items: 'alignleft aligncenter alignright alignjustify',
        },
        list: {
          icon: 'unordered-list',
          tooltip: 'List',
          items: 'bullist numlist checklist',
        },
      },

      // Menu
      // menubar: 'edit insert format table tools help',
      menubar: false,

      // Mobile
      mobile: {
        // Contexto (seleção de conteudo)
        setup: (editor) => {
          editor.ui.registry.addContextToolbar('textselection', {
            predicate: (node) => !editor.selection.isCollapsed(),
            items: 'bold italic | blockquote',
            position: 'selection',
            scope: 'node',
          });
        },
      },
    }"
    :initial-value="`${conteudo}`"
    output-format="html"
  />
</template>

<script>
import tinyEditor from "@tinymce/tinymce-vue";

export default {
  name: "Editor",
  components: {
    editor: tinyEditor,
  },
  props: {
    conteudo: {
      type: String,
      default: "Comece a sua história.",
    },
  },
};
</script>