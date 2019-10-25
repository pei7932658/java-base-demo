package com.sy.spring4_2.utils;

import java.io.*;
import java.util.List;

/**
 * @Author:peiliang
 * @Description:
 * @Date:2019/9/24 11:58
 * @Modified By:
 */
public class CommonUtils {
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

    public static Object deeplyCopy(Serializable obj) {
        try {
            return bytes2object(object2bytes(obj));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] object2bytes(Serializable obj) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            baos.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object bytes2object(byte[] bytes) {
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
