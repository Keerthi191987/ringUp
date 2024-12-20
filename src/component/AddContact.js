import { useState } from 'react';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import { saveContacts } from '../api/contactService';

function AddContact({loadFlag}) {
  const [flag,setFlag]=useState(false);

  const [show, setShow] = useState(false);
  const handleClose = () => setShow(false);
  const handleShow = () => setShow(true);
  const [formData, setFormData] = useState({
    contactName: "",  email: "", contactNumber: "", contactType: "" });  
  const [formStatus, setFormStatus] = useState("");

  const handleChange=(e)=>{
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  }

  const handleSubmit = async (e) => {  
    e.preventDefault();   
    if (formData?.contactName && formData?.email && formData?.contactNumber && formData?.contactType ) {      
      setFlag(true);   
      setFormStatus("Registration successful!");  
        await saveContacts(formData); 
        setShow(false); 
        loadFlag={flag};
             
    } else {       
      setFormStatus("Please fill in all fields.");
    }
  }


  return (
    <>
      <Button variant="primary" type="button" class="btn btn-primary" onClick={handleShow}>
      Add Contact
      </Button>

      <Modal show={show} onHide={handleClose}>
      <form onSubmit={handleSubmit}>  
        <Modal.Header closeButton>
          <Modal.Title>Add  Contact</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        {formStatus && <div className="status alert-danger">{formStatus}</div>}
                              
                     <div data-mdb-input-init class="form-outline mb-2">
                        <label class="form-label" for="name2">Name</label>
                        <input type="text" name="contactName"
                        value={formData.contactName}
                        onChange={handleChange}
                        required class="form-control" />                         
                     </div>
 
                    
                     <div data-mdb-input-init class="form-outline mb-2">                        
                         <label class="form-label" for="email2">Email address</label>
                         <input type="email" name="email" value={formData.email}
                            onChange={handleChange} class="form-control" />
                     </div>
 
                    
                     <div data-mdb-input-init class="form-outline mb-2">
                        <label class="form-label" for="password2">Phone Number</label>
                         <input type="number" name="contactNumber"  value={formData.contactNumber}
                        onChange={handleChange} class="form-control" />
                         
                     </div>                     
 
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="contactType" value="Fan"
                        onChange={handleChange} />
                        <label class="form-check-label" >Fam</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="contactType" value="BFF"
                        onChange={handleChange} />
                        <label class="form-check-label" >BFF</label>
                    </div>
                    <div class="form-check form-check-inline">
                        <input class="form-check-input" type="radio" name="contactType"  value="Org" 
                        onChange={handleChange} />
                        <label class="form-check-label">Org</label>
                    </div>                   
                
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleClose}>
            Close
          </Button>
          <Button variant="primary" type="submit">
            Save Changes
          </Button>
        </Modal.Footer>
        </form>
      </Modal>
    </>
  );
}

export default AddContact;