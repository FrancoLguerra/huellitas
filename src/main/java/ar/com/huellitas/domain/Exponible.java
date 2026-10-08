package ar.com.huellitas.domain;
import ar.com.huellitas.dtos.DTO;
import ar.com.huellitas.forms.RegistracionForm;

public abstract class Exponible <F extends RegistracionForm, D extends DTO>{

	public abstract D asDTO();
}
