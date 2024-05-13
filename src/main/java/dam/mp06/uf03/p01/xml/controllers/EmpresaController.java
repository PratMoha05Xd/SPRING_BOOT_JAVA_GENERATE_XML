package dam.mp06.uf03.p01.xml.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dam.mp06.uf03.p01.xml.model.domain.Empresa;
import dam.mp06.uf03.p01.xml.model.service.IEmpresaService;

@RestController
//http://localhost:8080/empresa/
@RequestMapping("/empreses/")
public class EmpresaController {

	@Autowired
	IEmpresaService empresaService;

	// http://localhost:8080/empresa/add
	@PostMapping("/add")
	public ResponseEntity<?> addEmpresa(@RequestBody Empresa empresa) {

		ResponseEntity<?> result = null;

		try {
			empresaService.add(empresa);
			result = ResponseEntity.status(HttpStatus.OK).body(empresa);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	// http://localhost:8080/empresa/upd
	@PutMapping("/upd")
	public ResponseEntity<?> updEmpresa(@RequestBody Empresa empresa) {

		ResponseEntity<?> result = null;

		try {
			empresaService.update(empresa);
			result = ResponseEntity.status(HttpStatus.OK).body(empresa);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	// http://localhost:8080/empresa/delete/{nif}
	@DeleteMapping("/delete/{nif}")
	public ResponseEntity<?> updEmpresa(@PathVariable String nif) {

		ResponseEntity<?> result = null;

		try {
			empresaService.delete(nif);
			result = ResponseEntity.status(HttpStatus.OK).body("Empresa eliminat");
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;
	}

	// http://localhost:8080/empresa/getAll
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll() {

		ResponseEntity<?> result = null;

		try {
			List<Empresa> empresas = empresaService.getAll();
			result = ResponseEntity.status(HttpStatus.OK).body(empresas);
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;

	}

	// http://localhost:8080/empresa/getOne/{nif}
	@GetMapping("/getOne/{nif}")
	public ResponseEntity<?> getByNif(@PathVariable String nif) {

		ResponseEntity<?> result = null;

		try {
			Empresa empresa = empresaService.getByCif(nif);

			if (empresa != null) {
				result = ResponseEntity.status(HttpStatus.OK).body(empresa);
			} else {
				result = ResponseEntity.status(HttpStatus.NOT_FOUND).body("L'Empresa amb NIF " + nif + " no existeix.");
			}
		} catch (Exception ex) {
			result = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
		}

		return result;

	}

}
