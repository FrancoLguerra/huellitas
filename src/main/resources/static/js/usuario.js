const formulario = document.getElementById("usuarioForm");

const nombre = document.getElementById("nombre");
const apellido = document.getElementById("apellido");
const mail = document.getElementById("mail");
const telefono = document.getElementById("telefono");

const nombreError = document.getElementById("nombreError");
const apellidoError = document.getElementById("apellidoError");
const mailError = document.getElementById("mailError");
const telefonoError = document.getElementById("telefonoError");

const mensaje = document.getElementById("mensaje");
const boton = document.getElementById("btnCrear");


formulario.addEventListener("submit", async function(event) {

    event.preventDefault();

    limpiarErrores();

    const valido = validarFormulario();

    if (!valido) {
        return;
    }

    const usuario = {
        nombre: nombre.value.trim(),
        apellido: apellido.value.trim(),
        mail: mail.value.trim(),
        telefono: telefono.value.trim()
    };

    boton.disabled = true;
    boton.textContent = "Creando...";

    try {

        const respuesta = await fetch("/api/usuarios", {

            method: "POST",

            headers: {
                "Content-Type": "application/json"
            },

            body: JSON.stringify(usuario)
        });

        if (respuesta.ok) {

            mostrarMensaje(
                "Usuario creado correctamente.",
                "exito"
            );

            formulario.reset();

        } else {

            const texto = await respuesta.text();

            mostrarMensaje(
                texto || "No se pudo crear el usuario.",
                "error-general"
            );
        }

    } catch (error) {

        console.error(error);

        mostrarMensaje(
            "No se pudo conectar con el servidor.",
            "error-general"
        );

    } finally {

        boton.disabled = false;
        boton.textContent = "Crear usuario";
    }
});


function validarFormulario() {

    let valido = true;

    const nombreValor = nombre.value.trim();
    const apellidoValor = apellido.value.trim();
    const mailValor = mail.value.trim();
    const telefonoValor = telefono.value.trim();


    // NOMBRE

    if (nombreValor.length < 2) {

        mostrarError(
            nombre,
            nombreError,
            "El nombre debe tener al menos 2 caracteres."
        );

        valido = false;
    }


    if (nombreValor.length > 100) {

        mostrarError(
            nombre,
            nombreError,
            "El nombre no puede superar los 100 caracteres."
        );

        valido = false;
    }


    // APELLIDO

    if (apellidoValor.length < 2) {

        mostrarError(
            apellido,
            apellidoError,
            "El apellido debe tener al menos 2 caracteres."
        );

        valido = false;
    }


    if (apellidoValor.length > 100) {

        mostrarError(
            apellido,
            apellidoError,
            "El apellido no puede superar los 100 caracteres."
        );

        valido = false;
    }


    // MAIL

    const patronMail =
        /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!patronMail.test(mailValor)) {

        mostrarError(
            mail,
            mailError,
            "Ingresá un correo electrónico válido."
        );

        valido = false;
    }


    // TELEFONO

    if (telefonoValor.length === 0) {

        mostrarError(
            telefono,
            telefonoError,
            "El teléfono es obligatorio."
        );

        valido = false;
    }


    return valido;
}


function mostrarError(campo, elementoError, mensajeError) {

    campo.classList.add("invalido");

    elementoError.textContent = mensajeError;
}


function limpiarErrores() {

    const campos = [
        nombre,
        apellido,
        mail,
        telefono
    ];

    const errores = [
        nombreError,
        apellidoError,
        mailError,
        telefonoError
    ];

    campos.forEach(campo => {
        campo.classList.remove("invalido");
    });

    errores.forEach(error => {
        error.textContent = "";
    });

    mensaje.className = "mensaje";
    mensaje.textContent = "";
}


function mostrarMensaje(texto, tipo) {

    mensaje.textContent = texto;

    mensaje.className = "mensaje " + tipo;
}