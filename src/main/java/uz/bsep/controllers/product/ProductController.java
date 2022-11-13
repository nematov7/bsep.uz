package uz.bsep.controllers.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bsep.controllers.AbstractController;
import uz.bsep.criteria.base.GenericCriteria;
import uz.bsep.dtos.product.ProductCreateDto;
import uz.bsep.dtos.product.ProductDto;
import uz.bsep.dtos.product.ProductUpdateDto;
import uz.bsep.projections.SingleProduct;
import uz.bsep.services.product.ProductServiceImpl;

import java.util.List;

import static uz.bsep.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH + "/product")
public class ProductController extends AbstractController<ProductServiceImpl> {
    protected ProductController(ProductServiceImpl service) {
        super(service);
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody ProductCreateDto dto) {
        var id = service.create(dto);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}/{lang}")
    public ResponseEntity<?> getByIdProduct(@PathVariable String id, @PathVariable String lang) {
        ProductDto productDto = service.get(id, lang);
        return ResponseEntity.ok().body(productDto);
    }

    /*
     harbir type dan bittadan mahsulot olish
     */
    @GetMapping("/{lang}")
    public ResponseEntity<?> getAllTypeOneId(@PathVariable String lang) {
        List<SingleProduct> allTypeIdOne = service.getAllTypeIdOne(lang);
        if (!allTypeIdOne.isEmpty()) {
            return ResponseEntity.ok(allTypeIdOne);
        } else {
            return ResponseEntity.badRequest().body("not found");
        }
    }

    /*
    bitta typega tegishliy hamma mahsulotlar
    */
    @GetMapping("/type/{typeId}/{lang}")
    public ResponseEntity<?> getAllByTypeId(@PathVariable String typeId, @PathVariable String lang) {
        List<SingleProduct> allByTypeId = service.getAllByTypeId(typeId, lang);
        return ResponseEntity.ok(allByTypeId);
    }

    @PutMapping("/{id}")
    public String editById(@PathVariable String id, ProductUpdateDto updateDto) {
        service.update(updateDto);
        return "ok";

    }

}
