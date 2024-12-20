import React from "react";


function Contact({contact}){    
   return(
    <>
    {contact?.data?.length === 0 && <tr>No Data Found . Please Insert new Contact</tr>}
    {contact?.data?.length > 0 && contact?.data?.map((contacts,index) => {                                  
        return(        
          <tr key={contacts?.contactId}>
                <td key={contacts?.contactId}>{index+1}</td>
                <td>{contacts?.contactName}</td>
                <td>{contacts?.email}</td>
                <td>{contacts?.contactNumber}</td>
                <td>{contacts?.contactType}</td>
            </tr>  
        ) 
    })
   
    
}
</>
)
}


export default  Contact;