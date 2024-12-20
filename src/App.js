import React, { useEffect } from "react";
import { useState } from "react";
import { getContacts } from "./api/contactService";
import ContactDetails from "./component/ContactDetails";
import Header from "./component/Header";


function App() {
  const [data,setData] =useState([]);
  
  const getContactsDetails=async () =>{
    try {
     const response= await getContacts();     
     setData(response);    
    } catch (error) {
      console.log(error);
    }   
  }

useEffect(()=>{
  getContactsDetails();  
},[])

  return (
    <div className="App">
        <Header count={data?.data?.length} />            
        <ContactDetails data={data}  />                   
    </div>
  );
}

export default App;
