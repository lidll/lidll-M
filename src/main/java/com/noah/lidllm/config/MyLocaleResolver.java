package com.noah.lidllm.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @ClassName MyLocaleResolver
 * @Description 国际化解析
 * @Author noah
 * @Date 4/27/21 10:49 AM
 * @Version 1.0
 **/
public class MyLocaleResolver implements LocaleResolver {
    /**
     * Resolve the current locale via the given request.
     * Can return a default locale as fallback in any case.
     *
     * @param request the request to resolve the locale for
     * @return the current locale (never {@code null})
     */
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("l");
        Locale aDefault = Locale.getDefault();
        //如果请求的链接带了国际化的参数
        if (!StringUtils.isEmpty(language)) {

            String[] s = language.split("_");
            aDefault = new Locale(s[0], s[1]);
        }
        return aDefault;
    }

    /**
     * Set the current locale to the given one.
     *
     * @param request  the request to be used for locale modification
     * @param response the response to be used for locale modification
     * @param locale   the new locale, or {@code null} to clear the locale
     * @throws UnsupportedOperationException if the LocaleResolver
     *                                       implementation does not support dynamic changing of the locale
     */
    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
