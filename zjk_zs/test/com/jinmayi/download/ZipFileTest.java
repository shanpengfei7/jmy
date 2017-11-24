package com.jinmayi.download;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Test;

import com.jinmayi.entity.Qrcode;

public class ZipFileTest {
	
	@Test
	public void cba() {
		File f = new File("c:\\abcd.txt");
		f.delete();
	}

	@Test
	public void abc() {
		File f = new File("c:\\abcd.txt");
		String str = "abc";
		List<Qrcode> qrcodes = new ArrayList<Qrcode>();
		Qrcode q = null;
		q = new Qrcode();
		q.setQrcode(str);
		qrcodes.add(q);
		q = new Qrcode();
		q.setQrcode(str);
		qrcodes.add(q);
		q = new Qrcode();
		q.setQrcode(str);
		qrcodes.add(q);
		q = new Qrcode();
		q.setQrcode(str);
		qrcodes.add(q);
		q = new Qrcode();
		q.setQrcode(str);
		qrcodes.add(q);
		try {
			for (Qrcode qrcode : qrcodes) {
				writeTxtFile(qrcode.getQrcode() + "\r\n", f);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean writeTxtFile(String content, File fileName)
			throws Exception {
		boolean flag = false;
		FileOutputStream o = null;
		try {
			o = new FileOutputStream(fileName, true);
			o.write(content.getBytes("utf-8"));
			o.close();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	//================================================================================================
	
	public void downLoadZipFile(List<String> fileList, HttpServletResponse response) throws IOException{
        String zipName = "myfile.zip";
        response.setContentType("APPLICATION/OCTET-STREAM");  
        response.setHeader("Content-Disposition","attachment; filename="+zipName);
        ZipOutputStream out = new ZipOutputStream(response.getOutputStream());
        try {
            for(Iterator<String> it = fileList.iterator();it.hasNext();){
            	String fileName = it.next();
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
                response.flushBuffer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            out.close();
        }
    }
	
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
	
//	public void aaa() {
//		List<String> fileList = new ArrayList<String>();
//		ZipFile zip = new ZipFile("");
//		String zipFileName = "";
//		ZipOutputStream out=new ZipOutputStream(new FileOutputStream(zipFileName));
//	    for(int i=0;i<fileList.size();i++){
//	        String filename = (String)fileList.get(i);
//	        File file = new File(filename);
//	        zip(out,file);
//	    }
//	    out.close();
//	}
//	
	//================================================================================================


	//�ļ��������
	    public static HttpServletResponse downLoadFiles(List<File> files,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        try {
	            /**������Ͼ�������Ҫ����������ļ���
	             * ��������Ѿ�׼��������Ҫ������ļ�*/
	            //List<File> files = new ArrayList<File>();
	     
	            /**����һ����ʱѹ���ļ���
	             * ���ǻ���ļ���ȫ��ע�뵽����ļ���
	             * ������ļ�������Զ�����.rar����.zip*/
	            File file = new File("c:/certpics.rar");
	            if (!file.exists()){   
	                file.createNewFile();   
	            }
	            response.reset();
	            //response.getWriter()
	            //�����ļ������
	            FileOutputStream fous = new FileOutputStream(file);   
	            /**����ķ������ǻ��õ�ZipOutputStream����һ�������,
	             * �����������ǰ������ת��һ��*/
	           ZipOutputStream zipOut 
	            = new ZipOutputStream(fous);
	            /**����������ܵľ���һ����Ҫ����ļ��ļ��ϣ�
	             * ����һ��ZipOutputStream*/
	           zipFile(files, zipOut);
	            zipOut.close();
	            fous.close();
	           return downloadZip(file,response);
	        }catch (Exception e) {
	                e.printStackTrace();
	            }
	            /**ֱ���ļ��Ĵ���Ѿ��ɹ��ˣ�
	             * �ļ��Ĵ�����̱��ҷ�װ��FileUtil.zipFile�����̬�����У�
	             * �Ժ����ֳ������������ľ������ͻ���д������*/
	           
	     
	        return response ;
	    }

	  /**
	     * �ѽ��ܵ�ȫ���ļ����ѹ���� 
	     * @param List<File>;  
	     * @param org.apache.tools.zip.ZipOutputStream  
	     */
	    public static void zipFile
	            (List<File> files,ZipOutputStream outputStream) {
	        int size = files.size();
	        for(int i = 0; i < size; i++) {
	            File file = files.get(i);
	            zipFile(file, outputStream);
	        }
	    }

	    public static HttpServletResponse downloadZip(File file,HttpServletResponse response) {
	        try {
	        // ��������ʽ�����ļ���
	        InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
	        byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);
	        fis.close();
	        // ���response
	        response.reset();

	        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	        response.setContentType("application/octet-stream");

	//�������������������ļ����ڴ˴���Ҫ��URLEncoder.encode�������д���
	        response.setHeader("Content-Disposition", "attachment;filename=" +URLEncoder.encode(file.getName(), "UTF-8"));
	        toClient.write(buffer);
	        toClient.flush();
	        toClient.close();
	        } catch (IOException ex) {
	        ex.printStackTrace();
	        }finally{
	             try {
	                    File f = new File(file.getPath());
	                    f.delete();
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	        }
	        return response;
	    }

	/**  
	     * ����������ļ�����������ļ����д��
	     * @param File
	     * @param org.apache.tools.zip.ZipOutputStream
	     */
	    public static void zipFile(File inputFile,
	            ZipOutputStream ouputStream) {
	        try {
	            if(inputFile.exists()) {
	                /**�����Ŀ¼�Ļ������ǲ���ȡ�����ģ�
	                 * ����Ŀ¼�Ĵ�������о���*/
	                if (inputFile.isFile()) {
	                    FileInputStream IN = new FileInputStream(inputFile);
	                    BufferedInputStream bins = new BufferedInputStream(IN, 512);
	                    //org.apache.tools.zip.ZipEntry
	                    ZipEntry entry = new ZipEntry(inputFile.getName());
	                    ouputStream.putNextEntry(entry);
	                    // ��ѹ���ļ����������   
	                    int nNumber;
	                    byte[] buffer = new byte[512];
	                    while ((nNumber = bins.read(buffer)) != -1) {
	                        ouputStream.write(buffer, 0, nNumber);
	                    }
	                    // �رմ�����������   
	                    bins.close();
	                    IN.close();
	                } else {
	                    try {
	                        File[] files = inputFile.listFiles();
	                        for (int i = 0; i < files.length; i++) {
	                            zipFile(files[i], ouputStream);
	                        }
	                    } catch (Exception e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }



}
