package pachetProiect;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Furnizor {
	private String nume;
	private String adresa;
	@Id
	private Integer cif;
	@Override
	public String toString() {
		return "Furnizor [nume=" + nume + ", adresa=" + adresa + ", cif=" + cif + ", cont=" + cont + ", telefon="
				+ telefon + "]";
	}
	private String cont;
	private String telefon;
	
	public Furnizor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Furnizor(Integer cif) {
		super();
		this.cif = cif;
	}
	public Furnizor(String nume, String adresa, Integer cif, String cont, String telefon) {
		super();
		this.nume = nume;
		this.adresa = adresa;
		this.cif = cif;
		this.cont = cont;
		this.telefon = telefon;
	}
	public String getNume() {
		return nume;
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public String getAdresa() {
		return adresa;
	}
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}
	public Integer getCif() {
		return cif;
	}
	public void setCif(Integer cif) {
		this.cif = cif;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getTelefon() {
		return telefon;
	}
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cif);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Furnizor other = (Furnizor) obj;
		return Objects.equals(cif, other.cif);
	}
	
	
}
