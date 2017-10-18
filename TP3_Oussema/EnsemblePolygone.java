package dessin;

public class EnsemblePolygone
{
    // data
    private final int TAILLE_MAX;
    private int placeRestante; // place restante dans l'ensemble
    private Polygone polygones[];;

    // constructors
    public EnsemblePolygone (int tailleMax)
    {
	if (tailleMax < 0)
	    {
		System.out.println("taille de l'ensemble invalide donc a creer un ensemble de taille 1");
		tailleMax = 1;
	    }
	TAILLE_MAX = tailleMax;
	polygones = new Polygone[tailleMax];
	placeRestante = tailleMax;
    }

    // methods
    /**
     * Pour ajoute un nouveau objet Polygone à condition que sa capacité n'est pas dépassé.
     *
     * @param Polygone nouveau objet Polygone
     */
    public void ajouterPolygone (Polygone pol)
    {
	if (placeRestante > 0)
	    {
		this.polygones[TAILLE_MAX - placeRestante] = pol;
		placeRestante --;
	    }
	else
	    {
		System.out.println("L'Ensemble n'a plus de place donc le dernier ajout a été annulé !!!");
	    }
    }

    /**
     * Retourne la somme de tous les perimetres de ses polygones
     *
     * @return double Somme total des perimtres des polygones
     */
    public double  sommePerimetres ()
    {
	int i;
	double somme = 0.0d;
	for (i = 0; i < TAILLE_MAX; i++)
	    {
		somme += polygones[i].perimetre();
	    }

	return somme;
    }
    /**
     * Pour afficher les polygones qu'il contient
     */
    public void affiche ()
    {
	System.out.println(this.toString());
    }
    public String toString ()
    {
	int i;
	String str = new String();
for (i = 0; i < TAILLE_MAX; i++)
	    {
		str += polygones[i] + "; ";
	    }	str = " Ensemble de polygone : \n";
	for (i = 0; i < TAILLE_MAX; i++)
	    {
		str += polygones[i] + "; ";
	    }

	return str;
    }

    public double sommeSurface()
	{	double surface = 0;
	
		for(int i=0;i<TAILLE_MAX;i++)
		{ 
		if (polygones[i].surface()!=-1)
		{
		surface+=polygones[i].surface();
		}
		}
		return surface;
	}

}


