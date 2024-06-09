const soap = require('soap');

//? const backendURL = 'http://localhost:8000/wsdl?wsdl';
const backendURL = 'https://sistemas-distribuidos-laboratorio.onrender.com/wsdl?wsdl';

async function main() {
    try {
        const client = await soap.createClientAsync(backendURL);

        const products = await client.GetProductsAsync();
        console.log(products);
    } catch(error) {
        console.log('Error', error);
    }
}; main();
