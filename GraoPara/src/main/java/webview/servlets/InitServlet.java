package webview.servlets;

import java.io.File;
import java.util.Date;
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

import business.EJB.util.EJBUtility;

import persistence.PersistenceAccess;
import persistence.dto.DTO;
import persistence.dto.OrigemDTO;
import persistence.dto.ProfileDTO;
import persistence.dto.TipoDocumentoDTO;
import persistence.dto.UserDTO;
import persistence.utility.PersistenceUtility;
import webview.WebUtility;

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
			profile = pa.findEntities("from Profile where profile = '" + p + "'");
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
		List<DTO> user = pa.findEntities("from User where email = 'admin@graopara.com'");
		if(user == null)
		{
			log.info("Criando usuário de admin...");
			pa.saveEntity(new UserDTO("Admin", EJBUtility.getHash("null","MD5"), (ProfileDTO) (pa.findEntities("from Profile where profile = 'admin'").get(0)),
				"admin@graopara.com", new Date()));
		}
		else user = null;
		
		user = pa.findEntities("from User where email = 'user@graopara.com'");
		if(user == null)
		{
			log.info("Criando usuário de teste...");
			pa.saveEntity(new UserDTO("Usuário Padrão", EJBUtility.getHash("null","MD5"), (ProfileDTO) (pa.findEntities("from Profile where profile = 'user'").get(0)),
				"user@graopara.com", new Date()));
		}
		else user = null;
		
		user = pa.findEntities("from User where email = 'default@graopara.com'");
		if(user == null)
		{
			log.info("Criando usuário sem privilégios de teste...");
			pa.saveEntity(new UserDTO("Anonimo", EJBUtility.getHash("null","MD5"), (ProfileDTO) (pa.findEntities("from Profile where profile = 'default'").get(0)),
				"default@graopara.com", new Date()));
		}
		user = null;
		
		List<DTO> origem = pa.findEntities("from Origem where tipoOrigem = 'CODICE'");
		if(origem == null) {
			log.info("Criando um origem de documento...");
			pa.saveEntity(new OrigemDTO("1", "CODICE", "CODICE"));
		}
		origem = pa.findEntities("from Origem where tipoOrigem = 'CAIXA'");
		if(origem == null) {
			log.info("Criando um origem de documento...");
			pa.saveEntity(new OrigemDTO("2", "CAIXA", "CAIXA"));
		}
		
		List<DTO> doc = pa.findEntities("from TipoDocumento where tipoDocumento = 'Ofícios'");
		if(doc == null)
		{
			log.info("Criando um tipo de documento...");
			pa.saveEntity(new TipoDocumentoDTO("Ofícios"));
		}
		
		doc = pa.findEntities("from TipoDocumento where tipoDocumento = 'Cartas'");
		if(doc == null)
		{
			log.info("Criando um tipo de documento...");
			pa.saveEntity(new TipoDocumentoDTO("Cartas"));
		}
		
		doc = pa.findEntities("from TipoDocumento where tipoDocumento = 'Relatórios'");
		if(doc == null)
		{
			log.info("Criando um tipo de documento...");
			pa.saveEntity(new TipoDocumentoDTO("Relatórios"));
		}
		doc = null;
		
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
