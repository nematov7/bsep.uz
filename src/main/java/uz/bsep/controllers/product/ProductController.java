package uz.bsep.controllers.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.bsep.controllers.AbstractController;
import uz.bsep.dtos.product.ProductCreateDto;
import uz.bsep.dtos.product.ProductDto;
import uz.bsep.services.product.ProductServiceImpl;

import static uz.bsep.controllers.AbstractController.PATH;

@Controller
@RequestMapping(PATH+"/product")
public class ProductController extends AbstractController<ProductServiceImpl> {
    protected ProductController(ProductServiceImpl service) {
        super(service);
    }


    @PostMapping
    public String save(ProductCreateDto dto, Model model){
        var id = service.create(dto);
        model.addAttribute("id", id);
        return "product";
    }

    @GetMapping("/{id}/{lang}")
    public String getById(@PathVariable String id, @PathVariable String lang, Model model){
        var productDto = service.get(id, lang);
        model.addAttribute("product", productDto);
        return "product";
    }




}
