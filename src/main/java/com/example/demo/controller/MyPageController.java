package com.example.demo.controller;

import com.example.demo.StringTemplateEngine;
import com.example.demo.user.model.PageDo;
import com.example.demo.user.model.SlotDo;
import com.example.demo.user.service.MyPageService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.templateresolver.StringTemplateResolver;

@Controller
@AllArgsConstructor
public class MyPageController {

    private SpringTemplateEngine  stringTemplateEngine;
    private MyPageService myPageService;

    @GetMapping("/m/{slot}")
    public String index(@PathVariable("slot") String slot) {
        return stringTemplateEngine.process(myPageService.getIndexPageBySlotId(slot), new Context());
    }

    @GetMapping("/m/{slot}/{path}")
    public String index(@PathVariable("slot") String slot, @PathVariable("path") String path) {
        return stringTemplateEngine.process(myPageService.getPathPageBySlotId(slot, path), new Context());
    }

    @PutMapping("/slot")
    public String addSlot(@RequestBody SlotDo slotDo) {
        myPageService.add(slotDo);
        return null;
    }

    @PutMapping("/page")
    public String addPage(@RequestBody PageDo pageDo) {
        myPageService.add(pageDo);
        return null;
    }

    @GetMapping("/slot/check/{slotId}")
    public String checkSlotId(@PathVariable("slotId") String slotId) {
        return myPageService.checkSlotId(slotId);
    }

    @GetMapping("/page/check/{slotId}")
    public boolean checkSlotIdAndPath(@PathVariable("slotId") String slotId, @RequestParam String path) {
        return myPageService.checkSlotIdAndPath(slotId, path);
    }

}
