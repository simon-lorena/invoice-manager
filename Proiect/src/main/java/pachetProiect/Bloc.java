package pachetProiect;

import static javax.persistence.CascadeType.ALL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Bloc {
	@Id
	private Integer id;
private Integer nr;
@ManyToOne
private Complex complex;


public Bloc(Integer id, Integer nr, List<Apartament> apartamente) {
	super();
	this.id = id;
	this.nr = nr;
	this.apartamente = apartamente;
}

@OneToMany(cascade = ALL, mappedBy = "bloc")
private List<Apartament> apartamente= new ArrayList<Apartament>();
public Bloc() {
	super();
	// TODO Auto-generated constructor stub
}

public Bloc(Integer id, Integer nr, Complex complex, List<Apartament> apartamente) {
	super();
	this.id = id;
	this.nr = nr;
	this.complex = complex;
	this.apartamente = apartamente;
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

public Complex getComplex() {
	return complex;
}

public void setComplex(Complex complex) {
	this.complex = complex;
}

public List<Apartament> getApartamente() {
	return apartamente;
}

public void setApartamente(List<Apartament> apartamente) {
	this.apartamente = apartamente;
}


}
