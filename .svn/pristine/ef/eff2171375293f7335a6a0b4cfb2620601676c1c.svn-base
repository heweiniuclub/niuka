package com.niuka.common.util;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class PicCompression {
/**
* 压缩图片方法
*
* @param oldFile
*            要压缩的图片路径
* @param newFile
*            新文件的文件夹
* @param width
*            压缩宽
* @param height
*            压缩高
* @param percentage
*            是否等比例压缩,true则宽高比自动调整
* @return
* @throws Exception
*/
	@SuppressWarnings("all")
	public static void reduceImg(String oldFile, String newFileWidth, int widthdist,
	    int heightdist, boolean percentage) {
		String newFile = null;
	   try {
	    File srcfile = new File(oldFile);
	    if (!srcfile.exists()) {
	     return;
	    }
	    Image src = javax.imageio.ImageIO.read(srcfile);
	
	    if (true) {
	     // 为等比压缩计算输出的宽高
	     double rate1 = ((double) src.getWidth(null))
	       / (double) widthdist + 0.1;
	     double rate2 = ((double) src.getHeight(null))
	       / (double) heightdist + 0.1;
	     double rate = rate1 > rate2 ? rate1 : rate2;
	
	     int new_w = (int) (((double) src.getWidth(null)) / rate);
	     int new_h = (int) (((double) src.getHeight(null)) / rate);
	     // 设定宽高
	     BufferedImage tag = new BufferedImage(new_w, new_h,
	       BufferedImage.TYPE_INT_RGB);
	     
	     int c = tag.getRGB(3, 3); 
	     // 设定文件扩展名
	     String filePrex = oldFile
	       .substring(0, oldFile.lastIndexOf('.'));
	     newFile = filePrex + oldFile.substring(filePrex.length());//文件路径
	     //组建新文件路径
	     int index =  newFile.lastIndexOf("/");
	     String temp = newFile.substring(0,index);//前
	     newFile = newFile.substring(index);//后
	     newFile = "/" + newFileWidth  + newFile;
	     newFile = temp + newFile;
	     // 生成图片
	     // 两种方法,效果与质量都相同,效率差不多
	//     tag.getGraphics().drawImage(src.getScaledInstance(widthdist,heightdist, Image.SCALE_SMOOTH), 0, 0, null);
	     tag.getGraphics().drawImage(src.getScaledInstance(new_w, new_h,Image.SCALE_SMOOTH), 0, 0, null);
	     FileOutputStream out = new FileOutputStream(newFile);
	     JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	     encoder.encode(tag);
	     out.close();
	    } else {
	     // 设定宽高
	     BufferedImage tag = new BufferedImage(widthdist, heightdist,
	       BufferedImage.TYPE_INT_RGB);
	
	     int c = tag.getRGB(3, 3); 
	     
	   //创建java2D对象
	     Graphics2D g2d=tag.createGraphics();
	     
	   //  填充背景
	     g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING , RenderingHints.VALUE_ANTIALIAS_ON);
	     g2d.setColor(Color.white);
	     g2d.fillRect(0, 0, 600, 400);

			
	     // 设定文件扩展名
	     String filePrex = oldFile
	       .substring(0, oldFile.lastIndexOf('.'));
	     newFile = filePrex + oldFile.substring(filePrex.length());//文件路径
	     //组建新文件路径
	     int index =  newFile.lastIndexOf("/");
	     String temp = newFile.substring(0,index);//前
	     newFile = newFile.substring(index);//后
	     newFile = "/" + newFileWidth  + newFile;
	     newFile = temp + newFile;
	     
	     // 生成图片
	     // 两种方法,效果与质量都相同,第二种效率比第一种高,约一倍
	     // tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist, Image.SCALE_SMOOTH), 0, 0, null);
	     tag.getGraphics().drawImage(src.getScaledInstance(widthdist, heightdist,Image.SCALE_SMOOTH), 0, 0, null);
	     FileOutputStream out = new FileOutputStream(newFile);
	     JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
	     encoder.encode(tag);
	     out.close();
	    }
	
	   } catch (IOException ex) {
	    ex.printStackTrace();
	   }
	}
	
    /**   
     * 删除文件，可以是单个文件或文件夹   
     * @param   fileName    待删除的文件名   
     * @return 文件删除成功返回true,否则返回false   
     */    
    public static boolean delete(String fileName){     
        File file = new File(fileName);     
        if(!file.exists()){     
            System.out.println("删除文件失败："+fileName+"文件不存在");     
            return false;     
        }else{     
            if(file.isFile()){     
                return deleteFile(fileName);     
            }else{     
                return deleteDirectory(fileName);     
            }     
        } 
    } 
         
    /**   
     * 删除单个文件   
     * @param   fileName    被删除文件的文件名   
     * @return 单个文件删除成功返回true,否则返回false   
     */    
    public static boolean deleteFile(String fileName){     
        File file = new File(fileName);     
        if(file.isFile() && file.exists()){     
            file.delete();     
            System.out.println("删除单个文件"+fileName+"成功！");     
            return true;     
        }else{     
            System.out.println("删除单个文件"+fileName+"失败！");     
            return false;     
        }     
    }     
         
    /**   
     * 删除目录（文件夹）以及目录下的文件   
     * @param   dir 被删除目录的文件路径   
     * @return  目录删除成功返回true,否则返回false   
     */    
    public static boolean deleteDirectory(String dir){     
        //如果dir不以文件分隔符结尾，自动添加文件分隔符     
        if(!dir.endsWith(File.separator)){     
            dir = dir+File.separator;     
        }     
        File dirFile = new File(dir);     
        //如果dir对应的文件不存在，或者不是一个目录，则退出     
        if(!dirFile.exists() || !dirFile.isDirectory()){     
            System.out.println("删除目录失败"+dir+"目录不存在！");     
            return false;     
        }     
        boolean flag = true;     
        //删除文件夹下的所有文件(包括子目录)     
        File[] files = dirFile.listFiles();     
        for(int i=0;i<files.length;i++){     
            //删除子文件     
            if(files[i].isFile()){     
                flag = deleteFile(files[i].getAbsolutePath());     
                if(!flag){     
                    break;     
                }     
            }     
            //删除子目录     
            else{     
                flag = deleteDirectory(files[i].getAbsolutePath());     
                if(!flag){     
                    break;     
                }     
            }     
        }     
             
        if(!flag){     
            System.out.println("删除目录失败");     
            return false;     
        }     
             
        //删除当前目录     
        if(dirFile.delete()){     
            System.out.println("删除目录"+dir+"成功！");     
            return true;     
        }else{     
            System.out.println("删除目录"+dir+"失败！");     
            return false;     
        }     
    }     
         
//    public static void main(String[] args) {     
//        String fileName = "F:/tomcat/apache-tomcat-6.0.36/webapps/JapanShops/attached/image/1/20130410114635_303.jpg";     
//        PicCompression.deleteFile(fileName);     
////        String fileDir = "G:/temp/temp0/temp1";     
//        //PicCompression.deleteDirectory(fileDir);     
////        PicCompression.delete(fileDir);        
//    }   
	
}