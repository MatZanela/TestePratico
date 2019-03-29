/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import controller.CepController;
import java.util.HashMap;
import java.util.Map;
import model.CEP;

/**
 *
 * @author User
 */
public class CepFacade {
    public static CEP buscaCepApi(String srcCep){
        
        srcCep = srcCep.replace(".", "");
        srcCep = srcCep.replace("-", "");
        
        Map<String,String> mapa = new HashMap<>();
        
        CepController controller = new CepController();
        
        
        CEP cep = new CEP();
        if((mapa = controller.buscarCepApi(srcCep)) == null){
            return null;
        }else{
            cep.setCep(mapa.get("cep"));
            cep.setBairro(mapa.get("bairro"));
            cep.setComplemento(mapa.get("complemento"));
            cep.setGia(mapa.get("gia"));
            cep.setIbge(mapa.get("ibge"));
            cep.setLocalidade(mapa.get("localidade"));
            cep.setLogradouro(mapa.get("logradouro"));
            cep.setUf(mapa.get("uf"));
            cep.setUnidade(mapa.get("unidade"));

            return cep;
        }
    }
}
