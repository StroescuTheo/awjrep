package hello;

import java.util.List;
import java.util.ArrayList;

public class Carte {
  private String titlu;
  private long cod;
  private int pagini;
  private double pret;
  private String gen; //Actiune, Drama, Comedie, Horror

  public Carte() {}

  public Carte(long cod, String titlu,String gen, int pagini, double pret) {
      this.titlu = titlu;
      this.cod = cod;
      this.gen = gen;
      this.pagini = pagini;
      this.pret = pret;
  }

  public String getTitlu() {
      return this.titlu;
  }
  
  public String getGen() {
      return this.gen;
  }
  
  public int getPagini() {
      return this.pagini;
  }
  
  public double getPret() {
      return this.pret;
  }

  public long getCod() {
    return this.cod;
  }
  public void setTitlu(String titlu)
  {this.titlu=titlu;}
  
  public void setGen(String gen)
  {this.gen=gen;}
  
  public void setPret(double pret)
  {this.pret=pret;}
  
  public void setPagini(int pagini)
  {this.pagini=pagini;}
}