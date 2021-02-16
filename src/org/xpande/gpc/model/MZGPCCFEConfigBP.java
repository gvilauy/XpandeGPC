package org.xpande.gpc.model;

import java.sql.ResultSet;
import java.util.Properties;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 2/15/21.
 */
public class MZGPCCFEConfigBP extends X_Z_GPC_CFEConfigBP {

    public MZGPCCFEConfigBP(Properties ctx, int Z_GPC_CFEConfigBP_ID, String trxName) {
        super(ctx, Z_GPC_CFEConfigBP_ID, trxName);
    }

    public MZGPCCFEConfigBP(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }
}
