package uz.bsep.controllers.product;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.bsep.controllers.AbstractController;
import uz.bsep.criteria.base.GenericCriteria;
import uz.bsep.dtos.product.ProductCreateDto;
import uz.bsep.dtos.product.ProductDto;
import uz.bsep.services.product.ProductServiceImpl;

import java.util.List;
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
    public String getById(@PathVariable String id, @PathVariable String lang){
        var productDto = service.get(id, lang);
        return "product";
    }

    @GetMapping("/{lang}")
    public String getAll(@PathVariable String lang){
        List<ProductDto> all = service.getAll(new GenericCriteria(), lang);
        return "products";
    }



}
