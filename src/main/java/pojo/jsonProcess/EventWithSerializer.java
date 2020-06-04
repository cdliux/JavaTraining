package pojo.jsonProcess;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import configBean.CustomDateDeserializer;
import configBean.CustomDateSerializer;

import java.net.HttpCookie;
import java.util.Date;

/**
 * @author ll0a
 * @version V1.0
 * @className: EventWithSerializer
 * @date 5/22/2020 4:19 PM
 * @description:
 */
public class EventWithSerializer {
    private String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date eventDate;

    @JsonCreator
    public EventWithSerializer(@JsonProperty("name") String name,@JsonProperty("eventDate") Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
