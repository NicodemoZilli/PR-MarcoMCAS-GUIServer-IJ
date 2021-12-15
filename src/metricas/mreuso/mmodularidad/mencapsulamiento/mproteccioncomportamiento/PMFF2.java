package metricas.mreuso.mmodularidad.mencapsulamiento.mproteccioncomportamiento;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class PMFF2 implements MProteccionComportamiento{
	
	private Contexto Ctx;
	private float PMFF;
	private float FF;
	private float NTF;
	
	public PMFF2(Contexto Ctx) {
		this.Ctx = Ctx;
		this.FF = Float.parseFloat(this.Ctx.getDato("PMFFFF").toString());
		this.NTF = Float.parseFloat(this.Ctx.getDato("PMFFNTF").toString());

	}
	
	@Override
	public void Calcular() {
		this.PMFF = this.FF / this.NTF;
		System.out.println("Metrica PMFF: " + this.PMFF);
		this.Ctx.addResponse("\"PMFF\":\""+String.format("%.4f", this.PMFF)+"\"");
	}

	@Override
	public void add(MProteccionComportamiento IMP) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");		
	}

	@Override
	public void remove(MProteccionComportamiento IMP) {}

	

}
