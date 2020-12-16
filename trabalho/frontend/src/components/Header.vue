<template>

    <v-container id="containerHeader" fluid>
        
        <v-toolbar
            dark
            color="primary">

            <v-col
                cols="12"
                sm="3"
                md="3"
                >
                <v-toolbar-title>

                    <strong> <h1>Rede de gato</h1> </strong>
                
                </v-toolbar-title>
            </v-col>

            <v-col
                cols="12"
                sm="3"
                md="8"
                >
            <v-bottom-navigation
                shift
                v-if="mostar"
                class="navegacao"
                :value="pagina"
                background-color="primary"
                color="white"
                >
                <v-btn router :to="todas + usuario">
                    <span>Todas publicações</span>

                    <v-icon>mdi-home</v-icon>
                </v-btn>

                <v-btn router :to="minhas + usuario">
                    <span>Minhas Publicações</span>

                    <v-icon>mdi-account</v-icon>
                </v-btn>

            </v-bottom-navigation>

            </v-col>

            <v-col
                cols="12"
                sm="1"
                md="1"
                >
            <v-menu
                bottom
                min-width="200px"
                rounded
                offset-y
                >

                <template v-slot:activator="{ on }">

                    <v-btn
                        :v-if="mostar"
                        icon
                        x-large
                        v-on="on"
                        >

                        <v-avatar color="white">

                            <v-icon color="teal"
                                    large
                                    dark>

                                mdi-account
                            </v-icon>
                            
                        </v-avatar>

                    </v-btn>

                </template>

                <v-card>

                    <v-list-item-content class="justify-center">

                        <div class="mx-auto text-center">

                            <v-avatar color="white">

                                <v-icon color="teal"
                                        large
                                        dark>

                                    mdi-account
                                </v-icon>
                                
                            </v-avatar>

                            <h3>{{ user }}</h3>

                            <p class="caption mt-1">
                                {{ login }}
                            </p>

                            <v-divider class="my-3"></v-divider>

                            <v-btn
                                small
                                depressed
                                rounded
                                text
                                router to="/"
                                >
                                Desconectar
                            </v-btn>

                        </div>

                    </v-list-item-content>

                </v-card>

            </v-menu>
            </v-col>

        </v-toolbar>

    </v-container>

</template>

<script>

    export default {
        name: "Header",

        data () {

            return {

                todas: '../home/',

                minhas: '../minhas-postagens/',

                drawer: null,
            }

        },

        props: {
            user: null,
            login: null,
            pagina: null,
            mostar: null,
            usuario: null,
        }

    };

</script>

<style>

    #containerHeader {
        padding: 0px;
    }

    .navegacao{
        box-shadow: 0 0 black !important;
    }


</style>


