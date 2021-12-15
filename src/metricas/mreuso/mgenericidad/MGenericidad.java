package metricas.mreuso.mgenericidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import metricas.mreuso.MReuso;

public interface MGenericidad extends MReuso {
	
	void add(MGenericidad IMG);

	void remove(MGenericidad IMG);

}
