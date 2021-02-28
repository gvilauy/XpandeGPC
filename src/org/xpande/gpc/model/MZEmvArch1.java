package org.xpande.gpc.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 2/28/21.
 */
public class MZEmvArch1 extends X_Z_Emv_Arch1{

    public MZEmvArch1(Properties ctx, int Z_Emv_Arch1_ID, String trxName) {
        super(ctx, Z_Emv_Arch1_ID, trxName);
    }

    public MZEmvArch1(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
