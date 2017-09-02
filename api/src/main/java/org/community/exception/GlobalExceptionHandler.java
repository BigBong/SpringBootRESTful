package org.community.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by frodo on 2017/6/2.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e.getMessage());
        mav.addObject("url", req.getRequestURL());
        String requestURL = req.getRequestURL().toString();
        if (requestURL.contains("/web/")) {
            mav.setViewName(DEFAULT_ERROR_VIEW);
        }

        return mav;
    }
}
