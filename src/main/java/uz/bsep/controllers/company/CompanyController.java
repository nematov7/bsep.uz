package uz.bsep.controllers.company;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.bsep.controllers.AbstractController;
import uz.bsep.dtos.company.CompanyCreateDto;
import uz.bsep.dtos.company.CompanyUpdateDto;
import uz.bsep.mappers.CompanyMapper;
import uz.bsep.services.company.CompanyServiceImpl;

import static uz.bsep.controllers.AbstractController.PATH;

@RestController
@RequestMapping(PATH + "/company")
public class CompanyController extends AbstractController<CompanyServiceImpl> {

    private final CompanyMapper mapper;


    protected CompanyController(CompanyServiceImpl service, CompanyMapper mapper) {
        super(service);
        this.mapper = mapper;
    }


    @PostMapping
    public ResponseEntity<?> save(@RequestBody CompanyCreateDto dto) {

        service.create(dto);
        return ResponseEntity.ok().body("ok");

    }

    @GetMapping("/{id}/{lang}")
    public ResponseEntity<?> getById(@PathVariable String id, @PathVariable String lang) {

        return null;
    }


    @PutMapping("/{id}")
    public String editById(@PathVariable String id, CompanyUpdateDto updateDto) {

        return
                null;
    }


    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id) {
        service.delete(id);
        return "";
    }
}
