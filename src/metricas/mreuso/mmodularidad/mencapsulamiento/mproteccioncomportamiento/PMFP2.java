package metricas.mreuso.mmodularidad.mencapsulamiento.mproteccioncomportamiento;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class PMFP2 implements MProteccionComportamiento{
	
	private Contexto Ctx;
	private float PMFP;
	private float NTC;
	private float FP[];
	private float FTC[];
	private float sumFPFTC;
	
	public PMFP2(Contexto Ctx) {
		this.Ctx = Ctx;
		this.NTC = Float.parseFloat(this.Ctx.getDato("PMFPNTC").toString());
		
		this.FP = new float [(int) this.NTC];
		this.FTC = new float [(int) this.NTC];
		this.sumFPFTC=0;
		
		for(int i=0; i<this.NTC; i++) {
			this.FP[i] =  Float.parseFloat(this.Ctx.getDato("PMFPFP"+i).toString());
			this.FTC[i] =  Float.parseFloat(this.Ctx.getDato("PMFPFTC"+i).toString());
		}
	}
	
	@Override
	public void Calcular() {
		for(int i=0; i<this.NTC; i++) {
			this.sumFPFTC += this.FP[i] / this.FTC[i];
		}
		this.PMFP = this.sumFPFTC / this.NTC;
		System.out.println("Metrica PMFP: " + this.PMFP);
		this.Ctx.addResponse("\"PMFP\":\""+String.format("%.4f", this.PMFP)+"\"");
	}

	@Override
	public void add(MProteccionComportamiento IMP) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");		
	}

	@Override
	public void remove(MProteccionComportamiento IMP) {}	

}
