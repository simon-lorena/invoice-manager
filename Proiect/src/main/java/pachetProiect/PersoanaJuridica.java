package pachetProiect;

import javax.persistence.Entity;

@Entity
public class PersoanaJuridica extends Proprietar {
	private Integer cif;

	public Integer getCif() {
		return cif;
	}

	public void setCif(Integer cif) {
		this.cif = cif;
	}

	public PersoanaJuridica() {
		super();

	}

	public PersoanaJuridica(Integer cif) {
		super();
		this.cif = cif;
	}

	public PersoanaJuridica(Integer id, String nume, Integer cif) {
		super(id, nume);
		this.cif = cif;
	}
	

}
