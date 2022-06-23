package uz.bsep.controllers.product;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.bsep.controllers.AbstractController;
import uz.bsep.dtos.product.ProductCreateDto;
import uz.bsep.services.product.ProductServiceImpl;

import static uz.bsep.controllers.AbstractController.PATH;

@Controller
@RequestMapping(PATH)
public class ProductController extends AbstractController<ProductServiceImpl> {
    protected ProductController(ProductServiceImpl service) {
        super(service);
    }

    @PostMapping("/save")
    public HttpEntity<?> save(ProductCreateDto dto){
        service.create(dto);
        return ResponseEntity.status(201).build();
    }

}
