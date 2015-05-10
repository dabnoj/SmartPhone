package misc;


import java.io.Serializable;

public class Contact implements Comparable<Contact>, Serializable {

	private static final long serialVersionUID = -2400446824332569780L;

	private String prenom;
	private String nom;
	private String numero;
	private String image;

	//getters setters
	public String getPrenom() { return prenom; }

	public void setPrenom(String prenom) { this.prenom = prenom; }

	public String getNom() { return nom; }

	public void setNom(String nom) { this.nom = nom; }

	public String getNumero() { return numero; }

	public void setNumero(String numero) {this.numero = numero; }

	public String getImage() { return image; }

	public void setImage(String image) { this.image = image; }

	/**
	 * methode pour trier les listes de contacts selon le nom -> implémente
	 * l'interface comparable (appelé par la méthode Collections.sort(List))
	 */
	@Override
	public int compareTo(Contact another) {

		if (getNom() == null)
			if (another.getNom() == null)
				return 0;
			else
				return -1;
		else if (another.getNom() == null)
			return 1;
		else
			return getNom().compareTo(another.getNom());
	}
}
