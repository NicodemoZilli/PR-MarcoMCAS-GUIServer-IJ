package metricas.mreuso.mmodularidad.mencapsulamiento.mproteccioncomportamiento;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class PM implements MProteccionComportamiento{
	
	private Contexto Ctx;
	private float PM;
	private float FNP;
	private float TF;
	
	public PM(Contexto Ctx) {
		this.Ctx = Ctx;
		this.FNP = Float.parseFloat(this.Ctx.getDato("PMFNP").toString());
		this.TF = Float.parseFloat(this.Ctx.getDato("PMTF").toString());
	}

	@Override
	public void Calcular() {
		this.PM = this.FNP / this.TF;
		System.out.println("Metrica PM: " + this.PM);
		this.Ctx.addResponse("\"PM\":\""+String.format("%.4f", this.PM)+"\"");
	}

	@Override
	public void add(MProteccionComportamiento IMP) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");		
	}

	@Override
	public void remove(MProteccionComportamiento IMP) {}

}