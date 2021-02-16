package org.xpande.gpc.model;

import org.compiere.model.Query;

import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

/**
 * Product: Adempiere ERP & CRM Smart Business Solution. Localization : Uruguay - Xpande
 * Xpande. Created by Gabriel Vila on 2/15/21.
 */
public class MZGPCCFEConfig extends X_Z_GPC_CFEConfig {

    public MZGPCCFEConfig(Properties ctx, int Z_GPC_CFEConfig_ID, String trxName) {
        super(ctx, Z_GPC_CFEConfig_ID, trxName);
    }

    public MZGPCCFEConfig(Properties ctx, ResultSet rs, String trxName) {
        super(ctx, rs, trxName);
    }

    /***
     * Obtiene modelo único de configuración de Recepción de CFE.
     * Xpande. Created by Gabriel Vila on 2/15/21.
     * @param ctx
     * @param trxName
     * @return
     */
    public static MZGPCCFEConfig getDefault(Properties ctx, String trxName){

        MZGPCCFEConfig model = new Query(ctx, I_Z_GPC_CFEConfig.Table_Name, "", trxName).setOnlyActiveRecords(true).first();

        return model;
    }

    /***
     * Obtiene y retorna lineas
     * @return
     */
    public List<MZGPCCFEConfigBP> getConfigBPartners(){

        String whereClause = X_Z_GPC_CFEConfigBP.COLUMNNAME_Z_GPC_CFEConfig_ID + " =" + this.get_ID();

        List<MZGPCCFEConfigBP> lines = new Query(getCtx(), I_Z_GPC_CFEConfigBP.Table_Name, whereClause, get_TrxName()).list();

        return lines;
    }

}
