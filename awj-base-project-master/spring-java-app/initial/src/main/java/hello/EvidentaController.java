		package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class EvidentaController {
  private List<Evidenta> grupa = new ArrayList<Evidenta>();

  EvidentaController() {
    Evidenta p1 = new Evidenta(1, "Jones", "Doe", 8.75,1500);
    Evidenta p2 = new Evidenta(2, "Paul", "Cloes", 9.20,2000);
    Evidenta p3 = new Evidenta(3, "Laur", "Crove",7,0);

    grupa.add(p1);
    grupa.add(p2);
    grupa.add(p3);
  }

  @RequestMapping(value="/Evidenta", method = RequestMethod.GET)
  public List<Evidenta> index() {
	  List<Evidenta> grupaa=new ArrayList<Evidenta>();
	  grupaa=this.grupa;
    return grupaa;
  }

  @RequestMapping(value="/Evidenta/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Evidenta p : this.grupa) {
      if(p.getId() == id) {
        return new ResponseEntity<Evidenta>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/Evidenta/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Evidenta p : this.grupa) {
      if(p.getId() == id) {
        this.grupa.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }
  //PUT
  @RequestMapping(value="/Evidenta/{id},{name},{prenume},{medie},{bursa}", method = RequestMethod.PUT)
  public List<Evidenta> replace(@PathVariable("id") int id,@PathVariable("name") String name,@PathVariable("prenume") String prenume,@PathVariable("medie") double medie,@PathVariable("bursa") int bursa) {
    for(Evidenta p : this.grupa) {
      if(p.getId() == id) {
		p.setName(name);
		p.setPrenume(prenume);
		p.setMedie(medie);
		p.setBursa(bursa);
		
		
		
	 }
    }
	return this.grupa;
	 
  }
  
  //Post
  @RequestMapping(value="/Evidenta/{name}/{prenume}/{medie}/{bursa}", method = RequestMethod.POST)
  public List<Evidenta> add(@PathVariable("name") String name,@PathVariable("prenume") String prenume,@PathVariable("medie") double medie,@PathVariable("bursa") int bursa) {
	  int i=0;
	  for(Evidenta p : this.grupa)
	  {
		  i++;
	  }
	  
    Evidenta p=new Evidenta(i+1,name,prenume,medie,bursa);
	grupa.add(p);
	return this.grupa;
	 
  }
}