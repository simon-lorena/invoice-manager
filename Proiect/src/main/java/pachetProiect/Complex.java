package pachetProiect;

import static javax.persistence.CascadeType.ALL;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class Complex {
	@Id
 private Integer id;
 private String nume;
 private String oras;
 @OneToMany(cascade = ALL, mappedBy = "complex")
 private List<Bloc> blocuri=new ArrayList<Bloc>();
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNume() {
	return nume;
}
public void setNume(String nume) {
	this.nume = nume;
}
public String getOras() {
	return oras;
}
public void setOras(String oras) {
	this.oras = oras;
}
public List<Bloc> getBlocuri() {
	return blocuri;
}
public void setBlocuri(List<Bloc> blocuri) {
	this.blocuri = blocuri;
}
public Complex(Integer id, String nume, String oras) {
	super();
	this.id = id;
	this.nume = nume;
	this.oras = oras;
}
public Complex(Integer id, String nume, String oras, List<Bloc> blocuri) {
	super();
	this.id = id;
	this.nume = nume;
	this.oras = oras;
	this.blocuri = blocuri;
}
public Complex() {
	super();
	// TODO Auto-generated constructor stub
}
 
}
