package org.community.version;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * Annotation for support Multi-version Restful API
 * Created by frodo on 2017/9/1.
 */
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {
    /**
     * version code
     *
     * @return
     */
    int value();
}
