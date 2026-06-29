const express = require('express');
const multer = require('multer');
const path = require('path');
const cors = require('cors');

const app = express();

// Libera o CORS para o seu HTML que roda localmente no navegador
app.use(cors({
  origin: '*', 
  methods: ['POST']
}));

// Configuração de onde o arquivo físico do Kimono será copiado
const storage = multer.diskStorage({
  destination: function (req, file, cb) {
    // AJUSTE AQUI: Coloque o caminho real para a pasta de imagens do seu front-end.
    // Pode ser um caminho absoluto do Linux, por exemplo: '/home/seu-usuario/projetos/uai-kimonos/imagens/'
    // Ou um caminho relativo baseado em onde este server.js está rodando, ex: './imagens/'
    cb(null, '/home/lucas/Documentos/programacao/java/springboot/sitedevendaquimono/src/main/resources/static/imagens'); 
  },
  filename: function (req, file, cb) {
    // Mantém o nome original do arquivo (ex: kimonoazul.png)
    cb(null, file.originalname); 
  }
});

const upload = multer({ storage: storage });

// Rota que o seu formulário vai chamar para fazer o upload físico do arquivo para o seu HD
app.post('/duplicar', upload.single('foto'), (req, res) => {
  res.status(200).json({ status: "sucesso", mensagem: "Imagem duplicada no Linux!" });
});

app.listen(3000, () => {
  console.log('🚀 Copiador de Imagens rodando na porta 3000 no Linux.');
});