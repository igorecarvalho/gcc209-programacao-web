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
                                prepend-inner-icon="mdi-calendar"
                                v-model="contato.dataNascimentoContato"
                                label="Data Nascimento"
                            ></v-text-field>

                        </v-col>

                    </v-row>

                    <v-row style="margin: 10px">
                        <v-toolbar-title>

                                <strong>
                                    Contato
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
                                prepend-inner-icon="mdi-mail"
                                v-model="contato.emailContato"
                                label="E-mail"
                            ></v-text-field>

                        </v-col>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                prepend-inner-icon="mdi-phone"
                                v-model="contato.telefoneContato"
                                label="Telefone"
                            ></v-text-field>

                        </v-col>

                    </v-row>

                    <v-row style="margin: 10px">
                        <v-toolbar-title>

                                <strong>
                                    Redes Sociais
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
                                prepend-inner-icon="mdi-facebook"
                                v-model="contato.facebookContato"
                                label="Facebook"
                            ></v-text-field>

                        </v-col>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                prepend-inner-icon="mdi-instagram"
                                v-model="contato.instagramContato"
                                label="Instagram"
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
                                prepend-inner-icon="mdi-twitter"
                                v-model="contato.twitterContato"
                                label="Twitter"
                            ></v-text-field>

                        </v-col>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                prepend-inner-icon="mdi-linkedin"
                                v-model="contato.linkedinContato"
                                label="Linkedin"
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

            voltar: '/listar-contatos',

            contato: {

                nomeContato: null,

                emailContato: null,

                telefoneContato: null,

                dataNascimentoContato: null,

                facebookContato: null,
                
                linkedinContato: null,

                twitterContato: null,

                instagramContato: null,
            },

        }),

        methods: {

            submit () {

                ContatosServices.cadastrar(this.contato)
                    .then(resposta => {
                        console.log(resposta)
                        this.$toast.success('Contato salvo com sucesso!')
                        window.location.href = this.voltar
                    })
                    .catch(error => {
                        this.$toast.error("Erro: " + error.response.data.message)
                    })

            },

        },
    }

</script>