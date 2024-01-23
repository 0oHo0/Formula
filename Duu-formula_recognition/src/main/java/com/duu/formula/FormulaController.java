package com.duu.formula;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author : duu
 * @data : 2024/1/13
 * @from ：https://github.com/0oHo0
 **/
@RestController
@RequestMapping("/formula")
public class FormulaController {
    @Resource
    ApiClient apiClient;

    @PostMapping("/do")
    public String doIdentify(MultipartFile file){
        FormulaResponse response = apiClient.doIdentify(file);
       return "$$"+response.getRes().getLatex()+"$$";
    }
}
