package clientServeur;

/**
 * Interface lien entre la couche pr�senattion et Service pour la cr�ation des objets
 * @author OlivB
 *
 */
public interface IFabrique {

	public IArme creerArme();
	public IArme creerArme(String nom, int encombrement, int prix, String monnaie);
	public IArme creerArme(int idArme, String nom, int encombrement, int prix, String monnaie);


}
