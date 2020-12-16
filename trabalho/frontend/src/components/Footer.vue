<template>

    <v-footer
        dark
        padless>

        <v-card
            
            class="flex"
            flat
            tile
            >

            <v-card-title id="cardFooter" >

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

<style>
    #cardFooter{
background-image: linear-gradient(to top, #151614, #1c211a, #212d20, #253a28, #274731, #2b5539, #306340, #347248, #45854c, #5a974e, #71aa4e, #8cbc4d);    }
</style>
