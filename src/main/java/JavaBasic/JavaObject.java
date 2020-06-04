package JavaBasic;

import com.sun.media.jfxmedia.events.NewFrameEvent;
import javafx.scene.input.PickResult;
import pojo.Address;
import pojo.Seller;
import pojo.jsonProcess.MyBean;

import java.security.PrivilegedExceptionAction;

/**
 * @author ll0a
 * @version V1.0
 * @className: JavaObject
 * @date 5/12/2020 2:36 PM
 * @description:
 */
public class JavaObject implements Cloneable{
    public void process() throws CloneNotSupportedException {
        System.out.print("------------------------------");
        System.out.println("\nJava Object 类剖析\n");
        getClassMethod();
        hashCodeMethod();
        toStringMethod();
        cloneMethod();

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return  super.clone();
    }

    private void registerNativesMethod(){
        System.out.print("------------------------------");
        System.out.println("\nregisterNatives() 方法");

    }

    private void getClassMethod() {
        System.out.print("------------------------------");
        System.out.println("\ngetClass() 方法");
        MyBean bean = new MyBean();
        System.out.println(bean.getClass());
        System.out.println(MyBean.class);
    }


    private void cloneMethod() throws CloneNotSupportedException {
        System.out.print("------------------------------");
        System.out.println("\nclone() 方法");
        JavaObject o1 = new JavaObject();
        JavaObject o2 = (JavaObject) o1.clone();
        System.out.println(o1 == o2);
        System.out.println("\no1 ->"+o1.hashCode());
        System.out.println("\no2 ->"+o2.hashCode());

    }

    private void hashCodeMethod(){
        System.out.print("------------------------------");
        System.out.println("\nhashCode() 方法");
        System.out.println("\nlewis ->"+"lewis".hashCode());
        System.out.println("\nlewis2 ->"+"lewis".hashCode());
    }

    private void equalsMethod(){
        System.out.print("------------------------------");
        System.out.println("\nequals() 方法");

    }


    private void toStringMethod() {
        System.out.print("------------------------------");
        System.out.println("\ntoString() 方法");
        MyBean bean = new MyBean();
        System.out.println("\ntbean.toString() -> " + bean.toString());
    }


    // private void registerNativesMethod(){
    //     System.out.print("------------------------------");
    //     System.out.println("\nregisterNatives() 方法");
    //
    // }

    public void method() {
        synchronized (this) {
            System.out.println("synchronized 代码块");
        }

    }

    private void useClone(){
        Seller sourceSeller =  new Seller("A001","Lewis","test");
        // Seller targetSeller = sourceSeller
    }







}
