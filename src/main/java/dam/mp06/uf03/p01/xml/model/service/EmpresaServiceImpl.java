package dam.mp06.uf03.p01.xml.model.service;

import java.util.List;

import dam.mp06.uf03.p01.xml.model.domain.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dam.mp06.uf03.p01.xml.model.repository.EmpresaRepository;

@Service
public class EmpresaServiceImpl implements IEmpresaService {

	@Autowired
	EmpresaRepository empresaRepository;

	@Override
	public void add(Empresa empresa) {
		empresaRepository.add(empresa);
	}

	@Override
	public void update(Empresa empresa) {
		empresaRepository.update(empresa);
	}

	@Override
	public void delete(String cif) {
		empresaRepository.delete(cif);
	}

	@Override
	public List<Empresa> getAll() {
		return empresaRepository.getAll();
	}

	@Override
	public Empresa getByCif(String cif) {
		return empresaRepository.getByNif(cif);
	}
}
