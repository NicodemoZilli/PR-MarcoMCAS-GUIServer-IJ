package metricas.mreuso.mmodularidad.mautonomia.mindependencia;

/**
 * @author David Nicodemo Zilli Vazquez
 * @version 1.0
 * @created Oct Dic 2021
 */

import metricas.mreuso.mmodularidad.mautonomia.MAutonomia;

public interface MIndependencia extends MAutonomia{
	
	void add(MIndependencia IMI);
	
	void remove(MIndependencia IMI);
}
