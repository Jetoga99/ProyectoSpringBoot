var btn = document.getElementById("btn_submit");
var Email_Warning = document.getElementById("EmailWarn");
let temp = [];
let cont = 0;
let flag = true;




class user {
  Name = "";
  Email = "";
  Phone = "";
  User_password = "";
  static total = 0;
  id = 0;
  constructor(Name, Phone, Email, User_password) {
    this.Name = Name.toUpperCase();
    this.Phone = Phone;
    this.Email = Email.toLowerCase();
    this.User_password = User_password;
    this.id = user.total;
    user.total++;
  }//constructor

}



btn.addEventListener("click", async function (e) {
  e.preventDefault();
  let password1 = document.getElementById("inputPassword1").value;
  let password2 = document.getElementById("inputPassword2").value;
  let FullName = document.getElementById("inputName").value;
  let phoneNumber = document.getElementById("phoneNumber").value;
	let Email = document.getElementById("inputEmail").value;


  // parte de validacion de datos 
  if (!ValidateName(FullName)) {  //if de validacion de nombre
    document.getElementById("nameAlert").style.display = "block";
    document.getElementById("nameAlert").innerHTML = `<div class="alert alert-danger" role="alert">
    ¡Ingrese su nombre completo por favor!
  </div>`;
    console.log(document.getElementById("inputName").style.borderColor);
    document.getElementById("inputName").style.borderColor = "#FF0000";

  }//fin de if validación de nombre 

  // Código de valores por default por el evento change 
  document.getElementById("inputName").addEventListener("change", function () {
    document.getElementById("inputName").style.borderColor = "";
    document.getElementById("nameAlert").style.display = "none";
  })




  if (!(ValidateNumber(phoneNumber))) {// if de validacion para numero de telefono 
    document.getElementById("PhoneAlert").style.display = "block";
    document.getElementById("PhoneAlert").innerHTML = `<div class="alert alert-danger" role="alert">
    ¡Ingrese su número de teléfono a 10 dígitos sin espacios!
  </div>`;
    console.log("por favor ingrese su numero de telefono a 10 digitos");
    console.log(document.getElementById("phoneNumber").style.borderColor);
    document.getElementById("phoneNumber").style.borderColor = "#FF0000";
    usr_number = 0;


  }//fin de if validación de número de teléfono.
  //Código de des alerta por mal ingreso de dato de número de teléfono
  document.getElementById("phoneNumber").addEventListener("change", function () {
    document.getElementById("phoneNumber").style.borderColor = "";
    document.getElementById("PhoneAlert").style.display = "none";
  })




  if (!ValidateEmail(Email)) {   //validación del correo electrónico 
    Email_Warning.style.display = "block";
    Email_Warning.innerHTML = `<div class="alert alert-danger" role="alert">
    ¡Ingrese un correo electrónico valido ejemplo (nombre@dominio.com)!
  </div>`;
    console.log(document.getElementById("inputEmail").style.borderColor);
    document.getElementById("inputEmail").style.borderColor = "#FF0000";

  }
  document.getElementById("inputEmail").addEventListener("change", function () {
    document.getElementById("inputEmail").style.borderColor = "";
    Email_Warning.style.display = "none";
  })


  //validación de contraseñas 

  if (!ValidatePasswords(password1, password2)) {
    document.getElementById("passwordAlert").style.display = "block";
    document.getElementById("passwordAlert").innerHTML = `<div class="alert alert-danger" role="alert">
    Las contraseñas deben coincidir y debe contener al menos 8 caracteres alfanumérico, sin espacios.
  </div>`;
    document.getElementById("inputPassword1").style.borderColor = "#FF0000";
    document.getElementById("inputPassword2").style.borderColor = "#FF0000";

  }
  document.getElementById("inputPassword1").addEventListener("change", function () {
    document.getElementById("inputPassword2").style.borderColor = "";
    document.getElementById("inputPassword1").style.borderColor = "";
    document.getElementById("passwordAlert").style.display = "none";

  })
  document.getElementById("inputPassword2").addEventListener("change", function () {
    document.getElementById("inputPassword2").style.borderColor = "";
    document.getElementById("inputPassword1").style.borderColor = "";
    document.getElementById("passwordAlert").style.display = "none";

  })
  
  
  const data = { email: Email,contraseña:null};
 fetch('/api/iniciar_sesion/', 
		{		
				  method: 'PUT', // or 'PUT'
				  headers: {
				    'Content-Type': 'application/json',
				  },
				  body: JSON.stringify(data),
				})
				  .then((response) => response.json())
				   .catch((error) => {
				    console.error('Error:', error);
				  })
				  .then( (data) => {
					console.log('success', data)
					if(data.email!=null)
					{	
					
					Swal.fire({
			            title: 'El correo ingresado ya existe, ¿desea iniciar sesión?',
			            icon: 'question',
			            iconHtml: '¿?',
			            confirmButtonText: `<a href="/pages/iniciarsesion.html">Iniciar sesión </a>`,
			            cancelButtonText: 'Cancelar',
			            showCancelButton: true,
			            showCloseButton: true,
			            isClicked: false,
			            focusConfirm: true
			    	      })  
			    	       
			    	 
			    	      }else{
						if (((ValidateName(FullName))) && ((ValidateNumber(phoneNumber))) && ((ValidateEmail(Email))) &&
		 					  ((ValidatePasswords(password1, password2)))) {//valida que toda las condiciones han sido respetadas y procede a cargar el archivo json
		       					const spaces1 = FullName.split(' ').length - 1;
		      						 let nombre1=null;
		      					 let apellido1=null;
							      					 const words = FullName.split(' ');
									if(spaces1==3){
										 nombre1=words[0].concat(' ',words[1]);
										 apellido1= words[2].concat(' ',words[3]);
									}else if(spaces1==2){
										 nombre1=words[0];
										 apellido1= words[1].concat(' ',words[2]);
									}else if(spaces1==1){
										 nombre1=words[0];
										 apellido1= words[1];
									}else if(spaces1==0){
										 nombre1=words[0];
										 apellido1= null;
									}
									
							       console.log("este es :" +nombre1);
							       
							  	const data = {proyecto_Id:1 , tipo_desarrollador: 1 , apellidos: apellido1,contraseña: password1,nombre:nombre1 ,email:Email};
										 fetch('/api/desarrollador/', {
											  method: 'POST', // or 'PUT'
											  headers: {
											    'Content-Type': 'application/json',
											    'Authorization': 'Bearer: ' + localStorage.getItem("Token")
									  },
									  body: JSON.stringify(data),
									})
									  .then((response) => response.json())
									  .then((data) => {
										console.log('Success:', data);
										  Swal.fire({
									      position: 'center',
									      icon: 'success',
									      title: '¡Tus datos han sido guardados exitosamente¡',
									      showConfirmButton: false,
									      timer: 1500
							    })
										
										
										
									  })
									  .catch((error) => {
									    console.error('Error:', error);
									  });  
									
						    document.getElementById("inputEmail").value = "";
						    document.getElementById("inputName").value = "";
						    document.getElementById("phoneNumber").value = "";
						    document.getElementById("inputPassword2").value = "";
						    document.getElementById("inputPassword1").value = "";
			
  						}//if validacion general
				
				
			}
			    	     
						 
		});
  
  

  
			
			



});



function ValidateEmail(usr_email) {
	
   var regx = /^([a-zA-Z0-9-.-_]+)@([a-zA-Z0-9]+)[.]([a-z]+)(.[a-z]+)?$/;
	  if (usr_email.match(regx)) {				  
			console.log("fine!")  
			return true;	  
	  } else {//if de match
	    return false;

  }				  

}

function ValidateName(name) {
  let regx = /^([a-zA-Z\_.é]+)([a-zA-Zá-ú ]+)([a-zA-Zá-ú ])?$/;
  if ((name.match(regx)) && (name.length >= 3)) {
    return true;

  } else {

    return false;

  }

}


function ValidateNumber(number) {

  let regx = /^([1-9-0]+)([1-9])?$/;


  if ((number.match(regx)) && (number.length == 10)) {

    return true;

  } else {

    return false;

  }

};

function ValidatePasswords(password1, password2) {

  var regx = /^([a-zA-Z0-9]+)([a-zA-Z0-9])?$/;

  if ((password1.match(regx)) && (password1.length >= 8) && (password2 === password1) && (password2.match(regx)) && (password2.length >= 8)) {
    return true;

  } else {
    return false;

  }

};
