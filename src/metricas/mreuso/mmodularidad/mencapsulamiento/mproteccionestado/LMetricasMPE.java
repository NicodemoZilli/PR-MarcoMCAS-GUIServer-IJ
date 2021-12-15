package metricas.mreuso.mmodularidad.mencapsulamiento.mproteccionestado;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import java.util.ArrayList;
import java.util.List;
import main.Contexto;

public class LMetricasMPE implements MProteccionEstado{
	
	private Contexto Ctx;
	private List<MProteccionEstado> LisMet;

	public LMetricasMPE(Contexto Ctx) {
		this.Ctx = Ctx;
		this.LisMet = new ArrayList<MProteccionEstado>();

		for(String metrica : this.Ctx.getMetricas())
		{
			if(metrica.equals("PMFP")) {
				this.add(new PMFP(this.Ctx));
			}else if(metrica.equals("PMFPR")) {
				this.add(new PMFPR(this.Ctx));
			}else if(metrica.equals("PMFF")) {
				this.add(new PMFF(this.Ctx));
			}
		}
	}

	@Override
	public void add(MProteccionEstado IMPE) {
		assert IMPE != null;
		this.LisMet.add(IMPE);
	}

	@Override
	public void remove(MProteccionEstado IMPE) {
		assert IMPE != null;
		this.LisMet.remove(IMPE);
	}

	@Override
	public void Calcular() {
		for(MProteccionEstado item : this.LisMet){
			item.Calcular();
		}
	}

}
