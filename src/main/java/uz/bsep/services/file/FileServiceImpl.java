package uz.bsep.services.file;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import uz.bsep.exceptions.ResourceNotFoundException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {


    final String imagePath = "./src/main/resources/images";



    @Override
    public String saveImage(MultipartFile file) throws IOException {
        String s = UUID.randomUUID().toString();
        mkDir(imagePath);
        File newFile = new File(imagePath+"/"+s+file.getOriginalFilename());
        file.transferTo(newFile.toPath());
        return s;
    }

    @Override
    public List<String> saveImages(MultipartFile[] files) {
        List<String> names = new ArrayList<>();
        mkDir(imagePath);
        for (MultipartFile file : files) {
            String id = UUID.randomUUID().toString();
            File newFile = new File(imagePath+"/"+id+file.getOriginalFilename());
            try {
                file.transferTo(newFile.toPath());
                names.add(id);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return names;
    }

    @Override
    public ResponseEntity<ByteArrayResource> getFile(String id) throws IOException {
        File folder = new File(imagePath);
        if (folder.listFiles() == null) {
            throw new ResourceNotFoundException("file not found");
        }
        File first = Arrays.stream(folder.listFiles()).filter(file -> file.getName().startsWith(id)).findFirst().orElseThrow(() -> new ResourceNotFoundException("file not found"));
        return ResponseEntity.ok()
                .body(new ByteArrayResource(Files.readAllBytes(first.toPath())));
    }


    public void mkDir(String url) {
        File directory = new File(url);
        if (!directory.exists()) {
            boolean mkdir = directory.mkdir();
        }
    }
}
