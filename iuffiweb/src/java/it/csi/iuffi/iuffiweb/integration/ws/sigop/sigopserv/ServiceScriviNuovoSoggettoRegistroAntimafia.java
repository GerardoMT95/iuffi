
package it.csi.iuffi.iuffiweb.integration.ws.sigop.sigopserv;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * <p>
 * Classe Java per serviceScriviNuovoSoggettoRegistroAntimafia complex type.
 * 
 * <p>
 * Il seguente frammento di schema specifica il contenuto previsto contenuto in
 * questa classe.
 * 
 * <pre>
 * &lt;complexType name="serviceScriviNuovoSoggettoRegistroAntimafia"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="idAzienda" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="cuaa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="ragioneSociale" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="idAmmCompetenza" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="idIntermediario" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="siglaPrefettura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numeroProtocollo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dataProtocollo" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="dataDocumento" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="note" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="extIdProcedimento" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="utenteUltimoAggiornamento" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceScriviNuovoSoggettoRegistroAntimafia", propOrder =
{
    "idAzienda",
    "cuaa",
    "ragioneSociale",
    "idAmmCompetenza",
    "idIntermediario",
    "siglaPrefettura",
    "numeroProtocollo",
    "dataProtocollo",
    "dataDocumento",
    "note",
    "extIdProcedimento",
    "utenteUltimoAggiornamento"
})
public class ServiceScriviNuovoSoggettoRegistroAntimafia
{

  protected long                 idAzienda;
  protected String               cuaa;
  protected String               ragioneSociale;
  protected Long                 idAmmCompetenza;
  protected Long                 idIntermediario;
  protected String               siglaPrefettura;
  protected Long                 numeroProtocollo;
  @XmlSchemaType(name = "dateTime")
  protected XMLGregorianCalendar dataProtocollo;
  @XmlSchemaType(name = "dateTime")
  protected XMLGregorianCalendar dataDocumento;
  protected String               note;
  protected long                 extIdProcedimento;
  protected long                 utenteUltimoAggiornamento;

  /**
   * Recupera il valore della proprietÓ idAzienda.
   * 
   */
  public long getIdAzienda()
  {
    return idAzienda;
  }

  /**
   * Imposta il valore della proprietÓ idAzienda.
   * 
   */
  public void setIdAzienda(long value)
  {
    this.idAzienda = value;
  }

  /**
   * Recupera il valore della proprietÓ cuaa.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getCuaa()
  {
    return cuaa;
  }

  /**
   * Imposta il valore della proprietÓ cuaa.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setCuaa(String value)
  {
    this.cuaa = value;
  }

  /**
   * Recupera il valore della proprietÓ ragioneSociale.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getRagioneSociale()
  {
    return ragioneSociale;
  }

  /**
   * Imposta il valore della proprietÓ ragioneSociale.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setRagioneSociale(String value)
  {
    this.ragioneSociale = value;
  }

  /**
   * Recupera il valore della proprietÓ idAmmCompetenza.
   * 
   * @return possible object is {@link Long }
   * 
   */
  public Long getIdAmmCompetenza()
  {
    return idAmmCompetenza;
  }

  /**
   * Imposta il valore della proprietÓ idAmmCompetenza.
   * 
   * @param value
   *          allowed object is {@link Long }
   * 
   */
  public void setIdAmmCompetenza(Long value)
  {
    this.idAmmCompetenza = value;
  }

  /**
   * Recupera il valore della proprietÓ idIntermediario.
   * 
   * @return possible object is {@link Long }
   * 
   */
  public Long getIdIntermediario()
  {
    return idIntermediario;
  }

  /**
   * Imposta il valore della proprietÓ idIntermediario.
   * 
   * @param value
   *          allowed object is {@link Long }
   * 
   */
  public void setIdIntermediario(Long value)
  {
    this.idIntermediario = value;
  }

  /**
   * Recupera il valore della proprietÓ siglaPrefettura.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getSiglaPrefettura()
  {
    return siglaPrefettura;
  }

  /**
   * Imposta il valore della proprietÓ siglaPrefettura.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setSiglaPrefettura(String value)
  {
    this.siglaPrefettura = value;
  }

  /**
   * Recupera il valore della proprietÓ numeroProtocollo.
   * 
   * @return possible object is {@link Long }
   * 
   */
  public Long getNumeroProtocollo()
  {
    return numeroProtocollo;
  }

  /**
   * Imposta il valore della proprietÓ numeroProtocollo.
   * 
   * @param value
   *          allowed object is {@link Long }
   * 
   */
  public void setNumeroProtocollo(Long value)
  {
    this.numeroProtocollo = value;
  }

  /**
   * Recupera il valore della proprietÓ dataProtocollo.
   * 
   * @return possible object is {@link XMLGregorianCalendar }
   * 
   */
  public XMLGregorianCalendar getDataProtocollo()
  {
    return dataProtocollo;
  }

  /**
   * Imposta il valore della proprietÓ dataProtocollo.
   * 
   * @param value
   *          allowed object is {@link XMLGregorianCalendar }
   * 
   */
  public void setDataProtocollo(XMLGregorianCalendar value)
  {
    this.dataProtocollo = value;
  }

  /**
   * Recupera il valore della proprietÓ dataDocumento.
   * 
   * @return possible object is {@link XMLGregorianCalendar }
   * 
   */
  public XMLGregorianCalendar getDataDocumento()
  {
    return dataDocumento;
  }

  /**
   * Imposta il valore della proprietÓ dataDocumento.
   * 
   * @param value
   *          allowed object is {@link XMLGregorianCalendar }
   * 
   */
  public void setDataDocumento(XMLGregorianCalendar value)
  {
    this.dataDocumento = value;
  }

  /**
   * Recupera il valore della proprietÓ note.
   * 
   * @return possible object is {@link String }
   * 
   */
  public String getNote()
  {
    return note;
  }

  /**
   * Imposta il valore della proprietÓ note.
   * 
   * @param value
   *          allowed object is {@link String }
   * 
   */
  public void setNote(String value)
  {
    this.note = value;
  }

  /**
   * Recupera il valore della proprietÓ extIdProcedimento.
   * 
   */
  public long getExtIdProcedimento()
  {
    return extIdProcedimento;
  }

  /**
   * Imposta il valore della proprietÓ extIdProcedimento.
   * 
   */
  public void setExtIdProcedimento(long value)
  {
    this.extIdProcedimento = value;
  }

  /**
   * Recupera il valore della proprietÓ utenteUltimoAggiornamento.
   * 
   */
  public long getUtenteUltimoAggiornamento()
  {
    return utenteUltimoAggiornamento;
  }

  /**
   * Imposta il valore della proprietÓ utenteUltimoAggiornamento.
   * 
   */
  public void setUtenteUltimoAggiornamento(long value)
  {
    this.utenteUltimoAggiornamento = value;
  }

}
