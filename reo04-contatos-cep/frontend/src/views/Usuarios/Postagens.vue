<template>

   <v-container style="max-width: 600px">

        <form>
            <v-card id="nova-publicacao" flat>
                
                <v-col cols="12">

                    <v-row>

                        <v-col
                            cols="12"
                            sm="12"
                            md="12"
                            >

                            <v-text-field
                                hide-details="auto"
                                outlined
                                v-model="post.titulo"
                                label="Titulo"
                            ></v-text-field>

                        </v-col>

                    </v-row>

                    <v-row>

                        <v-col
                            cols="12"
                            >

                            <v-textarea
                                hide-details="auto"
                                outlined
                                rows="4"
                                row-height="15"
                                v-model="post.mensagem"
                                label="Digite aqui a sua publicacao"
                            ></v-textarea>

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
                            Publicar
                        </v-btn>
                    
                    </v-row>
                    
                </v-col>

            </v-card>

        </form>

        <v-container fluid>

            <v-row dense>

                <v-col
                    v-for="card in posts"
                    :key="card.id">

                    <v-card id="publicacoes" >

                        <v-card class="img-card">

                            <v-img
                                max-height="600px"
                                src="https://cdn.vuetifyjs.com/images/cards/sunshine.jpg"
                                >
                            </v-img>

                        </v-card>

                        <v-card-title>
                           {{ card.titulo }}
                        </v-card-title>

                        <v-card-subtitle>
                            {{ card.mensagem }}
                        </v-card-subtitle>
                        
                        <v-card-actions>

                            <v-btn
                                color="orange lighten-2"
                                text
                                >
                                Comentários
                            </v-btn>

                            <v-spacer></v-spacer>

                            <v-btn
                                icon
                                @click="show = !show"
                                >

                                <v-icon>
                                    {{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}
                                </v-icon>
                                
                            </v-btn>

                        </v-card-actions>

                        <v-expand-transition>

                            <div v-show="show">

                                <v-divider></v-divider>

                                <v-col>

                                    <v-row
                                        v-for="comentario in card.comentarios"
                                        :key="comentario.id">
                                        
                                            <v-card-text>
                                                {{ comentario.usuario.nome }}
                                            </v-card-text>

                                            <v-card-text>
                                                {{ comentario.mensagem }}
                                            </v-card-text>                                        

                                    </v-row>

                                    <v-text-field
                                        hide-details="auto"
                                        outlined
                                        v-model="comentario"
                                        label="digite o comentario..."
                                    ></v-text-field>

                                    <v-row>

                                        <v-spacer></v-spacer>

                                        <v-btn
                                            text
                                            id="botao-comentar"
                                            color="green"
                                            size="10px"
                                            @click="comentar(card.id)"
                                            >
                                            Comentar
                                        </v-btn>
                                    
                                    </v-row>

                                </v-col>

                            </div>

                        </v-expand-transition>

                    </v-card>

                </v-col>

            </v-row>

        </v-container>


   </v-container>

</template>


<script>

    import PostServices from "../../services/postService";
    import UsuarioService from "../../services/usuarioService";
    import ComentarioService from "../../services/comentarioService";

    export default {
        data: () => ({

            usuarioID: null,

            show: false,

            comentario: null,

            novoComentario: {
                id: null,
                mensagem: null,
                usuario: null,
                post: null,
            },

            post: {
                id: null,
                titulo: null,
                mensagem: null,
                usuario: null,
            },

            posts: [],
            comments: null,

        }),

        mounted(){
            console.log((window.location.pathname).split('/')[2])
            UsuarioService.getUsuario((window.location.pathname).split('/')[2])
                .then(resposta => {
                        this.post.usuario = resposta.data
                        this.usuarioID = resposta.data.id
                        this.listar()
                    })
                    .catch(error => {
                        console.log(error)
                        this.listar()
                    })
        },

        methods: {

            submit () {

                PostServices.cadastrar(this.post)
                    .then(resposta => {
                        console.log(resposta.data)
                        this.$toast.success("Postagem realizado com sucesso")
                        this.listar()
                    })
                    .catch(error => {
                        console.log(error)
                        this.$toast.error("Erro ao realizar postagens")
                        this.listar()
                    })
            },

            comentar(idPost) {

                PostServices.getPost(idPost)
                    .then(resposta => {
                        this.novoComentario.post = resposta.data
                        this.novoComentario.usuario = this.post.usuario
                        this.novoComentario.mensagem = this.comentario

                        ComentarioService.cadastrar(this.novoComentario)
                            .then(resposta => {
                                console.log(resposta.data)
                                console.log("comentou")
                                this.$toast.success("Comentario realizado com sucesso")
                                this.listar()
                            })
                            .catch(error => {
                                console.log(error)
                                this.$toast.error("Erro ao realizar comentario")
                            })
                    })
                    .catch(error => {
                        console.log(error)
                        this.$toast.error("Erro ao carregar post para comentar")
                    })
            },
            
            listar(){
                
                this.show = false
                PostServices.listarPorUser(this.usuarioID)
                    .then( resposta => {
                        this.posts = resposta.data
                        
                        for (const key in this.posts) {
                            console.log("KEY", key)
                            if (Object.hasOwnProperty.call(this.posts, key)) {
                                console.log("id", this.posts[key].id)
                                ComentarioService.listarPorPostagem(this.posts[key].id)
                                    .then ( resposta => {
                                        this.posts[key].comentarios = resposta.data
                                    })
                                    .catch(error => {
                                        console.log("ERROWWW", error)
                                        this.$toast.error("Erro ao carregar comentarios")
                                    })


                            }
                        }
                        console.log(this.posts)
                        this.$toast.success("Sucesso ao carregar postagens")
                    })
                    .catch(error => {
                        console.log("AAUIAUIAS", error)
                        this.$toast.error("Erro ao carregar postagens")
                    })

            },

            carregarComentarios(idPost){
                ComentarioService.listarPorPostagem(idPost)
                    .then ( resposta => {
                        this.comments = resposta.data
                        console.log("acertou", this.comments)
                        return this.comments
                    })
                    .catch(error => {
                        console.log("ERROWWW", error)
                        this.$toast.error("Erro ao carregar comentarios")
                    })
            }
            
        },
    }
</script>

<style>
    #nova-publicacao {
        text-align: center;
    }

    #texto{
        margin: 0;
        padding: 0;
    }

    #botao-comentar {
        margin: 10px;
        padding: 5px;
    }

    .img-card {
        min-height: 100px;
        padding: 10px;
    }

    .img-card .img {
        height: 100%;
    }
</style>