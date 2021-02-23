package cn.com.xuxiaowei.captcha.servlet;

import com.pig4cloud.captcha.SpecCaptcha;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 普通验证码
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@WebServlet(urlPatterns = "/spec-captcha")
public class SpecCaptchaHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SpecCaptcha specCaptcha = new SpecCaptcha(130, 48);
        String text = specCaptcha.text();
        log.info("图片验证码：{}", text);

        // 设置响应头
        resp.setContentType(specCaptcha.getContentType());
        resp.setHeader("Pragma", "No-cache");
        resp.setHeader("Cache-Control", "no-cache");
        resp.setDateHeader("Expires", 0);

        // 转换流信息写出
        specCaptcha.out(resp.getOutputStream());

    }

}
