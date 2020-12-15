<template>

    <v-container id="login-box">

        <form>    

            <v-card
                min-width="300px"
                style="padding: 10px; margin: 10px"
                color="teal"
                dark
                >

                <v-card-title class="headline">
                    Login de usuário
                </v-card-title>

                <v-text-field
                    v-model="usuario.login"
                    :value="usuario.login"
                    label="Login"
                ></v-text-field>

                <v-text-field
                    v-model="usuario.senha"
                    :value="usuario.senha"
                    label="Senha"
                ></v-text-field>

                <v-card-actions>

                    <v-btn 
                            router :to="cadastrar">
                            Novo usuario
                    </v-btn>

                    <v-spacer></v-spacer>

                    <v-btn @click="login()">
                            Entrar
                    </v-btn>

                </v-card-actions>

            </v-card>

        </form>

    </v-container>

</template>


<script>

    export default {

        data: () => ({

            cadastrar: 'cadastrar-usuario',

            usuario: {

                login: null,

                senha: null,
            }

        }),

        methods: {

            login() {

                console.log("oin")
            }
        }

    }

</script>

<style>

    #login-box {
        min-width: 300px;
        display: flex;
        align-content: center;
        justify-content: space-around;
    }

</style>
