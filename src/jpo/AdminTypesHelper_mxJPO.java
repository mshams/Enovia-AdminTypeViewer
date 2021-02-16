/*
 * Copyright (c) 2021.
 *  @author Muhammad Shams - mshamsj@gmail.com
 *  @version 1.0
 */

package jpo;

import com.matrixone.apps.domain.util.MapList;
import com.matrixone.apps.domain.util.MqlUtil;
import jpo.dto.AdminTypeName;
import jpo.dto.AdminType_mxJPO;
import matrix.db.Context;

public class AdminTypesHelper_mxJPO {
    private static final String MQL_LIST_TYPE = "list type * select name description originated modified dump |;";
    private static final String MQL_LIST_CMD = "list command * select name description originated modified dump |;";
    private static final String MQL_LIST_REL = "list relationship * select name description originated modified dump |;";
    private static final String MQL_LIST_POLICY = "list policy * select name description originated modified dump |;";

    @com.matrixone.apps.framework.ui.ProgramCallable
    public MapList getTypesList(Context context, String[] args) throws Exception {
        MapList result;

        try {
            String buffer = MqlUtil.mqlCommand(context, MQL_LIST_TYPE);
            result = createMapList(buffer, jpo.dto.AdminTypeName.Type);

            return result;
        } catch (Exception e) {
            throw new Exception("getTypesList", e);
        }
    }

    @com.matrixone.apps.framework.ui.ProgramCallable
    public MapList getPoliciesList(Context context, String[] args) throws Exception {
        MapList result = new MapList();

        try {
            String buffer = MqlUtil.mqlCommand(context, MQL_LIST_POLICY);
            result = createMapList(buffer, jpo.dto.AdminTypeName.Policy);

            return result;
        } catch (Exception e) {
            throw new Exception("getPoliciesList", e);
        }
    }

    @com.matrixone.apps.framework.ui.ProgramCallable
    public MapList getRelsList(Context context, String[] args) throws Exception {
        MapList result = new MapList();

        try {
            String buffer = MqlUtil.mqlCommand(context, MQL_LIST_REL);
            result = createMapList(buffer, jpo.dto.AdminTypeName.Relationship);

            return result;
        } catch (Exception e) {
            throw new Exception("getRelsList", e);
        }
    }

    @com.matrixone.apps.framework.ui.ProgramCallable
    public MapList getCommandsList(Context context, String[] args) throws Exception {
        MapList result = new MapList();

        try {
            String buffer = MqlUtil.mqlCommand(context, MQL_LIST_CMD);
            result = createMapList(buffer, jpo.dto.AdminTypeName.Command);

            return result;
        } catch (Exception e) {
            throw new Exception("getCommandsList", e);
        }
    }

    private MapList createMapList(String buffer, jpo.dto.AdminTypeName typeName) throws Exception {
        MapList result = null;
        String[] lines = buffer.split("\n");

        if (lines.length > 0) {
            result = new MapList();

            for (String line : lines) {
                jpo.dto.AdminType_mxJPO obj = jpo.dto.AdminType_mxJPO.createFromString(line, typeName);
                result.add(obj.toMap());
            }
        }

        return result;
    }
}
