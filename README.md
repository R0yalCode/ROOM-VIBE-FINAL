#  ROOM VIBE

> **Video de navegación del sistema:**  
> 📺 [Ver demo en YouTube](https://www.youtube.com/watch?v=7RbMmlKqnqg)  

---

##  Descripción General

Este proyecto está desarrollado utilizando **Jakarta Faces (JSF)** con Facelets para construir una interfaz gráfica funcional, limpia y conectada a la lógica del sistema mediante *managed beans*. Ha sido creado en un entorno educativo como parte de una entrega evaluada en base a diseño, integración, usabilidad y trabajo en equipo.

---

## Vistas del Sistema
### Vista 1: index.xhtml
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

### Vista 6: contacto.xhtml
<img width="1901" height="1094" alt="image" src="https://github.com/user-attachments/assets/bc860816-6adc-4596-bd97-23704df75d79" />

---

## Estructura del Proyecto
```bash
room-vibe-web/
 ├── Dockerfile
 ├── mvnw
 ├── mvnw.cmd
 ├── pom.xml
 ├── README.md
 └── src/
     └── main/
         ├── java/
         │   └── edu/
         │       └── unl/
         │           └── cc/
         │               └── jbrew/
         │                   ├── bussiness/
         │                   │   ├── SecurityFacade.java
         │                   │   └── services/
         │                   │       ├── PermissionRepository.java
         │                   │       ├── RoleRepository.java
         │                   │       └── UserRepository.java
         │                   ├── controllers/
         │                   │   ├── AuthenticationBean.java
         │                   │   ├── AuthorizationFilter.java
         │                   │   └── security/
         │                   │       ├── UserHome.java
         │                   │       ├── UserList.java
         │                   │       ├── UserPrincipal.java
         │                   │       └── UserSession.java
         │                   ├── domain/
         │                   │   ├── common/
         │                   │   │   ├── GenderType.java
         │                   │   │   └── Person.java
         │                   │   └── security/
         │                   │       ├── ActionType.java
         │                   │       ├── Permission.java
         │                   │       ├── Role.java
         │                   │       └── User.java
         │                   ├── exception/
         │                   │   ├── CredentialInvalidException.java
         │                   │   ├── EncryptorException.java
         │                   │   └── EntityNotFoundException.java
         │                   ├── faces/
         │                   │   ├── ContactoBean.java
         │                   │   ├── FacesUtil.java
         │                   │   ├── InicioBean.java
         │                   │   ├── RecuperarBean.java
         │                   │   ├── ReservaBean.java
         │                   │   └── ValidatorBean.java
         │                   ├── jakarta/
         │                   │   └── hello/
         │                   │       ├── Hello.java
         │                   │       ├── HelloApplication.java
         │                   │       └── HelloWorldResource.java
         │                   └── util/
         │                       └── EncryptorManager.java
         ├── liberty/
         │   └── config/
         │       └── server.xml
         └── webapp/
             ├── contacto.xhtml
             ├── index.xhtml
             ├── login.xhtml
             ├── recuperar.xhtml
             ├── reserva.xhtml
             ├── servicios.xhtml
             ├── test.xhtml
             ├── images/
             │   ├── fondo.jpg
             │   ├── inicio.jpg
             │   ├── inicio1.jpg
             │   ├── reserva.jpg
             │   ├── restaurante.jpg
             │   ├── room-vibe-logo.jpg
             │   ├── spa.jpg
             │   └── servicios/
             │       ├── desayuno.jpg
             │       ├── estacionamiento.jpg
             │       ├── sala.jpg
             │       ├── seguridad.jpg
             │       ├── spa.jpg
             │       └── wifi.jpg
             ├── security/
             │   ├── userEdit.xhtml
             │   └── userList.xhtml
             └── WEB-INF/
                 ├── web.xml
                 └── templates/
                     ├── base.xhtml
                     └── fragments/
                         ├── footer.xhtml
                         └── topbar.xhtml
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



- ### [Steeven Pardo](https://github.com/Dan1el17) : Configuración y conexion con la base de datos.
- ### [Royel Jima](https://github.com/R0yalCode) : Configuración en las vistas, cuando el usuario se va a registrar o iniciar secion.  
- ### [Juan Calopino](https://github.com/JuaaanCalopino) : Diseño e implementacion de las vistas para que el cliente pueda elegir las habitaciones y visualizar los servicios.  
- ### [Daniel Saavedra](https://github.com/Dan-San837) : Diseño de la vista principal (index) e implementación de clases complementarias para la misma. 


---

## Autores: 
### [Steeven Pardo](https://github.com/Dan1el17)
### [Royel Jima](https://github.com/R0yalCode)
### [Juan Calopino](https://github.com/JuaaanCalopino)
### [Daniel Saavedra](https://github.com/Dan-San837)


