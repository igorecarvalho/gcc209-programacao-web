<template>

    <div id="container" >

        <Header :user="post.usuario.nome" :login="post.usuario.login" :pagina="value" :mostar="mostar" :usuario="post.usuario.id"/>

        <v-container style="max-width: 600px">

                <v-container fluid>

                    <v-expansion-panels  focusable>
                        <v-expansion-panel >
                            <v-expansion-panel-header disable-icon-rotate>
                                <h3>Nova publicação</h3>
                                    <template v-slot:actions>
                                        <v-icon color="#ff888a">
                                        mdi-chat-plus
                                        </v-icon>
                                    </template>                            
                            </v-expansion-panel-header>

                            <v-expansion-panel-content>
                                <form>

                                    <v-card id="publicacoes" flat>
                                        
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
                                                        rows="3"
                                                        row-height="15"
                                                        v-model="post.mensagem"
                                                        label="Digite aqui a sua publicacao"
                                                    ></v-textarea>

                                                </v-col>

                                            </v-row>

                                            <v-col cols="12">

                                                <v-file-input
                                                    outlined
                                                    show-size
                                                    accept="image/png, image/jpeg, image/bmp"
                                                    prepend-icon="mdi-camera"
                                                    label="Selecione a imagem"
                                                    @change="selectFile">
                                                </v-file-input>
                                                
                                            </v-col>

                                            <v-row>

                                                <v-spacer></v-spacer>

                                                <v-btn
                                                    id="botaoGeral"
                                                    class="mr-4"
                                                    color="white--text"
                                                    @click="submit"
                                                    >
                                                    Publicar
                                                </v-btn>
                                            
                                            </v-row>
                                            
                                        </v-col>

                                    </v-card>

                                </form>
                            </v-expansion-panel-content>
                        </v-expansion-panel>
                    </v-expansion-panels>

                </v-container>

                <v-container fluid>

                        <v-toolbar color="white--text" id="publicacoes">

                            <v-toolbar-title>

                                Publicações

                            </v-toolbar-title>

                        </v-toolbar>

                    <v-row dense>

                        <v-col cols="12"
                            v-for="card in posts"
                            :key="card.id">

                            <v-card color="white--text" id="publicacoes" >

                                <v-row id="superiorCard">

                                    <v-card-title id="usuario-card">
                                        {{card.usuario.nome}}
                                    </v-card-title>

                                    <v-spacer></v-spacer>

                                    <!-- <v-btn
                                        class="mr-4"
                                        icon
                                        color="#ff888a"
                                        @click="deletar(card.id)"
                                        >
                                        <v-icon size="20px">
                                            mdi-delete
                                        </v-icon>

                                    </v-btn>

                                    <v-dialog
                                        v-model="dialog[card.id]"
                                        persistent
                                        max-width="500px">

                                        <template v-slot:activator="{ on, attrs }">

                                            <v-btn
                                                class="mr-4"
                                                icon
                                                color="#ff888a"
                                                v-bind="attrs"
                                                v-on="on"
                                                @click="carregarEdicao(card)">

                                                <v-icon size="20px">
                                                    mdi-pencil
                                                </v-icon>

                                            </v-btn>

                                        </template>

                                        <v-card id="publicacoes">

                                            <v-card-title>

                                                <span class="headline">
                                                Edição do post {{card.id}}
                                                </span>

                                            </v-card-title>

                                            <v-card-text>
                                                
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
                                                                v-model="editado.titulo"
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
                                                                rows="3"
                                                                row-height="15"
                                                                v-model="editado.mensagem"
                                                                label="Digite aqui a sua publicacao"
                                                            ></v-textarea>

                                                        </v-col>

                                                    </v-row>

                                                </v-col>

                                            </v-card-text>
                                            
                                            <v-card-actions>

                                                <v-spacer></v-spacer>

                                                <v-btn
                                                    color="red darken-1"
                                                    text
                                                    @click="cancelarDialog(card.id)">
                                                    Close
                                                </v-btn>



                                                <v-btn
                                                    class="mr-4"
                                                    id="botaoGeral"
                                                    color="white--text"
                                                    @click="editar(card)">
                                                    Salvar
                                                </v-btn>
                                                    

                                            </v-card-actions>

                                        </v-card>
                                        
                                    </v-dialog> -->

                                </v-row>

                                <v-card class="img-card">

                                    <v-img
                                        class="imagem"
                                        max-width="auto"

                                        :src="card.fileName"
                                        >
                                    </v-img>

                                </v-card>

                                <v-card-subtitle id="dataCriacao">
                                    {{ card.dataCriacao }}
                                </v-card-subtitle>

                                <v-card-title>
                                    {{ card.titulo }}
                                </v-card-title>

                                <v-card-subtitle>
                                    {{ card.mensagem }}
                                </v-card-subtitle>

                                <v-card-actions>

                                    <v-btn
                                        id="botoes"
                                        text>
                                        Comentários ({{card.comentarios == undefined ? 0 : card.comentarios.length }})
                                    </v-btn>

                                    <v-spacer></v-spacer>

                                    <v-btn
                                        icon
                                        @click="show = !show">

                                        <v-icon>{{ show ? 'mdi-chevron-up' : 'mdi-chevron-down' }}</v-icon>
                                    </v-btn>

                                </v-card-actions>

                                <v-expand-transition>

                                    <v-container v-show="show">

                                        <v-row class="linha-comentario"
                                            v-for="comentario in card.comentarios"
                                            :key="comentario.id">
                                            
                                            <v-col
                                                class="col-comentario"
                                                cols="12"
                                                sm="2"
                                                md="2"
                                                >
                                                <v-card-text class="nome-comentario">
                                                    {{ comentario.usuario.nome }} :
                                                </v-card-text>

                                            </v-col>

                                            <v-col
                                                class="col-comentario"
                                                cols="12"
                                                sm="7"
                                                md="7">

                                                <v-card-text class="coment-comentario">
                                                    {{ comentario.mensagem }}
                                                </v-card-text>

                                            </v-col>

                                             <v-spacer></v-spacer>

                                            <v-col
                                                class="data-comentario"
                                                cols="12"
                                                sm="2"
                                                md="2">

                                                {{comentario.dataCriacao}}

                                            </v-col>

                                            <!-- <v-col
                                                class="col-comentario"
                                                cols="12"
                                                sm="1"
                                                md="1">

                                                <v-btn
                                                    class="mr-4"
                                                    icon
                                                    color="#ff888a"
                                                    @click="deletarComentario(comentario.id)"
                                                    >
                                                    <v-icon size="15px">
                                                        mdi-delete
                                                    </v-icon>

                                                </v-btn>

                                            </v-col> -->

                                        </v-row>

                                        <v-col cols="12"> 

                                            <v-text-field
                                                hide-details="auto"
                                                outlined
                                                v-model="comentario"
                                            ></v-text-field>

                                        </v-col>

                                        <v-row>

                                            <v-spacer></v-spacer>

                                            <v-btn
                                                text
                                                id="botao-comentar"
                                                size="10px"
                                                @click="comentar(card.id)"
                                                >
                                                Comentar
                                            </v-btn>
                                        
                                        </v-row>

                                    </v-container>

                                </v-expand-transition>

                            </v-card>

                        </v-col>

                    </v-row>

                </v-container>


        </v-container>

        <Footer />

    </div>

</template>


<script>

    import PostServices from "../services/postService";
    import UsuarioService from "../services/usuarioService";
    import ComentarioService from "../services/comentarioService";
    import UploadService from "../services/UploadFilesService";
    import Header from "../components/Header";
    import Footer from "../components/Footer";

    export default {
        data: () => ({

            mostar: true,

            value: 0,

            currentFile: undefined,

            progress: 0,

            message: "",

            fileInfos: [],

            dialog: [],

            usuarioID: null,

            show: false,

            comentario: null,

            novoComentario: {
                id: null,
                mensagem: null,
                usuario: null,
                post: null,
            },

            editado: {
                titulo: null,
                mensagem: null,
            },

            post: {
                id: null,
                titulo: null,
                mensagem: null,
                usuario: {
                    nome: '',
                },
            },

            posts: [],
            comments: null,

        }),

        mounted(){
            this.show = true
            //console.log((window.location.pathname).split('/')[2])
            UsuarioService.getUsuario((window.location.pathname).split('/')[2])
                .then(resposta => {
                        //console.log(resposta.data)
                        this.post.usuario = resposta.data
                        this.usuarioID = resposta.data.id
                        this.listar()
                    })
                    .catch(() => {
                        //console.log(error)
                        this.$toast.error("Erro ao carregar usuario")
                        this.listar()
                    })
        },

        methods: {

            selectFile(file) {
                //console.log("veio")
                this.progress = 0;
                this.currentFile = file;
            },


            upload() {

                if (!this.currentFile) {
                    this.message = "Please select a file!";
                    return;
                }

                this.message = "";
                UploadService.upload(this.currentFile, (event) => {
                    this.progress = Math.round((100 * event.loaded) / event.total);
                })
                .then((response) => {
                    this.message = response.data.message;
                    return UploadService.getFiles();
                })
                .then((files) => {
                    this.fileInfos = files.data;
                })
                .catch(() => {
                    this.progress = 0;
                    this.message = "Could not upload the file!";
                    this.currentFile = undefined;
                });
            },

            submit () {
                this.post.fileName = "http://localhost:7979/files/" + this.currentFile.name
                //console.log(this.post)
                PostServices.cadastrar(this.post)
                    .then(() => {
                        //console.log(resposta.data)

                        this.message = "";
                        
                        UploadService.upload(this.currentFile, (event) => {
                            this.progress = Math.round((100 * event.loaded) / event.total);
                        })
                        .then((response) => {
                            //console.log(response.data)
                            this.message = response.data.message;
                            return UploadService.getFiles();
                        })
                        .then((files) => {
                            this.fileInfos = files.data;
                        })
                        .catch(() => {
                            this.progress = 0;
                            this.message = "Could not upload the file!";
                            this.currentFile = '';
                        });

                        this.$toast.success("Postagem realizado com sucesso")
                        this.listar()
                        this.post.titulo = ''
                        this.post.mensagem = ''
                        this.currentFile = ''
                    })
                    .catch(() => {
                        //console.log(error)
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
                            .then(() => {
                                //console.log(resposta.data)
                                //console.log("comentou")
                                this.$toast.success("Comentario realizado com sucesso")
                                this.comentario = ''
                                this.novoComentario.mensagem = ''
                                this.listar()
                            })
                            .catch(() => {
                                //console.log(error)
                                this.$toast.error("Erro ao realizar comentario")
                            })
                    })
                    .catch(() => {
                        //console.log(error)
                        this.$toast.error("Erro ao carregar post para comentar")
                    })
            },
            
            listar(){
                PostServices.listar()
                    .then( resposta => {
                        this.posts = resposta.data
                        
                        for (const key in this.posts) {
                            //console.log("KEY", key)
                            if (Object.hasOwnProperty.call(this.posts, key)) {
                                //console.log("id", this.posts[key].id)
                                ComentarioService.listarPorPostagem(this.posts[key].id)
                                    .then ( resposta => {
                                        this.posts[key].comentarios = resposta.data
                                    })
                                    .catch(() => {
                                        //console.log("ERROWWW", error)
                                        this.$toast.error("Erro ao carregar comentarios")
                                    })


                            }
                        }
                        this.show = false
                        //console.log(this.posts)
                        this.novoComentario.mensagem = ''
                        this.$toast.success("Sucesso ao carregar postagens")
                    })
                    .catch(() => {
                        //console.log("AAUIAUIAS", error)
                        this.$toast.error("Erro ao carregar postagens")
                    })

            },

            editar(post) {
                post.titulo = this.editado.titulo
                post.mensagem = this.editado.mensagem
                //console.log("editado post: ", post)
                
                PostServices.editar(post, post.id)
                    .then ( () => {
                        //console.log(resposta.data)
                        this.$toast.success("Postagem editada com sucesso")
                        this.dialog = []
                        this.listar()
                    })
                    .catch(() => {
                        //console.log("ERROWWW", error)
                        this.$toast.error("Erro ao editar postagem")
                    })


            },

            carregarEdicao(post) {
                this.editado.titulo = post.titulo
                this.editado.mensagem = post.mensagem
                // console.log(this.editado.titulo)
                // console.log(this.editado.mensagem)
            },

            deletar(id){

                PostServices.deletar(id)
                    .then ( () => {
                        //console.log(resposta.data)
                        this.$toast.success("Sucesso ao deletar postagem")
                        this.listar()
                    })
                    .catch(() => {
                        //console.log(error.data)
                        this.$toast.error("Erro ao deletar postagem")
                    })
            },

            deletarComentario(id){
                
                ComentarioService.deletar(id)
                    .then ( () => {
                        this.$toast.success("Sucesso ao deletar comentario")
                        this.listar()
                    })
                    .catch(() => {
                        //console.log(error.data)
                        this.$toast.error("Erro ao deletar comentario")
                    })
            },

            cancelarDialog() {

                this.dialog = []

            }
            
        },
        components: {
            Header,
            Footer,
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
        background-color: #ff888a !important;
        color: #f3f3f3;
    }

    .img-card {
        min-height: 100px;
        padding: 10px;
        margin: 10px
    }

    .v-image__image.v-image__image--cover{
        height: 100%;
    }

    .v-card__text.username {
        font-weight: bolder;
        font-size: 15px
    }

    .linha-comentario {
        margin: 0px !important;
        padding: 0px !important;
        border-top: 0.1px solid !important;
    }

    .col-comentario {
        margin: 0px !important;
        padding: 0px !important;
    }
    .v-card__text {
        margin: 5px !important;
        padding: 5px !important;
    }
    .nome-comentario {
        color: #f3f3f3;
        padding-right: 10px !important;
        text-align: end !important;
        text-transform: capitalize !important;
        font-weight: bolder !important;
        font-size: 20px !important;
    }

    .coment-comentario {
        text-align: start !important;
        font-size: 15px !important;
    }

    .v-card.v-sheet.theme--light{
        overflow-x: hidden !important;
    }

    #container{
        padding: 0px;
        margin: 0px; 
    }

    #usuario-card{
        text-transform: capitalize;
        padding-left: 50px ;
        font-size: 20px !important;
    }

    .v-card__title{
        padding-top: 0px;
        font-size: 25px !important;
        font-weight: bolder !important;
    }

    .v-card__subtitle{
        text-align: center;
        color: white !important;

    }

    #superiorCard{
        display: flex;
        align-items: center;
        margin: 0px;
        max-height: 50px;

    }

    #dataCriacao{
        font-size: 10px;
        margin: 0px;
        padding: 0px;
        text-align: end;
        padding-right: 15px;
    }

    .data-comentario {
        text-align: end !important;
        font-size: 8px !important;
    }

    .botoes{
        color: #ff888a;
    }

    #botoes{
        color: #ff888a;

    }

    #botaoGeral{
        background-color: #ff888a !important;
    }

    #publicacoes{
        color: #f3f3f3 !important;
        background-color: #7b7979;
        border: 2px solid #a9a7a7;  

    }

    .v-application.primary--text{
        caret-color: #ff888a !important;
    }

    .v-input.v-input--hide-details.v-input--is-focused{
        color: #ff888a !important;
        caret-color: #ff888a !important;
    }

    .theme--light.v-input, .theme--light.v-input input, .theme--light.v-input textarea{
        color: #f3f3f3 !important;
    }

    .v-text-field--outlined>.v-input__control>.v-input__slot{
        background-color: #a9a7a7 !important;
    }

    .v-expansion-panel.v-expansion-panel--active.v-item--active{
        background-color: #a9a7a7 !important;
        color: #f3f3f3 !important;
    }
    .v-expansion-panel-header{
        background-color: #a9a7a7 !important;
        color: #f3f3f3 !important;
    }
    .v-expansion-panel-header.v-expansion-panel-header--active{
                background-color: #7b7979 !important;

    }
</style>