package controller.response.processors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ResponseProcessor {
    void process(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException;
}
