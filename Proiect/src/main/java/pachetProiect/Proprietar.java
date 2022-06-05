package pachetProiect;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Proprietar {
	@Id
	private Integer id;
	private String nume;
	
	public Proprietar(Integer id, String nume)
	{
		this.id=id;
		this.nume=nume;
	}
	public Proprietar(String nume)
	{
		this.nume=nume;
	}
	public Proprietar()
	{
		super();
	}
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
	

}
