package pachetProiect;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.AUTO;

@Entity
public class ArticolFactura {
	@Id 
	@GeneratedValue(strategy = AUTO)
	private Integer cod;
	public ArticolFactura(Produs produsFactura, Double cantitate) {
		
		this.produsFactura = produsFactura;
		this.cantitate = cantitate;
		
	}

	private Produs produsFactura;
	private Double cantitate;
	private Double valoareTVA;
	private Double valoareCuTVA;
	@ManyToOne
	private Factura factura;
	

	public Integer getCod() {
		return cod;
	}

	public void setCod(Integer cod) {
		this.cod = cod;
	}

	public Produs getProdusFactura() {
		return produsFactura;
	}

	public Double getCantitate() {
		return cantitate;
	}

	public void setProdusFactura(Produs produsFactura) {
		this.produsFactura = produsFactura;
	}

	public void setCantitate(Double cantitate) {
		this.cantitate = cantitate;
	}

	public ArticolFactura(Integer cod, Produs produsFactura, Double cantitate) {
		super();
		this.cod = cod;
		this.produsFactura = produsFactura;
		this.cantitate = cantitate;
		this.valoareTVA = this.produsFactura.getPretUnitar() * this.cantitate * this.produsFactura.getProcentTVA();
		this.valoareCuTVA = this.produsFactura.getPretUnitar() * this.cantitate + this.valoareTVA;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(cod);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArticolFactura other = (ArticolFactura) obj;
		return Objects.equals(cod, other.cod);
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public ArticolFactura() {
		super();
	}

	public Double getValoareTVA() {
		this.valoareTVA = this.produsFactura.getPretUnitar() * this.cantitate * this.produsFactura.getProcentTVA();

		return valoareTVA;
	}

	public Double getValoareCuTVA() {
		this.valoareCuTVA = this.produsFactura.getPretUnitar() * this.cantitate + this.valoareTVA;

		return valoareCuTVA;
	}
}