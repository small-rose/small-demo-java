package com.xiaocai.demo.java.jsoup;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.jupiter.api.Test;

/**
 * @Project : small-demo-java
 * @Author : zhangxiaocai
 * @Description : [ HtmlTest ] 说明：无
 * @Function :  功能说明：无
 * @Date ：2024/8/22 21:18
 * @Version ： 1.0
 **/
public class HtmlTest {


    @Test
    public void jsoupTest01(){
        String url = "https://www.peisebiao.com/info/cn.php";
        url = "https://www.peisebiao.com/info/jianbian.php";
        Document document = NetUtil.getDocument(url);
        System.out.println(document.toString());
        System.out.println("=========================================================");
        Elements liList = document.select(".row .col-xs-1_5 li");
        int x = 0 ;
        StringBuffer sb = new StringBuffer();

        for (Element li : liList) {
            if (x==4 || x ==0){
                sb.append("<tr>\n");
            }

            String style = li.select("div").attr("style");
            String chName = li.select("h3").text();
            String eName = li.select("h4").text();
            sb.append("<td style=\""+style+"\" width=\"40px\" height=\"40px\">"+chName+" "+eName+"</td>\n");
            if (x==3){
                sb.append("</tr>\n");
            }
            x++ ;
            if (x>=4){
                x= 0;
            }
        }
        sb.append("</tr>\n");
        System.out.println(sb.toString());
    }



    @Test
    public void jsoupTestJBian(){
        String url = "https://www.peisebiao.com/info/jianbian.php";
        Document document = NetUtil.getDocument(url);
        System.out.println(document.toString());
        System.out.println("=========================================================");
        Elements liList = document.select("div.item-clr-gradient");
        int x = 0 ;
        StringBuffer sb = new StringBuffer();

        for (Element li : liList) {
            if (x==4 || x ==0){
                sb.append("<tr>\n");
            }

            String style = li.select("div.gradient-block").attr("style");
            String style2 = li.select("span").get(0).select("input").val();
            String chName = li.select("span").get(1).text();
            String eName = li.select("span").get(2).text();
            sb.append("<td style=\""+style+" "+ style2+"\" width=\"40px\" height=\"80px\"></td>\n");
            sb.append("<td style=\""+style+" "+ style2+"\" width=\"40px\" height=\"23px\">"+chName+"      \t"+eName+"</td>\n");
            if (x==3){
                sb.append("</tr>\n");
            }
            x++ ;
            if (x>=4){
                x= 0;
            }
        }
        sb.append("</tr>\n");
        System.out.println(sb.toString());
    }


    @Test
    public void jsoupTestJp(){
        String url = "https://www.peisebiao.com/info/jp.php";
        Document document = NetUtil.getDocument(url);
        System.out.println(document.toString());
        System.out.println("=========================================================");
        Elements liList = document.select(".row .col-xs-1_5 li");
        int x = 0 ;
        StringBuffer sb = new StringBuffer();


        for (Element li : liList) {
            if (x==4 || x ==0){
                sb.append("<tr>\n");
            }

            String style = li.select("div").attr("style");
            String chName = li.select("h3").text();
            String eName = li.select("h4").text();
            sb.append("<td style=\""+style+"\" width=\"40px\" height=\"40px\">"+chName+" "+eName+"</td>\n");
            if (x==3){
                sb.append("</tr>\n");
            }
            x++ ;
            if (x>=4){
                x= 0;
            }
        }

        sb.append("</tr>\n");
        System.out.println(sb.toString());
    }
}
