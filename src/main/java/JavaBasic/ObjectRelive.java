package JavaBasic;

/**
 * @author ll0a
 * @version V1.0
 * @className: ObjectRelive
 * @date 6/3/2020 10:36 AM
 * @description:
 */
public class ObjectRelive {
    public static ObjectRelive obj;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method excuted.");
        obj = this;
    }

    @Override
    public String toString() {
        return "I am CanReliveObj.";
    }

    public static void invokeObjectRealive() throws InterruptedException {
        obj = new ObjectRelive();
        obj = null;

        System.gc();
        Thread.sleep(500);

        if (obj == null) {
            System.out.println("obj is null.");
        } else {
            System.out.println("obj is not null.");
        }

        obj = null;
        System.out.println("第二次 GC.");
        System.gc();
        Thread.sleep(500);

        if (obj == null) {
            System.out.println("obj is null.");
        } else {
            System.out.println("obj is not null.");
        }
    }
}
