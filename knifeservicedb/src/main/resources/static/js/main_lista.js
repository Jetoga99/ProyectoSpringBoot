let mainProds = document.getElementById("list-items")

window.addEventListener("load", function () {
  getData();
  //leerStorage();
});

const getData = () => {
  let promesa = fetch("/api/servicios/",{
    method: "GET"
  });
  promesa.then((response) => {
    response.json().then((data) => {
      data.forEach(producto => {
        /* console.log(producto.id,producto.title) */
        mainProds.innerHTML += `<div  class="card" style="height:auto;border:none;text-align:center;">
        <img class="card-img-top" src="${producto.imagen}" alt="${producto.servicio_nombre}">
        <div class="card-body d-flex flex-column">
          <h5 class="card-title">${producto.servicio_nombre}</h5>
         
        
      <a  class="card-link stretched-link" data-toggle="modal" data-target="#modal_${producto.servicios_id}">
     
    </a>
    
    <!-- Modal -->
    <div class="modal fade" id="modal_${producto.servicios_id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">${producto.servicio_nombre}</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Cerrar">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body" style="text-align:justify;">
          ${producto.servicio_descripcion}
          </div>
          <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="window.location.href='../pages/cotiza.html'">Cotiza</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
          </div>
        </div>
      </div>
    </div>
    </div>
      </div>`;

      });
    }).catch((error) => {
      console.error("Problema con formato de la respuesta" + error);
    });
  }).catch(error => {
    console.log("Error en la solicitud" + error)
  });
}

/*const leerStorage = () => {
  if (localStorage.length > 0) {
    let arregloServ = JSON.parse(localStorage.getItem("Serv"));
    console.log(typeof (arregloServ));
    arregloServ.forEach(servicio => {
      mainProds.insertAdjacentHTML("beforeend", `<div  class="card" style="height:auto;border:none;">
        <img class="card-img-top" src="${servicio.Imagen}" alt="${servicio.name}">
        <div class="card-body d-flex flex-column">
          <h5 class="card-title">${servicio.name}</h5>
          <p class="card-text">${servicio.description.slice(0, 30)}...</p>
       
          <a  class="card-link stretched-link" data-toggle="modal" data-target="#modal_${servicio.id}">
     
    </a>
    <!-- Modal -->
    <div class="modal fade" id="modal_${servicio.id}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title" id="exampleModalLabel">${servicio.name}</h5>
            <button type="button" class="close" data-dismiss="modal" aria-label="Cerrar">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body">
          ${servicio.description}
          </div>
          <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="window.location.href='../pages/cotiza.html'">Cotiza</button>
            <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>
          </div>
        </div>
      </div>
    </div>
    `);
    })//foreach
  }//if localStrorage
}//leerStorage*/
