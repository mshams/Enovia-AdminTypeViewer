/*
 * Copyright (c) 2021.
 *  @author Muhammad Shams - mshamsj@gmail.com
 *  @version 1.0
 */

package jpo;

import com.matrixone.apps.domain.util.MapList;
import matrix.db.Context;

public class AdminTypesHelper_mxJPO {
    @com.matrixone.apps.framework.ui.ProgramCallable
    public MapList getTypesList(Context context, String[] args) throws Exception {
        MapList result = new MapList();

        try {

            return result;
        } catch (Exception e) {
            throw new Exception("getTypesList", e);
        }
    }

    @com.matrixone.apps.framework.ui.ProgramCallable
    public MapList getPoliciesList(Context context, String[] args) throws Exception {
        MapList result = new MapList();

        try {

            return result;
        } catch (Exception e) {
            throw new Exception("getPoliciesList", e);
        }
    }

    @com.matrixone.apps.framework.ui.ProgramCallable
    public MapList getRelsList(Context context, String[] args) throws Exception {
        MapList result = new MapList();

        try {

            return result;
        } catch (Exception e) {
            throw new Exception("getRelsList", e);
        }
    }

    @com.matrixone.apps.framework.ui.ProgramCallable
    public MapList getCommandsList(Context context, String[] args) throws Exception {
        MapList result = new MapList();

        try {

            return result;
        } catch (Exception e) {
            throw new Exception("getCommandsList", e);
        }
    }
}
