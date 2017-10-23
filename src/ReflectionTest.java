import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * Provides static methods for initializing any object's field with default value
 * and invocation of ClassA method
 */
public class ReflectionTest {
    private static Logger logger = Logger.getLogger(ReflectionTest.class);

    public static void main(String[] args) {
        ClassA object = new ClassA();
        initializeFields(object);
        showFields(object);
        System.out.println(invokeMethod(object, "text", 17));
    }

    /**
     * Initializes object's field with default value depending on field type
     *
     * @param o any object
     */
    public static void initializeFields(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                switch (field.getType().getName()) {
                    case ("int"):
                        field.setAccessible(true);
                        field.set(o, 10);
                        field.setAccessible(false);
                        break;
                    case ("java.lang.String"):
                        field.setAccessible(true);
                        field.set(o, "Default");
                        field.setAccessible(false);
                        break;
                    case ("double"):
                        field.setAccessible(true);
                        field.set(o, 123.123);
                        field.setAccessible(false);
                        break;
                    case ("float"):
                        field.setAccessible(true);
                        field.set(o, 123.123F);
                        field.setAccessible(false);
                        break;
                    case ("boolean"):
                        field.setAccessible(true);
                        field.set(o, false);
                        field.setAccessible(false);
                        break;
                    case ("char"):
                        field.setAccessible(true);
                        field.set(o, 'A');
                        field.setAccessible(false);
                        break;
                    case ("short"):
                        field.setAccessible(true);
                        field.set(o, 0);
                        field.setAccessible(false);
                        break;
                    case ("long"):
                        field.setAccessible(true);
                        field.set(o, 1000);
                        field.setAccessible(false);
                        break;
                    default:
                        field.setAccessible(true);
                        field.set(o, null);
                        field.setAccessible(false);
                }
                logger.info("Private field was changed");
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Outputs all object's fields on console
     *
     * @param o
     */
    public static void showFields(Object o) {
        Field[] fields = o.getClass().getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                System.out.println(field.get(o));
                field.setAccessible(false);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * Invokes method of ClassA object using reflection
     *
     * @param object
     */
    public static String invokeMethod(ClassA object,  String line, int number) {
        Method method;
        String string = null;
        try {
            method = object.getClass().getDeclaredMethod("run", String.class, Integer.class);
            method.setAccessible(true);
            string = (String) method.invoke(object, line, number);
            logger.error("Method " + method.getName() + " was invoked");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return string;
    }
}
