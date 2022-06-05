package formulare;

import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pachetProiect.Furnizor;

@ManagedBean @ApplicationScoped
public class FormFurnizor {
	private Furnizor furnizor;
	private List<Furnizor> furnizori;
	EntityManager em;
	public FormFurnizor() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Proiect");
		em=emf.createEntityManager();
		
		init();
	}
	public void init() {
		this.furnizori=em.createQuery("select f from Furnizor f").getResultList();
		this.furnizor=this.furnizori.get(0);
}
	public void prevFurnizor(ActionEvent e) {
		Integer poz=this.furnizori.indexOf(this.furnizor);
		if(poz>0)
		this.furnizor=this.furnizori.get(poz-1);
		
	}
	public void nextFurnizor(ActionEvent e) {
		Integer poz=this.furnizori.indexOf(this.furnizor);
		if(poz<this.furnizori.size()-1)
		this.furnizor=this.furnizori.get(poz+1);
		
	}
	public void adaugareFurnizor(ActionEvent evt) {
		this.furnizor = new Furnizor();
		this.furnizor.setCif(999);
		this.furnizor.setNume("Furnizor Nou");
		this.furnizor.setAdresa("Adresa");
		this.furnizor.setCont("Cont bancar");
		this.furnizor.setTelefon("0720000000");
		this.furnizori.add(this.furnizor);
	}

	public void stergereFurnizor(ActionEvent evt) {
		this.furnizori.remove(this.furnizor);
		if (this.em.contains(this.furnizor)) {
			this.em.getTransaction().begin();
			this.em.remove(this.furnizor);
			this.em.getTransaction().commit();
		}

		if (!this.furnizori.isEmpty())
			this.furnizor = this.furnizori.get(0);
		else
			this.furnizor = null;
	}

	public void salvareFurnizor(ActionEvent evt) {
		System.out.println("Salvare");
		try{
			this.em.getTransaction().begin();
			this.em.merge(this.furnizor);
			this.em.getTransaction().commit();
		}catch(Exception ex){
			ex.getSuppressed();
		}
	}

	public void abandonFurnizor(ActionEvent evt) {
		System.out.println("Abandon furnizor !");
		em.clear();
		init();
	}
	public Furnizor getFurnizor() {
		return furnizor;
	}
	public void setFurnizor(Furnizor furnizor) {
		this.furnizor = furnizor;
	}
	public List<Furnizor> getFurnizori() {
		return furnizori;
	}
	public void setFurnizori(List<Furnizor> furnizori) {
		this.furnizori = furnizori;
	}
	public EntityManager getEm() {
		return em;
	}
	public void setEm(EntityManager em) {
		this.em = em;
	}

	
}
