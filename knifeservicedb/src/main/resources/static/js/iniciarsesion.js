
var btn = document.getElementById("btn_submit");
var Email_Warning = document.getElementById("EmailWarn");



let emails = [];
let passwords = [];
let flag =false;

btn.addEventListener("click", function (e) {
    e.preventDefault();
    let email = document.getElementById("inputEmail").value;
    let pw = document.getElementById("inputPassword1").value;
    if (!validateEmail(email)) {   //validación del correo electrónico 
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
    });

    if (!ValidatePassword(pw)) {
        document.getElementById("passwordAlert").style.display = "block";
        document.getElementById("passwordAlert").innerHTML = `<div class="alert alert-danger" role="alert">
        Las contraseñas deben coincidir y debe contener al menos 8 caracteres alfanumérico, sin espacios.
      </div>`;
        document.getElementById("inputPassword1").style.borderColor = "#FF0000";

    }
    document.getElementById("inputPassword1").addEventListener("change", function () {
        document.getElementById("inputPassword1").style.borderColor = "";
        document.getElementById("passwordAlert").style.display = "none";

    });


    if (validateEmail(email) && (ValidatePassword(pw))) {
        /*for (var i = 0, len = localStorage.length; i < len; ++i) {
            emails.push(JSON.parse(localStorage.getItem(localStorage.key(0)))["Email"]);
            passwords.push(JSON.parse(localStorage.getItem(localStorage.key(0)))["User_password"]);
        }*/
      /*  if (!emails.includes(email)) {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: '¡El correo no existe¡',
                showConfirmButton: false,
                timer: 2500
            })
        }*/
       /* else if ((emails.includes(email)) && (!passwords.includes(pw))) {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: '¡La contraseña es incorrecta¡',
                showConfirmButton: false,
                timer: 2500
            })
        }*/
       /*if ((emails.indexOf(email) == passwords.indexOf(pw)) && (emails.includes(email) && passwords.includes(pw))) {*/
          //  let name = JSON.parse(localStorage.getItem(localStorage.key(0)))["Name"];
			//const url= new URL('http://localhost:8080/api/iniciar_sesion/');
			
			//const params = new URLSearchParams(url.search);
			//params.append('Email', email);
			//params.append('Contraseña', pw);
			//params.toString();	
			//const new_url=	(`${url.origin}${url.pathname}?${params}`)
			let data={email:email, contraseña:pw};
			fetch('/api/iniciar_sesion/', {
				  method: 'POST', // or 'PUT'
				  headers: {
				    'Content-Type': 'application/json',
				  },
					     body: JSON.stringify(data),
				}).then((response) => response.json())
				  .catch((error) => {
				    console.error('Error:', error);
				  }).then((data) => {
				   if(data.accessToken!=null)
				    {
					 localStorage.setItem("Token", data.accessToken)
					sessionStorage.setItem('status', 'loggedIn');
				    Swal.fire({
                position: 'center',
                icon: 'success',
                title: '¡Has ingresado correctamente ' + email + '¡',
                showConfirmButton: false,
                timer: 2500
            		}).then(function () {
                	window.location.href = "../index.html";
            			})
						}else{
							  Swal.fire({
                position: 'center',
                icon: 'error',
                title: '¡Usuario o Contraseña Incorrectos¡',
                showConfirmButton: false,
                timer: 2500
            })
						}
				   
				  });
				  
				  
				  
				  //alert de login exitoso
				
		
        //}


    }
});

function validateEmail(valor) {


    // Define our regular expression.
    var validEmail = /^\w+([.-_+]?\w+)*@\w+([.-]?\w+)*(\.\w{2,10})+$/;

    // Using test we can check if the text match the pattern
    if (validEmail.test(valor) && (valor.length > 0)) {
        return true;
    } else {
        return false;
    }
}
function ValidatePassword(valor) {

    var regx = /^([a-zA-Z0-9]+)([a-zA-Z0-9])?$/;

    if ((valor.match(regx))) {
        return true;

    } else {

        return false;

    }

};
function sleep(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
};