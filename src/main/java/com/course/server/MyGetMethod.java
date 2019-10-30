package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author tyler.chen
 * @data 2019-10-21 23:24
 */

@RestController
@Api(value = "/", description = "这是我全部get方法")
public class MyGetMethod {

    @RequestMapping(value = "/getCookies", method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取到Cookies", httpMethod = "GET")
    public String getCookies(HttpServletResponse response) {
        //HttpServletRequest 装请求信息的类
        //HttpServletRespone 装响应信息的类
        Cookie cookie = new Cookie("login", "true");
        response.addCookie(cookie);
        return "恭喜你获得Cookies";
    }

    /**
     * 要求用户端携带
     * cookies访问
     */

    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "要求客户端携带cookies访问", httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if (Objects.isNull(cookies)) {
            return "你必须携带cookies信息来";
        }
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "恭喜您访问成功了";

            }
        }
        return "你必须携带cookies信息来";
    }

    /**
     * 开发以一个需要携带参数才能访问get请求
     * 第一种实现方式 URL：key=value & key=value
     * 我们来模拟获取商品列表,商品名称和商品价格
     */

    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get请求方法一", httpMethod = "GET")
    public Map<String, Integer> getList(@RequestParam Integer start, @RequestParam Integer end) {

        Map<String, Integer> myList = new HashMap<>();
        myList.put("鞋", 400);
        myList.put("干脆面", 4);
        myList.put("忖衫", 300);

        return myList;
    }

    /**
     * 第二种需要携带参数访问的get请求
     * url：ip:port/get/with/param/10/20
     */

    @RequestMapping(value = "/get/with/param/{start}/{end}")
    @ApiOperation(value = "需要携带参数才能访问的get请求方法二", httpMethod = "GET")
    public Map myGetList(@PathVariable Integer start, @PathVariable Integer end) {

        Map<String, Integer> myList = new HashMap<>();
        myList.put("鞋", 400);
        myList.put("干脆面", 4);
        myList.put("忖衫", 300);

        return myList;

    }

}
