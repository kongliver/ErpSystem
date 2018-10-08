package com.erpsystem.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @function   控制层公共类
 * @author     极客空
 * @date       2018年9月13日 下午11:11:29
 * @copyright  MR.Liu
 * @address    成都
 *
 */
public abstract class BaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
	    // 接收参数
        String action = request.getParameter("action");
        String desPath = null;
        try {
            // 获取当前对象的字节码
            Class<?> clazz = this.getClass();
            Method method = clazz.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            // 打开调用非public方法权限
            method.setAccessible(true);
            // 判断有无传入的方法，如果有就调用
            if (method != null) {
                // 动态的执行这个方法
                desPath = (String)method.invoke(this, request, response);
                if (desPath != null) {
                    request.getRequestDispatcher(desPath).forward(request, response);
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }       
    }

}
