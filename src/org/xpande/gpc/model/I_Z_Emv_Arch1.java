/******************************************************************************
 * Product: ADempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 2006-2017 ADempiere Foundation, All Rights Reserved.         *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * or (at your option) any later version.										*
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * or via info@adempiere.net or http://www.adempiere.net/license.html         *
 *****************************************************************************/
package org.xpande.gpc.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for Z_Emv_Arch1
 *  @author Adempiere (generated) 
 *  @version Release 3.9.1
 */
public interface I_Z_Emv_Arch1 
{

    /** TableName=Z_Emv_Arch1 */
    public static final String Table_Name = "Z_Emv_Arch1";

    /** AD_Table_ID=1000356 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Ciclo */
    public static final String COLUMNNAME_Ciclo = "Ciclo";

	/** Set Ciclo	  */
	public void setCiclo (String Ciclo);

	/** Get Ciclo	  */
	public String getCiclo();

    /** Column name Clase_Uso */
    public static final String COLUMNNAME_Clase_Uso = "Clase_Uso";

	/** Set Clase_Uso	  */
	public void setClase_Uso (String Clase_Uso);

	/** Get Clase_Uso	  */
	public String getClase_Uso();

    /** Column name Cmt_Ac */
    public static final String COLUMNNAME_Cmt_Ac = "Cmt_Ac";

	/** Set Cmt_Ac	  */
	public void setCmt_Ac (BigDecimal Cmt_Ac);

	/** Get Cmt_Ac	  */
	public BigDecimal getCmt_Ac();

    /** Column name Cmt_Al */
    public static final String COLUMNNAME_Cmt_Al = "Cmt_Al";

	/** Set Cmt_Al	  */
	public void setCmt_Al (BigDecimal Cmt_Al);

	/** Get Cmt_Al	  */
	public BigDecimal getCmt_Al();

    /** Column name Cod_Suscriptor */
    public static final String COLUMNNAME_Cod_Suscriptor = "Cod_Suscriptor";

	/** Set Cod_Suscriptor	  */
	public void setCod_Suscriptor (String Cod_Suscriptor);

	/** Get Cod_Suscriptor	  */
	public String getCod_Suscriptor();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name Ctas_Vencidas */
    public static final String COLUMNNAME_Ctas_Vencidas = "Ctas_Vencidas";

	/** Set Ctas_Vencidas	  */
	public void setCtas_Vencidas (String Ctas_Vencidas);

	/** Get Ctas_Vencidas	  */
	public String getCtas_Vencidas();

    /** Column name Dias_Fact */
    public static final String COLUMNNAME_Dias_Fact = "Dias_Fact";

	/** Set Dias_Fact	  */
	public void setDias_Fact (String Dias_Fact);

	/** Get Dias_Fact	  */
	public String getDias_Fact();

    /** Column name Dir_Envio */
    public static final String COLUMNNAME_Dir_Envio = "Dir_Envio";

	/** Set Dir_Envio	  */
	public void setDir_Envio (String Dir_Envio);

	/** Get Dir_Envio	  */
	public String getDir_Envio();

    /** Column name Dir_Predio */
    public static final String COLUMNNAME_Dir_Predio = "Dir_Predio";

	/** Set Dir_Predio	  */
	public void setDir_Predio (String Dir_Predio);

	/** Get Dir_Predio	  */
	public String getDir_Predio();

    /** Column name ErrorMsg */
    public static final String COLUMNNAME_ErrorMsg = "ErrorMsg";

	/** Set Error Msg	  */
	public void setErrorMsg (String ErrorMsg);

	/** Get Error Msg	  */
	public String getErrorMsg();

    /** Column name Estrato */
    public static final String COLUMNNAME_Estrato = "Estrato";

	/** Set Estrato	  */
	public void setEstrato (String Estrato);

	/** Get Estrato	  */
	public String getEstrato();

    /** Column name Fac_Venta */
    public static final String COLUMNNAME_Fac_Venta = "Fac_Venta";

	/** Set Fac_Venta	  */
	public void setFac_Venta (String Fac_Venta);

	/** Get Fac_Venta	  */
	public String getFac_Venta();

    /** Column name Fecha_Expedicion */
    public static final String COLUMNNAME_Fecha_Expedicion = "Fecha_Expedicion";

	/** Set Fecha_Expedicion	  */
	public void setFecha_Expedicion (String Fecha_Expedicion);

	/** Get Fecha_Expedicion	  */
	public String getFecha_Expedicion();

    /** Column name Fecha_Limite_Pago */
    public static final String COLUMNNAME_Fecha_Limite_Pago = "Fecha_Limite_Pago";

	/** Set Fecha_Limite_Pago	  */
	public void setFecha_Limite_Pago (String Fecha_Limite_Pago);

	/** Get Fecha_Limite_Pago	  */
	public String getFecha_Limite_Pago();

    /** Column name Fecha_Suspension */
    public static final String COLUMNNAME_Fecha_Suspension = "Fecha_Suspension";

	/** Set Fecha_Suspension	  */
	public void setFecha_Suspension (String Fecha_Suspension);

	/** Get Fecha_Suspension	  */
	public String getFecha_Suspension();

    /** Column name Fecha_Ult_Pago */
    public static final String COLUMNNAME_Fecha_Ult_Pago = "Fecha_Ult_Pago";

	/** Set Fecha_Ult_Pago	  */
	public void setFecha_Ult_Pago (String Fecha_Ult_Pago);

	/** Get Fecha_Ult_Pago	  */
	public String getFecha_Ult_Pago();

    /** Column name FileLineText */
    public static final String COLUMNNAME_FileLineText = "FileLineText";

	/** Set FileLineText	  */
	public void setFileLineText (String FileLineText);

	/** Get FileLineText	  */
	public String getFileLineText();

    /** Column name I_IsImported */
    public static final String COLUMNNAME_I_IsImported = "I_IsImported";

	/** Set Imported.
	  * Has this import been processed
	  */
	public void setI_IsImported (boolean I_IsImported);

	/** Get Imported.
	  * Has this import been processed
	  */
	public boolean isI_IsImported();

    /** Column name I_Mora */
    public static final String COLUMNNAME_I_Mora = "I_Mora";

	/** Set I_Mora	  */
	public void setI_Mora (BigDecimal I_Mora);

	/** Get I_Mora	  */
	public BigDecimal getI_Mora();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name IsConfirmed */
    public static final String COLUMNNAME_IsConfirmed = "IsConfirmed";

	/** Set Confirmed.
	  * Assignment is confirmed
	  */
	public void setIsConfirmed (boolean IsConfirmed);

	/** Get Confirmed.
	  * Assignment is confirmed
	  */
	public boolean isConfirmed();

    /** Column name LineNumber */
    public static final String COLUMNNAME_LineNumber = "LineNumber";

	/** Set LineNumber	  */
	public void setLineNumber (int LineNumber);

	/** Get LineNumber	  */
	public int getLineNumber();

    /** Column name Lugar_Ult_Pago */
    public static final String COLUMNNAME_Lugar_Ult_Pago = "Lugar_Ult_Pago";

	/** Set Lugar_Ult_Pago	  */
	public void setLugar_Ult_Pago (String Lugar_Ult_Pago);

	/** Get Lugar_Ult_Pago	  */
	public String getLugar_Ult_Pago();

    /** Column name Mens_Suspension */
    public static final String COLUMNNAME_Mens_Suspension = "Mens_Suspension";

	/** Set Mens_Suspension	  */
	public void setMens_Suspension (String Mens_Suspension);

	/** Get Mens_Suspension	  */
	public String getMens_Suspension();

    /** Column name Mes_Fact */
    public static final String COLUMNNAME_Mes_Fact = "Mes_Fact";

	/** Set Mes_Fact	  */
	public void setMes_Fact (String Mes_Fact);

	/** Get Mes_Fact	  */
	public String getMes_Fact();

    /** Column name Name */
    public static final String COLUMNNAME_Name = "Name";

	/** Set Name.
	  * Alphanumeric identifier of the entity
	  */
	public void setName (String Name);

	/** Get Name.
	  * Alphanumeric identifier of the entity
	  */
	public String getName();

    /** Column name Npagelectr */
    public static final String COLUMNNAME_Npagelectr = "Npagelectr";

	/** Set Npagelectr	  */
	public void setNpagelectr (String Npagelectr);

	/** Get Npagelectr	  */
	public String getNpagelectr();

    /** Column name Pague_Recargo */
    public static final String COLUMNNAME_Pague_Recargo = "Pague_Recargo";

	/** Set Pague_Recargo	  */
	public void setPague_Recargo (String Pague_Recargo);

	/** Get Pague_Recargo	  */
	public String getPague_Recargo();

    /** Column name Periodo_Facturado */
    public static final String COLUMNNAME_Periodo_Facturado = "Periodo_Facturado";

	/** Set Periodo_Facturado	  */
	public void setPeriodo_Facturado (String Periodo_Facturado);

	/** Get Periodo_Facturado	  */
	public String getPeriodo_Facturado();

    /** Column name Processed */
    public static final String COLUMNNAME_Processed = "Processed";

	/** Set Processed.
	  * The document has been processed
	  */
	public void setProcessed (boolean Processed);

	/** Get Processed.
	  * The document has been processed
	  */
	public boolean isProcessed();

    /** Column name Ruta */
    public static final String COLUMNNAME_Ruta = "Ruta";

	/** Set Ruta	  */
	public void setRuta (String Ruta);

	/** Get Ruta	  */
	public String getRuta();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();

    /** Column name UUID */
    public static final String COLUMNNAME_UUID = "UUID";

	/** Set Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public void setUUID (String UUID);

	/** Get Immutable Universally Unique Identifier.
	  * Immutable Universally Unique Identifier
	  */
	public String getUUID();

    /** Column name Valor_Pagar */
    public static final String COLUMNNAME_Valor_Pagar = "Valor_Pagar";

	/** Set Valor_Pagar	  */
	public void setValor_Pagar (BigDecimal Valor_Pagar);

	/** Get Valor_Pagar	  */
	public BigDecimal getValor_Pagar();

    /** Column name Valor_Ult_Pago */
    public static final String COLUMNNAME_Valor_Ult_Pago = "Valor_Ult_Pago";

	/** Set Valor_Ult_Pago	  */
	public void setValor_Ult_Pago (BigDecimal Valor_Ult_Pago);

	/** Get Valor_Ult_Pago	  */
	public BigDecimal getValor_Ult_Pago();

    /** Column name Z_Emv_Arch1_ID */
    public static final String COLUMNNAME_Z_Emv_Arch1_ID = "Z_Emv_Arch1_ID";

	/** Set Z_Emv_Arch1 ID	  */
	public void setZ_Emv_Arch1_ID (int Z_Emv_Arch1_ID);

	/** Get Z_Emv_Arch1 ID	  */
	public int getZ_Emv_Arch1_ID();

    /** Column name Z_LoadEmvPdf_ID */
    public static final String COLUMNNAME_Z_LoadEmvPdf_ID = "Z_LoadEmvPdf_ID";

	/** Set Z_LoadEmvPdf ID	  */
	public void setZ_LoadEmvPdf_ID (int Z_LoadEmvPdf_ID);

	/** Get Z_LoadEmvPdf ID	  */
	public int getZ_LoadEmvPdf_ID();

	public I_Z_LoadEmvPdf getZ_LoadEmvPdf() throws RuntimeException;
}
