<template>

   <v-container>

        <form>

            <v-toolbar flat>

                <v-toolbar-title>
                    <h2>
                        <strong>
                            Cadastro de Animal
                        </strong>
                    </h2>
                </v-toolbar-title>
                
            </v-toolbar>

            <v-card flat>
                
                <v-col cols="12" style="padding: 20px">

                    <v-row style="margin: 10px">
                        <v-toolbar-title>

                                <strong>
                                    Informações do Animal
                                </strong>

                        </v-toolbar-title>
                    </v-row>

                    <v-row>

                        <v-col
                            cols="12"
                            sm="12"
                            md="12"
                            >

                            <v-text-field
                                v-model="animal.nomeAnimal"
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
                                v-model="animal.tipoAnimal"
                                label="Tipo ou raça do animal"
                            ></v-text-field>

                        </v-col>

                        <v-col
                            cols="12"
                            sm="6"
                            md="6"
                            >

                            <v-text-field
                                type="number"
                                v-model="animal.idadeAnimal"
                                label="Idade do animal"
                            ></v-text-field>

                        </v-col>

                    </v-row>

                </v-col>

                <v-col cols="12">

                    <v-row>

                        <v-spacer></v-spacer>

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

        <v-data-table
            id="tabela"
            :headers="headers"
            :items="animais"
            sort-by="nomeAnimal"
            >

            <template v-slot:top>

                <v-toolbar
                    flat
                    >

                    <v-toolbar-title>
                        
                        <h2><strong> Animais </strong></h2>

                    </v-toolbar-title>

                    <v-spacer></v-spacer>

                </v-toolbar>

            </template>

        </v-data-table>

   </v-container>

</template>


<script>

    import AnimaisServices from "../../services/animalService";

    export default {
        data: () => ({
            
            headers: [
                { text: 'Nome', value: 'nomeAnimal', class: "black--text  font-weight-bold" },
                { text: 'Tipo', value: 'tipoAnimal', class: "black--text  font-weight-bold" },
                { text: 'Idade', value: 'idadeAnimal', class: "black--text  font-weight-bold" },
            ],

            animal: {
                nomeAnimal: null,
                tipoAnimal: null,
                idadeAnimal: null,
            },

            animais: [],
        }),

        mounted(){
            this.listar()
        },

        methods: {

            submit () {

                AnimaisServices.cadastrar(this.animal)
                    .then(resposta => {
                        console.log(resposta.data)
                        this.listar()
                    })
                    .catch(error => {
                        console.log(error)
                        this.listar()
                    })
            },
            
            listar(){
                
                AnimaisServices.listar()
                            .then( resposta => {
                                console.log(resposta.data)
                                this.animais = resposta.data
                            })
                            .catch(error => {
                                console.log(error)
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