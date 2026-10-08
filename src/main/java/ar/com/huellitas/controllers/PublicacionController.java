package ar.com.huellitas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.huellitas.domain.Publicacion;
import ar.com.huellitas.enums.EspecieMascota;
import ar.com.huellitas.enums.GeneroMascota;
import ar.com.huellitas.forms.PublicacionForm;
import ar.com.huellitas.services.PublicacionServiceImpl;

@Controller
public class PublicacionController {

    private final PublicacionServiceImpl publicacionService;

    public PublicacionController(PublicacionServiceImpl publicacionService) {
        this.publicacionService = publicacionService;
    }


    @GetMapping("/publicaciones")
    public String mostrarTodos(Model model) {

        List<Publicacion> publicaciones =
                publicacionService.listar();

        model.addAttribute("publicaciones", publicaciones);

        return "publicaciones";
    }


    @GetMapping("/publicaciones/nueva")
    public String nueva(Model model) {

        model.addAttribute("form", new PublicacionForm());

        model.addAttribute("especies", EspecieMascota.values());
        model.addAttribute("generos", GeneroMascota.values());

        return "publicacion-form";
    }


    @PostMapping("/publicaciones")
    public String crear(
            @ModelAttribute("form") PublicacionForm form) {

        publicacionService.guardar(form);

        return "redirect:/publicaciones";
    }


    @GetMapping("/publicaciones/{id}")
    public String mostrar(
            @PathVariable("id") Long id,
            Model model) {

        Publicacion publicacion =
                publicacionService.buscarPorId(id);

        model.addAttribute("publicacion", publicacion);

        return "publicacion";
    }


    @GetMapping("/publicaciones/{id}/editar")
    public String editar(
            @PathVariable("id") Long id,
            Model model) {

        Publicacion publicacion =
                publicacionService.buscarPorId(id);

        PublicacionForm form = new PublicacionForm();

		/*
		 * form.setUsuarioId(publicacion.getPublicadoPor().getId());
		 * form.setMascotaId(publicacion.getMascota().getId());
		 */
        form.setTextoAdicional(publicacion.getTextoAdicional());
        form.setUbicacion(publicacion.getUbicacion());

        model.addAttribute("form", form);
        model.addAttribute("id", id);

        return "publicacion-form";
    }


    @PostMapping("/publicaciones/{id}")
    public String actualizar(
            @PathVariable("id") Long id,
            @ModelAttribute("form") PublicacionForm form) {

        publicacionService.actualizar(id, form);

        return "redirect:/publicaciones";
    }


    @GetMapping("/publicaciones/{id}/eliminar")
    public String eliminar(
            @PathVariable("id") Long id) {

        publicacionService.eliminar(id);

        return "redirect:/publicaciones";
    }
}
