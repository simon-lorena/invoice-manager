package pachetProiect;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Produs {
	// Atribute private
	@Id
	private Integer cod;
	
	private String denumire;
	
	
	private Double pretUnitar;
	
	private Double procentTVA;

	// Constructori
	
	public Produs(Integer cod, String denumire, Double pretUnitar, Double procentTVA) {
		super();
		this.cod = cod;
		this.denumire = denumire;
		this.pretUnitar = pretUnitar;
		this.procentTVA = procentTVA;
	}
	
	public Produs(Integer cod) {
		super();
		this.cod = cod;
	}

	public Double getProcentTVA() {
		return procentTVA;
	}

	public void setProcentTVA(Double procentTVA) {
		this.procentTVA = procentTVA;
	}

	public Produs(){}
	
	// Getteri si setteri
	
	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}


	public Double getPretUnitar() {
		return pretUnitar;
	}

	public void setPretUnitar(Double pretUnitar) {
		this.pretUnitar = pretUnitar;
	}

	// Criteriu de egalitate
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produs other = (Produs) obj;
		if (cod == null) {
			if (other.cod != null)
				return false;
		} else if (!cod.equals(other.cod))
			return false;
		return true;
	}	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cod == null) ? 0 : cod.hashCode());
		return result;
	}	
	
	// Operatii specifice logicii modelului afacerii	
	
	public String toString(){
		return "Produs: cod:" + this.cod + ", denumire:"  + this.denumire;
	}

		
	
}