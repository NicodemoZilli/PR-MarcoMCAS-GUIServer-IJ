package metricas.mreuso.mgenericidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import java.util.ArrayList;
import java.util.List;
import main.Contexto;

public class LMetricasMG implements MGenericidad {

	private List<MGenericidad> LisMet;
	private Contexto Ctx;

	public LMetricasMG( Contexto Ctx) {
		this.Ctx = Ctx;
		this.LisMet = new ArrayList<MGenericidad>();
		
		for(String metrica : this.Ctx.getMetricas()) 
	 	{
			if(metrica.equals("DIT")) {
				this.add(new DIT(this.Ctx));
			}else if(metrica.equals("NOC")){
				this.add(new NOC(this.Ctx));
			}else if(metrica.equals("FHI")){
				this.add(new FHI(this.Ctx));
			}else if(metrica.equals("FHIJ")){
				this.add(new FHIJ(this.Ctx));
			}else if(metrica.equals("FFC")){
				this.add(new FFC(this.Ctx));
			}else if(metrica.equals("FHIAC")){
				this.add(new FHIAC(this.Ctx));
			}else if(metrica.equals("FMFAC")) {
				this.add(new FMFAC(this.Ctx));
			}
	 	}
	}

	@Override
	public void add(MGenericidad IMG) {
		assert IMG != null;
		this.LisMet.add(IMG);
	}

	@Override
	public void remove(MGenericidad IMG) {
		assert IMG != null;
		this.LisMet.remove(IMG);
	}

	@Override
	public void Calcular() {
		for (MGenericidad item : this.LisMet) {
			item.Calcular();
		}
	}

}
