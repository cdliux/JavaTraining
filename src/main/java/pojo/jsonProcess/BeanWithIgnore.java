package pojo.jsonProcess;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author ll0a
 * @version V1.0
 * @className: BeanWithIgnore
 * @date 5/22/2020 6:06 PM
 * @description:
 */
@JsonIgnoreProperties("id")
public class BeanWithIgnore {
    @JsonIgnore
    public Integer id;
    public String name;

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
