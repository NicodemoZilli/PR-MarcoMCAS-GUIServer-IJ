package metricas.mreuso.mflexibilidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class FP implements MFlexibilidad {

	private Contexto Ctx;
	private float FP;
	private float TC;
	private float Mn [];
	private float Mo [];
	private float DC [];
	private float sumMo;
	private float sumMnDC;

	public FP(Contexto Ctx) {
		this.Ctx = Ctx;
		this.TC = Float.parseFloat(this.Ctx.getDato("FPTC").toString());

		this.Mn = new float [(int) this.TC];
		this.Mo = new float [(int) this.TC];
		this.DC = new float [(int) this.TC];
		this.sumMo=0;
		this.sumMnDC=0;
		
		for(int i=0; i<this.TC; i++) {
			this.Mn[i] =  Float.parseFloat(this.Ctx.getDato("FPMn"+i).toString());
			this.Mo[i] =  Float.parseFloat(this.Ctx.getDato("FPMo"+i).toString());
			this.DC[i] =  Float.parseFloat(this.Ctx.getDato("FPDC"+i).toString());
		}
		
	}

	@Override
	public void Calcular() {
		
		for(int i=0; i<this.TC; i++) {
			this.sumMo += this.Mo[i];
			this.sumMnDC += (this.Mn[i] * this.DC[i]);
		}
		
		this.FP = this.sumMo / this.sumMnDC;
		System.out.println("Metrica FP: " + this.FP);
		this.Ctx.addResponse("\"FP\":\""+String.format("%.4f", this.FP)+"\"");
	}

	@Override
	public void add(MFlexibilidad IMF) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");

	}

	@Override
	public void remove(MFlexibilidad IMF) {}

}
