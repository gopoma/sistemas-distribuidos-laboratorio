const myService = {
    MyService: {
        MyPort: {
            MyFunction: function (args) {
                return new Promise((resolve, reject) => {
                    setTimeout(() => {
                        const result = {
                            name: args.name,
                            user: {
                                email: 'gordono@unsa.edu.pe',
                                role: 'admin'
                            }
                        };

                        return resolve(result);
                    }, 1000);
                });
            },

            Sum: function(args) {
                console.log({args});
                const {a, b} = args;

                return { result: Number.parseInt(a) + Number.parseInt(b) };
            }
        }
    }
};



const path = require('path');
const express = require('express');
const bodyParser = require('body-parser');
const soap = require('soap');

console.log('env', process.env.NODE_ENV);



const app = express();

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
