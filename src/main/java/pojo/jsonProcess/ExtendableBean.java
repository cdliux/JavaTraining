package pojo.jsonProcess;

import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ll0a
 * @version V1.0
 * @className: ExtendableBean
 * @date 5/22/2020 2:18 PM
 * @description:
 */
@JsonPropertyOrder({"name","properties","id"})
public class ExtendableBean {
    private Integer id;
    private String name;
    private Map<String, String> properties;

    @JsonAnyGetter(enabled = true)
    public Map<String, String> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonGetter("sellerName")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonAnySetter
    public void add(String key, String value) {
        properties.put(key, value);
    }

    public ExtendableBean(String name){
        this.name = name;
        Map<String,String> properties = new HashMap<>();
        this.properties = properties;
    }

    public ExtendableBean(){
        Map<String,String> properties = new HashMap<>();
        this.properties = properties;
    }
}
