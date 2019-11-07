package com.algerfan.lecture;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Auther algerfan
 * @Date 18-11-10 16:15
 * @Description
 **/
@WebServlet(urlPatterns = "/Servlet2",asyncSupported = true)
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long t1 = System.currentTimeMillis();
        //开启异步
        AsyncContext asyncContext = request.startAsync();
        CompletableFuture.runAsync(() -> someThing(asyncContext, asyncContext.getRequest(), asyncContext.getResponse()));
        System.out.println(System.currentTimeMillis() - t1);
    }

    private void someThing(AsyncContext asyncContext, ServletRequest request, ServletResponse response) {
        //模拟耗时操作
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            response.getWriter().write("done");
        } catch (IOException e) {
            e.printStackTrace();
        }
        asyncContext.complete();
    }
}
