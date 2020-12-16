<template>

    <v-div id="container" >

        <Header user="Não logado" login="Favor realizar login"/>

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
                        label="Login"
                    ></v-text-field>

                    <v-text-field
                        v-model="usuario.senha"
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

    </v-div>

</template>


<script>

    import UsuariosService from '../services/usuarioService';
    import Header from "../components/Header";

    export default {

        data: () => ({

            autenticacao: null,

            cadastrar: 'cadastrar-usuario',

            usuario: {

                login: null,

                senha: null,
            },

        }),

        methods: {

            login() {

                UsuariosService.listar()
                    .then(resposta => {
                        //console.log(resposta.data)
                        resposta.data.forEach(element => {
                            console.log(element)
                            if (this.usuario.login == element.login && this.usuario.senha == element.senha) {
                                this.autenticacao = element.id
                                console.log("check", this.autenticacao)
                                window.location.replace("/home/" + this.autenticacao);
                            }
                        });
                    })
                    if (this.autenticacao == null) {
                        this.$toast.error("Usuario nao cadastrado")
                    }
            },
        },

        components: {
            Header,
        },

    }

</script>

<style>

    #login-box {
        min-width: 300px;
        display: flex;
        align-content: center;
        justify-content: space-around;
    }

    .loader {
    border: 5px solid #f3f3f3; /* Light grey */
    border-top: 5px solid #3498db; /* Blue */
    border-radius: 50%;
    width: 25px;
    height: 25px;
    animation: spin 2s linear infinite;
    }
    @keyframes spin {
    0% {
        transform: rotate(0deg);
    }
    100% {
        transform: rotate(360deg);
    }
    }

</style>
