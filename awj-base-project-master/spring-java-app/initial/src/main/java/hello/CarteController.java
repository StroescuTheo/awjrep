
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
public class CarteController {
  private List<Carte> biblioteca = new ArrayList<Carte>();

  CarteController() {
    Carte p1 = new Carte(46456, "Lost girl","Drama",255,87.5);
    Carte p2 = new Carte(26944, "The Spy that died","Actiune",853,129.99);
    Carte p3 = new Carte(99621, "What if","Drama",89,100);

    biblioteca.add(p1);
    biblioteca.add(p2);
    biblioteca.add(p3);
  }

  @RequestMapping(value="/Carte", method = RequestMethod.GET)
  public List<Carte> index() {
    return this.biblioteca;
  }

  @RequestMapping(value="/Carte/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    int cont=0;
	for(Carte p : this.biblioteca) {
      if(cont++ == id) {
        return new ResponseEntity<Carte>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Carte/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    int cont=0;
	for(Carte p : this.biblioteca) {
      if(cont++ == id) {
        this.biblioteca.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  //PUT
  @RequestMapping(value="/Carte/{cod},{titlu},{gen},{pagini},{pret}", method = RequestMethod.PUT)
  public List<Carte> replace(@PathVariable("cod") long cod,@PathVariable("titlu") String titlu,@PathVariable("gen") String gen,@PathVariable("pagini") int pagini,@PathVariable("pret") double pret) {
    for(Carte p : this.biblioteca) {
      if(p.getCod() == cod) {
		p.setTitlu(titlu);
		p.setGen(gen);
		p.setPagini(pagini);
		p.setPret(pret);
		
		
		
	 }
    }
	return this.biblioteca;
	 
  }
  
	  
	@RequestMapping(value="/Carte/{titlu}/{gen}/{pagini}/{pret}", method = RequestMethod.POST)
	  public ResponseEntity create(@RequestBody Carte p) {
		biblioteca.add(p);
		
		return new ResponseEntity<Carte>(p, new HttpHeaders(), HttpStatus.OK);
	  }

  
  

}