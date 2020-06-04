package JavaBasic;

import pojo.Seller;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author ll0a
 * @version V1.0
 * @className: Singleton
 * @date 5/29/2020 3:42 PM
 * @description:
 */
public class Singleton  {
    private volatile static  Singleton uniqueInstance;

    public Singleton(){

    }



    private Singleton getUniqueInstance() {
        if (uniqueInstance == null) {
            synchronized (Singleton.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }


}
