const soap = require('soap');

//? const backendURL = 'http://localhost:8000/wsdl?wsdl';
const backendURL = 'https://sistemas-distribuidos-laboratorio.onrender.com/wsdl?wsdl';

async function main() {
    try {
        const client = await soap.createClientAsync(backendURL);

        const [result] = await client.MyFunctionAsync({name:'value'});
        console.log({result});

        const [result2] = await client.SumAsync({a: '3', b: '4'});
        console.log({result2});
    } catch(error) {
        console.log('Error', error);
    }
}; main();
