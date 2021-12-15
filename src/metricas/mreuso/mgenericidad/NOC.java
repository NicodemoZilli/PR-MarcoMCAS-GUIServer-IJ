package metricas.mreuso.mgenericidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class NOC implements MGenericidad {

	private float NOC;
	private Contexto Ctx;
		
	public NOC(Contexto Ctx) {
		this.Ctx = Ctx;
	}

	@Override
	public void add(MGenericidad IMG) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");
	}

	@Override
	public void remove(MGenericidad IMG) {}

	@Override
	public void Calcular() {
		System.out.println("Metrica FHIJ: " + this.NOC);
		this.Ctx.addResponse("\"NOC\":\""+String.format("%.4f", this.NOC)+"\"");	
	}

}
