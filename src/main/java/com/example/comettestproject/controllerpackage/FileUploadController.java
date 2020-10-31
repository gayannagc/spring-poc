package com.example.comettestproject.controllerpackage;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@RestController
@RequestMapping("/dummy/file-upload")
public class FileUploadController {


    @RequestMapping(value = "/upload",method = RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException {
        File convertFile = new File(new File("D:/XL-COMET/storage") + file.getOriginalFilename());
        convertFile.createNewFile();

        try(FileOutputStream fout = new FileOutputStream(convertFile)) {
            fout.write(file.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
        return "file upload success";
    }

}
