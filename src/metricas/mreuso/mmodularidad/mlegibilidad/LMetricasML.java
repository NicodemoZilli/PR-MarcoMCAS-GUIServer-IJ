package metricas.mreuso.mmodularidad.mlegibilidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import java.util.ArrayList;
import java.util.List;

import main.Contexto;


public class LMetricasML implements MLegibilidad{
	
	
	private List<MLegibilidad> LisMet;
	private Contexto Ctx;
	
	public LMetricasML(Contexto Ctx) {
		this.Ctx = Ctx;
		this.LisMet = new ArrayList<MLegibilidad>();
		for(String metrica : this.Ctx.getMetricas()) 
	 	{
			if(metrica.equals("LOC")) {
				this.add(new LOC(this.Ctx));
			}else if(metrica.equals("CC")) {
				this.add(new CC(this.Ctx));
			}else if(metrica.equals("WMC")){
				this.add(new WMC(this.Ctx));
			}
	 	}
	}

	@Override
	public void add(MLegibilidad IML) {
		assert IML != null;
		this.LisMet.add(IML);
	}

	@Override
	public void remove(MLegibilidad IML) {
		assert IML != null;
		this.LisMet.remove(IML);
	}

	@Override
	public void Calcular() {
		for(MLegibilidad item : this.LisMet){
			item.Calcular();
		}
	}

}
