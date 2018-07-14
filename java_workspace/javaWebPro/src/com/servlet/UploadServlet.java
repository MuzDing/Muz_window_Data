package com.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.biz.UserBiz;
import com.biz.UserBizImpl;
import com.entity.SysUser;
import com.util.MD5Util;

public class UploadServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6555647924238581985L;
	
	UserBiz ub = new UserBizImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//上传图片到服务器
		uploadImage(req);
		String userName = req.getAttribute("userName").toString();
		String password = req.getAttribute("password").toString();
		String nickName = req.getAttribute("nickName").toString();
		String imageUpload = req.getAttribute("imageUpload").toString();
		
		SysUser user = new SysUser();
		user.setUsrImage(imageUpload);
		user.setUsrName(userName);
		user.setUsrNickname(nickName);
		user.setUsrPassword(MD5Util.getMD5(password));
		
		//用户注册
		ub.insertUser(user);
		
		resp.sendRedirect("index.jsp");
	}
	
	@SuppressWarnings("unchecked")
	public void uploadImage(HttpServletRequest req) throws UnsupportedEncodingException{
		//获取表单提交类型，是否是 enctype="multipart/form-data" 文件流提交的形式
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		//文件上传目录
		String fpath = req.getServletContext().getRealPath("images/user/");
		File f = new File(fpath);
		if(!f.exists()){
			f.mkdirs();
		}
		//判断form表单是否以流的形式进行提交
		if(isMultipart){
			//文件上传核心代码
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			
			List<FileItem> items = null;
			try {
				items=upload.parseRequest(req);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
			for (FileItem fileItem : items) {
				//判断是否是文件
				if(!fileItem.isFormField()){
					File fullFile=new File(fileItem.getName());
					Date d = new Date();
					//获取上传的文件,并对上传的文件名添加时间挫
					String filename = d.getTime()+fullFile.getName();
					File uploadFile=new File(fpath,filename);
					//设置文件名到request对象中
					req.setAttribute(fileItem.getFieldName(), filename);
					try {
						//将文件写入服务器
						fileItem.write(uploadFile);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}else{
					String fieldName = fileItem.getFieldName();
					String fieldValue = fileItem.getString("UTF-8");
					//设置普通字段的名字和值到request对象中
					req.setAttribute(fieldName, fieldValue);
				}
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
