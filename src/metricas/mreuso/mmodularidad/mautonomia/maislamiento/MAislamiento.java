package metricas.mreuso.mmodularidad.mautonomia.maislamiento;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;
import metricas.mreuso.mmodularidad.mautonomia.MAutonomia;



public class MAislamiento implements MAutonomia{

	private Contexto Ctx;
	private float MA;
	
	public MAislamiento(Contexto Ctx) {
		this.Ctx = Ctx;
	}
	
	@Override
	public void Calcular() {
		this.MA=0;
	}

}
