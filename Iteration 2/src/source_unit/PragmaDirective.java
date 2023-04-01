package source_unit;

import java.util.ArrayList;
import java.util.List;



public class PragmaDirective {
	public List<Attributes> attributes;
	
	public PragmaDirective() {
		this.attributes= new ArrayList<>();
	}
	
	public void addAttribute(Attributes a) {
		attributes.add(a);
	}

}
