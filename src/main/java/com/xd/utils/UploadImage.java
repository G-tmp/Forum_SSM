package com.xd.utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;



public class UploadImage {


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
    public static String upload(MultipartFile file , String path)  {

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
                System.out.println("我日你妈");

                return  null;
            }

            System.out.println("成了");
            return fileName;
        }

        return null;
    }


}
