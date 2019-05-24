package com.quinn.tacoloco;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.quinn.tacoloco.model.Taco;

@Controller
public class TacolocoController {
	
	@Autowired
	private TacolocoService tacolocoService;

	
	@RequestMapping("/")
	public ModelAndView index() {
		List<Taco> taco = this.tacolocoService.findTacos();
		System.out.println("test" + taco.toString());
		System.out.println("dad");
		return new ModelAndView("index", "taco", taco);

}
		
}
