/*
 * Copyright (c) 2021.
 *  @author Muhammad Shams - mshamsj@gmail.com
 *  @version 1.0
 */

package jpo;

import com.matrixone.apps.domain.util.MapList;
import matrix.db.Context;
import matrix.db.JPO;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class AdminTypeTable_mxJPO {

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
}
