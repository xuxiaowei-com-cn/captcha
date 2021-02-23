package cn.com.xuxiaowei.captcha.servlet;

import com.pig4cloud.captcha.ChineseGifCaptcha;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 中文Gif验证码
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@WebServlet(urlPatterns = "/chinese-gif-captcha")
public class ChineseGifCaptchaHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        ChineseGifCaptcha chineseGifCaptcha = new ChineseGifCaptcha(130, 48);
        String result = chineseGifCaptcha.text();
        log.info("图片验证码：{}", result);

        // 设置响应头
        resp.setContentType(chineseGifCaptcha.getContentType());
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        // 转换流信息写出
        chineseGifCaptcha.out(resp.getOutputStream());

    }

}
