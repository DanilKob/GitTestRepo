package controller.response.processors;

import controller.filters.EncodingConstants;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("jsonResponseProcessor")
public class JsonResponseProcessor implements ResponseProcessor {
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
        response.setContentType(EncodingConstants.APPLICATION_JSON);
    }
}
