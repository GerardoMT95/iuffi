package it.csi.iuffi.iuffiweb.presentation.ricercaprocedimento;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.validator.GenericValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.csi.iuffi.iuffiweb.business.INuovoProcedimentoEJB;
import it.csi.iuffi.iuffiweb.business.IQuadroEJB;
import it.csi.iuffi.iuffiweb.business.IRicercaEJB;
import it.csi.iuffi.iuffiweb.dto.AziendaDTO;
import it.csi.iuffi.iuffiweb.dto.GruppoOggettoDTO;
import it.csi.iuffi.iuffiweb.dto.plsql.ControlloDTO;
import it.csi.iuffi.iuffiweb.dto.plsql.MainControlloDTO;
import it.csi.iuffi.iuffiweb.dto.procedimento.Procedimento;
import it.csi.iuffi.iuffiweb.exception.InternalUnexpectedException;
import it.csi.iuffi.iuffiweb.presentation.BaseController;
import it.csi.iuffi.iuffiweb.util.IuffiConstants;
import it.csi.iuffi.iuffiweb.util.IuffiFactory;
import it.csi.iuffi.iuffiweb.util.IuffiUtils;
import it.csi.iuffi.iuffiweb.util.annotation.IsPopup;
import it.csi.iuffi.iuffiweb.util.annotation.IuffiSecurity;
import it.csi.papua.papuaserv.dto.gestioneutenti.ws.UtenteAbilitazioni;

@Controller
@RequestMapping("/cuiuffi135")
@IuffiSecurity(value = "CU-IUFFI-135", controllo = IuffiSecurity.Controllo.PROCEDIMENTO)
public class CUIUFFI135NuovaIstanzaController extends BaseController
{

  @Autowired
  private IRicercaEJB           ricercaEJB           = null;

  @Autowired
  private IQuadroEJB            quadroEJB            = null;

  @Autowired
  private INuovoProcedimentoEJB nuovoProcedimentoEJB = null;

  @RequestMapping(value = "popupindex_{idGruppoOggetto}_{codRaggruppamento}", method = RequestMethod.GET)
  @IsPopup
  public String popupIndex(Model model, HttpServletRequest request,
      @PathVariable("idGruppoOggetto") @NumberFormat(style = NumberFormat.Style.NUMBER) long idGruppoOggetto,
      @PathVariable("codRaggruppamento") @NumberFormat(style = NumberFormat.Style.NUMBER) long codRaggruppamento)
      throws InternalUnexpectedException
  {
    Procedimento procedimento = IuffiFactory.getProcedimento(request);
    List<GruppoOggettoDTO> elenco = ricercaEJB.getElencoOggettiDisponibili(
        procedimento.getIdBando(), true,
        ((idGruppoOggetto > 0) ? idGruppoOggetto : null));

    if (procedimento.getIdStatoOggetto() < 10
        || procedimento.getIdStatoOggetto() > 90)
    {
      model.addAttribute("noConfirm", Boolean.TRUE);
      model.addAttribute("msgErrore",
          "Il procedimento selezionato si trova in uno stato per cui non � possibile creare alcuna Istanza.");

    }
    else
      if (elenco != null && elenco.size() > 0)
      {
        model.addAttribute("elenco", elenco);
      }
      else
      {
        model.addAttribute("noConfirm", Boolean.TRUE);
        model.addAttribute("msgErrore",
            "Non � possibile creare alcuna Istanza sul procedimento selezionato.");
      }

    model.addAttribute("descrizioneTipo", "Istanza");
    return "ricercaprocedimento/popupNuovoOggetto";
  }

  @RequestMapping(value = "popupindex_{idGruppoOggetto}_{codRaggruppamento}", method = RequestMethod.POST)
  @ResponseBody
  public String popupIndexPost(Model model, HttpSession session, HttpServletRequest request,
	  @PathVariable("idGruppoOggetto") @NumberFormat(style = NumberFormat.Style.NUMBER) long idGruppoOggetto,
	  @PathVariable("codRaggruppamento") @NumberFormat(style = NumberFormat.Style.NUMBER) long codRaggruppamento,
	  @RequestParam(value = "note") String note) throws InternalUnexpectedException {
      if (note != null && note.length() > 4000) {
	  return "Le note non possono superare i 4000 caratteri (attualmente il campo note contiene " + note.length()
	  + " caratteri).";
      }
      String idBandoOggettoStr = request.getParameter("oggettoSelezionato");

      if (GenericValidator.isBlankOrNull(idBandoOggettoStr)) {
	  return "Non hai selezionato nessuna istanza!";
      } else {
	  UtenteAbilitazioni utenteAbilitazioni = (UtenteAbilitazioni) session.getAttribute("utenteAbilitazioni");
	  String idLegameGruppoOggettoStr = request.getParameter("idLegameGruppoOggetto_" + idBandoOggettoStr);
	  long idLegameGruppoOggetto = Long.parseLong(idLegameGruppoOggettoStr);
	  long idBandoOggetto = Long.parseLong(idBandoOggettoStr);

	  List<String> elencoCDU = quadroEJB.getMacroCDUList(idLegameGruppoOggetto);
	  boolean abilitato = false;
	  if (elencoCDU != null) {
	      for (String cdu : elencoCDU) {
		  if (IuffiUtils.PAPUASERV.isMacroCUAbilitato(utenteAbilitazioni, cdu)) {
		      abilitato = true;
		      break;
		  }
	      }
	  }

	  if (!abilitato) {
	      return " <div class=\"stdMessagePanel\"> 																			\n"
		      + " 	<div class=\"alert alert-danger\">																		\n"
		      + "  	<p><strong>Attenzione!</strong><br/>																\n"
		      + "   	Non &egrave; possibile creare l'oggetto selezionato in base al tipo di utente connesso!</p>				\n"
		      + " 	</div> 																									\n"
		      + " </div> 																									\n";
	  }

	  Procedimento procedimento = IuffiFactory.getProcedimento(request);
	  if (utenteAbilitazioni.getRuolo().getIsList() != null
		  && Arrays.asList(utenteAbilitazioni.getRuolo().getIsList()).contains("isUtenteProfessionista")) {

	      Map<String, String> parametri = quadroEJB
		      .getParametri(new String[] { IuffiConstants.PARAMETRO.OGGETTI_NO_PROFESS });
	      String codiciOggetti = parametri.get(IuffiConstants.PARAMETRO.OGGETTI_NO_PROFESS);

	      String codiceOggettoCheVoglioCreare = quadroEJB.getCodiceOggettoByIdLegameGO(idLegameGruppoOggetto);
	      if (codiciOggetti != null && codiciOggetti.length() > 0
		      && codiciOggetti.contains(codiceOggettoCheVoglioCreare + "#")) {
		  // controllo esistenza CF sulla PSR_C_ABILITAZ_TECNICO_DOM_PAG per AZIENDA e BANDO
//		  if (!nuovoProcedimentoEJB.isTecnicoAbilitato(procedimento.getIdProcedimento(),
//			  utenteAbilitazioni.getCodiceFiscale())) {
//		      return "  	<p><strong>Attenzione!</strong><br/>																\n"
//			      + "   	Impossibile procedere con la creazione: il ruolo dell'utente corrente non &egrave; abilitato alla creazione dell'oggetto selezionato</p>";
//		  }
	      }

	  }

	  // in questo caso effettuo tutte le chiamate per creare il procedimento
	  AziendaDTO aziendaDTO = quadroEJB.getDatiAziendaAgricolaProcedimento(getIdProcedimento(session), null);

	  aggiornaDatiAAEPSian(aziendaDTO, utenteAbilitazioni);

	  // chiamo callMainControlliGravi
	  MainControlloDTO controlliGravi = nuovoProcedimentoEJB.callMainControlliGravi(idBandoOggetto,
		  procedimento.getIdProcedimento(), aziendaDTO.getIdAzienda(), utenteAbilitazioni.getIdUtenteLogin(),
		  codRaggruppamento);

	  if (controlliGravi.getRisultato() == IuffiConstants.SQL.RESULT_CODE.ERRORE_CRITICO) {
	      return IuffiConstants.SQL.MESSAGE.PLSQL_ERRORE_CRITICO + " "
		      + IuffiUtils.STRING.safeHTMLText(controlliGravi.getMessaggio());
	  } else if (controlliGravi.getRisultato() == IuffiConstants.SQL.RESULT_CODE.ERRORE_GRAVE) {
	      return createHTMLControlli(controlliGravi);
	  }

	  // chiamo il pl che crea il procedimento
	  controlliGravi = nuovoProcedimentoEJB.callMainCreazione(procedimento.getIdBando(), idLegameGruppoOggetto,
		  procedimento.getIdProcedimento(), aziendaDTO.getIdAzienda(), utenteAbilitazioni.getIdUtenteLogin(),
		  IuffiUtils.PAPUASERV.getFirstCodiceAttore(utenteAbilitazioni),
		  (codRaggruppamento > 0) ? codRaggruppamento : null, Boolean.FALSE, note);
	  if (controlliGravi.getRisultato() == IuffiConstants.SQL.RESULT_CODE.NESSUN_ERRORE) {
	      return "redirect:../procedimento/visualizza_procedimento_" + procedimento.getIdProcedimento() + ".do";
	  } else if (controlliGravi.getRisultato() == IuffiConstants.SQL.RESULT_CODE.ERRORE_CRITICO) {
	      return IuffiConstants.SQL.MESSAGE.PLSQL_ERRORE_CRITICO + " "
		      + IuffiUtils.STRING.safeHTMLText(controlliGravi.getMessaggio());
	  } else if (controlliGravi.getRisultato() == IuffiConstants.SQL.RESULT_CODE.ERRORE_GRAVE) {
	      return IuffiConstants.SQL.MESSAGE.PLSQL_ERRORE_GRAVE + " "
		      + IuffiUtils.STRING.safeHTMLText(controlliGravi.getMessaggio());
	  } else {
	      return IuffiConstants.SQL.MESSAGE.PLSQL_ERRORE_CRITICO + " "
		      + IuffiUtils.STRING.safeHTMLText(controlliGravi.getMessaggio());
	  }
      }
  }

  private String createHTMLControlli(MainControlloDTO controlliGravi)
  {
    StringBuilder sb = new StringBuilder(""
        + " <div class=\"stdMessagePanel\"> 																			\n"
        + " 	<div class=\"alert alert-danger\">																		\n"
        + "  	<p><strong>Attenzione!</strong><br/>																\n"
        + "   	Operazione non consentita a causa del rilevamento delle seguenti anomalie:</p>						\n"
        + " 	</div> 																									\n"
        + " </div> 																									\n"
        + " <table summary=\"controlliGravi\" class=\"table table-hover table-striped table-bordered tableBlueTh\"> 	\n"
        + " <thead> 																									\n"
        + "   <tr>  																									\n"
        + " 	<th>Codice</th> 																						\n"
        + " 	<th>Descrizione</th> 																					\n"
        + " 	<th>Messaggio</th> 																						\n"
        + "   </tr> 																									\n"
        + " </thead> 																								\n"
        + " <tbody> 																									\n");

    for (ControlloDTO controllo : controlliGravi.getControlli())
    {
      sb.append(" "
          + " <tr> \n"
          + " 	<td scope=\"col\" >" + controllo.getCodice() + "</td> \n"
          + " 	<td scope=\"col\" >"
          + IuffiUtils.STRING.safeHTMLText(controllo.getDescrizione())
          + "</td> \n"
          + " 	<td scope=\"col\" >"
          + IuffiUtils.STRING.safeHTMLText(controllo.getMessaggioErrore())
          + "</td> \n"
          + " </tr> \n");

    }
    sb.append("</tbody> </table>");
    return sb.toString();
  }

}
