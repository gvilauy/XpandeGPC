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
/** Generated Model - DO NOT CHANGE */
package org.xpande.gpc.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;

/** Generated Model for Z_GPC_CFEConfigBP
 *  @author Adempiere (generated) 
 *  @version Release 3.9.1 - $Id$ */
public class X_Z_GPC_CFEConfigBP extends PO implements I_Z_GPC_CFEConfigBP, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210215L;

    /** Standard Constructor */
    public X_Z_GPC_CFEConfigBP (Properties ctx, int Z_GPC_CFEConfigBP_ID, String trxName)
    {
      super (ctx, Z_GPC_CFEConfigBP_ID, trxName);
      /** if (Z_GPC_CFEConfigBP_ID == 0)
        {
			setAD_EMailConfig_ID (0);
			setC_BPartner_ID (0);
			setEMail (null);
			setEMailUserPW (null);
			setFolderError (null);
			setFolderOk (null);
			setZ_GPC_CFEConfigBP_ID (0);
			setZ_GPC_CFEConfig_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_GPC_CFEConfigBP (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_Z_GPC_CFEConfigBP[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	public I_AD_EMailConfig getAD_EMailConfig() throws RuntimeException
    {
		return (I_AD_EMailConfig)MTable.get(getCtx(), I_AD_EMailConfig.Table_Name)
			.getPO(getAD_EMailConfig_ID(), get_TrxName());	}

	/** Set EMail Configuration.
		@param AD_EMailConfig_ID EMail Configuration	  */
	public void setAD_EMailConfig_ID (int AD_EMailConfig_ID)
	{
		if (AD_EMailConfig_ID < 1) 
			set_Value (COLUMNNAME_AD_EMailConfig_ID, null);
		else 
			set_Value (COLUMNNAME_AD_EMailConfig_ID, Integer.valueOf(AD_EMailConfig_ID));
	}

	/** Get EMail Configuration.
		@return EMail Configuration	  */
	public int getAD_EMailConfig_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_AD_EMailConfig_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_C_BPartner getC_BPartner() throws RuntimeException
    {
		return (I_C_BPartner)MTable.get(getCtx(), I_C_BPartner.Table_Name)
			.getPO(getC_BPartner_ID(), get_TrxName());	}

	/** Set Business Partner .
		@param C_BPartner_ID 
		Identifies a Business Partner
	  */
	public void setC_BPartner_ID (int C_BPartner_ID)
	{
		if (C_BPartner_ID < 1) 
			set_Value (COLUMNNAME_C_BPartner_ID, null);
		else 
			set_Value (COLUMNNAME_C_BPartner_ID, Integer.valueOf(C_BPartner_ID));
	}

	/** Get Business Partner .
		@return Identifies a Business Partner
	  */
	public int getC_BPartner_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_C_BPartner_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set EMail Address.
		@param EMail 
		Electronic Mail Address
	  */
	public void setEMail (String EMail)
	{
		set_Value (COLUMNNAME_EMail, EMail);
	}

	/** Get EMail Address.
		@return Electronic Mail Address
	  */
	public String getEMail () 
	{
		return (String)get_Value(COLUMNNAME_EMail);
	}

	/** EMailRecipient AD_Reference_ID=363 */
	public static final int EMAILRECIPIENT_AD_Reference_ID=363;
	/** Document Owner = D */
	public static final String EMAILRECIPIENT_DocumentOwner = "D";
	/** Document Business Partner = B */
	public static final String EMAILRECIPIENT_DocumentBusinessPartner = "B";
	/** WF Responsible = R */
	public static final String EMAILRECIPIENT_WFResponsible = "R";
	/** Set EMail Recipient.
		@param EMailRecipient 
		Recipient of the EMail
	  */
	public void setEMailRecipient (String EMailRecipient)
	{

		set_Value (COLUMNNAME_EMailRecipient, EMailRecipient);
	}

	/** Get EMail Recipient.
		@return Recipient of the EMail
	  */
	public String getEMailRecipient () 
	{
		return (String)get_Value(COLUMNNAME_EMailRecipient);
	}

	/** Set EMail User Password.
		@param EMailUserPW 
		Password of your email user id
	  */
	public void setEMailUserPW (String EMailUserPW)
	{
		set_Value (COLUMNNAME_EMailUserPW, EMailUserPW);
	}

	/** Get EMail User Password.
		@return Password of your email user id
	  */
	public String getEMailUserPW () 
	{
		return (String)get_Value(COLUMNNAME_EMailUserPW);
	}

	/** Set FolderError.
		@param FolderError 
		Carpeta para proceso con Errores
	  */
	public void setFolderError (String FolderError)
	{
		set_Value (COLUMNNAME_FolderError, FolderError);
	}

	/** Get FolderError.
		@return Carpeta para proceso con Errores
	  */
	public String getFolderError () 
	{
		return (String)get_Value(COLUMNNAME_FolderError);
	}

	/** Set FolderOk.
		@param FolderOk 
		Carpeta para proceso OK
	  */
	public void setFolderOk (String FolderOk)
	{
		set_Value (COLUMNNAME_FolderOk, FolderOk);
	}

	/** Get FolderOk.
		@return Carpeta para proceso OK
	  */
	public String getFolderOk () 
	{
		return (String)get_Value(COLUMNNAME_FolderOk);
	}

	/** Set Immutable Universally Unique Identifier.
		@param UUID 
		Immutable Universally Unique Identifier
	  */
	public void setUUID (String UUID)
	{
		set_Value (COLUMNNAME_UUID, UUID);
	}

	/** Get Immutable Universally Unique Identifier.
		@return Immutable Universally Unique Identifier
	  */
	public String getUUID () 
	{
		return (String)get_Value(COLUMNNAME_UUID);
	}

	/** Set Z_GPC_CFEConfigBP ID.
		@param Z_GPC_CFEConfigBP_ID Z_GPC_CFEConfigBP ID	  */
	public void setZ_GPC_CFEConfigBP_ID (int Z_GPC_CFEConfigBP_ID)
	{
		if (Z_GPC_CFEConfigBP_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_GPC_CFEConfigBP_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_GPC_CFEConfigBP_ID, Integer.valueOf(Z_GPC_CFEConfigBP_ID));
	}

	/** Get Z_GPC_CFEConfigBP ID.
		@return Z_GPC_CFEConfigBP ID	  */
	public int getZ_GPC_CFEConfigBP_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_GPC_CFEConfigBP_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_Z_GPC_CFEConfig getZ_GPC_CFEConfig() throws RuntimeException
    {
		return (I_Z_GPC_CFEConfig)MTable.get(getCtx(), I_Z_GPC_CFEConfig.Table_Name)
			.getPO(getZ_GPC_CFEConfig_ID(), get_TrxName());	}

	/** Set Z_GPC_CFEConfig ID.
		@param Z_GPC_CFEConfig_ID Z_GPC_CFEConfig ID	  */
	public void setZ_GPC_CFEConfig_ID (int Z_GPC_CFEConfig_ID)
	{
		if (Z_GPC_CFEConfig_ID < 1) 
			set_Value (COLUMNNAME_Z_GPC_CFEConfig_ID, null);
		else 
			set_Value (COLUMNNAME_Z_GPC_CFEConfig_ID, Integer.valueOf(Z_GPC_CFEConfig_ID));
	}

	/** Get Z_GPC_CFEConfig ID.
		@return Z_GPC_CFEConfig ID	  */
	public int getZ_GPC_CFEConfig_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_GPC_CFEConfig_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}