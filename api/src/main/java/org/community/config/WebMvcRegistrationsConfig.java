package org.community.config;

import org.community.version.MultiVersionRequestMappingHandlerMapping;
import org.springframework.boot.autoconfigure.web.WebMvcRegistrationsAdapter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * Created by frodo on 2017/9/1.
 * http://www.cnblogs.com/jcli/p/springmvc_restful_version.html
 * https://github.com/hongfuli/study_notes/tree/master/spring/samples
 * http://blog.csdn.net/u010782227/article/details/74905404
 */
@Configuration
public class WebMvcRegistrationsConfig extends WebMvcRegistrationsAdapter {

    @Override
    public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
        return new MultiVersionRequestMappingHandlerMapping();
    }
}
