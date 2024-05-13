package dam.mp06.uf03.p01.xml.model.service;

import java.util.List;

import dam.mp06.uf03.p01.xml.model.domain.Empresa;

public interface IEmpresaService {

	void add(Empresa empresa);

	void update(Empresa empresa);

	void delete(String cif);

	List<Empresa> getAll();

	Empresa getByCif(String cif);

}
