package metricas.mreuso.mmodularidad.mautonomia.mindependencia;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import java.util.ArrayList;
import java.util.List;

import main.Contexto;
import metricas.mreuso.mgenericidad.DIT;
import metricas.mreuso.mgenericidad.MGenericidad;

public class LMetricasMI implements MIndependencia{
	
	private List<MIndependencia> LisMet;
	private Contexto Ctx;
	
	public LMetricasMI(Contexto Ctx) {
		this.LisMet = new ArrayList<MIndependencia>();
		this.Ctx = Ctx;
		
		for(String metrica : this.Ctx.getMetricas()) 
	 	{
			if(metrica.equals("Canales")) {
				this.add(new Canales(this.Ctx));
			}else if(metrica.equals("COF")) {
				this.add(new COF(this.Ctx));
			}
	 	}
	}

	@Override
	public void Calcular() {
		for (MIndependencia item : this.LisMet) {
			item.Calcular();
		}
	}

	@Override
	public void add(MIndependencia IMI) {
		assert IMI != null;
		this.LisMet.add(IMI);
	}

	@Override
	public void remove(MIndependencia IMI) {
		assert IMI != null;
		this.LisMet.remove(IMI);
	}


}
