package uz.bsep.services.file;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import uz.bsep.services.base.BaseGenericService;

import java.io.IOException;
import java.util.List;


public interface FileService extends BaseGenericService {


    String saveImage(MultipartFile file) throws IOException;

    List<String> saveImages(MultipartFile[] files);

    ResponseEntity<ByteArrayResource> getFile(String id) throws IOException;

}
