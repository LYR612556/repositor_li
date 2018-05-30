package com.netty.protocol.httpxml;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import com.netty.protocol.httpxml.pojo.Order;
import com.netty.protocol.httpxml.pojo.OrderFactory;
import org.jibx.runtime.BindingDirectory;
import org.jibx.runtime.IBindingFactory;
import org.jibx.runtime.IMarshallingContext;
import org.jibx.runtime.IUnmarshallingContext;
import org.jibx.runtime.JiBXException;

/**
 * created by liyurong
 **/
public class TestOrder {

    private IBindingFactory factory = null;
    private StringWriter writer = null;
    private StringReader reader = null;
    private final static String CHARSET_NAME = "UTF-8";

    private String encode2Xml(Order order) throws JiBXException, IOException {
        //根据Order的Class实例构造IBindingFactory对象
        factory = BindingDirectory.getFactory(Order.class);
        //创建新的StringWriter对象
        writer = new StringWriter();
        //通过IBindingFactory构造Marshalling上下文
        IMarshallingContext mctx = factory.createMarshallingContext();
        mctx.setIndent(2);
        //通过marshalDocument将order序列化为StringWriter
        mctx.marshalDocument(order, CHARSET_NAME, null, writer);
        //返回String类型的XML对象
        String xmlStr = writer.toString();
        writer.close();
        System.out.println(xmlStr.toString());
        return xmlStr;
    }

    private Order decode2Order(String xmlBody) throws JiBXException {
        //使用StringReader读取String类型的XML对象
        reader = new StringReader(xmlBody);
        //创建上下文
        IUnmarshallingContext uctx = factory.createUnmarshallingContext();
        //将String反序列化为Order对象
        Order order = (Order) uctx.unmarshalDocument(reader);
        return order;
    }

    public static void main(String[] args) throws JiBXException, IOException {
        TestOrder test = new TestOrder();
        Order order = OrderFactory.create(123);
        String body = test.encode2Xml(order);
        Order order2 = test.decode2Order(body);
        System.out.println(order2);

    }
}