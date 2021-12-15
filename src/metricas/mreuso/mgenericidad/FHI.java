package metricas.mreuso.mgenericidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class FHI implements MGenericidad {

	private float FHI;
	private float Mv;
	private float Mnv;
	private float Tm; 
	private Contexto Ctx;
	
	public FHI(Contexto Ctx) {
		this.Ctx = Ctx;
		this.Mv = Float.parseFloat(this.Ctx.getDato("FHIMv").toString());
		this.Mnv = Float.parseFloat(this.Ctx.getDato("FHIMnv").toString());
		this.Tm = Float.parseFloat(this.Ctx.getDato("FHITm").toString());
	}

	@Override
	public void add(MGenericidad IMG) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");
	}

	@Override
	public void remove(MGenericidad IMG) {}

	@Override
	public void Calcular() {
		this.FHI = (this.Mv + this.Mnv)/this.Tm;
		System.out.println("Metrica FHI: " + this.FHI);
		this.Ctx.addResponse("\"FHI\":\""+String.format("%.4f", this.FHI)+"\"");
	}

}
