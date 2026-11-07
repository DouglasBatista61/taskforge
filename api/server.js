const http = require("http");

const fs = require("fs");

const path = require("path");



http.createServer((req, res) => {

    const nome = req.url === "/" ? "/teste-cors.html" : req.url.split("?")[0];

    fs.readFile(path.join(__dirname, decodeURIComponent(nome)), (err, data) => {

        if (err) { res.writeHead(404); res.end("nao encontrado"); return; }

        res.end(data);

    });

}).listen(5173, () => console.log("Abra: http://localhost:5173/teste-cors.html"));




