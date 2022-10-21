let submit_btn = document.getElementById("submit_btn");
let alerta = document.getElementById("alerta");
let producto = document.getElementById("producto");
let precio = document.getElementById("price");

let descripcion = document.getElementById("descripcion");
let imagen = document.querySelector("#file");
let btnFake = document.getElementById('btnFake');
imagen.value='';
let img = " ";
let cont = 1;
//let listaServicios = [];
const key = "Serv";
let image=null;
let prev = document.getElementById("preview");

btnFake.addEventListener("click", function (e) {
    e.preventDefault();
    imagen.click();
})

submit_btn.addEventListener("click", function (e) {
    e.preventDefault();
    //console.log(imagen.value);
    if (validar(producto)) {//validacion de input producto
        producto.style.borderColor = "";
        if (validar(descripcion)) {//validacion de input descripcion 
            descripcion.style.borderColor = "";
            if (image!=null) {//validacion de imagen
                imagen.style.borderColor ="";
       
                //Crea el objeto servicio con id, nombre y descripcion
                //let servicio = { "id": 0, "name": producto.value, "price": parseInt(precio.value), "description": descripcion.value, "Imagen": img }
                // Agrega el objeto servicio a lista de servicios
                //listaServicios.push(servicio);
                //comvierte el objeto en json y lo guarda en el localstorage
                
                //localStorage.setItem(key, JSON.stringify(listaServicios));
                //Llama a la funcion preview para mostrar un preview de la card a mostrar
              
                //AQUI SE ESTABLECE EL SCRIPT DE FETCH		
                const data = { servicio_nombre:producto.value , servicio_descripcion:descripcion.value,imagen: image};
				fetch('/api/servicios/', {
				 method: 'POST', // or 'PUT'
					headers: {
						 'Content-Type': 'application/json',
						 'Authorization': 'Bearer: ' + localStorage.getItem("Token")
						 },
					  body: JSON.stringify(data),
						})
						  .then((response) => response.json())
						  .then((data) => {
							if((data.servicio_nombre!=null)){
								console.log('Success:', data);
								 Swal.fire({
							     text: '¡Servicio agregado satisfactoriamente!',
							     icon: 'success',
							     timer: '3000',
							     showConfirmButton: false,
							     color: 'black'
							                })
							      //Regresando todos los valores a vacio para nuevo servicio
					            producto.value = "";
					                descripcion.value = "";
					                precio.value = ""
					                imagen.value = null;
					                img = "";
					                prev.innerHTML = '';          
										
							}else{
								Swal.fire({
			            title: 'Se requiere Iniciar Sesión',
			             confirmButtonColor: 'black',
  						cancelButtonColor: 'gray',
			            confirmButtonText: `<a href="/pages/iniciarsesion.html">Iniciar sesión </a>`,
			            cancelButtonText: 'Cancelar',
			            showCancelButton: true,
			            showCloseButton: true,
			            isClicked: false,
			            focusConfirm: true,
			       		color:'black'
			    	      })
							}//if else  de validacion			
										
						 })
						 .catch((error) => {
						console.error('Error:', error);
						 });  
                

                //cambia el texto de la alerta 
                //cambia la clase de la alerta de alert-danger a alert-success
                //alerta.innerText = "Servicio agregado";
                // alerta.classList.add("alert-success");

                //Regresando todos los valores a vacio para nuevo servicio
               /* producto.value = "";
                descripcion.value = "";
                precio.value = ""
                imagen.value = null;
                img = "";
                prev.innerHTML = '';*/

                // const $image = document.querySelector('#image');
                //$image.setAttribute('src', "");
            } else {
                imagen.style.borderColor = "#FF0000";
                alerta.innerText = "Error - No hay imagen";
            }//else imagen
        } else {
            alerta.innerText = "Error en la descripción del producto";
        }//else descripcion 
    } else {
        alerta.innerText = "Error en el nombre del producto.";
    }//else prodcuto
    //muestra de alerta por 5 segundos
    alerta.style.display = "block";
    setTimeout(() => {
        alerta.style.display = "none";
    }, 5000);
});


//validacion de inputs | Verificando que no esten vacios y que tengan al menos 5 letras
function validar(campo) {
    var regex = /^\s+/
    if (campo.value.length == 0 || campo.value.length < 5) {
        //Si el input es erroneo mandando el foco al input
        campo.focus();
        //Agregando clase danger a la alerta
        alerta.classList.add("alert-danger");
        campo.style.borderColor = "#FF0000";
        return false;
    } else {
        if (campo.value.match(regex)) {
            //Si el input es erroneo mandando el foco al input
            campo.focus();
            //Agregando clase danger a la alerta
            alerta.classList.add("alert-danger");
            campo.style.borderColor = "#FF0000";
            return false;
        } else {
            return true;
        }

    };
}


//Imagen agregada
imagen.addEventListener("change", function () {
    const reader = new FileReader();
    reader.addEventListener("load", () => {
        //Codigo de imagen guardada en variable "img"

        img = reader.result;


        //console.log(img);
        //localStorage.setItem("recent-image", reader.result);
    });
    reader.readAsDataURL(this.files[0]);
});

//mostrando imagen en pantalla al cargarla
const $form = document.querySelector('#form')

const $image = document.querySelector('#image')
const $file = document.querySelector('#file')
function renderImage(formData) {
    const file = formData.get('image')
 	 image = URL.createObjectURL(file)
   
    prev.innerHTML = '';

    //$image.setAttribute('src', image)

    prev.innerHTML = preview(producto.value, descripcion.value, image, cont);
}


$file.addEventListener('change', (event) => {
    const formData = new FormData($form)
    renderImage(formData)
})

function preview(nombre, descripcion, image, id) {
    return `<div  card" style="width: 50rem;hover:">
    <img class="card-img-top" src="${image}" alt="${nombre}">
    <div class="card-body d-flex flex-column">
      <h4 class="card-title">${nombre}</h4>
      <p class="card-text">${descripcion.slice(0, 30)}...</p>
    
  <button type="button" class="btn btn-dark mt-auto" data-toggle="modal" data-target="#modal_${id}">
  Ver más
</button>

<!-- Modal -->

</div>
  </div>`
}


