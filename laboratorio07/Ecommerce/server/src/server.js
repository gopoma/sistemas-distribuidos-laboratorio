const products = [
    {
        id: 1,
        name: "Lapiceros",
        price: 0.80,
        stock: 100,
        description: "Lapiceros de alta calidad disponibles en varios colores, perfectos para tareas de escritura diaria.",
        image: "https://minisope.vtexassets.com/arquivos/ids/185695-800-800?v=637819474442270000&width=800&height=800&aspect=true",
        stars: 3,
    },
    {
        id: 2,
        name: "Cuadernos",
        price: 3.40,
        stock: 40,
        description: "Cuadernos duraderos con 100 páginas rayadas, ideales para la escuela, la oficina y el uso personal.",
        image: "https://lh6.googleusercontent.com/proxy/lWAMNYhg0i6tOLoDWcm6BSlQCe5kQMzSg2egqk00a_3wY4gLUafp1osIzMTeBq9nskylHAKOYBK2tKjQV5XgAm2bJ6hjahrnR0p0wAPzISNc8XY3CSOr2Bklk4yVko-shK-0C8I",
        stars: 5,
    },
    {
        id: 3,
        name: "Hojas Bond",
        price: 10.50,
        stock: 75,
        description: "Una resma de 500 hojas de papel bond premium, adecuada para impresión y fotocopiado.",
        image: "https://offi.pe/image/catalog/PRODUCTOS/PAPELERIA/PAPEL%20IMPRESORA%20FOTOCOPIA/Papel%20impresora/papel-bond-a4-80gramos-report.png",
        stars: 4,
    },
];



const myService = {
    MyService: {
        MyPort: {
            GetProducts: async function(args) {
                return products;
            },
        }
    }
};



const path = require('path');
const express = require('express');
const bodyParser = require('body-parser');
const soap = require('soap');
const cors = require('cors');

console.log('env', process.env.NODE_ENV);



const app = express();

app.use(cors());
app.use(bodyParser.raw({type: function(){return true;}, limit: '5mb'}));

app.get("/", (request, response) => {
    return response.json({
        name: "Ecommerce",
        version: "1.0.0"
    });
});

app.get("/docs", (request, response) => {
    response.setHeader('Content-Disposition', 'inline');
    response.setHeader('Content-Type', 'text/xml');

    if(process.env.NODE_ENV === 'production') {
        return response.sendFile(path.join(__dirname, '/myservice-prod.wsdl'));
    } else {
        return response.sendFile(path.join(__dirname, '/myservice-dev.wsdl'));
    }
});



let xml = null;
if(process.env.NODE_ENV === 'production') {
    xml = require('fs').readFileSync(path.join(__dirname, '/myservice-prod.wsdl'), 'utf8');
} else {
    xml = require('fs').readFileSync(path.join(__dirname, '/myservice-dev.wsdl'), 'utf8');
}

app.listen(8000, function(){
    //Note: /wsdl route will be handled by soap module
    //and all other routes & middleware will continue to work
    soap.listen(app, '/wsdl', myService, xml, function(){
      console.log('server initialized');
    });
});
