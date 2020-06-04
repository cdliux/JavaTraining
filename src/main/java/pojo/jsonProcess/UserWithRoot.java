package pojo.jsonProcess;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author ll0a
 * @version V1.0
 * @className: UserWithRoot
 * @date 5/22/2020 3:57 PM
 * @description:
 */
@JsonRootName(value = "user")
public class UserWithRoot {
    private Integer id;
    private String name;

    public UserWithRoot(Integer id,String name) {
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
        name = name;
    }
}
