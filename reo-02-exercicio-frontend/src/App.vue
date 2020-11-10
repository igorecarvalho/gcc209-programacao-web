<template>

        <v-app  cols="12" id="app">

            <FormularioSimples></FormularioSimples>

        </v-app>

</template>

<script>

    import FormularioSimples from './components/ExercicioFormulario.vue'

    export default {

        name: 'App',

        components: {
            FormularioSimples
        }

    }

</script>

<style>
    #app {
        font-family: "Gill Sans Extrabold", Helvetica, sans-serif;
        padding: 10px;

        background: linear-gradient(to right, rgb(83, 105, 118), rgb(41, 46, 73));
    }
</style>
