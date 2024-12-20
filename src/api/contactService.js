import axios  from "axios";

const api_url="http://localhost:2019/api/v1/contact";


export async function getContacts(){
    return await axios.get(`${api_url}/getContacts`).then((response) => response)
    .catch((error) => console.error(error))
} 

export async function saveContacts(contactPayLoad){    
    return await axios.post(`${api_url}/addContact`,contactPayLoad).then((response) => response)
    .catch((error) => console.error(error));
} 
