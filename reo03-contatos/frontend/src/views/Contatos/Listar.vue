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

                <v-btn
                    class="mr-2"
                    router :to="editar + item.id" 
                    icon>
                    <v-icon color="blue" size="25px"> mdi-pencil </v-icon>
                </v-btn>

                <v-btn
                    class="mr-2"
                    @click="deletar(item.id)"
                    icon>
                    <v-icon color="red" size="25px"> mdi-delete </v-icon>
                </v-btn>

            </template>

        </v-data-table>

   </v-container>

</template>


<script>

    import ContatosServices from "../../services/contatosService";

    export default {

        data: () => ({

            cadastrar: 'cadastrar-contato',

            editar: '/contato/editar/',

            headers: [
                { text: 'Nome', value: 'nomeContato' },
                { text: 'E-mail', value: 'emailContato' },
                { text: 'Telefone', value: 'telefoneContato' },
                { text: 'Data Nascimento', value: 'dataNascimentoContato' },
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
                ContatosServices.deletar(contato, contato.id)
                        .then( () => {
                            this.$toast.error('Contatos deletado!')
                            this.listar()
                        })
                        .catch(error => {
                            console.log('erroww')
                            console.log(error)
                            this.$toast.error('Erro ao deletar contatos!')
                        })

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
