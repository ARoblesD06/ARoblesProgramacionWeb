/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.digis01.ARoblesTestProgramacionNCapasWeb.Util;

import java.io.IOException;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.web.multipart.MultipartFile;


public class Util {

    public static String convertirImagenBase64(MultipartFile imagenFile) {
        try {
            if (!imagenFile.isEmpty()) {
                byte[] bytes = imagenFile.getBytes();
                return Base64.encodeBase64String(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
