package hello;

import java.util.List;
import java.util.ArrayList;

public class SuperHero {
    private int id;
  private String name;
  private String Identity;
  private String Secret;
  private int Team_Members;
  private String Main_Super_Power;//{Flight,Strength,Lasers,Healing,None,Agility};


  public SuperHero() {}

  public SuperHero(int id, String name,String Identity,String Secret,int Team_Members,String Main_Super_Power) {
     this.id = id;
	 this.name = name;
	  this.Identity=Identity;
	  this.Secret=Secret;
	  this.Team_Members=Team_Members;
	  this.Main_Super_Power=Main_Super_Power;
      
  }

  public String getName() {
      return this.name;
  }
  
  public String getIdentity() {
      return this.Identity;
  }
  public String getSecret() {
      return this.Secret;
  }
  public int getTeam_Memebers() {
      return this.Team_Members;
  }
  public String getMain_Super_Power() {
      return this.Main_Super_Power;
  }

  public int getId() {
    return this.id;
  }
  public void setName(String name)
  {this.name=name;}
  
  public void setIdentity(String Identity)
  {this.Identity=Identity;}
  public void setSecret(String Secret)
  {this.Secret=Secret;}
  public void setTeam_Members(int Team_Members)
  {this.Team_Members=Team_Members;}
  public void setMain_Super_Power(String Main_Super_Power)
  {this.Main_Super_Power=Main_Super_Power;}
}