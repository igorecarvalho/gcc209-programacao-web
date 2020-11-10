<template>

    <v-data-table
        id="tabela"
        :headers="headers"
        :items="disciplinas"
        sort-by="disciplina"
        >

        <template v-slot:top>

            <v-toolbar
                flat
                >

                <v-toolbar-title>
                    
                    <h2><strong> Disciplinas </strong></h2>

                </v-toolbar-title>

                <v-spacer></v-spacer>

                <v-btn
                    class="mx-2"
                    fab
                    dark
                    color="green"
                    >

                    <v-icon dark>
                        mdi-plus
                    </v-icon>
                    
                </v-btn>

            </v-toolbar>

        </template>

        <template v-slot:item.acoes="{ item }">

            <v-btn
                class="mr-2"
                @click="editar(item)"
                icon>
                <v-icon color="blue" size="25px"> mdi-pencil </v-icon>
            </v-btn>

            <v-btn
                class="mr-2"
                @click="deletar(item)"
                icon>
                <v-icon color="red" size="25px"> mdi-delete </v-icon>
            </v-btn>

        </template>

    </v-data-table>

</template>


<script>

    export default {

        data: () => ({

            headers: [
                { text: 'Disciplina', value: 'disciplina' },
                { text: 'Professor', value: 'professor' },
                { text: 'Nota', value: 'nota' },
                { text: 'Dias da Semana', value: 'dias_semana' },
                { text: 'Horário', value: 'horario' },
                { text: 'Ações', value: 'acoes', sortable: false },
            ],

            disciplinas: [],

        }),

        computed: {
        },

        created () {
            this.initialize()
        },

        methods: {

            initialize () {

                this.disciplinas = [

                    {
                        disciplina: 'IAlg',
                        professor: 'Juliana',
                        nota: 6.0,
                        dias_semana: 'segunda e quinta',
                        horario: '15:00 as 16:40',
                    },

                    {
                        disciplina: 'Calculo',
                        professor: 'João',
                        nota: 8.0,
                        dias_semana: 'terça e sexta',
                        horario: '8:00 as 9:40',
                    },

                    {
                        disciplina: 'Circuitos digitais',
                        professor: 'Maria',
                        nota: 9.1,
                        dias_semana: 'segunda e terça',
                        horario: '13:00 as 14:40',
                    },

                    {
                        disciplina: 'Estatistica',
                        professor: 'Luciana',
                        nota: 7.8,
                        dias_semana: 'quinta',
                        horario: '9:00',
                    },

                ]

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
