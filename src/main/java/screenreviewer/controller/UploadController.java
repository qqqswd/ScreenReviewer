package screenreviewer.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import screenreviewer.pojo.Result;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Slf4j
@RestController
public class UploadController {

//    @Autowired
//    private AliOSSUtils aliOSSUtils;

    //本地存储文件
    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception {
        log.info("文件上传:{}",image);
        //获取原始文件名 - 1.jpg  123.0.0.jpg
        String originalFilename = image.getOriginalFilename();

        //构造唯一的文件名 (不能重复) - uuid(通用唯一识别码) de49685b-61c0-4b11-80fa-c71e95924018
        int index = originalFilename.lastIndexOf(".");
        String extname = originalFilename.substring(index);
        String newFileName = UUID.randomUUID().toString() + extname;
        log.info("新的文件名: {}", newFileName);

        //将文件存储在服务器的磁盘目录中 E:\images
        String filePath = "E:\\images\\" + newFileName;
        image.transferTo(new File(filePath));

        return Result.success(filePath);
    }
}