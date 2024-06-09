const soap = require('soap');

const url = 'http://localhost:8000/wsdl?wsdl';

async function main() {
    try {
        const client = await soap.createClientAsync(url);
//?        client.MyFunction({name:'value', val:'xd'}, function(error, result) {
//?            if(error) {
//?                console.log('Error', error);
//?            } else {
//?                console.log('Result', result);
//?            }
//?        });
        const [result] = await client.MyFunctionAsync({name:'value'});
        console.log({result});

        const [result2] = await client.SumAsync({a: '3', b: '4'});
        console.log({result2});
    } catch(error) {
        console.log('Error', error);
    }
}; main();
