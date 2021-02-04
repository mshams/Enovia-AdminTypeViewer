/*
 * Copyright (c) 2021.
 *  @author Muhammad Shams - mshamsj@gmail.com
 *  @version 1.0
 */

package jpo.dto;

import java.util.Arrays;

public class AdminType_mxJPO {
    private static final String ATT_SEPARATOR = "\\|";
    private String name;
    private String description;
    private String originated;
    private String modified;
    private AdminTypeName type;

    public AdminType_mxJPO(String name, String description, String originated, String modified, AdminTypeName type) {
        this.name = name;
        this.description = description;
        this.originated = originated;
        this.modified = modified;
        this.type = type;
    }

    public AdminType_mxJPO() {
    }

    public static AdminType_mxJPO createFromString(String buffer, AdminTypeName typeName) throws Exception {
        AdminType_mxJPO obj = null;

        String[] values = buffer.split(ATT_SEPARATOR);
        if (values.length == 4) {
            obj = new AdminType_mxJPO(
                    values[0],
                    values[1],
                    values[2],
                    values[3],
                    typeName
            );
        } else throw (new Exception(String.format(
                "Buffer is not in a correct format. Len = %d {%s}",
                values.length, Arrays.toString(values)
        )));

        return obj;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", originated='" + originated + '\'' +
                ", modified='" + modified + '\'' +
                ", type=" + type.name();
    }

    public enum AdminTypeName {
        Type, Policy, Relationship, Command
    }
}


