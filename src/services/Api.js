import axios from 'axios';

//api de conexão com os microserviços
const Api = axios.create({
    baseURL: 'https://conectagraxa-backend.onrender.com',
})

export default Api;