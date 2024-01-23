package com.duu.formula;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;

public class MultipartFileToFileConverter {

    public static File convert(MultipartFile multipartFile) throws IOException {
        // 如果是 CommonsMultipartFile 类型，可以直接获取字节数组
        if (multipartFile instanceof CommonsMultipartFile) {
            byte[] bytes = ((CommonsMultipartFile) multipartFile).getBytes();
            return createFileFromBytes(bytes);
        } else {
            // 对于其他类型的 MultipartFile，可以使用 multipartFile.getBytes()
            byte[] bytes = multipartFile.getBytes();
            return createFileFromBytes(bytes);
        }
    }

    private static File createFileFromBytes(byte[] bytes) throws IOException {
        // 创建一个临时文件
        File tempFile = File.createTempFile("temp", null);
        // 将字节数组写入临时文件
        org.apache.commons.io.FileUtils.writeByteArrayToFile(tempFile, bytes);
        return tempFile;
    }

}