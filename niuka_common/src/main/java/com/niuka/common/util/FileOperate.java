package com.niuka.common.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;

@SuppressWarnings("all")
public class FileOperate{

	//导出excel
	public static void getExcel(List list, Object[] heads, OutputStream output) {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("sheet1");
		HSSFRow rows = sheet1.createRow(0);//创建行
		for (int i = 0; i < heads.length; i++) {
			sheet1.setColumnWidth(i, 3500);// 设置列宽
			HSSFCell cell1 = rows.createCell(i); //创建列
			if(heads[i] !=null){					
				cell1.setCellValue(new HSSFRichTextString(heads[i].toString()));
			}
		}
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			HSSFRow row = sheet1.createRow(i+1);//创建行
			HSSFCell cell = row.createCell(0);
			cell.setCellValue(new HSSFRichTextString(""+(i+1)));
			for (int j = 0; j < heads.length; j++) {
				HSSFCell cell1 = row.createCell(j); //创建列
				if(obj[j] !=null){					
					cell1.setCellValue(new HSSFRichTextString(obj[j].toString()));
				}
			}
		}
	    
		try {
			output.flush();
			wb.write(output);
			output.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//读取excel文件
	public static List<Object[]> readExcel(InputStream stream){
		try {
			HSSFWorkbook wb = new HSSFWorkbook(new POIFSFileSystem(stream));
			HSSFSheet sheet = wb.getSheetAt(0);
			List<Object[]> data = new ArrayList<Object[]>();
			for(int i = 1; i <= sheet.getLastRowNum(); i ++){
				HSSFRow row = sheet.getRow(i);
				Object[] rowData = new Object[row.getLastCellNum()];
				for(int j = 0; j < row.getLastCellNum(); j++){
					if(row.getCell(j).getCellType()==Cell.CELL_TYPE_STRING){
						rowData[j] = row.getCell(j).getStringCellValue();
					}
					if(row.getCell(j).getCellType()==Cell.CELL_TYPE_NUMERIC){
						rowData[j] = row.getCell(j).getNumericCellValue();
					}
					if(row.getCell(j).getCellType()==Cell.CELL_TYPE_BOOLEAN){
						rowData[j] = row.getCell(j).getBooleanCellValue();
					}
					if(row.getCell(j).getCellType()==Cell.CELL_TYPE_BLANK){
						rowData[j] = "";
					}
				}
				data.add(rowData);
			}
			return data;
		} catch (Exception e) {
			//return null;
			//e.printStackTrace();
		}
		return null;
	}
	//读取文件
	public static List<String> readFile(InputStream stream){
		BufferedReader reader;
		List<String> data = new ArrayList<String>();
		try {
			reader =new BufferedReader(new InputStreamReader(stream,"utf-8"));
			String temp = "";
			while((temp=reader.readLine())!=null){
				data.add(temp);
			}
			return data;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 传入字节流对象，读取字节
	 * @param stream
	 * @return
	 * @throws IOException
	 */
	public static byte[] getBytesByStream(InputStream stream) throws IOException {
		byte[] b = null;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		InputStream is = null;
		try {
			is = new BufferedInputStream(stream);
			int count = 0;
			byte[] buf = new byte[16384];
			while ((count = is.read(buf)) != -1) {
				if (count > 0) {
					baos.write(buf, 0, count);
				}
			}
			b = baos.toByteArray();

		} finally {
			try {
				if (is != null)
					is.close();
				if (baos != null)
					baos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return b;
	}
	
	/**
	 * 传入文件，读取文件字节
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static byte[] getBytesByFile(File file) throws IOException {
		return getBytesByStream(new FileInputStream(file));
	}
	
	/**
	 * 传入字符流对象，读取字符
	 * @param reader
	 * @return
	 * @throws IOException
	 */
	public static char[] getCharsByReader(Reader reader) throws IOException {
		char[] c = null;
		CharArrayWriter caw = new CharArrayWriter();
		Reader in = null;
		try {
			in = new BufferedReader(reader);
			int count = 0;
			char[] buf = new char[16384];
			while ((count = in.read(buf)) != -1) {
				if (count > 0) {
					caw.write(buf, 0, count);
				}
			}
			c = caw.toCharArray();
		} finally {
			try {
				if (caw != null)
					caw.close();
				if (in != null)
					in.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return c;
	}
	
	/**
	 * 传入文件，读取文件字符
	 * @param file
	 * @return
	 * @throws IOException
	 */
	public static char[] getCharsByFile(File file) throws IOException {
		return getCharsByReader(new FileReader(file));
	}

	/**
	 * 把字节写入本地磁盘(如果文件存在，则覆盖)
	 * @param file
	 * @param data
	 * @throws IOException
	 */
	public static void writeFileByBytes(File file, byte[] data) throws IOException {
		writeFileByBytes(file, false, data);
	}
	
	/**
	 * 把字节写入本地磁盘
	 * @param Stream
	 * @param data
	 * @throws IOException
	 */
	public static void writeFileByBytes(File file,boolean append,byte[] data) throws IOException {
		writeByBytes(new FileOutputStream(file, append), data);
	}
	
	/**
	 * 把字节写入内存
	 * @param Stream
	 * @param data
	 * @throws IOException
	 */
	public static void writeByBytes(OutputStream Stream,byte[] data) throws IOException {
		OutputStream os = null;
		try {
			os = new BufferedOutputStream(Stream);
			os.write(data);

		} finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 把字符写入本地磁盘(如果文件存在，则覆盖)
	 * @param file
	 * @param data
	 * @throws IOException
	 */
	public static void writeFileByChars(File file,char[] data) throws IOException {
		writeFileByChars(file, false, data);
	}

	/**
	 * 把字符写入本地磁盘
	 * @param file
	 * @param data
	 * @throws IOException
	 */
	public static void writeFileByChars(File file,boolean append,char[] data) throws IOException {
		writeByChars(new FileWriter(file, append), data);
	}

	/**
	 * 把字符写入内存
	 * @param file
	 * @param data
	 * @throws IOException
	 */
	public static void writeByChars(Writer writer,char[] data) throws IOException {
		BufferedWriter os = null;
		try {
			os = new BufferedWriter(writer);
			os.write(data);
			
		} finally {
			try {
				if (os != null)
					os.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
