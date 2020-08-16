package com.xd.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;



public class UploadImageUtil {


    /**
     *  图片写入磁盘
     *  if (success)
     *      return file name;
     *  else
     *      return null;
     *
     * @param file
     * @param path
     * @return
     */
    public static String upload(MultipartFile file , String path) throws IOException {

        if (file != null){
//            String path = session.getServletContext().getRealPath("resources/img_profile");
            String originalFile = file.getOriginalFilename();
            // file format
            String suffix = originalFile.substring(originalFile.lastIndexOf('.'));
            // timestamp
            String fileName = System.currentTimeMillis()+suffix;
//            String savePath = path+"/"+fileName;

            File saveFile = new File(path,fileName);

            if (!saveFile.exists()){
                saveFile.mkdirs();
            }
            System.out.println("save file : "+saveFile);

            file.transferTo(saveFile);

            return fileName;
        }

        return null;
    }


}
