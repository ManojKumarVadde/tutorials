package org.baeldung.web.controller;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;

import org.baeldung.web.dto.Foo;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FooController {

    public FooController() {
        super();
    }

    // API - read
    @PreAuthorize("#oauth2.hasScope('read')")
    @RequestMapping(method = RequestMethod.GET, value = "/foos/{id}")
    @ResponseBody
    public Foo findById(@PathVariable final long id) {
        return new Foo(Long.parseLong(randomNumeric(2)), randomAlphabetic(4));
    }

}
