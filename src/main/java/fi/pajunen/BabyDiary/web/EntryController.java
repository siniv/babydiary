package fi.pajunen.BabyDiary.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fi.pajunen.BabyDiary.domain.CategoryRepository;
import fi.pajunen.BabyDiary.domain.Entry;
import fi.pajunen.BabyDiary.domain.EntryRepository;

@Controller
public class EntryController {
	
	@Autowired
	private EntryRepository erepository;
	
	@Autowired
	private CategoryRepository crepository;
	
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
	
	@GetMapping("/entrylist")
	public String entryList(Model model) {
		model.addAttribute("entries", erepository.findAll());
		return "entrylist";
	}
	
	@GetMapping("/add")
	public String addEntry(Model model) {
		model.addAttribute("entry", new Entry());
		model.addAttribute("categories", crepository.findAll());
		return "addentry";
	}
	
	@PostMapping("/save")
	public String save(Entry entry) {
		erepository.save(entry);
		return "redirect:entrylist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/delete/{id}")
	public String deleteEntry(@PathVariable("id") Long id, Model model) {
		erepository.deleteById(id);
		return "redirect:../entrylist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/edit/{id}")
    public String editEntry(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("entry", erepository.findById(id));
    	model.addAttribute("categories", crepository.findAll());
    	return "editentry";
    }

}
