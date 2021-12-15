package metricas.mreuso.mmodularidad.mautonomia.municaresponsabilidad;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import metricas.mreuso.mmodularidad.mautonomia.MAutonomia;

public interface MUnicaResponsabilidad extends MAutonomia{
	
	void add(MUnicaResponsabilidad IMUR);
	
	void remove(MUnicaResponsabilidad IMUR);
}
