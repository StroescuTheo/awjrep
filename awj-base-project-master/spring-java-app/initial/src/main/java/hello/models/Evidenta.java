package hello;

import java.util.List;
import java.util.ArrayList;

public class Evidenta {
  private String name;
  private String prenume;
  private double medie;
  int bursa;
  private int id;

  public Evidenta() {}

  public Evidenta(int id, String name,String prenume,double medie,int bursa) {
      this.name = name;
	  this.prenume=prenume;
	  this.medie=medie;
	  this.bursa=bursa;
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public String getPrenume() {
    return this.prenume;
  }
   public double getMedie() {
    return this.medie;
  }
   public int getId() {
    return this.id;
  }
   public int getBursa() {
    return this.bursa;
  }
  public void setName(String name)
  {this.name=name;}
    public void setPrenume(String prenume)
  {this.prenume=prenume;}
    public void setBursa(int bursa)
  {this.bursa=bursa;}
    public void setMedie(double medie)
  {this.medie=medie;}
}