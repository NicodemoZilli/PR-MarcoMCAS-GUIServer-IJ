package metricas.mreuso.mmodularidad.mlegibilidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import metricas.mreuso.mmodularidad.MModularidad;

public interface MLegibilidad extends MModularidad{
	
	void add(MLegibilidad IML);

	void remove(MLegibilidad IML);

}
