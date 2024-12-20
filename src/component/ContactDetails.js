import React from "react";
import Contact from "./Contact";



function ContactDetails({data}){    
    return(
        <>   
            <div className="container">
                <table className="table table-striped table-bordered table-hover">
                 <thead>
                    <tr>
                         <th>#</th>
                         <th>Name</th>
                         <th>Email Address</th>
                         <th>Phone Number</th>
                         <th>Type</th>                            
                    </tr>
                 </thead>  
                 <tbody>
                        <Contact contact={data} />                                 
                </tbody>
                </table>
            </div>                          
           </>
    );    
};


export default  ContactDetails;