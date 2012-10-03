package webview.servlet.init;

import java.io.File;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.Profile;
import persistence.dto.TemaPalavraChave;
import persistence.dto.TipoDocumento;
import persistence.dto.UserAccount;
import persistence.util.PersistenceUtility;
import webview.util.WebUtility;
import business.EJB.util.EJBUtility;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet("/InitServlet")
public class InitServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static Log log = LogFactory.getLog(InitServlet.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		initLogger(config);

		log.info("Iniciando sistema Grão-Para...");
		PersistenceAccess pa = new PersistenceAccess();
		String[] profiles_names = {"default", "user", "admin"};

		List<DTO> profile;
		for (String p : profiles_names) {
			profile = pa.findEntity("from ProfileMO where profile = '" + p + "'");
			if(profile == null) {
				log.info("Profile '" + p + "' não encontrado, recriando..." );
				if(p.equals("default")) {
					pa.saveEntity(WebUtility.default_profile);
				}
				else if(p.equals("user")) {
					pa.saveEntity(WebUtility.user_profile);
				}
				else if(p.equals("admin")) {
					pa.saveEntity(WebUtility.admin_profile);
				}
			}
			else if(profile.size() > 1) {
				log.error("Profile '" + p + "' repetido no banco de dados, verificar imediatamente.");
			}
		}

		//TODO: MUDAR SENHA
		List<DTO> user = pa.findEntity("from UserMO where email = 'admin@graopara.com'");
		if(user == null)
		{
			log.info("Criando usuário de admin...");
			pa.saveEntity(
					new UserAccount(
							"Admin", 
							(Profile) (pa.findEntity("from ProfileMO where profile = 'admin'").get(0)),
							"admin@graopara.com",
							EJBUtility.getHash("null","MD5")
					)
			);
		}
		else user = null;

		user = pa.findEntity("from User where email = 'user@graopara.com'");
		if(user == null)
		{
			log.info("Criando usuário de teste...");
			pa.saveEntity(
					new UserAccount(
							"Usuário Padrão", 
							(Profile) (pa.findEntity("from ProfileMO where profile = 'user'").get(0)),
							"user@graopara.com",
							EJBUtility.getHash("null","MD5")
					)
			);
			
		}
		else user = null;

		user = pa.findEntity("from User where email = 'default@graopara.com'");
		if(user == null)
		{
			log.info("Criando usuário sem privilégios de teste...");
			pa.saveEntity(
					new UserAccount(
							"Anonimo", 
							(Profile) (pa.findEntity("from ProfileMO where profile = 'default'").get(0)),
							"default@graopara.com",
							EJBUtility.getHash("null","MD5")
					)
			);
		}
		user = null;

//		List<DTO> origem = pa.findEntity("from CodiceCaixaMO where tipoOrigem = 'CODICE'");
//		if(origem == null) {
//			log.info("Criando um origem de documento...");
//			pa.saveEntity(new OrigemDTO("1", "CODICE", "CODICE"));
//		}
//		origem = pa.findEntities("from Origem where tipoOrigem = 'CAIXA'");
//		if(origem == null) {
//			log.info("Criando um origem de documento...");
//			pa.saveEntity(new OrigemDTO("2", "CAIXA", "CAIXA"));
//		}

		List<DTO> typeDocument = pa.findEntity("from TipoDocumentoMO where nome = 'Ofícios'");
		if(typeDocument == null)
		{
			log.info("Criando um tipo de documento...");
			pa.saveEntity(new TipoDocumento("Ofícios", "Tipos de documentos de ofícios"));
		}

		typeDocument = pa.findEntity("from TipoDocumentoMO where nome = 'Cartas'");
		if(typeDocument == null)
		{
			log.info("Criando um tipo de documento...");
			pa.saveEntity(new TipoDocumento("Cartas", "Tipos de documentos de cartas"));
		}

		typeDocument = pa.findEntity("from TipoDocumentoMO where nome = 'Relatórios'");
		if(typeDocument == null)
		{
			log.info("Criando um tipo de documento...");
			pa.saveEntity(new TipoDocumento("Relatórios", "Tipos de documentos de relatórios"));
		}
		typeDocument = null;
		
		List<DTO> theme = pa.findEntity("from TemaPalavraChaveMO where tema = 'Autores'");
		if(theme == null)
		{
			log.info("Criando um tema para palavra-chaves...");
			pa.saveEntity(new TemaPalavraChave("Autores"));
		}
		
		theme = pa.findEntity("from TemaPalavraChaveMO where tema = 'Instituição'");
		if(theme == null)
		{
			log.info("Criando um tema para palavra-chaves...");
			pa.saveEntity(new TemaPalavraChave("Instituição"));
		}
		
		theme = pa.findEntity("from TemaPalavraChaveMO where tema = 'Ação'");
		if(theme == null)
		{
			log.info("Criando um tema para palavra-chaves...");
			pa.saveEntity(new TemaPalavraChave("Ação"));
		}

		log.info("Finalizando inicialização...");
	}

	private void initLogger(ServletConfig config) {
		String logprop_config = config
				.getInitParameter("log4j.properties-location");
		ServletContext sc = config.getServletContext();

		if (logprop_config != null) {
			String webAppPath = sc.getRealPath("/");
			String real_logprop = webAppPath + logprop_config;
			File file_logprop = new File(real_logprop);
			if (file_logprop.exists()) {
				PropertyConfigurator.configureAndWatch(real_logprop);
				return;
			}
		}

		System.err
				.println("Erro iniciando o sistema de log do arquivo de configuração");
		System.err.println("Iniciando configuração de fallback básica...");
		BasicConfigurator.configure();
	}

	@Override
	public void destroy() {
		log.info("Encerrando o sistema...");
		log.info("Encerrando a SessionFactory do Hibernate...");
		PersistenceUtility.closeSessionFactory();
		log.info("Encerrando o logging...");
		log = null;
		//System.gc();
		LogFactory.releaseAll();
	}

}