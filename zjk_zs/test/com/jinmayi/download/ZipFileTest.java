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
                    //读入需要下载的文件的内容，打包到zip文件    
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
            //读入需要下载的文件的内容，打包到zip文件    
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


	//文件打包下载
	    public static HttpServletResponse downLoadFiles(List<File> files,
	            HttpServletRequest request, HttpServletResponse response)
	            throws Exception {
	        try {
	            /**这个集合就是你想要打包的所有文件，
	             * 这里假设已经准备好了所要打包的文件*/
	            //List<File> files = new ArrayList<File>();
	     
	            /**创建一个临时压缩文件，
	             * 我们会把文件流全部注入到这个文件中
	             * 这里的文件你可以自定义是.rar还是.zip*/
	            File file = new File("c:/certpics.rar");
	            if (!file.exists()){   
	                file.createNewFile();   
	            }
	            response.reset();
	            //response.getWriter()
	            //创建文件输出流
	            FileOutputStream fous = new FileOutputStream(file);   
	            /**打包的方法我们会用到ZipOutputStream这样一个输出流,
	             * 所以这里我们把输出流转换一下*/
	           ZipOutputStream zipOut 
	            = new ZipOutputStream(fous);
	            /**这个方法接受的就是一个所要打包文件的集合，
	             * 还有一个ZipOutputStream*/
	           zipFile(files, zipOut);
	            zipOut.close();
	            fous.close();
	           return downloadZip(file,response);
	        }catch (Exception e) {
	                e.printStackTrace();
	            }
	            /**直到文件的打包已经成功了，
	             * 文件的打包过程被我封装在FileUtil.zipFile这个静态方法中，
	             * 稍后会呈现出来，接下来的就是往客户端写数据了*/
	           
	     
	        return response ;
	    }

	  /**
	     * 把接受的全部文件打成压缩包 
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
	        // 以流的形式下载文件。
	        InputStream fis = new BufferedInputStream(new FileInputStream(file.getPath()));
	        byte[] buffer = new byte[fis.available()];
	        fis.read(buffer);
	        fis.close();
	        // 清空response
	        response.reset();

	        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	        response.setContentType("application/octet-stream");

	//如果输出的是中文名的文件，在此处就要用URLEncoder.encode方法进行处理
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
	     * 根据输入的文件与输出流对文件进行打包
	     * @param File
	     * @param org.apache.tools.zip.ZipOutputStream
	     */
	    public static void zipFile(File inputFile,
	            ZipOutputStream ouputStream) {
	        try {
	            if(inputFile.exists()) {
	                /**如果是目录的话这里是不采取操作的，
	                 * 至于目录的打包正在研究中*/
	                if (inputFile.isFile()) {
	                    FileInputStream IN = new FileInputStream(inputFile);
	                    BufferedInputStream bins = new BufferedInputStream(IN, 512);
	                    //org.apache.tools.zip.ZipEntry
	                    ZipEntry entry = new ZipEntry(inputFile.getName());
	                    ouputStream.putNextEntry(entry);
	                    // 向压缩文件中输出数据   
	                    int nNumber;
	                    byte[] buffer = new byte[512];
	                    while ((nNumber = bins.read(buffer)) != -1) {
	                        ouputStream.write(buffer, 0, nNumber);
	                    }
	                    // 关闭创建的流对象   
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
