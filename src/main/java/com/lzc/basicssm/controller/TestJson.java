package com.lzc.basicssm.controller;

import com.alibaba.fastjson.JSON;
import com.lzc.basicssm.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/json")
public class TestJson {

    @RequestMapping(value = "/testRequestBody", method = RequestMethod.POST)
    public void setJson(@RequestBody Book book, HttpServletResponse response) throws IOException {
        book.setAuthor("zzzz");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println(JSON.toJSONString(book));
    }

    @RequestMapping(value = "/testfastBody", method = RequestMethod.POST)
    @ResponseBody
    public Object setFastJson(){

        List<Book> list = new ArrayList<Book>();
        list.add(new Book("1", "aa", "lala"));
        list.add(new Book("2", "bb", "hehe"));
        return list;
    }
}
