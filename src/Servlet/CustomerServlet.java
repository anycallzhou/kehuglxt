package Servlet;

import cn.itcast.commons.CommonUtils;

//import cn.itcast.servlet.BaseServlet; //我写一个if else判断的类型
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import CustomerService.*;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;
import domain.Customer;
import fulei.BaseServlet;
import java.util.*;
import org.apache.commons.beanutils.BeanUtils;
/**
 * Created by liunian on 2017/6/29.
 */
@WebServlet(name = "CustomerServlet")
//反射 加上封装了servlet
//如果不这样做。可以采用建立多个servlet，一一对应，或者用if -else 判断
public class CustomerServlet extends BaseServlet {
    private  CustomerService customerService =new CustomerService();
    public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Customer customer =new Customer() ;
       // System.out.println(request.getParameterMap().toString());
       // Map<String,String[]> map = request.getParameterMap();
        Customer customer = CommonUtils.toBean(request.getParameterMap(),Customer.class);
        customer.setId(CommonUtils.uuid());// customer 对象建立成功

        //进行add操作
        customerService.add(customer);
//        map.keySet()
//        try {
//            BeanUtils.populate(customer,map);
//        }catch (Exception e){
//            throw new RuntimeException(e);
//        }
        System.out.println(customer.getDescription());
        System.out.println(customer.getName());
        System.out.println(customer.getEmail());
        System.out.println(customer.getPhone());



        request.setAttribute("msg", "添加成功");

        return "/msg.jsp";
    }
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////        PrintWriter out = response.getWriter();
////        out.print("sdaaads");
//        request.setAttribute("msg","添加用户成功");
//        //response.sendRedirect("/msg.jsp");
//        request.getRequestDispatcher("/msg.jsp").forward(request,response);
//    }


}

