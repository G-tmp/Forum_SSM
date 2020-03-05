package com.xd.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;



public class UploadImage {

    public static String upload(MultipartFile file , String path) {

        if (file != null){
//            String path = session.getServletContext().getRealPath("resources/img_profile");
            String originalFile = file.getOriginalFilename();
            String suffix = originalFile.substring(originalFile.lastIndexOf('.'));
            String fileName = System.currentTimeMillis()+suffix;
//            String savePath = path+"/"+fileName;

            File saveFile = new File(path,fileName);

            if (!saveFile.exists()){
                saveFile.mkdirs();
            }
            System.out.println(saveFile);

            try {
                file.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return fileName;
        }

        return null;
    }


}
