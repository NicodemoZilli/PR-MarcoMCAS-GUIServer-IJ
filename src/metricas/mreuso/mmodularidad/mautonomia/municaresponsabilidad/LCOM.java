package metricas.mreuso.mmodularidad.mautonomia.municaresponsabilidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import main.Contexto;

public class LCOM implements MUnicaResponsabilidad{
	
	private  Contexto Ctx;
	private float LCOM;
	private float a;
	private float m;
	private float muA [];
	private float smuA;
	
	
	public LCOM(Contexto Ctx) {
		this.Ctx = Ctx;
		this.a = Float.parseFloat(this.Ctx.getDato("LCOMa").toString());
		this.m = Float.parseFloat(this.Ctx.getDato("LCOMm").toString());
		this.muA = new float [(int) this.a];
		for(int i=0; i<this.a; i++) {
			this.muA[i] =  Float.parseFloat(this.Ctx.getDato("LCOMmuA"+i).toString());
		}
	}


	@Override
	public void Calcular() {
		for(int i=0; i<this.a; i++) {
			this.smuA += this.muA[i];
		}
		this.LCOM= (((1/this.a)*this.smuA)-this.m)/(1-this.m);
		System.out.println("Metrica LCOM: " + this.LCOM);
		this.Ctx.addResponse("\"LCOM\":\""+String.format("%.4f", this.LCOM)+"\"");
	}

	@Override
	public void add(MUnicaResponsabilidad IMUR) {
		throw new UnsupportedOperationException("Operacion no Soportada en add");		
	}

	@Override
	public void remove(MUnicaResponsabilidad IMUR) {}

}
