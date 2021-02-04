/*
 * Copyright (c) 2021.
 *  @author Muhammad Shams - mshamsj@gmail.com
 *  @version 1.0
 */

package tests;

import jpo.dto.AdminType_mxJPO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

class AdminType_mxJPOTest {
    private static final String STR_TYPE = "Ext_ConfigObject|Config Object|11/17/2021 6:09:41 PM|11/18/2021 10:59:54 AM";
    private static final String STR_CMD = "ECHDecisionApplicableItemsPowerView|PowerView to show Applicable Items and Applies To tabs|2/4/2021 9:04:13 PM|2/4/2021 9:04:13 PM";
    private static final String STR_REL = "ECR Reference|ECR Reference|2/4/2021 3:33:53 PM|2/4/2021 3:39:43 PM";
    private static final String STR_POLICY = "EC Part|governs a Part released using engineering change|2/4/2021 3:32:53 PM|2/15/2021 8:46:39 AM";
    private static jpo.dto.AdminType_mxJPO objType;
    private static jpo.dto.AdminType_mxJPO objRel;
    private static jpo.dto.AdminType_mxJPO objPolicy;
    private static jpo.dto.AdminType_mxJPO objCmd;

    @Test
    void createFromStringType() {
        try {
            objType = jpo.dto.AdminType_mxJPO.createFromString(
                    STR_TYPE,
                    jpo.dto.AdminType_mxJPO.AdminTypeName.Type);
        } catch (Exception e) {
            fail(e.toString());
        }

        assertNotNull(objType);
    }

    @Test
    void createFromStringCmd() {
        try {
            objCmd = AdminType_mxJPO.createFromString(
                    STR_CMD,
                    jpo.dto.AdminType_mxJPO.AdminTypeName.Command);

        } catch (Exception e) {
            fail(e.toString());
        }
        assertNotNull(objCmd);
    }

    @Test
    void createFromStringRel() {
        try {
            objRel = AdminType_mxJPO.createFromString(
                    STR_REL,
                    jpo.dto.AdminType_mxJPO.AdminTypeName.Relationship);

        } catch (Exception e) {
            fail(e.toString());
        }
        assertNotNull(objRel);
    }

    @Test
    void createFromStringPolicy() {
        try {
            objPolicy = AdminType_mxJPO.createFromString(
                    STR_POLICY,
                    jpo.dto.AdminType_mxJPO.AdminTypeName.Policy);

        } catch (Exception e) {
            fail(e.toString());
        }
        assertNotNull(objPolicy);
    }

}