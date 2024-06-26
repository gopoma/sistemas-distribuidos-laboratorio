import { useEffect, useState } from 'react';
import { xml2js } from 'xml-js';

const backendURL = 'http://localhost:8000/wsdl?wsdl';
//? const backendURL = 'https://sistemas-distribuidos-laboratorio.onrender.com/wsdl?wsdl';

function App() {
  const [products, setProducts] = useState([]);

  async function init() {
    function parseSOAPResponse(xmlString) {
      const options = {
        compact: true,
        ignoreAttributes: true,
        ignoreComment: true,
        ignoreDeclaration: true,
        ignoreInstruction: true,
        ignoreCdata: true,
      };

      const result = xml2js(xmlString, options);

      // Extract data from the parsed XML
      const soapBody = result['soap:Envelope']['soap:Body'];
      const responseData = soapBody['tns:GetProductsResponse'];

      // Convert products to an array if multiple products are returned
      const productList = [];
      for (const k of Object.keys(responseData)) {
        productList.push(responseData[k]);
      }

      // Extract relevant fields from each product
      const parsedProducts = productList.map(product => ({
        id: product.id._text,
        name: product.name._text,
        price: parseFloat(product.price._text),
        stock: parseInt(product.stock._text),
        description: product.description._text,
        image: product.image._text,
        stars: parseFloat(product.stars._text),
      }));

      return parsedProducts;
    }

    const soapEnvelope = `
      <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:web="http://yourwebserviceurl.com">
        <soapenv:Header/>
        <soapenv:Body>
          <web:GetProducts/>
        </soapenv:Body>
      </soapenv:Envelope>
    `;

    const response = await fetch(backendURL, {
      method: 'POST',
      headers: {
        'Content-Type': 'text/xml;charset=UTF-8',
      },
      body: soapEnvelope,
    });
    const xmlStr = await response.text();
    const products = parseSOAPResponse(xmlStr);

    console.log(products);
    setProducts(products);
  }

  useEffect(() => {
    init();
  }, []);

  return (
    <section className="h-screen bg-slate-100 p-4">
      <h1 className='text-4xl font-bold text-center'>
        Ecommerce
      </h1>
      <section className="grid xl:grid-cols-3 lg:grid-cols-2 md:grid-cols-1">
        {
          products.map(product => (
            <article key={product.id} className="py-6">
              <div className="flex max-w-md bg-white shadow-lg rounded-lg overflow-hidden">
                <div className="w-1/3 bg-cover">
                  <img className="w-full h-full" src={product.image}/>
                </div>
                <div className="w-2/3 p-4">
                  <h1 className="text-gray-900 font-bold text-2xl">{product.name}</h1>
                  <p className="mt-2 text-gray-600 text-sm">{product.description}</p>
                  <div className="flex item-center mt-2">
                    {Array.from({ length: product.stars }, (_, index) => (
                      <svg className="w-5 h-5 fill-current text-yellow-400" viewBox="0 0 24 24">
                        <path d="M12 17.27L18.18 21L16.54 13.97L22 9.24L14.81 8.63L12 2L9.19 8.63L2 9.24L7.46 13.97L5.82 21L12 17.27Z" />
                      </svg>
                    ))}
                    {Array.from({ length: 5 - product.stars }, (_, index) => (
                      <svg className="w-5 h-5 fill-current text-gray-500" viewBox="0 0 24 24">
                        <path d="M12 17.27L18.18 21L16.54 13.97L22 9.24L14.81 8.63L12 2L9.19 8.63L2 9.24L7.46 13.97L5.82 21L12 17.27Z" />
                      </svg>
                    ))}
                  </div>
                  <div className="flex item-center justify-between mt-3">
                    <h1 className="text-gray-700 font-bold text-xl">S/. {product.price.toFixed(2)}</h1>
                    <button className="px-3 py-2 bg-gray-800 text-white text-xs font-bold uppercase rounded">Add to Cart</button>
                  </div>
                </div>
              </div>
            </article>
          ))
        }
      </section>
    </section>
  )
}

export default App
