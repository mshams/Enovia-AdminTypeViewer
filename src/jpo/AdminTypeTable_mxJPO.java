/*
 * Copyright (c) 2021.
 *  @author Muhammad Shams - mshamsj@gmail.com
 *  @version 1.0
 */

package jpo;

import com.matrixone.apps.domain.util.FrameworkException;
import com.matrixone.apps.domain.util.MapList;
import com.matrixone.apps.domain.util.MqlUtil;
import com.matrixone.apps.framework.ui.UIUtil;
import matrix.db.Context;
import matrix.db.JPO;
import matrix.util.StringList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class AdminTypeTable_mxJPO {
    private static String LINK_SHOW_TYPE = "emxPLMOnlineAdminTypeReport.jsp?typeName=%s";
    private static String LINK_SHOW_REL = "emxPLMOnlineAdminRelationshipReport.jsp?relationshipName=%s";
    private static String LINK_SHOW_CMD = "emxPLMOnlineAdminCommandReport.jsp?CommandName=%s";
    private static String LINK_SHOW_POLICY = "emxPLMOnlineAdminPolicyReport.jsp?policyName=%s";

    @com.matrixone.apps.framework.ui.ProgramCallable
    public Vector getParamByColumnName(Context context, String[] args) throws Exception {
        Vector vResult = new Vector();
        HashMap programMap = JPO.unpackArgs(args);
        HashMap mapColumn = (HashMap) programMap.get("columnMap");
        String paramName = (String) mapColumn.get("name");
        MapList mapListObjects = (MapList) programMap.get("objectList");

        for (Object mapListObject : mapListObjects) {
            Map mapItem = (Map) mapListObject;
            String result;

            try {
                result = mapItem.get(paramName).toString();
            } catch (Exception e) {
                result = "-";
            }

            vResult.add(result);
        }
        return vResult;
    }

    @com.matrixone.apps.framework.ui.ProgramCallable
    public Vector getHyperlinkColumn(Context context, String[] args) throws FrameworkException {
        Vector vResult = new Vector();

        try {
            HashMap programMap = JPO.unpackArgs(args);
            Map paramListMap = (Map) programMap.get("paramList");
            MapList mapListObjects = (MapList) programMap.get("objectList");

            String hrefBaseURL = "";
            String progName = (String) paramListMap.get("program");
            switch (progName.trim()) {
                case "jpo.AdminTypesHelper:getTypesList":
                    hrefBaseURL = LINK_SHOW_TYPE;
                    break;
                case "jpo.AdminTypesHelper:getCommandsList":
                    hrefBaseURL = LINK_SHOW_CMD;
                    break;
                case "jpo.AdminTypesHelper:getPoliciesList":
                    hrefBaseURL = LINK_SHOW_POLICY;
                    break;
                case "jpo.AdminTypesHelper:getRelsList":
                    hrefBaseURL = LINK_SHOW_REL;
                    break;
            }

            for (Object mapListObject : mapListObjects) {
                Map mapItem = (Map) mapListObject;
                String typeName;
                String hrefStr;

                try {
                    typeName = mapItem.get("name").toString();
                    hrefStr = String.format(hrefBaseURL, typeName);
                    typeName = String.format(
                            "<a href='%s' target='_blank'>Open AdminType</a>",
                            hrefStr
                    );
                } catch (Exception e) {
                    typeName = "-";
                }

                vResult.add(typeName);
            }
        } catch (Exception e) {

        }
        return vResult;
    }
}
