<template>

    <v-container>

        <form>

            <v-toolbar flat>

                <v-toolbar-title>
                    <h2>
                        <strong>
                            Cadastro de contato
                        </strong>
                    </h2>
                </v-toolbar-title>
                
            </v-toolbar>

            <v-card flat>
                
                <v-col cols="12">

                    <v-row>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                v-model="contato.nomeContato"
                                label="Nome"
                            ></v-text-field>

                        </v-col>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                v-model="contato.emailContato"
                                label="E-mail"
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
                                v-model="contato.telefoneContato"
                                label="Telefone"
                            ></v-text-field>

                        </v-col>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                v-model="contato.dataNascimentoContato"
                                label="Data Nascimento"
                            ></v-text-field>

                        </v-col>

                    </v-row>

                </v-col>

                <v-col cols="12">

                    <v-row>

                        <v-spacer></v-spacer>

                        <v-btn
                            class="mr-4"
                            color="red darken-1 white--text"
                            router :to="voltar"
                            >
                            Cancelar
                        </v-btn>

                        <v-btn
                            class="mr-4"
                            color="green white--text"
                            @click="submit"
                            >
                            Salvar
                        </v-btn>
                    
                    </v-row>
                    
                </v-col>

            </v-card>

        </form>

    </v-container>
        
</template>

<script>

    import ContatosServices from "../../services/contatosService";

    export default {

        data: () => ({

            contatoId: 0,

            voltar: '/listar-contatos',

            contato: {

                nomeContato: null,

                emailContato: null,

                telefoneContato: null,

                dataNascimentoContato: null,
            },

        }),

        mounted(){

            var url_string = window.location.href; //recuperando a string da url
            var url = new URL(url_string); //transformando a url em objeto para acessar os parametros
            var pathname = url.pathname //recuperando o valor do parametro referente a id
            console.log(url)
            console.log(url_string)
            console.log(pathname.split('/'))
            this.contatoId = pathname.split('/')[3]

            ContatosServices.getContato(this.contatoId)
                        .then( resposta => {
                            console.log(resposta.data)
                            this.contato = resposta.data
                            console.log(this.contato)
                        }).catch(error => {
                            console.log(error.response.data.message)
                            this.$toast.error('Erro ao editar sprint!')
                            this.$toast.error("Erro: " + error.response.data.message)
                        })
        },

        methods: {

            submit () {

                console.log(this.contato)
                console.log(this.contato.id)
                ContatosServices.editar(this.contato, this.contato.id)
                    .then(resposta => {
                        console.log(resposta)
                        this.$toast.success('Contato editado com sucesso!')
                        window.location.href = this.voltar
                    })
                    .catch(error => {
                        this.$toast.error("Erro: " + error)
                    })

            },

        },
    }

</script>