package pojo.jsonProcess;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * @author ll0a
 * @version V1.0
 * @className: MyBean
 * @date 5/22/2020 5:24 PM
 * @description:
 */
public class MyBean {
    public int id;
    private String name;

    @JsonSetter("sellerName")
    public void setName(String name) {
        this.name = name;
    }

    public MyBean(){

    }

    public MyBean(int id,String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
