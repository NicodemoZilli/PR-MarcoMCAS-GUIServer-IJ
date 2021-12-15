package metricas.mreuso.mmodularidad.mlegibilidad;

import main.Contexto;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

public class LOC implements MLegibilidad{
	
	private Contexto Ctx;
	private float LOC;
	
	public LOC(Contexto Ctx) {
		this.Ctx = Ctx;
	}

	@Override
	public void Calcular() {
		this.LOC=0;
	}

	@Override
	public void add(MLegibilidad IML) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");
	}

	@Override
	public void remove(MLegibilidad IML) {}

}
