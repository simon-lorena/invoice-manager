package pachetProiect;

import javax.persistence.Entity;

@Entity
public class PersoanaFizica extends Proprietar {
	private String cnp;

	public String getCnp() {
		return cnp;
	}

	public void setCnp(String cnp) {
		this.cnp = cnp;
	}
	public PersoanaFizica() {
		super();

	}

	public PersoanaFizica(String cnp) {
		super();
		this.cnp = cnp;
	}

	public PersoanaFizica(Integer id, String nume, String cnp) {
		super(id, nume);
		this.cnp = cnp;
	}
	
}
