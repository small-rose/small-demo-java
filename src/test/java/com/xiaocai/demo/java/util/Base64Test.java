package com.xiaocai.demo.java.util;

import com.xiaocai.demo.java.utils.Base64Tools;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @Project : small-demo-java
 * @Author : zhangzongyuan
 * @Description : [ Base64Test ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/4/17 22:17
 * @Version ： 1.0
 **/
public class Base64Test {

    @Test
    public void encoding(){
        String inputFile = "D:\\apps\\tomcat-embed-core-8.5.75.jar"; // 替换为要转换的文件路径
        String outputFile = "D:\\apps\\tomcat-embed-core-8.5.75.jar.txt"; // 替换为输出的文本文件路径
         inputFile = "C:\\Users\\SHFND-NOTE200001\\Downloads\\apache-tomcat-8.5.100-windows-x64.zip"; // 替换为要转换的文件路径
         outputFile = "C:\\Users\\SHFND-NOTE200001\\Downloads\\apache-tomcat.txt"; // 替换为输出的文本文件路径

        // Base64 编码
        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(inputFile));
            String base64String = Base64.getEncoder().encodeToString(fileContent);
            Base64Tools.writeStringToFile(outputFile, base64String);
            System.out.println("文件已成功转换为 Base64 文本并保存到输出文件中。");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void decoding(){

        // Base64 解码
        String base64InputFile = "C:\\Users\\SHFND-NOTE200001\\Downloads\\Click.txt"; // 替换为包含 Base64 文本的文件路径
        String binaryOutputFile = "C:\\Users\\SHFND-NOTE200001\\Downloads\\ClickShow1_4_1.base64.zip"; // 替换为输出的二进制文件路径

        try {
            String base64String = Base64Tools.readFileToString(base64InputFile);
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            Base64Tools.writeBytesToFile(binaryOutputFile, decodedBytes);
            System.out.println("Base64 文本已成功解码为二进制文件并保存到输出文件中。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void encodingNyf(){
        String inputFile = "D:\\apps\\tomcat-embed-core-8.5.75.jar"; // 替换为要转换的文件路径
        String outputFile = "D:\\apps\\tomcat-embed-core-8.5.75.jar.txt"; // 替换为输出的文本文件路径
        inputFile = "C:\\Users\\ZhangZongYuan\\Downloads\\Nyf-Repair-Tool.zip"; // 替换为要转换的文件路径
        outputFile = "C:\\Users\\ZhangZongYuan\\Downloads\\Nyf-Repair-Tool.txt"; // 替换为输出的文本文件路径

        // Base64 编码
        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(inputFile));
            String base64String = Base64.getEncoder().encodeToString(fileContent);
            Base64Tools.writeStringToFile(outputFile, base64String);
            System.out.println("文件已成功转换为 Base64 文本并保存到输出文件中。");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void decodingNyf(){

        // Base64 解码
        String base64InputFile = "C:\\Users\\ZhangZongYuan\\Downloads\\Nyf-Repair-Tool.txt"; // 替换为包含 Base64 文本的文件路径
        String binaryOutputFile = "C:\\Users\\ZhangZongYuan\\Downloads\\Nyf-Repair-Tool.zip"; // 替换为输出的二进制文件路径

        try {
            String base64String = Base64Tools.readFileToString(base64InputFile);
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            Base64Tools.writeBytesToFile(binaryOutputFile, decodedBytes);
            System.out.println("Base64 文本已成功解码为二进制文件并保存到输出文件中。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
