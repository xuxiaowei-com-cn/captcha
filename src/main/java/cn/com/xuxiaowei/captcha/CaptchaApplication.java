package cn.com.xuxiaowei.captcha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 程序执行入口
 *
 * @author xuxiaowei
 */
@ServletComponentScan("cn.com.xuxiaowei.captcha.servlet")
@SpringBootApplication
public class CaptchaApplication {

    public static void main(String[] args) {
        SpringApplication.run(CaptchaApplication.class, args);
    }

}
