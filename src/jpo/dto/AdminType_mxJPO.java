/*
 * Copyright (c) 2021.
 *  @author Muhammad Shams - mshamsj@gmail.com
 *  @version 1.0
 */

package jpo.dto;

public class AdminType_mxJPO {
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

}

enum AdminTypeName {
    Type, Policy, Relationship, Command
}
