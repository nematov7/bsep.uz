package uz.bsep.controllers.file;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.bsep.controllers.AbstractController;
import uz.bsep.exceptions.BadRequestException;
import uz.bsep.services.file.FileService;

import java.io.IOException;
import java.util.List;

import static uz.bsep.controllers.AbstractController.PATH;


@RestController
@RequestMapping(PATH+"/file")
public class FileController extends AbstractController<FileService> {
    protected FileController(FileService service) {
        super(service);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ByteArrayResource> getFile(@PathVariable String id) throws IOException {
        return service.getFile(id);
    }

    @PostMapping("/image")
    public ResponseEntity<String> saveFile(@RequestPart MultipartFile file) throws IOException {
        checkFileToImage(file);
        String s = service.saveImage(file);
        return ResponseEntity.ok(s);
    }

    private void checkFileToImage(MultipartFile file) {

    }

    @PostMapping("/images")
    public ResponseEntity<List<String>> saveFiles(@RequestBody MultipartFile[] files){
        if (files==null || files.length<1) {
            throw new BadRequestException("files is not empty");
        }
        List<String> s = service.saveImages(files);
        return ResponseEntity.ok(s);
    }



}
