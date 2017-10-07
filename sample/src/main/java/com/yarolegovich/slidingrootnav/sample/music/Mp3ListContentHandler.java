package com.yarolegovich.slidingrootnav.sample.music;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.List;

/**
 * Created by luoguizhao on 2017/10/8.
 */

public class Mp3ListContentHandler extends DefaultHandler {
    private String tagName;
    private Mp3Info mp3Info;//定义一个全局变量的标签名称
    private List<Mp3Info> mp3Infos;

    //构造方法，将List集合传入进去
    public Mp3ListContentHandler(List<Mp3Info> mp3Infos) {
        super();
        this.mp3Infos = mp3Infos;
    }

    //解析其中的文本<mp3.name>qmys.mp3</mp3.name>--->qmys.mp3
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        String temp=new String(ch,start,length);
        if(tagName.equals("id")){
            mp3Info.setId(temp);
        }else if(tagName.equals("mp3.name")){
            mp3Info.setMp3Name(temp);
        }else if(tagName.equals("mp3.size")){
            mp3Info.setMp3Size(temp);
        }else if(tagName.equals("lrc.name")){
            mp3Info.setLrcName(temp);
        }else if(tagName.equals("lrc.size")){
            mp3Info.setLrcSize(temp);
        }
    }

    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
    }

    //解析结束元素
    @Override
    public void endElement(String uri, String localName, String qName)
            throws SAXException {
        if(localName.equals("resource")){
            mp3Infos.add(mp3Info);
        }
        tagName="";
    }

    //解析Document
    @Override
    public void startDocument() throws SAXException {
        //解析<resources>部分
        super.startDocument();
    }

    /**
     * 解析Element
     * namespaceURI 命名空间
     * localName 不带前缀部分<worker id="001">--->worker
     * qName 带前缀部分<abc:worker id="001">---->abc:worker
     * attributes  属性集合  <abc:worker id="001">---->id="001"....
     */
    @Override
    public void startElement(String uri, String localName, String qName,
                             Attributes attributes) throws SAXException {
        //解析<resource>部分
        tagName=localName;
        if(tagName.equals("resource")){
            mp3Info=new Mp3Info();
        }
    }




}
