let mainServices = document.getElementById("inputServ")

window.addEventListener("load", function () {
    getData();
    leerStorage();
});

const getData = () => {
    let promesa = fetch("/js/publicaciones.json", {
        method: "GET"
    });
    promesa.then((response) => {
        response.json().then((data) => {
            console.log(data);
            console.log(typeof (data));
            data.forEach(producto => {
                /* console.log(producto.id,producto.title) */
                mainServices.innerHTML += `<option value="${producto.price}">${producto.name}</option>
        `;

            });
        }).catch((error) => {
            console.error("Problema con formato de la respuesta" + error);
        });
    }).catch(error => {
        console.log("Error en la solicitud" + error)
    });


}
const leerStorage = () => {
    if (localStorage.length > 0) {
        let arregloServ = JSON.parse(localStorage.getItem("Serv"));
        console.log(typeof (arregloServ));
        arregloServ.forEach(servicio => {
            mainServices.insertAdjacentHTML("beforeend", `<option value="${servicio.price}">${servicio.name}</option>
      `);
        })//foreach
    }//if localStrorage
}//leerStorage


let btnCot = document.getElementById("btnCotiza");//aqui insertamos el id del boton cotizar


btnCot.addEventListener("click", function (e) {//aqui creamos unn evento para el boton indicandolo dentro de la funcion con la letra e
    e.preventDefault();//aqui se cancela el evento si es cancelable, lo que significa que la acción predeterminada que pertenece al evento no ocurrirá. 
    let cont = 0;
    let iva = document.getElementById("checkIVA").checked;
    let nombre = document.getElementById("inputName").value;
    let correo = document.getElementById("inputCorreo").value;
    let telefono = document.getElementById("inputTel").value;
    let cp = document.getElementById("inputCodPost").value;
    let textCard = document.getElementById("textCard");//aqui declaramos el cuadro del texto 
    let servicio = document.getElementById("inputServ");//aqui declaramos las selecciones del servcio
    // console.log(iva);//este log lo usamos para verificar si el checkbox del iva esta seleccionado(true) o no(false)
    // console.log(servicio.selectedIndex);//el selectedIndex es para ver que opcion del select fue escogida.
    // console.log(servicio.options[servicio.selectedIndex].value);//muestra el valor que contiene cada uno de nuestros option */

    //validacion de numero telefonico y correo electronico
    if (!(ValidateNumber(telefono))) {// if de validacion para numero de telefono 
        document.getElementById("AlertMessage").style.display = "block";
        document.getElementById("AlertMessage").innerHTML = `<div style="color:red" role="alert">
¡Ingrese su contacto telefónico a 10 dígitos!
</div>`;
        console.log(document.getElementById("inputTel").style.borderColor);
        document.getElementById("inputTel").style.borderColor = "#FF0000";


    }//fin de if validación de número de teléfono.
    //Código de des alerta por mal ingreso de dato de número de teléfono
    document.getElementById("inputTel").addEventListener("change", function () {
        document.getElementById("inputTel").style.borderColor = "";
        document.getElementById("AlertMessage").style.display = "none";
    })


    if (!(Validatepostal(cp))) {// if de validacion para numero de telefono 
        document.getElementById("AlertMessage").style.display = "block";
        document.getElementById("AlertMessage").innerHTML = `<div style="color:red" role="alert">
¡Ingrese el código postal de 5 dígitos!
</div>`;
        console.log(document.getElementById("inputCodPost").style.borderColor);
        document.getElementById("inputCodPost").style.borderColor = "#FF0000";


    }//fin de if validación de número de teléfono.
    //Código de des alerta por mal ingreso de dato de número de teléfono
    document.getElementById("inputCodPost").addEventListener("change", function () {
        document.getElementById("inputCodPost").style.borderColor = "";
        document.getElementById("AlertMessage").style.display = "none";
    })





    if (!ValidateEmail(correo)) {   //validación del correo electrónico 
        document.getElementById("AlertMessage").style.display = "block";
        document.getElementById("AlertMessage").innerHTML = `<div style="color:red" role="alert">
¡Ingrese un correo válido ejemplo(nombre@dominio.com)!
</div>`;

        document.getElementById("inputCorreo").style.borderColor = "#FF0000";

    }
    document.getElementById("inputCorreo").addEventListener("change", function () {
        document.getElementById("inputCorreo").style.borderColor = "";
        document.getElementById("AlertMessage").style.display = "none";
    })

    if (!ValidateName(nombre)) {  //if de validacion de nombre
        document.getElementById("AlertMessage").style.display = "block";
        document.getElementById("AlertMessage").innerHTML = `<div style="color:red" role="alert">
¡Escriba su nombre correctamente!
</div>`;

        document.getElementById("inputName").style.borderColor = "#FF0000";

    }//fin de if validación de nombre 

    // Código de valores por default por el evento change 
    document.getElementById("inputName").addEventListener("change", function () {
        document.getElementById("inputName").style.borderColor = "";
        document.getElementById("AlertMessage").style.display = "none";
    })





    if ((ValidateName(nombre)) && (ValidateEmail(correo)) && ((ValidateNumber(telefono))) && ((Validatepostal(cp)))) {

        /*         let new_user = { "usr_id": cont, "usr_fullName": usr_name, "usr_email": usr_email, "usr_phone": usr_number, "usr_message": mensaje };
                cont++;
                usuarios.push(new_user);
                console.log(usuarios);
                form.submit();
                localStorage.setItem(key, JSON.stringify(usuarios));
                usr_email = "";
                document.getElementById("email").value = usr_email;
                usr_name = "";
                document.getElementById("Nombre").value = usr_name;
                usr_number = "";
                document.getElementById("Number").value = usr_number;
                mensaje = "";
                document.getElementById("message_1").value = mensaje; */
        let price = 0;

        let valores = Array.from(servicio.selectedOptions).map(option => price += parseInt(option.value))
        if (iva) { price = price * 1.16 }
        textCard.innerHTML = "$" + price.toFixed(2) + " Pesos";//aqui Mandamos a imprimir en el textCard el valor de y el tofixed designa el numero maximo de decimales 

        window.print()

    }










});









function cotizar(iva, serv) {//aqui creamos la funcion para cotizar
    let result = 0;
    if (serv == 1) {//Pagina Web
        result += 15000;//aqui se agrega el valor de la selection 1
    } else if (serv == 2) {//app movil
        result += 18000;//aqui se agrega el valor de la selection 2
    } else if (serv == 3) {//base de datos
        result += 8500;//aqui se agrega el valor de la selection 3
    } else if (serv == 4) {//servicio tecnico pagina web
        result += 9000;//aqui se agrega el valor de la selection 4
    } else if (serv == 5) {//servicio tecnico app movil
        result += 12000;//aqui se agrega el valor de la selection 5
    } else if (serv == 6) {//servicio tecnico base de datos
        result += 5000;//aqui se agrega el valor de la selection 6
    }//else if
    if (iva) {//checkIVA
        result *= 1.16;//aqui se suma el IVA
    }//if iva
    return result;
}//cotizar























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



function Validatepostal(number) {

    let regx = /^([1-9-0]+)([1-9])?$/;


    if ((number.match(regx)) && (number.length == 5)) {


        return true;

    } else {


        return false;

    }

}