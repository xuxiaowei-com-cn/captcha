package cn.com.xuxiaowei.captcha.servlet;

import com.pig4cloud.captcha.GifCaptcha;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Gif验证码
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@WebServlet(urlPatterns = "/gif-captcha")
public class GifCaptchaHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GifCaptcha gifCaptcha = new GifCaptcha(130, 48);
        String result = gifCaptcha.text();
        log.info("图片验证码：{}", result);

        // 设置响应头
        resp.setContentType(gifCaptcha.getContentType());
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        // 转换流信息写出
        gifCaptcha.out(resp.getOutputStream());

    }

}
