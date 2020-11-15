module.exports = {

    "devServer": {
      "proxy": "http://localhost:7979"
    },
    
    "lintOnSave": false,

    "runtimeCompiler": true,

    "publicPath": process.env.NODE_ENV === 'production' ? '/agenda/' : '/',

    "outputDir": "../backend/src/main/resources/static"
  }