
package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.ArrayList;


@RestController
public class SuperHeroController {
  private List<SuperHero> registration = new ArrayList<SuperHero>();

  SuperHeroController() {
    SuperHero p1 = new SuperHero(1, "Batman","Bruce Wayne","Yes",2,"None");
    SuperHero p2 = new SuperHero(2, "Thor","Thor Odinson","No",5,"Strength");
    SuperHero p3 = new SuperHero(3, "Black Panther","T'Challa","No",0,"Agility");
	SuperHero p4 = new SuperHero(4, "Hulk","Bruce Banner","No",5,"Strength");
	
	

    registration.add(p1);
    registration.add(p2);
    registration.add(p3);
	registration.add(p4);
  }
  
  
	  
	@RequestMapping(value="/SuperHero/{name}/{Identity}/{Secret}/{Team_members}/{Main_Super_Power}", method = RequestMethod.POST)
	  public ResponseEntity create(@RequestBody SuperHero p) {
		registration.add(p);
		
		return new ResponseEntity<SuperHero>(p, new HttpHeaders(), HttpStatus.OK);
	  }

  
  

  @RequestMapping(value="/SuperHero", method = RequestMethod.GET)
  public List<SuperHero> index() {
    return this.registration;
  }

  @RequestMapping(value="/SuperHero/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(SuperHero p : this.registration) {
      if(p.getId() == id) {
        return new ResponseEntity<SuperHero>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/SuperHero/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(SuperHero p : this.registration) {
      if(p.getId() == id) {
        this.registration.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  //PUT
  @RequestMapping(value="/SuperHero/{id},{name},{Identity},{Secret},{Team_members},{Main_Super_Power}", method = RequestMethod.PUT)
  public List<SuperHero> replace(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("Identity") String Identity,@PathVariable("Secret") String Secret,@PathVariable("Team_members") int Team_members,@PathVariable("Main_Super_Power") String Main_Super_Power) {
    for(SuperHero p : this.registration) {
      if(p.getId() == id) {
		p.setName(name);
		p.setIdentity(Identity);
		p.setSecret(Secret);
		p.setTeam_Members(Team_members);
		p.setMain_Super_Power(Main_Super_Power);
		
		
	 }
    }
	return this.registration;
	 
  }
  

	 
  
}