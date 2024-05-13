package dam.mp06.uf03.p01.xml.model.repository;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Repository;

@Repository
//La fem d'àmbit de paquet
class SerialitzacioXmlRepository {


	public void serialitza(Object object, String pathArxiu) {

		FileOutputStream fileOutputStream;
		try {
			fileOutputStream = new FileOutputStream(pathArxiu);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		XMLEncoder xmlEncoder = new XMLEncoder(fileOutputStream);
		xmlEncoder.writeObject(object);
		xmlEncoder.close();
	}

	public Object deserialitza(String pathArxiu) {
		Object result = null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(pathArxiu);
		} catch (FileNotFoundException e) {
			// throw new RuntimeException(e);
			result = null;
		}
		if (fileInputStream != null) {
			XMLDecoder xmlDecoder = new XMLDecoder(fileInputStream);
			result = xmlDecoder.readObject();
			xmlDecoder.close();
		}
		return result;
	}

}
