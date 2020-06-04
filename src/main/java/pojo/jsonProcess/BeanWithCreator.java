package pojo.jsonProcess;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author ll0a
 * @version V1.0
 * @className: BeanWithCreator
 * @date 5/22/2020 4:35 PM
 * @description:
 */
public class BeanWithCreator {
    private Integer id;
    private String name;

    @JsonCreator()
    public BeanWithCreator(@JsonProperty("id") Integer id, @JsonProperty("firstName") String name) {
        this.id = id;
        this.name = name;
    }

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
