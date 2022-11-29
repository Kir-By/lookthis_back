package com.kirby.lookthis.main.contoller;

import com.kirby.lookthis.main.entity.SystemError;
import com.kirby.lookthis.main.service.SystemErrorService;
import com.kirby.lookthis.main.uil.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

@ControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionController {
    private final SystemErrorService systemErrorService;


    public String getInputString(HttpServletRequest request) {
        HashMap<String, String> requestParam = new HashMap();
        Enumeration eParam = request.getParameterNames();
        while (eParam.hasMoreElements()) {
            String pName = (String)eParam.nextElement();
            if("password".equals(pName))
                continue;
            String[] pValue = request.getParameterValues(pName);
            requestParam.put(pName, String.join(",", pValue));
        }
        return requestParam.toString();
    }

    @ExceptionHandler(Exception.class)
    public void handleAnyException(HttpServletRequest request, Exception ex) throws IOException {
        if(ex.getClass() != CustomException.class){
            SystemError systemError = SystemError.builder()
                    .bodypart(getInputString(request))
                    .url(request.getRequestURL().toString())
                    .user_id(request.getHeader("Authorization"))
                    .message(ex.toString())
                    .build();

            systemErrorService.saveError(systemError);
        }
    }
}
