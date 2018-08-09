package com.iflytek.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iflytek.util.VerifyCode;

@Controller
@RequestMapping("/validate")
public class VerifyCodeController {
	
	@SuppressWarnings("static-access")
	@RequestMapping("/verifyCode")
	public void verifyCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		  response.setHeader("Pragma", "No-cache"); 
	        response.setHeader("Cache-Control", "no-cache"); 
	        response.setDateHeader("Expires", 0); 
	        response.setContentType("image/jpeg"); 
		 //创建对象
        VerifyCode vc = new VerifyCode();
        //获取图片对象
        BufferedImage bi = vc.getImage();
        //获得图片的文本内容
        String text = vc.getText();
        // 将系统生成的文本内容保存到session中
        request.getSession().setAttribute("text", text);
        //向浏览器输出图片
        vc.output(bi, response.getOutputStream());
	}

}
