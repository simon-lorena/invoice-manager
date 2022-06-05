package pachetProiect;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Factura {
	@Id
private Integer nrFactura;
	@Temporal(TemporalType.DATE)
private Date dataEmiterii;
	@Temporal(TemporalType.DATE)
private Date dataScadenta;
	@ManyToOne
private Furnizor furnizorFactura;
	@OneToMany(cascade = ALL, mappedBy = "factura")
private List<ArticolFactura> articole = new ArrayList<ArticolFactura>(); 
private Double totalPlata;


private StareFactura stare=StareFactura.Scadenta;

@ManyToOne
private Apartament apartamentFactura;

public Apartament getApartamentFactura() {
	return apartamentFactura;
}
public void setApartamentFactura(Apartament apartamentFactura) {
	this.apartamentFactura = apartamentFactura;
}
public StareFactura getStare() {
	return stare;
}

public Long getZilePanaLaScadenta(){
	Date dataCurenta= new Date();
	long zileRamase=this.getDataScadenta().getTime()-dataCurenta.getTime();
    TimeUnit time = TimeUnit.DAYS; 
    zileRamase = time.convert(zileRamase, TimeUnit.MILLISECONDS);
    return zileRamase;
}
public Factura() {
	super();
}
public void setStare(StareFactura stare) {
	this.stare = stare;
}
public Integer getNrFactura() {
	return nrFactura;
}
public void setNrFactura(Integer nrFactura) {
	this.nrFactura = nrFactura;
}
public Date getDataEmiterii() {
	return dataEmiterii;
}
public void setDataEmiterii(Date dataEmiterii) {
	this.dataEmiterii = dataEmiterii;
}
public Date getDataScadenta() {
	return dataScadenta;
}
public void setDataScadenta(Date dataScadenta) {
	this.dataScadenta = dataScadenta;
}
public Furnizor getFurnizorFactura() {
	return furnizorFactura;
}
public void setFurnizorFactura(Furnizor furnizorFactura) {
	this.furnizorFactura = furnizorFactura;
}
public List<ArticolFactura> getArticole() {
	return articole;
}
public void setArticole(List<ArticolFactura> articole) {
	this.articole = articole;
}
public Factura(Integer nrFactura) {
	super();
	this.nrFactura = nrFactura;
}
public Double getTotalPlata() {
	this.totalPlata=0.0;
	for(ArticolFactura a: this.articole) {
		this.totalPlata=this.totalPlata+a.getValoareCuTVA();
	}
	return totalPlata;
}
public Factura(Integer nrFactura, Date dataEmiterii, Date dataScadenta, Furnizor furnizorFactura,
		List<ArticolFactura> articole) {
	super();
	this.nrFactura = nrFactura;
	this.dataEmiterii = dataEmiterii;
	this.dataScadenta = dataScadenta;
	this.furnizorFactura = furnizorFactura;
	this.articole = articole;
	this.totalPlata=0.0;
	for(ArticolFactura a: this.articole) {
		this.totalPlata=this.totalPlata+a.getValoareCuTVA();
	}
}
@Override
public int hashCode() {
	return Objects.hash(nrFactura);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Factura other = (Factura) obj;
	return Objects.equals(nrFactura, other.nrFactura);
}

}
