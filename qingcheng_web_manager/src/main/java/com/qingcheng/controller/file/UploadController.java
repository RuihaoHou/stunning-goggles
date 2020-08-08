package com.qingcheng.controller.file;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @author houruihao
 * @date 2020-08-04 22:04
 * @description 文件上传
 */
@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OSSClient ossClient;

    /**
     * 本地上传
     * @param file 文件对象
     * @return 文件访问路径
     */
    @PostMapping("/native")
    public String nativeUpload( @RequestParam("file") MultipartFile file){

        //获取img的绝对路径
        String path = request.getSession().getServletContext().getRealPath("img");
        String nativePath = path+"/"+file.getOriginalFilename();
        File desFile = new File(nativePath);
        if (!desFile.getParentFile().exists()){
            desFile.mkdirs();
        }
        try {
            file.transferTo(desFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "http://localhost:9101/img/"+file.getOriginalFilename();
    }

    /**
     * 本地上传
     * @param file 文件对象
     * @return 文件访问路径
     */
    @RequestMapping("/oss")
    public String ossUpload( @RequestParam("file") MultipartFile file, String folder){
        //bucket名
        String bucketName = "qingcheng-hou";
        //定义文件名
        String key =folder+"/"+ UUID.randomUUID() +file.getOriginalFilename();
        PutObjectRequest putObjectRequest = null;
        try {
            putObjectRequest = new PutObjectRequest(bucketName, key, file.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        ossClient.putObject(putObjectRequest);
        // 设置URL过期时间为10年  3600l* 1000*24*365*10
        Date expiration = new Date(System.currentTimeMillis()+ 3600L * 1000 * 24 * 365 * 10);
        // 生成URL
        String Rurl = ossClient.generatePresignedUrl(bucketName, key, expiration).toString();
        String url = "";
        if (!"".equals(Rurl)) {
            url = Rurl;
        }
        return url;
    }
}
