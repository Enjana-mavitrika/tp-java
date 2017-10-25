package dessin;

public class EnsemblePolygone
{
  
  /*------------------------------------------------
   *                   data                        *
   *                                               *
   *-----------------------------------------------*/
  
  protected final int TAILLE_MAX;
  protected int placeRestante; // place restante dans l'ensemble
  protected Polygone polygones[];;

  
  /*------------------------------------------------
   *               constructors                    *
   *                                               *
   *-----------------------------------------------*/
  
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
  

  /*------------------------------------------------
   *                   methods                     *
   *                                               *
   *-----------------------------------------------*/
  
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
    double somme = 0.0d;
    for (int i = 0; i < TAILLE_MAX; i++)
    {
      somme += polygones[i].perimetre();
    }

    return somme;
  }

  /**
   * Methode qui calcul la somme des surfaces des polygones convexes de l'ensemble
   *
   * @return double : la somme des surfaces
   */
  public double sommeSurface ()
  {
    double somme = 0.0d;
    for (int i = 0; i < TAILLE_MAX; i++)
      somme += (polygones[i].estConvexe()) ? polygones[i].surface() : 0.0d;
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
    str = "\n Ensemble de polygone ("+ TAILLE_MAX +") : \n";
    for (i = 0; i < TAILLE_MAX; i++)
    {
      str += polygones[i] + "; ";
    }

    return str;
  }
}
