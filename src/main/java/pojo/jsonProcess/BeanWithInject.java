package pojo.jsonProcess;

import com.fasterxml.jackson.annotation.JacksonInject;

/**
 * @author ll0a
 * @version V1.0
 * @className: BeanWithInject
 * @date 5/22/2020 4:59 PM
 * @description:
 */
public class BeanWithInject {
    @JacksonInject
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
