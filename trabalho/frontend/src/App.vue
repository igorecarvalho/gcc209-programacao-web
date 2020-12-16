<template>

    <div>

        <v-app id="app">

            <router-view></router-view>
            <Footer></Footer>

        </v-app>

    </div>

</template>

<script>

    //import Header from "@/components/Header.vue";
    //import Footer from "@/components/Footer.vue";
    import 'vue-toast-notification/dist/theme-sugar.css';

    export default {

        name: "App",

        components: {
            //Header,
            //Footer,
        },
    };

</script>

<style>

#app{
    background-color: grey;
}

</style>