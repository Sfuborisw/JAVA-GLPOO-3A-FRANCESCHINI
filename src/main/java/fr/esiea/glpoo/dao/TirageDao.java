package fr.esiea.glpoo.dao;

import java.io.File;
import java.util.List;

import fr.esiea.glpoo.tirage.Tirage;

public interface TirageDao {

	List<Tirage> findAllTirage() throws Exception;

	void init(File file);
}
