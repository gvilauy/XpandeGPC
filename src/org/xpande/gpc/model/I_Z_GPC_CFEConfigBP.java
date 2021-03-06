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

/** Generated Interface for Z_GPC_CFEConfigBP
 *  @author Adempiere (generated) 
 *  @version Release 3.9.1
 */
public interface I_Z_GPC_CFEConfigBP 
{

    /** TableName=Z_GPC_CFEConfigBP */
    public static final String Table_Name = "Z_GPC_CFEConfigBP";

    /** AD_Table_ID=1000355 */
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

    /** Column name AD_EMailConfig_ID */
    public static final String COLUMNNAME_AD_EMailConfig_ID = "AD_EMailConfig_ID";

	/** Set EMail Configuration	  */
	public void setAD_EMailConfig_ID (int AD_EMailConfig_ID);

	/** Get EMail Configuration	  */
	public int getAD_EMailConfig_ID();

	public I_AD_EMailConfig getAD_EMailConfig() throws RuntimeException;

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

    /** Column name C_BPartner_ID */
    public static final String COLUMNNAME_C_BPartner_ID = "C_BPartner_ID";

	/** Set Business Partner .
	  * Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID);

	/** Get Business Partner .
	  * Identifies a Business Partner
	  */
	public int getC_BPartner_ID();

	public I_C_BPartner getC_BPartner() throws RuntimeException;

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

    /** Column name EMail */
    public static final String COLUMNNAME_EMail = "EMail";

	/** Set EMail Address.
	  * Electronic Mail Address
	  */
	public void setEMail (String EMail);

	/** Get EMail Address.
	  * Electronic Mail Address
	  */
	public String getEMail();

    /** Column name EMailRecipient */
    public static final String COLUMNNAME_EMailRecipient = "EMailRecipient";

	/** Set EMail Recipient.
	  * Recipient of the EMail
	  */
	public void setEMailRecipient (String EMailRecipient);

	/** Get EMail Recipient.
	  * Recipient of the EMail
	  */
	public String getEMailRecipient();

    /** Column name EMailUserPW */
    public static final String COLUMNNAME_EMailUserPW = "EMailUserPW";

	/** Set EMail User Password.
	  * Password of your email user id
	  */
	public void setEMailUserPW (String EMailUserPW);

	/** Get EMail User Password.
	  * Password of your email user id
	  */
	public String getEMailUserPW();

    /** Column name FolderError */
    public static final String COLUMNNAME_FolderError = "FolderError";

	/** Set FolderError.
	  * Carpeta para proceso con Errores
	  */
	public void setFolderError (String FolderError);

	/** Get FolderError.
	  * Carpeta para proceso con Errores
	  */
	public String getFolderError();

    /** Column name FolderOk */
    public static final String COLUMNNAME_FolderOk = "FolderOk";

	/** Set FolderOk.
	  * Carpeta para proceso OK
	  */
	public void setFolderOk (String FolderOk);

	/** Get FolderOk.
	  * Carpeta para proceso OK
	  */
	public String getFolderOk();

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

    /** Column name Z_GPC_CFEConfigBP_ID */
    public static final String COLUMNNAME_Z_GPC_CFEConfigBP_ID = "Z_GPC_CFEConfigBP_ID";

	/** Set Z_GPC_CFEConfigBP ID	  */
	public void setZ_GPC_CFEConfigBP_ID (int Z_GPC_CFEConfigBP_ID);

	/** Get Z_GPC_CFEConfigBP ID	  */
	public int getZ_GPC_CFEConfigBP_ID();

    /** Column name Z_GPC_CFEConfig_ID */
    public static final String COLUMNNAME_Z_GPC_CFEConfig_ID = "Z_GPC_CFEConfig_ID";

	/** Set Z_GPC_CFEConfig ID	  */
	public void setZ_GPC_CFEConfig_ID (int Z_GPC_CFEConfig_ID);

	/** Get Z_GPC_CFEConfig ID	  */
	public int getZ_GPC_CFEConfig_ID();

	public I_Z_GPC_CFEConfig getZ_GPC_CFEConfig() throws RuntimeException;
}
