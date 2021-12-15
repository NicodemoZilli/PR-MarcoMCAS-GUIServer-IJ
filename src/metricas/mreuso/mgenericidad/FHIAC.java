package metricas.mreuso.mgenericidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class FHIAC implements MGenericidad {

	private float FHIAC;
	private float FHIJ;
	private float NOH;
	private Contexto Ctx;


	public FHIAC(Contexto Ctx) {
		this.Ctx = Ctx;
		this.FHIJ = Float.parseFloat(this.Ctx.getDato("FHIACFHIJ").toString());
		this.NOH = Float.parseFloat(this.Ctx.getDato("FHIACNOH").toString());
	}

	@Override
	public void add(MGenericidad IMG) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");
	}

	@Override
	public void remove(MGenericidad IMG) {}

	@Override
	public void Calcular() {
		this.FHIAC = this.FHIJ / this.NOH;
		System.out.println("Metrica FHIAC: " + this.FHIAC);
		this.Ctx.addResponse("\"FHIAC\":\""+String.format("%.4f", this.FHIAC)+"\"");
	}
}
