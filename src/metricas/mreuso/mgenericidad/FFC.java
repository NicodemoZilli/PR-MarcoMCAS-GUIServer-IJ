package metricas.mreuso.mgenericidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class FFC implements MGenericidad {

	private float FFC;
	private float NOP;
	private float Tm;
	private Contexto Ctx;

	public FFC(Contexto Ctx) {
		this.Ctx = Ctx;
		this.NOP = Float.parseFloat(this.Ctx.getDato("FFCNOP").toString());
		this.Tm = Float.parseFloat(this.Ctx.getDato("FFCTm").toString());
	}

	@Override
	public void add(MGenericidad IMG) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");
	}

	@Override
	public void remove(MGenericidad IMG) {}

	@Override
	public void Calcular() {
		this.FFC = this.NOP / this.Tm;
		System.out.println("Metrica FFC: " + this.FFC);
		this.Ctx.addResponse("\"FFC\":\""+String.format("%.4f", this.FFC)+"\"");
	}

}
