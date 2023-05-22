package it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.4.6-redhat-1
 * 2016-02-02T10:41:23.537+01:00 Generated source version: 2.4.6-redhat-1
 * 
 */
@WebService(targetNamespace = "http://papuaserv.webservice.business.papuaserv.papua.csi.it/", name = "IMessaggisticaWS")
@XmlSeeAlso(
{ ObjectFactory.class })
public interface IMessaggisticaWS
{

  @WebResult(name = "listaMessaggi", targetNamespace = "")
  @RequestWrapper(localName = "getListaMessaggi", targetNamespace = "http://papuaserv.webservice.business.papuaserv.papua.csi.it/", className = "it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.GetListaMessaggi")
  @WebMethod
  @ResponseWrapper(localName = "getListaMessaggiResponse", targetNamespace = "http://papuaserv.webservice.business.papuaserv.papua.csi.it/", className = "it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.GetListaMessaggiResponse")
  public it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.ListaMessaggi getListaMessaggi(
      @WebParam(name = "idProcedimento", targetNamespace = "") int idProcedimento,
      @WebParam(name = "codiceRuolo", targetNamespace = "") java.lang.String codiceRuolo,
      @WebParam(name = "codiceFiscale", targetNamespace = "") java.lang.String codiceFiscale,
      @WebParam(name = "tipoMessaggio", targetNamespace = "") int tipoMessaggio,
      @WebParam(name = "letto", targetNamespace = "") java.lang.Boolean letto,
      @WebParam(name = "obbligatorio", targetNamespace = "") java.lang.Boolean obbligatorio,
      @WebParam(name = "visibile", targetNamespace = "") java.lang.Boolean visibile)
      throws LogoutException_Exception, InternalException_Exception;

  @WebResult(name = "dettagliMessaggio", targetNamespace = "")
  @RequestWrapper(localName = "getDettagliMessaggio", targetNamespace = "http://papuaserv.webservice.business.papuaserv.papua.csi.it/", className = "it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.GetDettagliMessaggio")
  @WebMethod
  @ResponseWrapper(localName = "getDettagliMessaggioResponse", targetNamespace = "http://papuaserv.webservice.business.papuaserv.papua.csi.it/", className = "it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.GetDettagliMessaggioResponse")
  public it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.DettagliMessaggio getDettagliMessaggio(
      @WebParam(name = "idElencoMessaggi", targetNamespace = "") long idElencoMessaggi,
      @WebParam(name = "codiceFiscale", targetNamespace = "") java.lang.String codiceFiscale)
      throws InternalException_Exception;

  @RequestWrapper(localName = "verificaLogout", targetNamespace = "http://papuaserv.webservice.business.papuaserv.papua.csi.it/", className = "it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.VerificaLogout")
  @WebMethod
  @ResponseWrapper(localName = "verificaLogoutResponse", targetNamespace = "http://papuaserv.webservice.business.papuaserv.papua.csi.it/", className = "it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.VerificaLogoutResponse")
  public void verificaLogout(
      @WebParam(name = "arg0", targetNamespace = "") int arg0,
      @WebParam(name = "arg1", targetNamespace = "") java.lang.String arg1)
      throws LogoutException_Exception, InternalException_Exception;

  @RequestWrapper(localName = "confermaLetturaMessaggio", targetNamespace = "http://papuaserv.webservice.business.papuaserv.papua.csi.it/", className = "it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.ConfermaLetturaMessaggio")
  @WebMethod
  @ResponseWrapper(localName = "confermaLetturaMessaggioResponse", targetNamespace = "http://papuaserv.webservice.business.papuaserv.papua.csi.it/", className = "it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.ConfermaLetturaMessaggioResponse")
  public void confermaLetturaMessaggio(
      @WebParam(name = "idElencoMessaggi", targetNamespace = "") long idElencoMessaggi,
      @WebParam(name = "codiceFiscale", targetNamespace = "") java.lang.String codiceFiscale)
      throws InternalException_Exception;

  @WebResult(name = "allegato", targetNamespace = "")
  @RequestWrapper(localName = "getAllegato", targetNamespace = "http://papuaserv.webservice.business.papuaserv.papua.csi.it/", className = "it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.GetAllegato")
  @WebMethod
  @ResponseWrapper(localName = "getAllegatoResponse", targetNamespace = "http://papuaserv.webservice.business.papuaserv.papua.csi.it/", className = "it.csi.iuffi.iuffiweb.integration.ws.papuaserv.messaggistica.GetAllegatoResponse")
  public byte[] getAllegato(
      @WebParam(name = "idAllegato", targetNamespace = "") long idAllegato)
      throws InternalException_Exception;
}