let btnQuote = document.getElementById("submit_btn");
const form = document.getElementById("subscribe");
const div_base = document.getElementsByClassName("input-group ");
let key = "informacion_contacto";
let cont = 0;
let usuarios = [];


if (localStorage.key(0)) {
    for (let index = 0; index < localStorage.length; index++) {
        if ((localStorage.key(index)) == 'informacion_contacto') {
            usuarios = JSON.parse(localStorage.getItem(key));
            usuarios.forEach((element) => {
                cont = element.usr_id;
            });
            console.log(cont);
            cont++;
            console.log(usuarios);
            break;
        }//fin if del localstorage
    }//fin ciclo for 
} //fin condicion if 



btnQuote.addEventListener("click", function (e) {  //comando de ejecucion de boton
    e.preventDefault();
    let usr_name = document.getElementById("Nombre").value;
    let usr_number = document.getElementById("Number").value;
    var usr_email = document.getElementById("email").value;
    let mensaje = document.getElementById("message_1").value;

    if (!(ValidateMessage(mensaje))) {
        document.getElementById("AlertMessage").style.display = "block";
        document.getElementById("AlertMessage").innerHTML = `<div style="color:red" role="alert">
    ¡comente sus dudas sin espacios innecesarios mayor a 15 letras!
  </div>`;
        console.log(document.getElementById("message_1").style.borderColor);
        document.getElementById("message_1").style.borderColor = "#FF0000";
    }

    document.getElementById("message_1").addEventListener("change", function () {
        document.getElementById("message_1").style.borderColor = "";
        document.getElementById("AlertMessage").style.display = "none";

    })



    //validacion de numero telefonico y correo electronico
    if (!(ValidateNumber(usr_number))) {// if de validacion para numero de telefono 
        document.getElementById("AlertMessage").style.display = "block";
        document.getElementById("AlertMessage").innerHTML = `<div style="color:red" role="alert">
    ¡Ingrese su contacto telefónico a 10 dígitos!
  </div>`;
        console.log(document.getElementById("Number").style.borderColor);
        document.getElementById("Number").style.borderColor = "#FF0000";


    }//fin de if validación de número de teléfono.
    //Código de des alerta por mal ingreso de dato de número de teléfono
    document.getElementById("Number").addEventListener("change", function () {
        document.getElementById("Number").style.borderColor = "";
        document.getElementById("AlertMessage").style.display = "none";
    })

    if (!ValidateEmail(usr_email)) {   //validación del correo electrónico 
        document.getElementById("AlertMessage").style.display = "block";
        document.getElementById("AlertMessage").innerHTML = `<div style="color:red" role="alert">
    ¡Ingrese un correo válido ejemplo(nombre@dominio.com)!
  </div>`;
        console.log(document.getElementById("email").style.borderColor);
        document.getElementById("email").style.borderColor = "#FF0000";

    }
    document.getElementById("email").addEventListener("change", function () {
        document.getElementById("email").style.borderColor = "";
        document.getElementById("AlertMessage").style.display = "none";
    })

    if (!ValidateName(usr_name)) {  //if de validacion de nombre
        document.getElementById("AlertMessage").style.display = "block";
        document.getElementById("AlertMessage").innerHTML = `<div style="color:red" role="alert">
    ¡Escriba su nombre correctamente!
  </div>`;
        console.log(document.getElementById("Nombre").style.borderColor);
        document.getElementById("Nombre").style.borderColor = "#FF0000";

    }//fin de if validación de nombre 

    // Código de valores por default por el evento change 
    document.getElementById("Nombre").addEventListener("change", function () {
        document.getElementById("Nombre").style.borderColor = "";
        document.getElementById("AlertMessage").style.display = "none";
    })





    if ((ValidateName(usr_name)) && (ValidateEmail(usr_email)) && ((ValidateNumber(usr_number))) && ((ValidateMessage(mensaje)))) {

        let new_user = { "usr_id": cont, "usr_fullName": usr_name, "usr_email": usr_email, "usr_phone": usr_number, "usr_message": mensaje };
        cont++;
        usuarios.push(new_user);
        Email.send({
            SecureToken: "3edc481f-37ac-44f8-bf82-a43a9c2defca",
            To: 'knifeserviceit2022@gmail.com',
            From: "andrestecpile97@gmail.com",
            Subject: "This is the subject",
            Body: "And this is the body"
        }).then(
            message => alert(message)
        );

        Swal.fire('¡Su información ha sido enviada, espere pronto nuestra respuesta!');

        localStorage.setItem(key, JSON.stringify(usuarios));
        usr_email = "";
        document.getElementById("email").value = usr_email;
        usr_name = "";
        document.getElementById("Nombre").value = usr_name;
        usr_number = "";
        document.getElementById("Number").value = usr_number;
        mensaje = "";
        document.getElementById("message_1").value = mensaje;

    }



});







function ValidateEmail(usr_email) {
    var regx = /^([a-zA-Z0-9-.-_]+)@([a-zA-Z0-9]+)[.]([a-z]+)(.[a-z]+)?$/;
    if (usr_email.match(regx)) {
        // alert("Valid email address!");

        return true;
    } else {
        // alert("Invalid email address!");
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

}

function ValidateMessage(Message) {
    if ((document.getElementById("message_1").value) && ((document.getElementById("message_1").value)[0] != ' ') && (Message.length > 15)) {
        // alert("Valid email address!");


        return true;
    } else {

        // alert("Invalid email address!");
        return false;
    }

}
