package com.niuka.api.server.controller.util;

import com.niuka.api.server.controller.constant.ApiConstant;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/**
 * Created by admin on 2017/8/28.
 */
public class UploadUtil {
    /**
     * Base64编码图片上传
     * @param request
     * @param out
     * @param base64File
     * @param imgExts
     * @throws Exception
     */
    public static void writeImageBase64(HttpServletRequest request, PrintWriter out, String base64File, List<String> imgExts,String module) throws Exception {
        Base64 decoder = new Base64();
        String basePath = ApiConstant.IMAGE_FIRST_URL;
        String extName = base64File.split(";")[0].split("/")[1];
        String dir = "/statics/app/"+module+"/";;
        if (!imgExts.contains(extName)) {
            out.println(resultString("上传图片的格式不正确!请上传JPG,JPEG,BMP,GIF,PNG", null, "FAILURE"));
        }else{
            String fileName = UUID.randomUUID().toString() + "." + extName;
            base64File = base64File.split(",")[1];
            if(base64File==null){
                throw new FileUploadException();
            }
            try {
                // Base64解码
                byte[] bytes = decoder.decodeBase64(base64File.getBytes());
                for (int i = 0; i < bytes.length; ++i) {
                    if (bytes[i] < 0) {// 调整异常数据
                        bytes[i] += 256;
                    }
                }
                createFolder(basePath + "/"+dir); //如果目录不存在，自动创建
                // 生成图片
                String filePath = basePath + "/"+dir + fileName;
                OutputStream outs = new FileOutputStream(filePath);
                outs.write(bytes);
                outs.flush();
                outs.close();
                out.print(resultString(dir+fileName, null, "SUCCESS"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void createFolder(String path) {
        File saveFile = new File(path);
        if (!saveFile.exists()) {
            saveFile.mkdirs();
        }
    }

    public  static String resultString(String imageUrl, String remark, String status) {
        StringBuffer buffer = new StringBuffer();
        buffer.append("{");
        buffer.append("\"url\"").append(":\"");
        buffer.append(imageUrl).append("\",");
        buffer.append("\"title\"").append(":\"");
        buffer.append(remark).append("\",");
        buffer.append("\"state\"").append(":\"");
        buffer.append(status);
        buffer.append("\"}");
        return buffer.toString();
    }
    /**
     * 图片上传
     * @param request
     * @param out
     * @param fileList
     * @param imgExts
     * @throws Exception
     */
    public static void writeImageNoraml(HttpServletRequest request, PrintWriter out, List<FileItem> fileList, List<String> imgExts,String module) throws Exception {
        Iterator it = fileList.iterator();
        File file = null;
        String extName = null;
        String basePath = ApiConstant.IMAGE_FIRST_URL;
        String dir = "/statics/app/"+module+"/";

        if(it.hasNext()){
            FileItem item = (FileItem) it.next();
            if (!item.isFormField()) {
                String name = item.getName();
                if (item.getSize()>2097152) {
                    out.print(resultString("上传图片的格式不存在，或者上传图片超过[2M]", null, "FAILURE"));
                } else {
                    if (name.lastIndexOf(".") >= 0) {
                        extName = name.substring(name.lastIndexOf(".")+1);
                        if (!imgExts.contains(extName)) {
                            out.println(resultString("上传图片的格式不正确!请上传JPG,JPEG,BMP,GIF,PNG", null, "FAILURE"));
                        }
                    } else {
                        out.println(resultString("上传图片的格式不正确!请上传JPG,JPEG,BMP,GIF,PNG", null, "FAILURE"));
                    }
                    createFolder(basePath + "/"+dir); //如果目录不存在，自动创建
                    file = new File(basePath + dir + UUID.randomUUID() + "." + extName);
                    item.write(file);
                    out.print(resultString(dir+file.getName(), null, "SUCCESS"));
                }
            }
        }
    }

}
