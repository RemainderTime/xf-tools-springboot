package com.xf.test01;

import com.sun.imageio.plugins.common.ImageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.awt.image.BufferedImageDevice;
import sun.nio.ch.IOUtil;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @program: jwt-user
 * @description:
 * @author: xf
 * @create: 2022-01-12 07:14
 **/

@Controller
public class GraphicsController {


   @RequestMapping("/code")
   private void GraphicsCode(HttpServletRequest request, HttpServletResponse response){

      BufferedImage bufferedImage =new BufferedImage(50,50,BufferedImage.TYPE_INT_RGB);

      Graphics graphics = bufferedImage.getGraphics();
      graphics.setColor(new Color(255,255,255));

      Font font =new Font("这是一段文字",Font.BOLD,25);
      graphics.setFont(font);

      graphics.fillRect(0,0,50,50);

      graphics.setColor(Color.BLACK);

      graphics.drawString("2566",20,25);

      graphics.dispose();

      try {
         ServletOutputStream outputStream = response.getOutputStream();
         ImageIO.write(bufferedImage,"JPG",outputStream);
         outputStream.close();
      } catch (IOException e) {
         e.printStackTrace();
      }


   }


}
