package com.xiaocai.demo.java.utils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

/**
 * @Project : springboot-demo
 * @Author : Small-Rose / zhangxaiocai
 * @Description : [ Base64Tools ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2023/12/14 15:37
 * @Version ： 1.0
 **/
public class Base64Tools {


    public static void main(String[] args) {
        //String inputFile = "C:\\Users\\SHFND-NOTE200001\\Downloads\\ClickShow1_4_1.zip"; // 替换为要转换的文件路径
        //String outputFile = "C:\\Users\\SHFND-NOTE200001\\Downloads\\Click.txt"; // 替换为输出的文本文件路径
        String inputFile = "D:\\idea-Work\\zzy-new\\db-demo.zip"; // 替换为要转换的文件路径
        String outputFile = "D:\\idea-Work\\zzy-new\\db-demo.zip.txt"; // 替换为输出的文本文件路径

        // Base64 编码
        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(inputFile));
            String base64String = Base64.getEncoder().encodeToString(fileContent);
            writeStringToFile(outputFile, base64String);
            System.out.println("文件已成功转换为 Base64 文本并保存到输出文件中。");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Base64 解码
        String base64InputFile = "C:\\Users\\SHFND-NOTE200001\\Downloads\\Click.txt"; // 替换为包含 Base64 文本的文件路径
        String binaryOutputFile = "C:\\Users\\SHFND-NOTE200001\\Downloads\\ClickShow1_4_1.base64.zip"; // 替换为输出的二进制文件路径

        try {
            String base64String = readFileToString(base64InputFile);
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            writeBytesToFile(binaryOutputFile, decodedBytes);
            System.out.println("Base64 文本已成功解码为二进制文件并保存到输出文件中。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void encodeToString(String inputFile, String outputFile) {
        // Base64 编码
        try {
            byte[] fileContent = Files.readAllBytes(Paths.get(inputFile));
            String base64String = Base64.getEncoder().encodeToString(fileContent);
            writeStringToFile(outputFile, base64String);
            System.out.println("文件已成功转换为 Base64 文本并保存到输出文件中。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decodeToString(String base64InputFile, String binaryOutputFile) {
        // Base64 解码
        try {
            String base64String = readFileToString(base64InputFile);
            byte[] decodedBytes = Base64.getDecoder().decode(base64String);
            writeBytesToFile(binaryOutputFile, decodedBytes);
            System.out.println("Base64 文本已成功解码为二进制文件并保存到输出文件中。");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void writeStringToFile(String filePath, String content) throws IOException {
        byte[] contentBytes = content.getBytes(StandardCharsets.UTF_8);
        Files.write(Paths.get(filePath), contentBytes);
    }

    public static String readFileToString(String filePath) throws IOException {
        byte[] fileBytes = Files.readAllBytes(Paths.get(filePath));
        return new String(fileBytes, StandardCharsets.UTF_8);
    }

    public static void writeBytesToFile(String filePath, byte[] contentBytes) throws IOException {
        Files.write(Paths.get(filePath), contentBytes);
    }
}
