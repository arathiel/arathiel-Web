package util.trait;

/**
 * Adresses de connexion aux différents services
 * @author Jonathan Fuentes
 *
 */
public class Parameter {

	public static final String SERVICE_TRAIT 		= "ejb:/ZArathiel-Server/FacadeTraitServ!clientServeur.IFacadeService";
	public static final String ENRICHISSEUR  		= "ejb:/ZArathiel-Server/TraitFactory!clientServeur.factory.EnrichisseurRP";
	
	public static final String SERVICE_ARATHIEL 	= "ejb:/arathiel-EJB/FacadeService!clientServeur.IFacadeService";
	public static final String ENRICHISSEUR_ARA  	= "ejb:/arathiel-EJB/TraitFactory!clientServeur.trait.EnrichisseurRP";
}
