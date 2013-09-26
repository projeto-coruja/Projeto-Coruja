package business.EJB.user;

import java.util.List;

import persistence.dto.DTO;
import persistence.dto.Profile;
import persistence.dto.UserAccount;
import persistence.exceptions.UpdateEntityException;
import business.DAO.login.ProfileDAO;
import business.DAO.login.UserDAO;
import business.EJB.util.EJBUtility;
import business.EJB.util.RegularExpression;
import business.exceptions.login.DuplicateUserException;
import business.exceptions.login.IncorrectLoginInformationException;
import business.exceptions.login.IncorrectProfileInformationException;
import business.exceptions.login.ProfileNotFoundException;
import business.exceptions.login.UnreachableDataBaseException;
import business.exceptions.login.UserNotFoundException;

/**
 * Classe de administração
 */
public class AdminBean {

	private UserDAO userDAO;
	private ProfileDAO profileDAO;

	private final String profileNamePattern = "([a-z0-9]){3,}";
	private final RegularExpression profileNameChecker = new RegularExpression(profileNamePattern);

	private final String emailPattern = "([A-Za-z0-9])([_.-]?[A-Za-z0-9])*@([A-Za-z0-9]+)(\\.[A-Za-z0-9]+)+";
	private final RegularExpression emailChecker = new RegularExpression(emailPattern);

	public AdminBean() {
		userDAO = new UserDAO();
		profileDAO = new ProfileDAO();
	}

	/**
	 * Classe não usado.
	 * @param profile
	 * @param read
	 * @param write
	 * @param edit
	 * @throws UnreachableDataBaseException
	 * @throws IncorrectProfileInformationException
	 */
	@Deprecated
	public void adicionarProfile(String profile, boolean read, boolean write, boolean edit) 
			throws UnreachableDataBaseException, IncorrectProfileInformationException {
		try {
			if(!profileNameChecker.check(profile))	throw new IncorrectProfileInformationException("Nome inválido");
			Profile check = profileDAO.findProfileByName(profile);
			if(check.getProfile().equals(profile))	throw new IncorrectProfileInformationException("Nome de profile já existe.");
		} catch(ProfileNotFoundException e) {
			profileDAO.createProfile(profile);
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
			throw e;
		}
	}

	/**
	 * Adiciona um novo usuário pré-aprovado no banco de dados.
	 * @param email - Email do usuário
	 * @param name - Nome do usuário
	 * @param password - Senha do usuário
	 * @param profile - Perfil no qual o usuário fará parte
	 * @throws UnreachableDataBaseException
	 * @throws IncorrectLoginInformationException quando é fornecido um email fora do padrão.
	 * @throws DuplicateUserException quando o email já está registrado.
	 */
	public void adicionarUsuario(String email, String name, String password, String profile) throws UnreachableDataBaseException, IncorrectLoginInformationException, DuplicateUserException {
		try {
			if(!emailChecker.check(email))	
				throw new IncorrectLoginInformationException("Email inválido");	
			
			UserAccount check;
			
			try {
				check = userDAO.findUserByEmail(email);
				
				if(check != null)	
					throw new DuplicateUserException();
				
			} catch (UserNotFoundException e) {
				Profile p_dto = null;
				try {
					p_dto = profileDAO.findProfileByName(profile);
				} catch (ProfileNotFoundException f) {
					e.printStackTrace();
				}
				userDAO.addUser(email, name, EJBUtility.getHash(password, "MD5"), p_dto);
			}
		} catch (UnreachableDataBaseException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Troca o nível de permissão um usuário
	 * @param email - Email do usuário que terá as permissões alterada.
	 * @param novo_perfil - Nível de permissão que o usuário passará fazer parte.
	 * @throws IncorrectProfileInformationException quando o perfil escolhido já é o perfil do usuário
	 * @throws UnreachableDataBaseException quando há algum problema na transação, hibernate ou sql
	 * @throws UserNotFoundException quando o email fornecido não corresponde a nenhum usuário cadastrado.
	 * @throws ProfileNotFoundException quando o perfil fornecido não corresponde a nenhum perfil cadastrado.
	 * @throws IllegalArgumentException
	 * @throws UpdateEntityException
	 */
	public void alterarPermissoesUsuario(String email, String novo_perfil) 
			throws IncorrectProfileInformationException, UnreachableDataBaseException, UserNotFoundException, 
				ProfileNotFoundException, IllegalArgumentException, UpdateEntityException {
		userDAO.changeUserProfile(email, profileDAO.findProfileByName(novo_perfil));
	}

	/**
	 * Remove um usuário do BD
	 * @param email - Email do usuári a ser removido.
	 * @throws UnreachableDataBaseException
	 * @throws UserNotFoundException
	 */
	public void deletarUsuario(String email) throws UnreachableDataBaseException, UserNotFoundException {
		userDAO.removeUser(email);
	}

	/**
	 * Lista todos os perfils disponíveis
	 * @return <tt>List&lt;DTO&gt;</tt> com todos os perfils disponíveis no BD
	 * @throws UnreachableDataBaseException
	 * @throws ProfileNotFoundException
	 */
	public List<DTO> getAllAvailableProfiles() throws UnreachableDataBaseException, ProfileNotFoundException{
		return profileDAO.getAllProfiles();
	}
	
}
