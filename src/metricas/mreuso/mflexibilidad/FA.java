package metricas.mreuso.mflexibilidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class FA implements MFlexibilidad {

	private Contexto Ctx;
	private float FA;
	private float TCA;
	private float TC;

	public FA(Contexto Ctx) {
		this.Ctx = Ctx;
		this.TCA = Float.parseFloat(this.Ctx.getDato("FATCA").toString());
		this.TC = Float.parseFloat(this.Ctx.getDato("FATC").toString());
	}

	@Override
	public void add(MFlexibilidad IMF) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");

	}

	@Override
	public void remove(MFlexibilidad IMF) {}
	
	@Override
	public void Calcular() {
		this.FA = this.TCA/this.TC;
		System.out.println("Metrica FA: " + this.FA);
		this.Ctx.addResponse("\"FA\":\""+String.format("%.4f", this.FA)+"\"");
	}

}
