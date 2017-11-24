package com.jinmayi.download;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * ѹ���ļ�������
 */
public class ZipUtils {
    
    public static void zipFile(String fileName, ZipOutputStream out) throws IOException{
        File file = new File(fileName);
        if( file.exists() ){
            byte[] buffer = new byte[1024];
            FileInputStream fis = new FileInputStream(file);
            out.putNextEntry(new ZipEntry(file.getName()));
            int len = 0 ;
            //������Ҫ���ص��ļ������ݣ������zip�ļ�    
            while ((len = fis.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
            }
            out.flush();
            out.closeEntry();
            fis.close();
        }
    }
}