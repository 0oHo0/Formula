package com.duu.formula;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.resource.Resource;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.crypto.digest.Digester;
import cn.hutool.crypto.digest.MD5;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @author : duu
 * @data : 2024/1/11
 * @from ：https://github.com/0oHo0
 **/
@Component
public class ApiClient {
    @Value("${simpletex.appId}")
    public String appId;
    @Value("${simpletex.appSecret}")
    public String appSecret;
    @Value("${simpletex.token}")
    public String token;

    public FormulaResponse doIdentify(MultipartFile multipartFile){
        FormulaResponse formulaResponse = new FormulaResponse();
        long timestamp = System.currentTimeMillis()/1000;

        String string = RandomUtil.randomString(16);
        Map<String, String> map = new HashMap<>();
        map.put("timestamp", String.valueOf(timestamp));
        map.put("random-str", string);
        map.put("app-id",appId);
        String content = String.format("app-id=%s&random-str=%s&timestamp=%s&secret=%s",appId,string,timestamp,appSecret);
        String sign = DigestUtil.md5Hex(content);
        map.put("sign",sign);
        System.out.println(map);
        HttpRequest request = HttpRequest.post("https://server.simpletex.cn/api/latex_ocr")
                .addHeaders(map);
        File file = null;
        try {
            file = MultipartFileToFileConverter.convert(multipartFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        request.form("file", file);
        HttpResponse httpResponse = request.execute();
        FormulaResponse response = JSONUtil.toBean(httpResponse.body(), FormulaResponse.class);
        return response;
    }
}
