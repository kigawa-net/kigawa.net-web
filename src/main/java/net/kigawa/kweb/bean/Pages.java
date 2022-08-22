package net.kigawa.kweb.bean;

import net.kigawa.kweb.controller.ApiController;
import net.kigawa.kweb.controller.AppController;
import net.kigawa.kweb.response.Page;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import java.net.URI;
import java.util.LinkedList;
import java.util.List;

public class Pages
{
    private final BeanFactory beanFactory;
    private final URIUtil uriUtil;

    @Autowired
    public Pages(URIUtil uriUtil, BeanFactory beanFactory)
    {
        this.beanFactory = beanFactory;
        this.uriUtil = uriUtil;
        if (beanFactory == null) throw new NullPointerException("bean factory is null");
        if (uriUtil == null) throw new NullPointerException("uri util is null");
    }

    public List<Page> getRootSitemap()
    {
        var list = new LinkedList<Page>();
        list.add(new Page(
                "top",
                "/",
                uriUtil.generateUrl(AppController.class, "top", Model.class),
                uriUtil.generateUrl(ApiController.class, "top")
        ));
        list.add(uriUtil.generatePage(
                "service",
                "/service"
        ));
        return list;
    }

    public URI getApiRoot()
    {
        return uriUtil.generateUrl(ApiController.class, "root");
    }

}
