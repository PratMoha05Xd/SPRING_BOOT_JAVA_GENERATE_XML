package dam.mp06.uf03.p01.xml.model.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import dam.mp06.uf03.p01.xml.model.domain.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class EmpresaRepository {

	@Value("${empreses.db.xml}")
	public String DB_EMPRESES;

	@Autowired
	SerialitzacioXmlRepository serialitzacioXmlRepository;

	public List<Empresa> getAll() {
		return this.getDb();
	}

	public void add(Empresa empresa) {
		List<Empresa> llista = this.getDb();
		Empresa empresaDb = this.getByNif(llista, empresa.getCif());
		if (empresaDb == null) {
			llista.add(empresa);
			serialitzacioXmlRepository.serialitza(llista, DB_EMPRESES);
		} else {
			throw new RuntimeException("L'empresa amb CIF " + empresa.getCif() + " ja existeix.");
		}
	}

	public void update(Empresa empresa) {
		List<Empresa> llista = this.getDb();
		Empresa empresaDb = this.getByNif(llista, empresa.getCif());
		if (empresaDb != null) {
			empresaDb.setNom(empresa.getNom());
			serialitzacioXmlRepository.serialitza(llista, DB_EMPRESES);
		} else {
			throw new RuntimeException("L'empresa amb CIF " + empresa.getCif() + " no existeix.");
		}
	}

	public void delete(String cif) {
		List<Empresa> llista = this.getDb();
		Empresa empresaDb = this.getByNif(llista, cif);
		if (empresaDb != null) {
			llista.remove(empresaDb);
			serialitzacioXmlRepository.serialitza(llista, DB_EMPRESES);
		} else {
			throw new RuntimeException("L'empresa amb CIF " + cif + " no existeix.");
		}
	}

	public Empresa getByNif(String cif) {
		return this.getByNif(null, cif);
	}

	private Empresa getByNif(List<Empresa> pLlista, String cif) {
		Empresa result = null;
		List<Empresa> llista = pLlista;
		if (llista == null) {
			llista = this.getDb();
		}
		Optional<Empresa> element = llista.stream().filter(x -> x.getCif().equals(cif)).findFirst();
		if (element.isPresent()) {
			result = element.get();
		}
		return result;
	}

	private List<Empresa> getDb() {
		List<Empresa> result = null;
		Object object = serialitzacioXmlRepository.deserialitza(DB_EMPRESES);
		if (object != null) {
			result = (List<Empresa>) object;
		} else {
			result = new ArrayList<Empresa>();
		}
		return result;
	}
}
