package metricas.mreuso.mgenericidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class FMFAC implements MGenericidad {

	private float FMFAC;
	private float FFC;
	private float Tc;
	private Contexto Ctx;

	public FMFAC(Contexto Ctx) {
		this.Ctx = Ctx;
		this.FFC = Float.parseFloat(this.Ctx.getDato("FMFACFFC").toString());
		this.Tc = Float.parseFloat(this.Ctx.getDato("FMFACTc").toString());
	}

	@Override
	public void add(MGenericidad IMG) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");
	}

	@Override
	public void remove(MGenericidad IMG) {}

	@Override
	public void Calcular() {
		this.FMFAC = this.FFC / this.Tc;
		System.out.println("Metrica FMFAC: " + this.FMFAC);
		this.Ctx.addResponse("\"FMFAC\":\""+String.format("%.4f", this.FMFAC)+"\"");
	}
}
