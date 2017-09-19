package com.niuka.common.captcha;

import java.awt.image.BufferedImage;

import java.io.IOException;

import javax.imageio.ImageIO;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 验证码缓存工具类
 *
 * @author hewei
 */
public class CaptchaHelper {
    public static final String CACHE_CAPTCHA = "_captcha";

    public static boolean validate(HttpServletRequest request, String captcha) {
        String sessionCaptcha = request.getSession().getAttribute(CaptchaHelper.CACHE_CAPTCHA).toString();

        return (sessionCaptcha == null)
               ? false
               : sessionCaptcha.equalsIgnoreCase(captcha);
    }

    public static void setInCache(final HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedImage image = new Captcha() {
            protected void setInCache(String captcha) {
                request.getSession().setAttribute(CACHE_CAPTCHA, captcha);
            }
        }.generate();
        ServletOutputStream out = response.getOutputStream();

        ImageIO.write(image, "jpg", out);

        try {
            out.flush();
        } finally {
            out.close();
        }
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
