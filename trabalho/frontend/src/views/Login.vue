<template>

    <div id="container" >

        <Header user="Não logado" login="Favor realizar login" :mostar="mostra"/>

        <v-container id="login-box">

            <form>    

                <v-card
                    id="login"
                    min-width="300px"
                    style="padding: 10px; margin: 10px"
                    dark
                    >

                    <v-card-title class="headlineLogin">
                        Login de usuário
                    </v-card-title>

                    <v-text-field
                        outlined
                        v-model="usuario.login"
                        label="Login"
                    ></v-text-field>

                    <v-text-field
                        outlined
                        type="password"
                        counter
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

        <Footer/>

    </div>

</template>


<script>

    import UsuariosService from '../services/usuarioService';
    import Header from "../components/Header";
    import Footer from "../components/Footer";

    export default {

        data: () => ({

            mostra: false,

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
            Footer,
        },

    }

</script>

<style>

    #login-box {
        min-height: 700px;
        min-width: 300px;
        display: grid;
        align-content: center;
        justify-content: space-around;
        
    }

    #login{
background-image: radial-gradient(circle, #235511, #39671d, #4f7a29, #668d35, #7ea141, #7fa041, #819f40, #829e40, #6d8933, #587526, #456119, #324e0c);    }

    #headlineLogin{
        font-size: 50px;
        font-weight: bolder;
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
