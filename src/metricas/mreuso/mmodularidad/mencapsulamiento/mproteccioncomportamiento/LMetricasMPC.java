package metricas.mreuso.mmodularidad.mencapsulamiento.mproteccioncomportamiento;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import java.util.ArrayList;
import java.util.List;

import main.Contexto;

public class LMetricasMPC implements MProteccionComportamiento{

	private List<MProteccionComportamiento> LisMet;
	private Contexto Ctx;
	
	public LMetricasMPC(Contexto Ctx) {
		this.LisMet = new ArrayList<MProteccionComportamiento>();
		this.Ctx = Ctx;
		for(String metrica : this.Ctx.getMetricas()) 
	 	{
			if(metrica.equals("PM")) {
				this.add(new PM(this.Ctx));
			}else if(metrica.equals("TPM")) {
				this.add(new TPM(this.Ctx));
			}else if(metrica.equals("PMFP")) {
				this.add(new PMFP2(this.Ctx));
			}else if(metrica.equals("PMFPR")) {
				this.add(new PMFPR2(this.Ctx));
			}else if(metrica.equals("PMFF")) {
				this.add(new PMFF2(this.Ctx));
			}
	 	}
	}

	@Override
	public void add(MProteccionComportamiento IMPC) {
		assert IMPC != null;
		this.LisMet.add(IMPC);
	}

	@Override
	public void remove(MProteccionComportamiento IMPC) {
		assert IMPC != null;
		this.LisMet.remove(IMPC);
	}

	@Override
	public void Calcular() {
		for (MProteccionComportamiento item : this.LisMet) {
			item.Calcular();
		}
	}

}