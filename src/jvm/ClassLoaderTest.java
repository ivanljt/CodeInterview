package jvm;


import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ClassLoaderTest {
    public int i = 0;

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader customClassLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                System.out.println("loading class " + name);
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream inputStream = getClass().getResourceAsStream(fileName);
                    if (inputStream == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[inputStream.available()];
                    inputStream.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };
        //自定义类加载器加载
        Object o = customClassLoader.loadClass("jvm.ClassLoaderTest").newInstance();
//        ClassLoaderTest classLoaderTest1 = (ClassLoaderTest) customClassLoader.loadClass("jvm.ClassLoaderTest").newInstance();
        //使用系统应用程序类加载器加载
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        System.out.println(classLoaderTest.equals(o));//类的实例是否一致
        System.out.println(o.getClass());
        System.out.println(o instanceof jvm.ClassLoaderTest);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassLoaderTest that = (ClassLoaderTest) o;
        return i == that.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
