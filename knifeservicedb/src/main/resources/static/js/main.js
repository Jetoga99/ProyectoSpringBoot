
let navbar1 = document.getElementById("nav");
let footer1 = document.getElementsByTagName("footer")[0];

window.addEventListener("load", function (e) {
  if (sessionStorage.getItem('status') == null) {
    navbar1.innerHTML = `
    <nav id="navbar" class="navbar" style="justify-content: center;">

    <ul>
     <li><a href="#">
     <img src="../src/Logo.png" width="120" class=alt="">
     </a></li>
     <li><a class="nav-link active" href="/Index.html">Inicio</a></li>
     <li><a class="nav-link" href="../pages/quienessomos.html" style="text-align:center;">Acerca de </br>Nosotros</a></li>
     <li><a class="nav-link" href="../pages/servicios.html">Servicios</a></li>
     <li><a class="nav-link" href="../pages/contacto.html">Contacto</a></li>
     <li><button onclick="window.location.href='../pages/registro.html'" type="button" class="btn btn-dark" style=" font-family:'Poppins', sans-serif;" id="registrate"><span> Regístrate
     </span></button></li>
     <li><button onclick="window.location.href='../pages/iniciarsesion.html'" type=" button" class="btn btn-dark"
     style=" font-family:'Poppins', sans-serif;" id="iniciar"><span> Iniciar
     Sesión </span></button></li>
     </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>


</nav>`} else {
    navbar1.innerHTML = `
<nav id="navbar" class="navbar" style="justify-content: center;">

<ul>
 <li><a href="#">
 <img src="../src/Logo.png" width="120" class=alt="">
 </a></li>
 <li><a class="nav-link active" href="/Index.html">Inicio</a></li>
 <li><a class="nav-link" href="../pages/quienessomos.html" style="text-align:center;">Acerca de </br>Nosotros</a></li>
 <li><a class="nav-link" href="../pages/servicios.html">Servicios</a></li>
 <li><a class="nav-link" href="../pages/contacto.html">Contacto</a></li>
 <li><button onclick="sessionStorage.clear();document.location.reload(true)" type="button" class="btn btn-dark" style=" font-family:'Poppins', sans-serif;" id="logout"><span> Cerrar Sesión
 </span></button></li>
 </ul>
    <i class="bi bi-list mobile-nav-toggle"></i>


</nav>`};

  // se uso el codigo onclick="window.location.href='../pages/registro.html'" para linkear la pagina registro al boton de registro


  footer1.innerHTML = `<div class="container">
  <div class="row">
    <div class="footer-col">
      <h4 class = "compfoter">Compañia </h4>
      <ul>
        <li><a href="../pages/quienessomos.html">Acerca de nosotros</a></li>
        <li><a href="../pages/servicios.html">Nuestros Servicios</a></li>
        <li><a href="../pages/contacto.html">Contáctanos</a></li>
        <li><a href="../pages/registro.html">Regístrate</a></li>
        <li><a href="../pages/iniciarsesion.html">Iniciar Sesión</a></li>
        <li><a target="_blank" href="../pages/alta.html">Alta</a></li>
      </ul>
    </div>
    <div class="footer-col">
      <h4 class = "sigfoter">Siguenos</h4>
      <div class="social-links">
        <a target="_blank" href="https://www.facebook.com/profile.php?id=100086169017722&sk=about_details"><i class="fab fa-facebook-f"></i></a>
        <a target="_blank" href="https://twitter.com/Brucewa00550347"><i class="fab fa-twitter"></i></a>
        <a target="_blank" href="https://www.instagram.com/tiknife/"><i class="fab fa-instagram"></i></a>
        <a target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin-in"></i></a>
      </div>
    </div>
    <address>&copy; 2022 IT Knife Web Service. Todos los derechos reservados.</address>
  </div>
</div>`
});

window.onload = function navbarfunction() {
  "use strict";
  const select = (el, all = false) => {
    el = el.trim()
    if (all) {
      return [...document.querySelectorAll(el)]
    } else {
      return document.querySelector(el)
    }
  }

  const on = (type, el, listener, all = false) => {
    let selectEl = select(el, all)

    if (selectEl) {
      if (all) {
        selectEl.forEach(e => e.addEventListener(type, listener))
      } else {
        selectEl.addEventListener(type, listener)
      }
    }
  }

  const scrollto = (el) => {
    window.scrollTo({
      top: 0,
      behavior: 'smooth'
    })
  }

  on('click', '.mobile-nav-toggle', function (e) {
    select('#navbar').classList.toggle('navbar-mobile')
    this.classList.toggle('bi-list')
    this.classList.toggle('bi-x')
  })
  on('click', '#navbar .nav-link', function (e) {
    let section = select(this.hash)
    if (section) {
      e.preventDefault()

      let navbar = select('#navbar')
      let header = select('#header')
      let sections = select('section', true)
      let navlinks = select('#navbar .nav-link', true)

      navlinks.forEach((item) => {
        item.classList.remove('active')
      })

      this.classList.add('active')

      if (navbar.classList.contains('navbar-mobile')) {
        navbar.classList.remove('navbar-mobile')
        let navbarToggle = select('.mobile-nav-toggle')
        navbarToggle.classList.toggle('bi-list')
        navbarToggle.classList.toggle('bi-x')
      }

      if (this.hash == '#header') {
        header.classList.remove('header-top')
        sections.forEach((item) => {
          item.classList.remove('section-show')
        })
        return;
      }

      if (!header.classList.contains('header-top')) {
        header.classList.add('header-top')
        setTimeout(function () {
          sections.forEach((item) => {
            item.classList.remove('section-show')
          })
          section.classList.add('section-show')

        }, 350);
      } else {
        sections.forEach((item) => {
          item.classList.remove('section-show')
        })
        section.classList.add('section-show')
      }

      scrollto(this.hash)
    }
  }, true)

  window.addEventListener('load', () => {
    if (window.location.hash) {
      let initial_nav = select(window.location.hash)

      if (initial_nav) {
        let header = select('#header')
        let navlinks = select('#navbar .nav-link', true)

        header.classList.add('header-top')

        navlinks.forEach((item) => {
          if (item.getAttribute('href') == window.location.hash) {
            item.classList.add('active')
          } else {
            item.classList.remove('active')
          }
        })

        setTimeout(function () {
          initial_nav.classList.add('section-show')
        }, 350);

        scrollto(window.location.hash)
      }
    }
  });

};


