package com.web.controller;

import org.core.http.HttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.utils.file.FileUtils;

@RestController
@RequestMapping("/rest")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @RequestMapping(value = "/write", method = RequestMethod.POST)
    public HttpResponse write(@RequestParam("fileName") final String fileName, @RequestBody final String body) {
        HttpResponse httpResponse = HttpResponse.ok();
        logger.info(String.format("%s: %s", fileName, body));
        FileUtils.write(fileName, new StringBuffer(body), null);
        return httpResponse;
    }

}
