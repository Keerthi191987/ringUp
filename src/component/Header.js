import React, { useEffect, useState } from "react";
import AddContact from "./AddContact";


function Header({count}){

    const [loadFlag,setLoadFlag]=useState(false);

useEffect(()=>{
    setLoadFlag(loadFlag);
   // addContactDetails();
},[loadFlag])
  
    return (
        <>
        <div>
            <nav className="navbar bg-body-tertiary">
                <div className="container-fluid">
                    <span className="navbar-brand mb-0 h1">RingUp</span>
                </div>
            </nav>
            <div className="container p-2">
            <div class="row">
                    <div class="col">
                        <h6>Contacts <span class="badge text-bg-secondary">Total : {count}</span></h6>
                    </div>
                    <div class="col text-right float-end text-end">
                    <div class="row">
                        <div class="col-8">
                        <div class="input-group ">
                             <input type="text" class="form-control" aria-label="Text input with dropdown button" />                            
                            <button class="btn btn-outline-secondary dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="false">Search By</button>
                            <ul class="dropdown-menu dropdown-menu-end">
                                <li><a class="dropdown-item" href="#">User Name</a></li>
                                <li><a class="dropdown-item" href="#">Phone Number</a></li>                                
                            </ul>                                
                            </div>
                        </div>
                        <div class="col-4">
                            <AddContact loadFlag={loadFlag} />
                        </div>
                       </div>    
                    </div>
            </div>                   
            </div>    
      </div> 
  </>  
    );
}

export default Header;