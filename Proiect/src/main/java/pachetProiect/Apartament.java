package pachetProiect;

import static javax.persistence.CascadeType.ALL;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Apartament {
	@Id
	private Integer id;
	private Integer nr;
	@ManyToOne
	private Bloc bloc;
	@ManyToOne(cascade = ALL)
	private Proprietar proprietar;
	
	public Apartament(Integer id, Integer nr, Proprietar proprietar) {
		super();
		this.id = id;
		this.nr = nr;
		this.proprietar = proprietar;
	}

	public Apartament(Integer id) {
		super();
		this.id = id;
	}

	public Apartament() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartament(Integer id, Integer nr, Proprietar proprietar, Bloc bloc) {
		super();
		this.id = id;
		this.nr = nr;
		this.proprietar = proprietar;
		this.bloc = bloc;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNr() {
		return nr;
	}

	public void setNr(Integer nr) {
		this.nr = nr;
	}

	public Proprietar getProprietar() {
		return proprietar;
	}

	public void setProprietar(Proprietar proprietar) {
		this.proprietar = proprietar;
	}

	public Bloc getBloc() {
		return bloc;
	}

	public void setBloc(Bloc bloc) {
		this.bloc = bloc;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apartament other = (Apartament) obj;
		return Objects.equals(id, other.id);
	}
}
