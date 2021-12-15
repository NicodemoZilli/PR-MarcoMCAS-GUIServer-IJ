package metricas.mreuso.mmodularidad.mencapsulamiento.mproteccioncomportamiento;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class TPM implements MProteccionComportamiento{
	
	private Contexto Ctx;
	private float TPM;
	private float PMFP;
	private float PMFPR;
	private float PMFF;
	
	public TPM(Contexto Ctx) {
		this.Ctx = Ctx;
		this.PMFP = Float.parseFloat(this.Ctx.getDato("TPMPMFP").toString());
		this.PMFPR = Float.parseFloat(this.Ctx.getDato("TPMPMFPR").toString());
		this.PMFF = Float.parseFloat(this.Ctx.getDato("TPMPMFF").toString());
	}

	@Override
	public void Calcular() {
		this.TPM = (this.PMFP + this.PMFPR + this.PMFF)/3;
		System.out.println("Metrica TPM: " + this.TPM);
		this.Ctx.addResponse("\"TPM\":\""+String.format("%.4f", this.TPM)+"\"");
	}

	@Override
	public void add(MProteccionComportamiento IMP) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");		
	}

	@Override
	public void remove(MProteccionComportamiento IMP) {}
}