package com.algerfan.lecture;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther algerfan
 * @Date 18-11-10 16:06
 * @Description
 **/
@WebServlet(urlPatterns = "/Servlet1")
public class Servlet1 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long t1 = System.currentTimeMillis();

        someThing(request,response);
        System.out.println(System.currentTimeMillis() - t1);
    }

    private void someThing(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        response.getWriter().write("done");
    }
}
