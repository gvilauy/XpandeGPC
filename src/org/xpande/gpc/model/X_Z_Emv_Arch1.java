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

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.Env;

/** Generated Model for Z_Emv_Arch1
 *  @author Adempiere (generated) 
 *  @version Release 3.9.1 - $Id$ */
public class X_Z_Emv_Arch1 extends PO implements I_Z_Emv_Arch1, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20210228L;

    /** Standard Constructor */
    public X_Z_Emv_Arch1 (Properties ctx, int Z_Emv_Arch1_ID, String trxName)
    {
      super (ctx, Z_Emv_Arch1_ID, trxName);
      /** if (Z_Emv_Arch1_ID == 0)
        {
			setI_IsImported (false);
// N
			setIsConfirmed (false);
// N
			setProcessed (false);
// N
			setZ_Emv_Arch1_ID (0);
        } */
    }

    /** Load Constructor */
    public X_Z_Emv_Arch1 (Properties ctx, ResultSet rs, String trxName)
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
      StringBuffer sb = new StringBuffer ("X_Z_Emv_Arch1[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Ciclo.
		@param Ciclo Ciclo	  */
	public void setCiclo (String Ciclo)
	{
		set_Value (COLUMNNAME_Ciclo, Ciclo);
	}

	/** Get Ciclo.
		@return Ciclo	  */
	public String getCiclo () 
	{
		return (String)get_Value(COLUMNNAME_Ciclo);
	}

	/** Set Clase_Uso.
		@param Clase_Uso Clase_Uso	  */
	public void setClase_Uso (String Clase_Uso)
	{
		set_Value (COLUMNNAME_Clase_Uso, Clase_Uso);
	}

	/** Get Clase_Uso.
		@return Clase_Uso	  */
	public String getClase_Uso () 
	{
		return (String)get_Value(COLUMNNAME_Clase_Uso);
	}

	/** Set Cmt_Ac.
		@param Cmt_Ac Cmt_Ac	  */
	public void setCmt_Ac (BigDecimal Cmt_Ac)
	{
		set_Value (COLUMNNAME_Cmt_Ac, Cmt_Ac);
	}

	/** Get Cmt_Ac.
		@return Cmt_Ac	  */
	public BigDecimal getCmt_Ac () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Cmt_Ac);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Cmt_Al.
		@param Cmt_Al Cmt_Al	  */
	public void setCmt_Al (BigDecimal Cmt_Al)
	{
		set_Value (COLUMNNAME_Cmt_Al, Cmt_Al);
	}

	/** Get Cmt_Al.
		@return Cmt_Al	  */
	public BigDecimal getCmt_Al () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Cmt_Al);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Cod_Suscriptor.
		@param Cod_Suscriptor Cod_Suscriptor	  */
	public void setCod_Suscriptor (String Cod_Suscriptor)
	{
		set_Value (COLUMNNAME_Cod_Suscriptor, Cod_Suscriptor);
	}

	/** Get Cod_Suscriptor.
		@return Cod_Suscriptor	  */
	public String getCod_Suscriptor () 
	{
		return (String)get_Value(COLUMNNAME_Cod_Suscriptor);
	}

	/** Set Ctas_Vencidas.
		@param Ctas_Vencidas Ctas_Vencidas	  */
	public void setCtas_Vencidas (String Ctas_Vencidas)
	{
		set_Value (COLUMNNAME_Ctas_Vencidas, Ctas_Vencidas);
	}

	/** Get Ctas_Vencidas.
		@return Ctas_Vencidas	  */
	public String getCtas_Vencidas () 
	{
		return (String)get_Value(COLUMNNAME_Ctas_Vencidas);
	}

	/** Set Dias_Fact.
		@param Dias_Fact Dias_Fact	  */
	public void setDias_Fact (String Dias_Fact)
	{
		set_Value (COLUMNNAME_Dias_Fact, Dias_Fact);
	}

	/** Get Dias_Fact.
		@return Dias_Fact	  */
	public String getDias_Fact () 
	{
		return (String)get_Value(COLUMNNAME_Dias_Fact);
	}

	/** Set Dir_Envio.
		@param Dir_Envio Dir_Envio	  */
	public void setDir_Envio (String Dir_Envio)
	{
		set_Value (COLUMNNAME_Dir_Envio, Dir_Envio);
	}

	/** Get Dir_Envio.
		@return Dir_Envio	  */
	public String getDir_Envio () 
	{
		return (String)get_Value(COLUMNNAME_Dir_Envio);
	}

	/** Set Dir_Predio.
		@param Dir_Predio Dir_Predio	  */
	public void setDir_Predio (String Dir_Predio)
	{
		set_Value (COLUMNNAME_Dir_Predio, Dir_Predio);
	}

	/** Get Dir_Predio.
		@return Dir_Predio	  */
	public String getDir_Predio () 
	{
		return (String)get_Value(COLUMNNAME_Dir_Predio);
	}

	/** Set Error Msg.
		@param ErrorMsg Error Msg	  */
	public void setErrorMsg (String ErrorMsg)
	{
		set_Value (COLUMNNAME_ErrorMsg, ErrorMsg);
	}

	/** Get Error Msg.
		@return Error Msg	  */
	public String getErrorMsg () 
	{
		return (String)get_Value(COLUMNNAME_ErrorMsg);
	}

	/** Set Estrato.
		@param Estrato Estrato	  */
	public void setEstrato (String Estrato)
	{
		set_Value (COLUMNNAME_Estrato, Estrato);
	}

	/** Get Estrato.
		@return Estrato	  */
	public String getEstrato () 
	{
		return (String)get_Value(COLUMNNAME_Estrato);
	}

	/** Set Fac_Venta.
		@param Fac_Venta Fac_Venta	  */
	public void setFac_Venta (String Fac_Venta)
	{
		set_Value (COLUMNNAME_Fac_Venta, Fac_Venta);
	}

	/** Get Fac_Venta.
		@return Fac_Venta	  */
	public String getFac_Venta () 
	{
		return (String)get_Value(COLUMNNAME_Fac_Venta);
	}

	/** Set Fecha_Expedicion.
		@param Fecha_Expedicion Fecha_Expedicion	  */
	public void setFecha_Expedicion (String Fecha_Expedicion)
	{
		set_Value (COLUMNNAME_Fecha_Expedicion, Fecha_Expedicion);
	}

	/** Get Fecha_Expedicion.
		@return Fecha_Expedicion	  */
	public String getFecha_Expedicion () 
	{
		return (String)get_Value(COLUMNNAME_Fecha_Expedicion);
	}

	/** Set Fecha_Limite_Pago.
		@param Fecha_Limite_Pago Fecha_Limite_Pago	  */
	public void setFecha_Limite_Pago (String Fecha_Limite_Pago)
	{
		set_Value (COLUMNNAME_Fecha_Limite_Pago, Fecha_Limite_Pago);
	}

	/** Get Fecha_Limite_Pago.
		@return Fecha_Limite_Pago	  */
	public String getFecha_Limite_Pago () 
	{
		return (String)get_Value(COLUMNNAME_Fecha_Limite_Pago);
	}

	/** Set Fecha_Suspension.
		@param Fecha_Suspension Fecha_Suspension	  */
	public void setFecha_Suspension (String Fecha_Suspension)
	{
		set_Value (COLUMNNAME_Fecha_Suspension, Fecha_Suspension);
	}

	/** Get Fecha_Suspension.
		@return Fecha_Suspension	  */
	public String getFecha_Suspension () 
	{
		return (String)get_Value(COLUMNNAME_Fecha_Suspension);
	}

	/** Set Fecha_Ult_Pago.
		@param Fecha_Ult_Pago Fecha_Ult_Pago	  */
	public void setFecha_Ult_Pago (String Fecha_Ult_Pago)
	{
		set_Value (COLUMNNAME_Fecha_Ult_Pago, Fecha_Ult_Pago);
	}

	/** Get Fecha_Ult_Pago.
		@return Fecha_Ult_Pago	  */
	public String getFecha_Ult_Pago () 
	{
		return (String)get_Value(COLUMNNAME_Fecha_Ult_Pago);
	}

	/** Set FileLineText.
		@param FileLineText FileLineText	  */
	public void setFileLineText (String FileLineText)
	{
		set_Value (COLUMNNAME_FileLineText, FileLineText);
	}

	/** Get FileLineText.
		@return FileLineText	  */
	public String getFileLineText () 
	{
		return (String)get_Value(COLUMNNAME_FileLineText);
	}

	/** Set Imported.
		@param I_IsImported 
		Has this import been processed
	  */
	public void setI_IsImported (boolean I_IsImported)
	{
		set_Value (COLUMNNAME_I_IsImported, Boolean.valueOf(I_IsImported));
	}

	/** Get Imported.
		@return Has this import been processed
	  */
	public boolean isI_IsImported () 
	{
		Object oo = get_Value(COLUMNNAME_I_IsImported);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set I_Mora.
		@param I_Mora I_Mora	  */
	public void setI_Mora (BigDecimal I_Mora)
	{
		set_Value (COLUMNNAME_I_Mora, I_Mora);
	}

	/** Get I_Mora.
		@return I_Mora	  */
	public BigDecimal getI_Mora () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_I_Mora);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Confirmed.
		@param IsConfirmed 
		Assignment is confirmed
	  */
	public void setIsConfirmed (boolean IsConfirmed)
	{
		set_Value (COLUMNNAME_IsConfirmed, Boolean.valueOf(IsConfirmed));
	}

	/** Get Confirmed.
		@return Assignment is confirmed
	  */
	public boolean isConfirmed () 
	{
		Object oo = get_Value(COLUMNNAME_IsConfirmed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set LineNumber.
		@param LineNumber LineNumber	  */
	public void setLineNumber (int LineNumber)
	{
		set_Value (COLUMNNAME_LineNumber, Integer.valueOf(LineNumber));
	}

	/** Get LineNumber.
		@return LineNumber	  */
	public int getLineNumber () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LineNumber);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set Lugar_Ult_Pago.
		@param Lugar_Ult_Pago Lugar_Ult_Pago	  */
	public void setLugar_Ult_Pago (String Lugar_Ult_Pago)
	{
		set_Value (COLUMNNAME_Lugar_Ult_Pago, Lugar_Ult_Pago);
	}

	/** Get Lugar_Ult_Pago.
		@return Lugar_Ult_Pago	  */
	public String getLugar_Ult_Pago () 
	{
		return (String)get_Value(COLUMNNAME_Lugar_Ult_Pago);
	}

	/** Set Mens_Suspension.
		@param Mens_Suspension Mens_Suspension	  */
	public void setMens_Suspension (String Mens_Suspension)
	{
		set_Value (COLUMNNAME_Mens_Suspension, Mens_Suspension);
	}

	/** Get Mens_Suspension.
		@return Mens_Suspension	  */
	public String getMens_Suspension () 
	{
		return (String)get_Value(COLUMNNAME_Mens_Suspension);
	}

	/** Set Mes_Fact.
		@param Mes_Fact Mes_Fact	  */
	public void setMes_Fact (String Mes_Fact)
	{
		set_Value (COLUMNNAME_Mes_Fact, Mes_Fact);
	}

	/** Get Mes_Fact.
		@return Mes_Fact	  */
	public String getMes_Fact () 
	{
		return (String)get_Value(COLUMNNAME_Mes_Fact);
	}

	/** Set Name.
		@param Name 
		Alphanumeric identifier of the entity
	  */
	public void setName (String Name)
	{
		set_Value (COLUMNNAME_Name, Name);
	}

	/** Get Name.
		@return Alphanumeric identifier of the entity
	  */
	public String getName () 
	{
		return (String)get_Value(COLUMNNAME_Name);
	}

	/** Set Npagelectr.
		@param Npagelectr Npagelectr	  */
	public void setNpagelectr (String Npagelectr)
	{
		set_Value (COLUMNNAME_Npagelectr, Npagelectr);
	}

	/** Get Npagelectr.
		@return Npagelectr	  */
	public String getNpagelectr () 
	{
		return (String)get_Value(COLUMNNAME_Npagelectr);
	}

	/** Set Pague_Recargo.
		@param Pague_Recargo Pague_Recargo	  */
	public void setPague_Recargo (String Pague_Recargo)
	{
		set_Value (COLUMNNAME_Pague_Recargo, Pague_Recargo);
	}

	/** Get Pague_Recargo.
		@return Pague_Recargo	  */
	public String getPague_Recargo () 
	{
		return (String)get_Value(COLUMNNAME_Pague_Recargo);
	}

	/** Set Periodo_Facturado.
		@param Periodo_Facturado Periodo_Facturado	  */
	public void setPeriodo_Facturado (String Periodo_Facturado)
	{
		set_Value (COLUMNNAME_Periodo_Facturado, Periodo_Facturado);
	}

	/** Get Periodo_Facturado.
		@return Periodo_Facturado	  */
	public String getPeriodo_Facturado () 
	{
		return (String)get_Value(COLUMNNAME_Periodo_Facturado);
	}

	/** Set Processed.
		@param Processed 
		The document has been processed
	  */
	public void setProcessed (boolean Processed)
	{
		set_Value (COLUMNNAME_Processed, Boolean.valueOf(Processed));
	}

	/** Get Processed.
		@return The document has been processed
	  */
	public boolean isProcessed () 
	{
		Object oo = get_Value(COLUMNNAME_Processed);
		if (oo != null) 
		{
			 if (oo instanceof Boolean) 
				 return ((Boolean)oo).booleanValue(); 
			return "Y".equals(oo);
		}
		return false;
	}

	/** Set Ruta.
		@param Ruta Ruta	  */
	public void setRuta (String Ruta)
	{
		set_Value (COLUMNNAME_Ruta, Ruta);
	}

	/** Get Ruta.
		@return Ruta	  */
	public String getRuta () 
	{
		return (String)get_Value(COLUMNNAME_Ruta);
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

	/** Set Valor_Pagar.
		@param Valor_Pagar Valor_Pagar	  */
	public void setValor_Pagar (BigDecimal Valor_Pagar)
	{
		set_Value (COLUMNNAME_Valor_Pagar, Valor_Pagar);
	}

	/** Get Valor_Pagar.
		@return Valor_Pagar	  */
	public BigDecimal getValor_Pagar () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Valor_Pagar);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Valor_Ult_Pago.
		@param Valor_Ult_Pago Valor_Ult_Pago	  */
	public void setValor_Ult_Pago (BigDecimal Valor_Ult_Pago)
	{
		set_Value (COLUMNNAME_Valor_Ult_Pago, Valor_Ult_Pago);
	}

	/** Get Valor_Ult_Pago.
		@return Valor_Ult_Pago	  */
	public BigDecimal getValor_Ult_Pago () 
	{
		BigDecimal bd = (BigDecimal)get_Value(COLUMNNAME_Valor_Ult_Pago);
		if (bd == null)
			 return Env.ZERO;
		return bd;
	}

	/** Set Z_Emv_Arch1 ID.
		@param Z_Emv_Arch1_ID Z_Emv_Arch1 ID	  */
	public void setZ_Emv_Arch1_ID (int Z_Emv_Arch1_ID)
	{
		if (Z_Emv_Arch1_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_Z_Emv_Arch1_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_Z_Emv_Arch1_ID, Integer.valueOf(Z_Emv_Arch1_ID));
	}

	/** Get Z_Emv_Arch1 ID.
		@return Z_Emv_Arch1 ID	  */
	public int getZ_Emv_Arch1_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_Emv_Arch1_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	public I_Z_LoadEmvPdf getZ_LoadEmvPdf() throws RuntimeException
    {
		return (I_Z_LoadEmvPdf)MTable.get(getCtx(), I_Z_LoadEmvPdf.Table_Name)
			.getPO(getZ_LoadEmvPdf_ID(), get_TrxName());	}

	/** Set Z_LoadEmvPdf ID.
		@param Z_LoadEmvPdf_ID Z_LoadEmvPdf ID	  */
	public void setZ_LoadEmvPdf_ID (int Z_LoadEmvPdf_ID)
	{
		if (Z_LoadEmvPdf_ID < 1) 
			set_Value (COLUMNNAME_Z_LoadEmvPdf_ID, null);
		else 
			set_Value (COLUMNNAME_Z_LoadEmvPdf_ID, Integer.valueOf(Z_LoadEmvPdf_ID));
	}

	/** Get Z_LoadEmvPdf ID.
		@return Z_LoadEmvPdf ID	  */
	public int getZ_LoadEmvPdf_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_Z_LoadEmvPdf_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}
}