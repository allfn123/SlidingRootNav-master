package com.yarolegovich.slidingrootnav.sample.music;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by luoguizhao on 2017/10/8.
 */

public class HttpDownloader {
    private URL url=null;

    //下载文件，该文件主要是文本类型文件，返回其中的内容
    public String download(String urlStr){
        StringBuffer sb=new StringBuffer();
        String line=null;
        BufferedReader buffer=null;
        try {
            //创建一个URL对象
            url=new URL(urlStr);
            //创建一个Http连接
            HttpURLConnection urlConn=(HttpURLConnection)url.openConnection();
            //使用IO流读取数据
            buffer=new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
            while((line=buffer.readLine())!=null){
                sb.append(line);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
