package uz.bsep.controllers.type;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bsep.controllers.AbstractController;
import uz.bsep.dtos.type.TypeCreateDto;
import uz.bsep.dtos.type.TypeDto;
import uz.bsep.entities.product.Type;
import uz.bsep.services.type.TypeServiceImpl;
import java.util.List;

import static uz.bsep.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH + "/type")
public class TypeController extends AbstractController<TypeServiceImpl> {
    protected TypeController(TypeServiceImpl service) {
        super(service);
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody TypeDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }

    @GetMapping("/{lang}")
    public ResponseEntity<List<TypeCreateDto>> getAll(@PathVariable String lang) {
        List<TypeCreateDto> all = service.getAlll(lang);
        return ResponseEntity.ok().body(all);
    }
    // TODO: 30.10.2022 delete

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable  String id){
        try {
         service.delete(id);
            return ResponseEntity.ok("ok");
        }catch (Exception e){
            return ResponseEntity.badRequest().body("not delete");
        }

    }

    @PutMapping("/{id}")
    public void editById(@PathVariable String id,@RequestBody TypeDto dto){
       service.update(dto);
    }

}
