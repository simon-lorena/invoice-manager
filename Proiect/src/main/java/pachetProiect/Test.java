package pachetProiect;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

public class Test {

	public static void main(String[] args) throws ParseException {
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("Proiect");
		EntityManager  em=emf.createEntityManager();
		em.getTransaction().begin();
		Furnizor f1= new Furnizor("Electricitate SRL","Iasi, Pascani, Strada Stefan cel Mare",12345, "BTRLRONCRT19282736374","0720405678");
		Furnizor f2= new Furnizor("Apa SRL","Iasi, Strada Zimbrului",122, "BTRLRONCRT12482736374","0720605678");
		Furnizor f3= new Furnizor("Internet SRL","Iasi, Tg.Frumos, Strada Florilor",145, "BTRLRONCRT19234736374","0735405678");
		Furnizor f4= new Furnizor("Televiziune SRL","Iasi, Strada Lazar",125, "BTRLRONCRT19282836374","0748405678");
		Furnizor f5= new Furnizor("Gaz SRL","Neamt, Roman, Strada Vitejilor",112, "BTRLRONCRT19282778374","0725408678");
		
		em.persist(f1);//Adaugare baza de date
		em.persist(f2);
		em.persist(f3);
		em.persist(f4);
		em.persist(f5);
		
		
		List<Furnizor> lst=em.createQuery("select f from Furnizor f").getResultList();//citire
		for(Furnizor f:lst) {
			//System.out.println(f.toString());
		}
		//Furnizor fur=(Furnizor) em.createQuery("select f from Furnizor f where f.cif=12345").getSingleResult();//un singur rezultate
		//fur.setNume("Etta SRL");//modificare
		//em.merge(fur);//modificare
		
		
		Produs p1= new Produs(1,"Apa",2.5,0.09);
		Produs p2= new Produs(2,"Curent",25.0,0.19);
		Produs p3= new Produs(3,"Internet",5.0,0.19);
		Produs p4= new Produs(4,"Gaz",12.0,0.19);
		Produs p5= new Produs(5,"Taxa administrare",6.0,0.19);
		Produs p6= new Produs(6,"Penalitati",6.0,0.19);
		
		em.persist(p1);
		em.persist(p2);
		em.persist(p3);
		em.persist(p4);
		em.persist(p5);
		em.persist(p6);
		
		ArticolFactura a1= new ArticolFactura(101,p1,4.0);
		ArticolFactura a2= new ArticolFactura(102,p2,4.5);
		ArticolFactura a3= new ArticolFactura(103,p3,1.0);
		ArticolFactura a4= new ArticolFactura(104,p4,8.0);
		ArticolFactura a5= new ArticolFactura(105,p5,2.0);
		ArticolFactura a6= new ArticolFactura(106,p1,12.0);
		ArticolFactura a7= new ArticolFactura(107,p2,11.0);
		ArticolFactura a8= new ArticolFactura(108,p3,7.0);
		ArticolFactura a9= new ArticolFactura(109,p4,8.0);
		ArticolFactura a10= new ArticolFactura(110,p6,10.0);
		ArticolFactura a11= new ArticolFactura(111,p6,8.0);
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		em.persist(a4);
		em.persist(a5);
		em.persist(a6);
		em.persist(a7);
		em.persist(a8);
		em.persist(a9);
		em.persist(a10);
		em.persist(a11);
		
		List<ArticolFactura> la1=new ArrayList<ArticolFactura>();
		la1.add(a1);la1.add(a5);
		List<ArticolFactura> la2=new ArrayList<ArticolFactura>();
		la2.add(a2);la2.add(a10);
		List<ArticolFactura> la3=new ArrayList<ArticolFactura>();
		la3.add(a3);la3.add(a11);
		List<ArticolFactura> la4=new ArrayList<ArticolFactura>();
		la4.add(a4);
		List<ArticolFactura> la5=new ArrayList<ArticolFactura>();
		la5.add(a6);
		
	    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");      
	    Date data1 = formatter.parse("26-09-2021"); 
	    Date data2 = formatter.parse("26-02-2022");
	    
		Factura fa1= new Factura(1, data1,data2,f1,la1);
		
		Date data5 = formatter.parse("02-12-2021"); 
	    Date data6 = formatter.parse("02-02-2022");
	    Factura fa2= new Factura(2, data5,data6,f2,la2);
	    
	    Date data7 = formatter.parse("30-12-2021"); 
	    Date data8 = formatter.parse("30-01-2022");
	    Factura fa3= new Factura(3, data7,data8,f3,la3);
	    
	    Date data9 = formatter.parse("13-11-2021"); 
	    Date data10 = formatter.parse("02-01-2022");
	    Factura fa4= new Factura(4, data9,data10,f4,la4);
	    
	    Date data11 = formatter.parse("12-12-2021"); 
	    Date data12 = formatter.parse("12-03-2022");
	    Factura fa5= new Factura(5, data11,data12,f5,la5);
	    a1.setFactura(fa1);a5.setFactura(fa1);
	    a2.setFactura(fa2);a10.setFactura(fa2);
	    a3.setFactura(fa3);a11.setFactura(fa3);
	    a4.setFactura(fa4);
	    a6.setFactura(fa5);
	    
	    Proprietar pr1 = new PersoanaFizica(1,"Alexa Ioana","2991212270834");
	    Proprietar pr2 = new PersoanaFizica(2,"Popescu Mihai","1991212260834");
	    Proprietar pr3 = new PersoanaFizica(3,"Popescu Ioana","2961212270834");
	    Proprietar pr4 = new PersoanaFizica(4,"Nastase Ionut","1941232270834");
	    Proprietar pr5 = new PersoanaFizica(5,"Dumitrescu Andreea","2991212291834");
	    Proprietar pr6 = new PersoanaFizica(6,"Popa Claudia","2970312270834");
	    Proprietar pr7 = new PersoanaFizica(7,"Cantemir Daniel","1971209275834");
	    Proprietar pr8 = new PersoanaFizica(8,"Dumitrescu Alexandru","1791212350834");
	    Proprietar pr9 = new PersoanaJuridica(9,"Alfa SRL",123432);
	    Proprietar pr10 = new PersoanaJuridica(10,"Betta SRL", 435674);
	    Proprietar pr11 = new PersoanaJuridica(11,"Gamma SRL",324564);
	    Proprietar pr12 = new PersoanaJuridica(12,"Etta SRL",543123);
	    Proprietar pr13 = new PersoanaJuridica(13,"Epsilon SRL",765678);
	    Proprietar pr14 = new PersoanaJuridica(14,"Omicron SRL",234322);

		Apartament ap1= new Apartament(101,1,pr1);
		Apartament ap2= new Apartament(102,2,pr2);
		Apartament ap3= new Apartament(103,3,pr3);
		Apartament ap4= new Apartament(201,1,pr4);
		Apartament ap5= new Apartament(202,2,pr5);
		Apartament ap6= new Apartament(203,3,pr6);
		Apartament ap7= new Apartament(301,1,pr7);
		Apartament ap8= new Apartament(401,1,pr8);
		Apartament ap9= new Apartament(402,2,pr9);
		Apartament ap10= new Apartament(501,1,pr10);
		Apartament ap11= new Apartament(601,1,pr11);
		Apartament ap12= new Apartament(602,2,pr12);
		Apartament ap13= new Apartament(701,1,pr13);
		Apartament ap14= new Apartament(801,1,pr14);
	
		
		List<Apartament>lstAp1= new ArrayList<Apartament>();
		lstAp1.add(ap1);
		lstAp1.add(ap2);
		lstAp1.add(ap3);
		List<Apartament>lstAp2= new ArrayList<Apartament>();
		lstAp2.add(ap4);
		lstAp2.add(ap5);
		lstAp2.add(ap6);
		List<Apartament>lstAp3= new ArrayList<Apartament>();
		lstAp3.add(ap7);
		List<Apartament>lstAp4= new ArrayList<Apartament>();
		lstAp4.add(ap8);
		lstAp4.add(ap9);
		List<Apartament>lstAp5= new ArrayList<Apartament>();
		lstAp5.add(ap10);
		List<Apartament>lstAp6= new ArrayList<Apartament>();
		lstAp6.add(ap11);
		lstAp6.add(ap12);
		List<Apartament>lstAp7= new ArrayList<Apartament>();
		lstAp7.add(ap13);
		List<Apartament>lstAp8= new ArrayList<Apartament>();
		lstAp8.add(ap14);
		Bloc b1=new Bloc(101,1,lstAp1);
		Bloc b2=new Bloc(102,2,lstAp2);
		Bloc b3=new Bloc(201,1,lstAp3);
		Bloc b4=new Bloc(202,2,lstAp4);
		Bloc b5=new Bloc(301,1,lstAp5);
		Bloc b6=new Bloc(401,1,lstAp6);
		Bloc b7=new Bloc(402,2,lstAp7);
		Bloc b8=new Bloc(403,3,lstAp8);

		List<Bloc> lstBl1= new ArrayList<Bloc>();
		lstBl1.add(b1);lstBl1.add(b2);
		List<Bloc> lstBl2= new ArrayList<Bloc>();
		lstBl2.add(b3);lstBl2.add(b4);
		List<Bloc> lstBl3= new ArrayList<Bloc>();
		lstBl3.add(b5);
		List<Bloc> lstBl4= new ArrayList<Bloc>();
		lstBl4.add(b6);lstBl4.add(b7);lstBl4.add(b8);
		Complex c1=new Complex(101, "Lazar Residence","Iasi",lstBl1);
		Complex c2=new Complex(102, "Royal Town","Iasi",lstBl2);
		Complex c3=new Complex(103, "Carol Residence","Iasi",lstBl3);
		Complex c4=new Complex(104, "Conest Residence","Iasi",lstBl4);
		
		ap1.setBloc(b1);
		ap2.setBloc(b1);
		ap3.setBloc(b1);
		ap4.setBloc(b2);
		ap5.setBloc(b2);
		ap6.setBloc(b2);
		ap7.setBloc(b3);
		ap8.setBloc(b4);
		ap9.setBloc(b4);
		ap10.setBloc(b5);
		ap11.setBloc(b6);
		ap12.setBloc(b6);
		ap13.setBloc(b7);
		ap14.setBloc(b8);
		b1.setComplex(c1);
		b2.setComplex(c1);
		b3.setComplex(c2);
		b4.setComplex(c2);
		b5.setComplex(c3);
		b6.setComplex(c4);
		b7.setComplex(c4);
		b8.setComplex(c4);
		fa1.setApartamentFactura(ap1);
		fa2.setApartamentFactura(ap2);
		fa3.setApartamentFactura(ap3);
		fa4.setApartamentFactura(ap4);
		fa5.setApartamentFactura(ap5);
		
			em.persist(ap1);
		em.persist(ap2);
		em.persist(ap3);
		em.persist(ap4);
		em.persist(ap5);
		em.persist(ap6);
		em.persist(ap7);
		em.persist(ap8);
		em.persist(ap9);
		em.persist(ap10);
		em.persist(ap11);
		em.persist(ap12);
		em.persist(ap13);
		em.persist(ap14);
		em.persist(b1);
		em.persist(b2);
		em.persist(b3);
		em.persist(b4);
		em.persist(b5);
		em.persist(b6);
		em.persist(b7);
		em.persist(b8);
		em.persist(c1);
		em.persist(c2);
		em.persist(c3);
		em.persist(c4);
		em.persist(fa1);
		em.persist(fa2);
		em.persist(fa3);
		em.persist(fa4);
		em.persist(fa5);
		em.getTransaction().commit();

}}
