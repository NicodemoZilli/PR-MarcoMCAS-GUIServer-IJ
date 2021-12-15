package metricas.mreuso.mmodularidad.mencapsulamiento.mproteccioncomportamiento;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import metricas.mreuso.mmodularidad.mencapsulamiento.MEncapsulamiento;

public interface MProteccionComportamiento extends MEncapsulamiento{
	
	void add(MProteccionComportamiento IMP);

	void remove(MProteccionComportamiento IMP);

}