package controller.utils;

import controller.Parameters;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class CommandUtil {
    public static final String RESPONSE_PROCESSOR_BEAN_NAME_SUFFIX = "ResponseProcessor";

    public String getCommandBeanName(HttpServletRequest request) {
        return request.getParameter(Parameters.ACTION_PARAM);
    }

    public String getResponseProcessorBeanName(String responseType) {
        return responseType.split("/")[0] + RESPONSE_PROCESSOR_BEAN_NAME_SUFFIX;
    }

    public String getResponsePage(String responseType) {
        return responseType.substring(responseType.indexOf("/"));
    }
}
