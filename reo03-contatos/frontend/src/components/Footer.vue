<template>

    <v-footer
        app
        dark
        padless>

        <v-card
            class="flex"
            flat
            tile
            >

            <v-card-title class="primary">

                <strong class="subheading">GCC209-PROGRAMAÇÃO WEB</strong>

                <v-spacer></v-spacer>

            </v-card-title>

            <v-card-text class="py-2 white--text text-center">
                {{ new Date().getFullYear() }} — <strong>Igor Carvalho</strong>
            </v-card-text>
            
        </v-card>

    </v-footer>

</template>

<script>

    export default {
        name: "Footer",

        data: () => ({

        }),
    };

</script>
