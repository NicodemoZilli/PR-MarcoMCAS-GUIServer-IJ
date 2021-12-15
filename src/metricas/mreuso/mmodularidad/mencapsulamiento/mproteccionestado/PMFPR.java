package metricas.mreuso.mmodularidad.mencapsulamiento.mproteccionestado;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class PMFPR implements MProteccionEstado{
	
	private Contexto Ctx;
	private float PMFPR;
	private float NTJ;
	private float FPR[];
	private float NTF[];
	private float sumFPRNTF;
	
	public PMFPR(Contexto Ctx) {
		this.Ctx = Ctx;
		this.NTJ = Float.parseFloat(this.Ctx.getDato("PMFPRNTJ").toString());
		
		this.FPR = new float [(int) this.NTJ];
		this.NTF = new float [(int) this.NTJ];
		this.sumFPRNTF=0;
		
		for(int i=0; i<this.NTJ; i++) {
			this.FPR[i] =  Float.parseFloat(this.Ctx.getDato("PMFPRFPR"+i).toString());
			this.NTF[i] =  Float.parseFloat(this.Ctx.getDato("PMFPRNTF"+i).toString());
		}
	}
	
	@Override
	public void Calcular() {
		this.PMFPR=0;
		for(int i=0; i<this.NTJ; i++) {
			this.sumFPRNTF += this.FPR[i] / this.NTF[i];
		}
		this.PMFPR = this.sumFPRNTF / this.NTJ;
		System.out.println("Metrica PMFPR: " + this.PMFPR);
		this.Ctx.addResponse("\"PMFPR\":\""+String.format("%.4f", this.PMFPR)+"\"");
	}

	@Override
	public void add(MProteccionEstado IMP) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");		
	}

	@Override
	public void remove(MProteccionEstado IMP) {}

	

}
