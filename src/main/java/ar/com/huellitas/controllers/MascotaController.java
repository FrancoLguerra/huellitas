package ar.com.huellitas.controllers;

import java.net.http.HttpClient.Redirect;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ar.com.huellitas.domain.Mascota;
import ar.com.huellitas.enums.EspecieMascota;
import ar.com.huellitas.enums.GeneroMascota;
import ar.com.huellitas.forms.MascotaForm;
import ar.com.huellitas.services.MascotaService;

@Controller
public class MascotaController {
	
	private final MascotaService mascotaService;
	
	public MascotaController(MascotaService mascotaService) {
		this.mascotaService = mascotaService;
	}
	
	@GetMapping("/mascotas")
	public String listar(Model model) {
		model.addAttribute("mascotas", mascotaService.listar());
		return "mascotas";
	}
	
	@GetMapping("/mascotas/nuevo")
	public String nueva(Model model) {
		model.addAttribute("form", new MascotaForm());

	    model.addAttribute(
	            "especies",
	            EspecieMascota.values()
	    );

	    model.addAttribute(
	            "generos",
	            GeneroMascota.values()
	    );
		return "mascota-form";
	}
	
	@PostMapping("/mascotas")
	public String registrar(@ModelAttribute("form") MascotaForm form) {
		   mascotaService.registrar(
		            form.getNombre(),
		            form.getEspecie(),
		            form.getGenero(),
		            form.getColor(),
		            form.getRaza(),
		            form.isCastrado()
		    );
		return "redirect:/mascotas";
	}
    @GetMapping("/mascotas/{id}/editar")
    public String editar(@PathVariable("id") Long id, Model model) {

        Mascota mascota = mascotaService.buscarPorId(id);

        MascotaForm form = new MascotaForm();

        form.setNombre(mascota.getNombre());
        form.setEspecie(mascota.getEspecie());
        form.setGenero(mascota.getGenero());
        form.setColor(mascota.getColor());
        form.setRaza(mascota.getRaza());
        form.setCastrado(mascota.isCastrado());

        model.addAttribute("form", form);
        model.addAttribute("id", id);
        model.addAttribute("especies", EspecieMascota.values());
        model.addAttribute("generos", GeneroMascota.values());

        return "mascota-form";
    }
	
	@GetMapping("mascotas/{id}/eliminar")
	public String eliminar(@PathVariable("id") Long id) {
		mascotaService.eliminar(id);
		return "redirect:/mascotas";
	}
}
