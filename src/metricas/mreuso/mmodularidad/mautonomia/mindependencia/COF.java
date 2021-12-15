package metricas.mreuso.mmodularidad.mautonomia.mindependencia;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class COF implements MIndependencia {

	private float COF;
	private Contexto Ctx;
	private float TC;
	private float ST;
	
	public COF(Contexto Ctx) {
		this.Ctx = Ctx;
		this.TC = Float.parseFloat(this.Ctx.getDato("COFTC").toString());
		this.ST = Float.parseFloat(this.Ctx.getDato("COFST").toString());

	}
		
	@Override
	public void Calcular() {
		this.COF= (float) (this.ST / (Math.pow(this.TC,2)-this.TC));
		System.out.println("Metrica COF: " + this.COF);
		this.Ctx.addResponse("\"COF\":\""+String.format("%.4f", this.COF)+"\"");
	}

	@Override
	public void add(MIndependencia IMI) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");		
	}

	@Override
	public void remove(MIndependencia IMI) {}

}
