/*
 * Copyright (c) 2021.
 *  @author Muhammad Shams - mshamsj@gmail.com
 *  @version 1.0
 */

package jpo;

import matrix.db.Context;
import matrix.db.MQLCommand;
import matrix.util.MatrixException;

public class MQLUtil_mxJPO {
    public static String runMQl(Context ctx, String command) throws MatrixException {
        MQLCommand mqlCommand = new MQLCommand();
        mqlCommand.open(ctx);
        mqlCommand.executeCommand(ctx, command);
        String resultStr = mqlCommand.getResult();
        mqlCommand.close(ctx);

        return resultStr;
    }
}
