package fulei;

import javax.servlet.http.HttpServlet;

/**
 * Created by liunian on 2017/6/30.
 */
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class BaseServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // super.service(req, resp);
       String methodname = req.getParameter("method");
      Method method = null;
              try {
                  method = this.getClass().getMethod(methodname,HttpServletRequest.class,HttpServletResponse.class);
              }catch (Exception e){
                  throw new  RuntimeException("您要调用的方法不存在",e);
              }
              try {

              String result = (String)method.invoke(this,req,resp);
                  if(result != null && !result.trim().isEmpty()) {//如果请求处理方法返回不为空
                      int index = result.indexOf(":");//获取第一个冒号的位置
                      if(index == -1) {//如果没有冒号，使用转发
                          req.getRequestDispatcher(result).forward(req, resp);
                      } else {//如果存在冒号
                          String start = result.substring(0, index);//分割出前缀
                          String path = result.substring(index + 1);//分割出路径
                          if(start.equals("f")) {//前缀为f表示转发
                              req.getRequestDispatcher(path).forward(req, resp);
                          } else if(start.equals("r")) {//前缀为r表示重定向
                          }
                      }
                  }
              }catch (Exception e){
                  throw new RuntimeException(e);
              }


    }
}
