package beans;

public class BeanCursoJsp {

	private Long id;

	private String login;

	private String senha;

	private String nome;

	private String fone;

	private String cep;

	private String rua;

	private String bairro;

	private String cidade;

	private String estado;

	private String ibge;

	private String fotoBase64;

	private String fotoBase64Miniatura;

	private String curriculoBase64;

	private String contentType;

	private String contentTypeCurriculo;

	private String tempFotoUser;

	private String sexo;

	private String perfil;
	
	private boolean ativo;

	private boolean atualizarImage = true;

	private boolean atualizarPdf = true;

	
	
	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isAtualizarImage() {
		return atualizarImage;
	}

	public void setAtualizarImage(boolean atualizarImage) {
		this.atualizarImage = atualizarImage;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public boolean isAtualizarPdf() {
		return atualizarPdf;
	}

	public void setAtualizarPdf(boolean atualizarPdf) {
		this.atualizarPdf = atualizarPdf;
	}

	public void setFotoBase64Miniatura(String fotoBase64Miniatura) {
		this.fotoBase64Miniatura = fotoBase64Miniatura;
	}

	public String getFotoBase64Miniatura() {
		return fotoBase64Miniatura;
	}

	/* Esse metodo tempFotoUser e para carregamento da imagem no front-end */
	public String getTempFotoUser() {

		tempFotoUser = "data:" + contentType + ";base64," + fotoBase64;

		return tempFotoUser;
	}

	public String getCurriculoBase64() {
		return curriculoBase64;
	}

	public String getContentTypeCurriculo() {
		return contentTypeCurriculo;
	}

	public void setCurriculoBase64(String curriculoBase64) {
		this.curriculoBase64 = curriculoBase64;
	}

	public void setContentTypeCurriculo(String contentTypeCurriculo) {
		this.contentTypeCurriculo = contentTypeCurriculo;
	}

	public void setFotoBase64(String fotoBase64) {
		this.fotoBase64 = fotoBase64;
	}

	public String getFotoBase64() {
		return fotoBase64;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getContentType() {
		return contentType;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getIbge() {
		return ibge;
	}

	public void setIbge(String ibge) {
		this.ibge = ibge;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
