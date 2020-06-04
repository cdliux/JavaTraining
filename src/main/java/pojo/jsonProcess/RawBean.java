package pojo.jsonProcess;

import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * @author ll0a
 * @version V1.0
 * @className: RowBean
 * @date 5/22/2020 3:26 PM
 * @description:
 */
public class RawBean {
    private String name;

    @JsonRawValue
    private String json;

    public RawBean(String name,String json) {
        this.name = name;
        this.json = json;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }
}
