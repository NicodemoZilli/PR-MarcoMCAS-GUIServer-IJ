package metricas.mreuso.mgenericidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class FHIJ implements MGenericidad {

	private float FHIJ;
	private float FHI;
	private float Tc;
	private Contexto Ctx;

	public FHIJ(Contexto Ctx) {
		this.Ctx = Ctx;
		this.FHI = Float.parseFloat(this.Ctx.getDato("FHIJFHI").toString());
		this.Tc = Float.parseFloat(this.Ctx.getDato("FHIJTc").toString());
	}

	@Override
	public void add(MGenericidad IMG) {
		throw new UnsupportedOperationException("Operacion no Soportada en DIT add");
	}

	@Override
	public void remove(MGenericidad IMG) {}

	@Override
	public void Calcular() {
		this.FHIJ = this.FHI / (this.Tc - 1);
		System.out.println("Metrica FHIJ: " + this.FHIJ);
		this.Ctx.addResponse("\"FHIJ\":\""+String.format("%.4f", this.FHIJ)+"\"");
	}

}
