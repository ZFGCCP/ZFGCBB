package com.zfgc.zfgbb.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zfgc.zfgbb.services.core.ContentService;
import com.zfgc.zfgbb.authorization.AllowAnonymous;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/resources/{resourceType}")
@RequiredArgsConstructor
public class WikiResourceController extends BaseController {
    private final ContentService contentService;

    @RequestMapping("/{resourceId}")
    @AllowAnonymous
    public String getWikiResource(
            @PathVariable("resourceType") String resourceType,
            @PathVariable("resourceId") Integer resourceId) {
        return resourceType;
    }

}
