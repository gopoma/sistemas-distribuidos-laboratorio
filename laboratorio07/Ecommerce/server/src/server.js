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

const express = require('express');
const bodyParser = require('body-parser');
const soap = require('soap');

const xml = require('fs').readFileSync('myservice.wsdl', 'utf8');

//express server example
const app = express();

//body parser middleware are supported (optional)
app.use(bodyParser.raw({type: function(){return true;}, limit: '5mb'}));

app.listen(8000, function(){
    //Note: /wsdl route will be handled by soap module
    //and all other routes & middleware will continue to work
    soap.listen(app, '/wsdl', myService, xml, function(){
      console.log('server initialized');
    });
});
