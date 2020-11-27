<template>

   <v-container>

        <v-data-table
            id="tabela"
            :headers="headers"
            :items="contatos"
            sort-by="nomeContato"
            >

            <template v-slot:top>

                <v-toolbar
                    flat
                    >

                    <v-toolbar-title>
                        
                        <h2><strong> Contatos </strong></h2>

                    </v-toolbar-title>

                    <v-spacer></v-spacer>

                    <v-btn
                        class="mx-2"
                        fab
                        dark
                        router :to="cadastrar"
                        color="green"
                        >

                        <v-icon dark>
                            mdi-account-plus
                        </v-icon>
                        
                    </v-btn>

                </v-toolbar>

            </template>

            <template v-slot:item.acoes="{ item }">

                <v-dialog  v-model="dialog_visualizar[item.id]"
                            :retain-focus="false"
                            max-width="400">

                    <template v-slot:activator="{ on, attrs }">

                        <v-btn
                            class="mr-2"
                            icon
                            color="green"
                            v-bind="attrs"
                            v-on="on">
                            <v-icon size="25px"> 
                                mdi-eye 
                            </v-icon>
                        </v-btn>

                    </template>
                    
                    <v-card
                        fluid
                        justify="space-around"
                        class="mx-auto"
                        max-width="600"
                        min-height="434"
                        tile>

                        <v-col cols="12">

                            <v-row justify="space-around" style="padding: 15px">

                                <v-avatar
                                    size="100px">
                                    <img
                                        src="https://img.olhardigital.com.br/uploads/acervo_imagens/2020/04/r4x3/20200401055253_660_495_-_gato_com_mascara_de_protecao.jpg"
                                        alt="John"
                                    >
                                </v-avatar>

                            </v-row>

                            <v-row justify="space-around">

                                <v-card-title>

                                    <h2><strong>{{item.nomeContato}}</strong></h2>

                                </v-card-title>

                            </v-row>

                            <v-col cols="12">

                                <v-row justify="space-around">
                                    
                                    <v-icon>mdi-cake</v-icon> 
                                    <v-spacer></v-spacer>
                                    {{item.dataNascimentoContato}}

                                </v-row>

                            </v-col>

                            <v-divider></v-divider>

                            <v-col cols="12">
                        
                                <v-row style="padding: 5px">
                                    <v-icon>mdi-home-city</v-icon>: 
                                    <v-spacer></v-spacer>
                                    {{ item.logradouroContato + ' - ' + item.bairroContato + ' - ' + item.localidadeContato + ' - ' + item.ufContato }}
                                </v-row>

                            </v-col>

                            <v-divider></v-divider>

                            <v-divider></v-divider>

                            <v-col cols="12">
                        
                                <v-row style="padding: 5px">
                                    <v-icon>mdi-phone</v-icon>: 
                                    <v-spacer></v-spacer>
                                    {{ item.telefoneContato }}
                                </v-row>

                                <v-row style="padding: 5px">
                                    <v-icon>mdi-mail</v-icon>: 
                                    <v-spacer></v-spacer>
                                    {{ item.emailContato }}
                                </v-row>

                            </v-col>

                            <v-divider></v-divider>

                            <v-col cols="12">
                        
                                <v-row justify="space-around" style="padding: 5px">

                                    <v-btn
                                        :href="item.facebookContato"
                                        target="_blank"
                                        dark
                                        color="#3b5998"
                                        icon>
                                        <v-icon size="25px">mdi-facebook</v-icon>
                                    </v-btn>

                                    <v-btn
                                        :href="item.instagramContato"
                                        target="_blank"
                                        dark
                                        color="pink"
                                        icon>
                                        <v-icon size="25px">mdi-instagram</v-icon>
                                    </v-btn>

                                    <v-btn
                                        :href="item.twitterContato"
                                        target="_blank"
                                        dark
                                        color="#1DA1F2"
                                        icon>
                                        <v-icon size="25px">mdi-twitter</v-icon>
                                    </v-btn>

                                    <v-btn
                                        :href="item.linkedinContato"
                                        target="_blank"
                                        dark
                                        color="#2867B2"
                                        icon>
                                        <v-icon size="25px">mdi-linkedin</v-icon>
                                    </v-btn>

                                </v-row>

                            </v-col>

                        </v-col>

                    </v-card>

                </v-dialog>

                <v-btn
                    class="mr-2"
                    router :to="editar + item.id" 
                    icon>
                    <v-icon color="blue" size="25px"> mdi-pencil </v-icon>
                </v-btn>

                <v-dialog  v-model="dialog_cancelar[item.id]"
                            persistent 
                            :retain-focus="false"
                            max-width="300">

                    <template v-slot:activator="{ on, attrs }">

                        <v-btn
                            class="mr-2"
                            icon
                            color="red"
                            v-bind="attrs"
                            v-on="on">
                            <v-icon size="25px"> 
                                mdi-delete 
                            </v-icon>
                        </v-btn>

                    </template>
                    
                    <v-card>
                        
                        <v-card-title class="headline">
                            <strong><h2>Atenção!</h2></strong>
                        </v-card-title>
                        
                        <v-card-text>
                                Deseja realmente deletar o contato: 
                                <p><strong> {{item.nomeContato}} </strong>?</p>
                        </v-card-text>

                        <v-card-actions>

                            <v-spacer></v-spacer>

                            <v-btn  color="red darken-1" 
                                    text @click="cancelarDialogo(item.id)">
                                Não
                            </v-btn>

                            <v-btn  color="green darken-1 white--text" 
                                    @click="deletar(item.id)">
                                Sim
                            </v-btn>

                        </v-card-actions>

                    </v-card>

                </v-dialog>

            </template>

        </v-data-table>

   </v-container>

</template>


<script>

    import ContatosServices from "../../services/contatosService";

    export default {

        data: () => ({

            dialog_cancelar: [],

            dialog_visualizar: [],

            cadastrar: 'cadastrar-contato',

            editar: '/contato/editar/',

            headers: [
                { text: 'Nome', value: 'nomeContato', class: "black--text  font-weight-bold" },
                { text: 'E-mail', value: 'emailContato', class: "black--text  font-weight-bold" },
                { text: 'Telefone', value: 'telefoneContato', class: "black--text  font-weight-bold" },
                { 
                    text: 'Ações', 
                    value: 'acoes', 
                    sortable: false, 
                    align: 'center' ,
                    class: "black--text  font-weight-bold"
                },
            ],

            contatos: [],

        }),

        mounted(){

            this.listar()

        },

        methods: {


            listar(){
                ContatosServices.listar()
                            .then( resposta => {
                                console.log(resposta.data)
                                this.contatos = resposta.data
                            })
                            .catch(error => {
                                console.log(error)
                                this.$toast.error('Erro ao carregar contatos!')
                            })
            },

            deletar(contato) {

                console.log(contato)

                ContatosServices.deletar(contato)
                        .then( () => {
                            this.$toast.success('Contato deletado com sucesso!')
                            this.listar()
                        })
                        .catch(error => {
                            console.log(error)
                            this.$toast.error('Erro ao deletar contatos!')
                        })

            },

            cancelarDialogo(){
                this.dialog_cancelar = []
                this.dialog_visualizar = []
            },

        },

    }

</script>

<style>

    #tabela {
        text-align: center;
        padding: 10px;
    }

</style>
