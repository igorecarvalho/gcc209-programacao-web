<template>

    <div id="container" >

        <Header user="Não logado" login="Favor realizar login" :mostar="mostra"/>

        <v-container>

            <form>

                <v-toolbar id="publicacoes" flat>

                    <v-toolbar-title>
                        <h2>
                            <strong>
                                Cadastro de Usuario
                            </strong>
                        </h2>
                    </v-toolbar-title>
                    
                </v-toolbar>

                <v-card id="publicacoes" flat>
                    
                    <v-col cols="12" style="padding: 20px">

                        <v-row style="margin: 10px">
                            <v-toolbar-title>

                                    <strong>
                                        Informações pessoais
                                    </strong>

                            </v-toolbar-title>
                        </v-row>

                        <v-row>

                            <v-col
                                cols="12"
                                sm="6"
                                md="6"
                                >

                                <v-text-field
                                    v-model="usuario.nome"
                                    label="Nome"
                                ></v-text-field>

                            </v-col>

                        </v-row>

                        <v-row>

                            <v-col
                                cols="12"
                                sm="6"
                                md="6"
                                >

                                <v-text-field
                                    v-model="usuario.login"
                                    label="Login"
                                ></v-text-field>

                            </v-col>

                        </v-row>

                        <v-row>

                            <v-col
                                cols="12"
                                sm="6"
                                md="6"
                                >

                                <v-text-field
                                    type="password"
                                    v-model="usuario.senha"
                                    label="Senha"
                                ></v-text-field>

                            </v-col>

                        </v-row>

                        <v-row style="margin: 10px">
                            <v-toolbar-title>

                                    <strong>
                                        Endereço
                                    </strong>

                            </v-toolbar-title>
                        </v-row>

                        <v-row>

                            <v-col
                                cols="12"
                                sm="6"
                                md="6"
                                >

                                <v-text-field
                                    v-model="usuario.cep"
                                    v-on:keyup="attEndereco"
                                    mask='"#####-###"'
                                    label="CEP"
                                ></v-text-field>

                            </v-col>

                        </v-row>

                        <v-row>

                            <v-col
                                cols="12"
                                sm="6"
                                md="6"
                                >

                                <v-text-field
                                    v-model="usuario.logradouro"
                                    :value="usuario.logradouro"
                                    label="Logradouro"
                                ></v-text-field>

                            </v-col>

                            <v-col
                                cols="12"
                                sm="6"
                                md="6"
                                >

                                <v-text-field
                                    v-model="usuario.bairro"
                                    :value="usuario.bairro"
                                    label="Bairro"
                                ></v-text-field>

                            </v-col>

                        </v-row>

                        <v-row>

                            <v-col
                                cols="12"
                                sm="6"
                                md="6"
                                >

                                <v-text-field
                                    v-model="usuario.localidade"
                                    :value="usuario.localidade"
                                    label="Cidade"
                                ></v-text-field>

                            </v-col>

                            <v-col
                                cols="12"
                                sm="6"
                                md="6"
                                >

                                <v-text-field
                                    v-model="usuario.uf"
                                    :value="usuario.uf"
                                    label="UF"
                                ></v-text-field>

                            </v-col>

                        </v-row>

                    <v-col cols="12">

                        <v-row>

                            <v-spacer></v-spacer>

                            <v-btn
                                id="botoes"
                                class="mr-4"
                                color="white--text"
                                router :to="voltar"
                                text
                                >
                                Cancelar
                            </v-btn>

                            <v-btn
                                id="botaoGeral"
                                class="mr-4"
                                color="white--text"
                                @click="submit"
                                >
                                Salvar
                            </v-btn>
                        
                        </v-row>
                        
                    </v-col>

                    </v-col>

                </v-card>

            </form>

        </v-container>

        <Footer/>

    </div>
        
</template>

<script>

    import UsuarioServices from "../../services/usuarioService";
    import CepServices from "../../services/cepService";
    import Header from "../../components/Header";
    import Footer from "../../components/Footer";

    export default {

        data: () => ({
            
            mostra: false,

            voltar: '/',

            usuario: {

                nome: null,

                login: null,

                senha: null,

                cepContato: null,

                logradouroContato: null,

                bairroContato: null,

                localidadeContato: null,

                ufContato: null,
            },

        }),

        methods: {

            submit () {

                if(!UsuarioServices.listar()
                    .then(resposta => {
                        //console.log(resposta.data)
                        resposta.data.some(element => {
                            console.log(element)
                            if (this.usuario.login == element.login) {
                               this.$toast.error("Informe um login de usuario válido!")
                               return true;
                            }
                        });
                    })){
                        UsuarioServices.cadastrar(this.usuario)
                            .then(resposta => {
                                console.log(resposta.data)
                                this.$toast.success('Usuario salvo com sucesso!')
                                window.location.href = this.voltar
                            })
                            .catch(error => {
                                console.log(error)
                                this.$toast.error("Erro ao cadastrar usuario")
                            })
                    }
            },

            attEndereco(){

                CepServices.getEndereco(this.usuario.cep)
                    .then(resposta => {
                        this.usuario.logradouro = resposta.data.logradouro
                        this.usuario.bairro = resposta.data.bairro
                        this.usuario.localidade = resposta.data.localidade
                        this.usuario.uf = resposta.data.uf
                    })
                    .catch(() => {
                    })
            }

        },

        components: {
            Header,
            Footer,
        },

    }

</script>

<style>

</style>
