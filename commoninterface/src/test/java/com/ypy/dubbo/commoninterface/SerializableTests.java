package com.ypy.dubbo.commoninterface;

import com.ypy.dubbo.commoninterface.bean.UserAddress;

import java.io.*;

/**
 * 序列化和反序列化Demo
 *
 * Serializable主要作用将类的实例持久化保存，序列化就是保存，反序列化就是读取。
 * 保存也不一定保存在本地，也可以保存到远方。类一定要实现Serializable才可以。
 */
public class SerializableTests {

    public static void main(String[] args) throws IOException,ClassNotFoundException {

        // 将类作为文本，写入硬盘（序列化）
        UserAddress userAddress = new UserAddress(1,"北京市1","1","李老师","123456789","Y");
        // 序列化的时候，会将serialVersionUID值写入到文件中，如果实体没有定义，jvm会按照自己的规则，自动定义一个写入
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("c:/obj.txt"));
        objectOutputStream.writeObject(userAddress);
        objectOutputStream.close();

        // 将文本内容读取并赋值给内存中的对象（反序列化）
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("c:/obj.txt"));
        // 反序列化的时候，会校验序列化文件的serialVersionUID值和对象中定义的serialVersionUID值是否匹配，如果相同则通过，如果不同，会抛出InvalidClassException异常！
        /**
         * serialVersionUID不一致测试验证：
         * 第一步：序列化
         * 第二步：更改UserAddress中的serialVersionUID
         * 第三步：反序列化
         */
        UserAddress userAddress1 = (UserAddress)objectInputStream.readObject();
        System.out.println(userAddress1);
        objectInputStream.close();
    }

}
