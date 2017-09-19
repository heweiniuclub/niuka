package com.niuka.api.server.controller.upload;


import com.niuka.api.server.controller.base.BaseController;
import com.niuka.api.server.controller.util.UploadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * 图片上传
 *
 * @author hewei
 */
@Api(tags = "图片上传")
@Controller
@RequestMapping("/upload")
public class UploadController extends BaseController {

    @ApiOperation("图片上传")
    @RequestMapping(value = "uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public void uploadImg() {
        PrintWriter out = null;
        try{
            List<String> imgExts = new ArrayList<String>();
            Collections.addAll(imgExts, new String[]{"gif", "jpg", "png", "jpeg", "bmp"});
            response.setCharacterEncoding("utf8");
            response.setContentType("text/html;charset=UTF-8");
            response.addHeader("Access-Control-Allow-Origin", "*");
            response.addHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
            response.addHeader(
                    "Access-Control-Allow-Headers",
                    "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires, Content-Type, X-E4M-With");

            out = response.getWriter();

            String image = request.getParameter("image");
            String module = request.getParameter("module");

            if (image == null) {
                ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
                servletFileUpload.setHeaderEncoding("utf8");
                List fileList = servletFileUpload.parseRequest(request);
                if ((fileList != null) && (!fileList.isEmpty())) {
                    UploadUtil.writeImageNoraml(request, out, fileList, imgExts,module);
                }
            } else {
                UploadUtil.writeImageBase64(request, out, image, imgExts,module);
            }
        }catch (Exception e){
            e.printStackTrace();
            out.print( UploadUtil.resultString("上传图片失败", e.getMessage(), "FAILURE"));
        }finally {
            out.close();
        }


    }
}