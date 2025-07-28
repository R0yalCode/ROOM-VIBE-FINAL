#  ROOM VIBE

> **Video de navegación del sistema:**  
> 📺 [Ver demo en YouTube](https://www.youtube.com/watch?v=7RbMmlKqnqg)  

---

##  Descripción General

Este proyecto está desarrollado utilizando **Jakarta Faces (JSF)** con Facelets para construir una interfaz gráfica funcional, limpia y conectada a la lógica del sistema mediante *managed beans*. Ha sido creado en un entorno educativo como parte de una entrega evaluada en base a diseño, integración, usabilidad y trabajo en equipo.

---

## Vistas del Sistema
### Vista 1: index.xhtml
<<<<<<< HEAD
<img width="1904" height="999" alt="Image" src="https://github.com/user-attachments/assets/7a470b58-97d3-490b-92ae-10005e75cbfd" />

### Vista 2: login.xhtml
<img width="1919" height="1002" alt="Image" src="https://github.com/user-attachments/assets/5994038a-9543-4387-b0d3-df40a1bd712e" />

### Vista 3: recuperar.xhtml
<img width="1917" height="954" alt="Image" src="https://github.com/user-attachments/assets/fc4c5896-384f-4971-9c46-1066f5eabc6c" />

### Vista 4: habitaciones.xhtml
<img width="1918" height="995" alt="Image" src="https://github.com/user-attachments/assets/92c3c77c-01b0-48f7-b1b2-03ba501401ec" />
<img width="1919" height="864" alt="Image" src="https://github.com/user-attachments/assets/2636aba7-44cd-40f9-abdf-fd12f9f94e2d" />

### Vista 4: reserva.xhtml
<img width="1904" height="980" alt="Image" src="https://github.com/user-attachments/assets/7ff2d13e-da25-42d4-a0fc-2d25e7c19a8d" />

### Vista 5: servicios.xhtml
<img width="1909" height="944" alt="Image" src="https://github.com/user-attachments/assets/e31b2049-ed9a-49f0-a7f7-1ea2e21bbffe" />
=======
<img width="1901" height="997" alt="image" src="https://github.com/user-attachments/assets/028c8baf-5e80-49ea-9b91-43645dfe5a97" />

### Vista 2: login.xhtml
<img width="1919" height="865" alt="image" src="https://github.com/user-attachments/assets/4bf09e19-0ac9-4171-872b-bd48485c1aa6" />

### Vista 3: recuperar.xhtml
<img width="1919" height="673" alt="image" src="https://github.com/user-attachments/assets/699213bf-5991-4764-b8d9-58b45ed2b839" />

### Vista 4: habitaciones.xhtml
<img width="1901" height="1078" alt="image" src="https://github.com/user-attachments/assets/43d2bbfe-7c60-46c7-a889-bd8f02d3b0f3" />
<img width="1905" height="1048" alt="image" src="https://github.com/user-attachments/assets/014ec47e-462c-4a8b-be1f-6cb326bd2d4b" />
<img width="1815" height="1045" alt="image" src="https://github.com/user-attachments/assets/ec2d9c2d-5c9d-4c74-9ed9-72c7196f5991" />

### Vista 4: reserva.xhtml
<img width="1900" height="1099" alt="image" src="https://github.com/user-attachments/assets/45e9de38-3bce-408e-b1f0-a247f3ce3ece" />

### Vista 5: servicios.xhtml
<img width="1900" height="1100" alt="image" src="https://github.com/user-attachments/assets/65bfdee5-c5b1-4fef-934a-9d4d2dc52091" />
>>>>>>> origin/feature

### Vista 6: contacto.xhtml
<img width="1901" height="1094" alt="image" src="https://github.com/user-attachments/assets/bc860816-6adc-4596-bd97-23704df75d79" />

---

## Estructura del Proyecto
```bash
room-vibe-web/
├── Dockerfile
├── docker-compose-dev-mysql.yml
├── docker-compose-prod.yml
├── docker-env
├── mvnw
├── mvnw.cmd
├── pom.xml
├── README.md
├── room-vibe-web.iml
├── src/
│   └── main/
│       ├── java/
│       │   └── edu/
│       │       └── unl/
│       ├── liberty/
│       │   └── config/
│       │       └── server.xml
│       ├── resources/
│       │   └── META-INF/
│       │       ├── initial-data.sql
│       │       ├── persistence-hibernate.xml
│       │       └── persistence.xml
│       └── webapp/
│           ├── contacto.xhtml
│           ├── index.xhtml
│           ├── login.xhtml
│           ├── recuperar.xhtml
│           ├── reserva.xhtml
│           ├── habitaciones/
│           │   ├── habitacionDoble.xhtml
│           │   ├── habitaciones.xhtml
│           │   ├── habitacionPresidencial.xhtml
│           │   ├── habitacionSencilla.xhtml
│           │   └── habitacionSuite.xhtml
│           ├── resources/
│           │   ├── css/
│           │   └── images/
│           ├── security/
│           │   ├── userEdit.xhtml
│           │   └── userList.xhtml
│           ├── servicios/
│           │   ├── servicio.xhtml
│           │   ├── servicioDesayuno.xhtml
│           │   ├── servicioEstacionamiento.xhtml
│           │   ├── servicioSala.xhtml
│           │   ├── servicioSeguridad.xhtml
│           │   ├── servicioSpa.xhtml
│           │   └── servicioWifi.xhtml
│           └── WEB-INF/
│               ├── web.xml
│               └── templates/
│                   ├── base.xhtml
│                   └── fragments/
│                       ├── footer.xhtml
│                       └── topbar.xhtml
```

---

  ## Requisitos de Sistema
- Java SE 21
- Apache Maven (versión 3.8.x o superior)
- Docker: para la conexion con la base de datos. 
- Un navegador web moderno 
- IDE como IntelliJ IDEA para desarrollo
> No es necesario instalar Maven si usas el Maven Wrapper (mvnw, mvnw.cmd).
Asegúrate de tener configurada la variable de entorno JAVA_HOME apuntando a tu instalación de Java.

---

##  Instalación del proyecto

```bash
bash
git clone https://github.com/R0yalCode/ROOM-VIBE-FINAL.git
cd ROOM-VIBE-FINAL
mvn clean install
```
---

##  Roles del equipo
- ### [Steeven Pardo](https://github.com/Dan1el17) : Encargado de la configuración e integración de la base de datos, asegurando una conexión eficiente y segura entre la aplicación y el sistema de gestión de datos.
- ### [Royel Jima](https://github.com/R0yalCode) : Responsable de la configuración de las vistas relacionadas con los procesos de registro e inicio de sesión de los usuarios. Revisor, utilizando gitflow para la revision del codigo de la implementaciond de cada participante, y su correcto flujo de trabajo en las diferentes ramas. 
- ### [Juan Calopino](https://github.com/JuaaanCalopino) : Diseñó e implementó las vistas orientadas al cliente, permitiendo la selección de habitaciones y la visualización detallada de los servicios ofrecidos. 
- ### [Daniel Saavedra](https://github.com/Dan-San837) : Lideró el diseño de la vista principal (index) del proyecto e implementó clases adicionales para complementar su funcionamiento. 

---

## Autores: 
### [Steeven Pardo](https://github.com/Dan1el17)
### [Royel Jima](https://github.com/R0yalCode)
### [Juan Calopino](https://github.com/JuaaanCalopino)
### [Daniel Saavedra](https://github.com/Dan-San837)


