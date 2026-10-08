const modal = document.getElementById("modalEditarUsuario");

modal.addEventListener("show.bs.modal", function (event) {

    const boton = event.relatedTarget;

    const id = boton.getAttribute("data-id");
    const nombre = boton.getAttribute("data-nombre");
    const apellido = boton.getAttribute("data-apellido");
    const mail = boton.getAttribute("data-mail");
    const telefono = boton.getAttribute("data-telefono");

    document.getElementById("editarId").value = id;
    document.getElementById("editarNombre").value = nombre;
    document.getElementById("editarApellido").value = apellido;
    document.getElementById("editarMail").value = mail;
    document.getElementById("editarTelefono").value = telefono;

    document.getElementById("formEditarUsuario").action =
        "/usuarios/" + id;
});