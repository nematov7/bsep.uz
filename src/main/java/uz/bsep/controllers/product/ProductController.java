package uz.bsep.controllers.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bsep.controllers.AbstractController;
import uz.bsep.criteria.base.GenericCriteria;
import uz.bsep.dtos.product.ProductCreateDto;
import uz.bsep.dtos.product.ProductDto;
import uz.bsep.dtos.product.ProductUpdateDto;
import uz.bsep.services.product.ProductServiceImpl;

import java.util.List;

import static uz.bsep.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH+"/product")
public class ProductController extends AbstractController<ProductServiceImpl> {
    protected ProductController(ProductServiceImpl service) {
        super(service);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductCreateDto dto){
        var id = service.create(dto);
        return  ResponseEntity.ok(dto);
    }

    @GetMapping("/{id}/{lang}")
    public ResponseEntity<?> getById(@PathVariable String id, @PathVariable String lang){
        ProductDto productDto = service.get(id, lang);
        return ResponseEntity.ok().body(productDto);
    }

    @GetMapping("/{lang}")
    public String getAll(@PathVariable String lang){
        List<ProductDto> all = service.getAll(new GenericCriteria(), lang);
        return "products";
    }


    @PutMapping("/{id}")
    public String editById(@PathVariable String id, ProductUpdateDto updateDto){
        service.update(updateDto);
        return "ok";
    }

}
