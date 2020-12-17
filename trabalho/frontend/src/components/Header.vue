<template>

    <v-container id="containerHeader" fluid>
        
        <v-toolbar
            dark
            id="toolbarHeader">

            <v-col
                cols="12"
                sm="1"
                md="1"
                id="logo"
                >
                <div class="d-flex flex-column justify-space-between align-center">
                    <v-img
                        width="50px"
                        id="img"
                        src="../assets/logo.png">
                    </v-img>
                </div>
            </v-col>

            <v-col
                cols="12"
                sm="4"
                md="4"
                >
                <v-toolbar-title >

                    <strong> <h1>REDE DE GATO</h1> </strong>
                
                </v-toolbar-title>
            </v-col>

            <v-col
                cols="12"
                sm="6"
                md="6"
                >
                <v-bottom-navigation
                    v-if="mostar"
                    class="navegacao"
                    :value="pagina"
                    color="#ff888a"
                    >
                    <v-btn router :to="todas + usuario">

                        <v-icon size="30px">mdi-home</v-icon>
                    </v-btn>

                    <v-btn router :to="minhas + usuario">

                        <v-icon  size="30px">mdi-account</v-icon>
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
                        v-if="mostar"
                        icon
                        x-large
                        v-on="on"
                        >

                        <v-avatar >

                            <v-icon color="#ff888a"
                                    size="30px"
                                    dark>

                                mdi-logout
                            </v-icon>
                            
                        </v-avatar>

                    </v-btn>

                </template>

                <v-card>

                    <v-list-item-content class="justify-center">

                        <div class="mx-auto text-center">

                            <v-avatar color="white">

                                <v-icon color="#ff888a"
                                        large
                                        dark>

                                    mdi-account
                                </v-icon>
                                
                            </v-avatar>

                            <p class="logoutNome">
                                {{ user }}
                            </p>

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

    #toolbarHeader{
        background-color: #7b7979;
        box-shadow: 0 0 black;
        border-bottom: 2px solid #a9a7a7;


    }

    .navegacao{
        box-shadow: 0 0 black !important;
        background-color: transparent !important;
        justify-content: flex-end !important;

        
    }

    .v-btn__content{
        font-weight: bolder;
    }

    #corFont{
        color: #ff888a;
    }

    .logoutNome{
        font-size: 20px;
        text-transform: capitalize;
        font-weight: bolder;
    }


</style>


