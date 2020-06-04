package pojo.jsonProcess;

import com.fasterxml.jackson.annotation.JsonAlias;

/**
 * @author ll0a
 * @version V1.0
 * @className: AliasBean
 * @date 5/22/2020 5:42 PM
 * @description:
 */
public class AliasBean {
    @JsonAlias({"fName", "f_name"})
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
