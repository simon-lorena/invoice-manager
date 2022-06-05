package formulare;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.postgresql.jdbc.AbstractBlobClob;

import pachetProiect.*;

@ManagedBean
@ApplicationScoped
public class FormFactura {
	private EntityManager em;
	private Factura factura;
	private ArticolFactura articolfactura;
	private StareFactura stare;
	private Furnizor furnizor;
	private Apartament apartament;

	private List<Furnizor> furnizori = new ArrayList<Furnizor>();
	private List<Factura> facturi = new ArrayList<Factura>();
	private StareFactura[] stari;
	private DataModel<ArticolFactura> articoleFacturaDataModel;
	private List<Apartament> apartamente = new ArrayList<Apartament>();
	private List<Produs> produse = new ArrayList<Produs>();

	public Apartament getApartament() {
		return this.factura.getApartamentFactura();
	}
	
	public String getAdresa() {
		Apartament ap = this.getApartament();
		Bloc bc= ap.getBloc();
		Complex c=bc.getComplex();
		return "Oras "+c.getOras()+", Complex "+c.getNume()+", Bl. nr. "+bc.getNr().toString()+", Ap. "+ap.getNr().toString();
	}
	public StareFactura[] getStari()
	{
		return this.stari;
	}
	public void setStari()
	{
		this.stari = StareFactura.values();
	}
	public void setApartament(Apartament apartament) {
		this.factura.setApartamentFactura(apartament);
	}

	private void initModelApartamente() {
		this.apartamente = em.createQuery("SELECT o FROM Apartament o", Apartament.class).getResultList();
		if (this.apartamente != null && !this.apartamente.isEmpty())
			Collections.sort(this.apartamente, (p1, p2) -> p1.getProprietar().getNume().compareTo(p2.getProprietar().getNume()));
	}

	public List<Apartament> getApartamente() {
		return apartamente;
	}

	public void setApartamente(List<Apartament> apartamente) {
		this.apartamente = apartamente;
	}

	public Furnizor getFurnizor() {
		return this.factura.getFurnizorFactura();
	}

	public void setFurnizor(Furnizor furnizor) {
		this.factura.setFurnizorFactura(furnizor);

	}

	public List<Furnizor> getFurnizori() {
		return furnizori;
	}

	public void setFurnizori(List<Furnizor> furnizori) {
		this.furnizori = furnizori;
	}

	public ArticolFactura getArticolfactura() {
		return articolfactura;
	}

	public void setArticolfactura(ArticolFactura articolfactura) {
		this.articolfactura = articolfactura;
	}

	public FormFactura() throws ParseException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Proiect");
		em = emf.createEntityManager();
		initModelFacturi();
		initModelProduse();
		initModelFurnizori();
		initModelApartamente();
		setStari();

	}

	private void initModelFurnizori() {
		this.furnizori = em.createQuery("SELECT o FROM Furnizor o", Furnizor.class).getResultList();
		if (this.furnizori != null && !this.furnizori.isEmpty())
			Collections.sort(this.furnizori, (p1, p2) -> p1.getCif().compareTo(p2.getCif()));
	}

	private void initModelFacturi() throws ParseException {
		this.facturi = em.createQuery("select f from Factura f").getResultList();
		if (this.facturi != null && !this.facturi.isEmpty()) {
			Collections.sort(this.facturi, (f1, f2) -> f1.getNrFactura().compareTo(f2.getNrFactura()));
			if (!this.facturi.contains(this.factura))
				this.factura = this.facturi.get(0);
		}
		if (this.factura == null)
			adaugareFactura(null);

	}

	private void initModelProduse() {
		this.produse = em.createQuery("SELECT o FROM Produs o", Produs.class).getResultList();
		if (this.produse != null && !this.produse.isEmpty())
			Collections.sort(this.produse, (p1, p2) -> p1.getCod().compareTo(p2.getCod()));
	}

	public void prevFactura(ActionEvent evt) {
		Integer idCurent = this.facturi.indexOf(factura);
		if (idCurent > 0)
			this.factura = this.facturi.get(idCurent - 1);
		else
			this.factura = this.facturi.get(0);
	}

	public void nextFactura(ActionEvent evt) {
		Integer idCurent = this.facturi.indexOf(factura);
		if (idCurent < this.facturi.size() - 1)
			this.factura = this.facturi.get(idCurent + 1);
		else
			this.factura = this.facturi.get(this.facturi.size() - 1);
	}

	public void adaugareFactura(ActionEvent evt) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date data1 = formatter.parse("01-01-2000");
		Date data2 = formatter.parse("01-01-2000");
		this.factura = new Factura();
		this.factura.setNrFactura(999);
		;
		this.factura.setDataEmiterii(data1);
		this.factura.setDataScadenta(data2);
		this.facturi.add(this.factura);
	}

	public void stergereFactura(ActionEvent evt) {
		this.facturi.remove(this.factura);
		if (this.em.contains(this.factura)) {
			this.em.getTransaction().begin();
			this.em.remove(this.factura);
			this.em.getTransaction().commit();
		}

		if (!this.facturi.isEmpty())
			this.factura = this.facturi.get(0);
		else
			this.factura = null;
	}

	public void salvareFactura(ActionEvent evt) {
		System.out.println("Salvare");
		if (this.em.contains(this.factura)) {
			this.em.getTransaction().begin();
			this.em.merge(this.factura);
			this.em.getTransaction().commit();
		} else {
			this.em.getTransaction().begin();
			this.em.persist(this.factura);
			this.em.getTransaction().commit();
		}
	}

	public void abandonFactura(ActionEvent evt) throws ParseException {
		System.out.println("Abandon factura !");
		em.clear();
		initModelFacturi();
	}

	public Integer getNrFactura() {
		return this.factura.getNrFactura();
	}

	public void setNrFactura(Integer id) {
		Integer idx = this.facturi.indexOf(new Factura(id));
		this.factura = this.facturi.get(idx);
	}

	public DataModel<ArticolFactura> getArticoleFacturaDataModel() {
		articoleFacturaDataModel = new ListDataModel<ArticolFactura>(this.factura.getArticole());
		return articoleFacturaDataModel;
	}

	public List<Produs> getProduse() {
		return produse;
	}

	public Integer getCodProdus() {
		;
		return this.articoleFacturaDataModel.getRowData().getProdusFactura().getCod();
	}

	public Integer getCodFurnizor() {

		return this.factura.getFurnizorFactura().getCif();
	}
	public StareFactura getStareFactura()
	{
		return this.factura.getStare();
	}
	public void setStareFactura(StareFactura stare)
	{
		this.factura.setStare(stare);
	}
	public void setCodFurnizor(Integer cod) {
		Integer idx = this.furnizori.indexOf(new Furnizor(cod));
		Furnizor furnizor = this.furnizori.get(idx);
		this.factura.setFurnizorFactura(furnizor);
	}
	public Integer getCodApartament() {

		return this.factura.getApartamentFactura().getId();
	}

	public void setCodApartament(Integer cod) {
		Integer idx = this.apartamente.indexOf(new Apartament(cod));
		Apartament apartament = this.apartamente.get(idx);
		this.factura.setApartamentFactura(apartament);
		;
	}

	public void setCodProdus(Integer cod) {
		Integer idx = this.produse.indexOf(new Produs(cod));
		Produs produs = this.produse.get(idx);
		this.articoleFacturaDataModel.getRowData().setProdusFactura(produs);
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public List<Factura> getFacturi() {
		return facturi;
	}

	public void setFacturi(List<Factura> facturi) {
		this.facturi = facturi;
	}

	public void stergeArticol(ActionEvent evt) {
		ArticolFactura articolModel = this.articoleFacturaDataModel.getRowData();
		this.factura.getArticole().remove(articolModel);
	}

	public void adaugaArticol(ActionEvent evt) {
		ArticolFactura articolNou = new ArticolFactura(null, this.produse.get(0), 0.0);
		this.factura.getArticole().add(articolNou);
		articolNou.setFactura(this.factura);
	}

}
