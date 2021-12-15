package metricas.mreuso.mflexibilidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import metricas.mreuso.MReuso;

public interface MFlexibilidad extends MReuso {

	void add(MFlexibilidad IMF);

	void remove(MFlexibilidad IMF);

}
