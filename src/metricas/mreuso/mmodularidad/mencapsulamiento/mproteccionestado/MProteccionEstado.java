package metricas.mreuso.mmodularidad.mencapsulamiento.mproteccionestado;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import metricas.mreuso.mmodularidad.mencapsulamiento.MEncapsulamiento;

public interface MProteccionEstado extends MEncapsulamiento{
	
	void add(MProteccionEstado IMP);

	void remove(MProteccionEstado IMP);

}
