/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade;

import dao.CepDao;
import java.util.HashMap;
import java.util.Map;
import model.CEP;
import viacep.ViaCep;

/**
 *
 * @author User
 */
public class CepFacade {
    
    // codigos e regras de negocio para insercao de CEP no banco de dados
    public static void inserirCepBd(CEP cep){
        CepDao dao = new CepDao();
        dao.insereCep(cep);
    }
    
    // codigos e regras de negocio para busca de CEP pelo ViaCep
    public static CEP buscarCepApi(String srcCep){
        
        srcCep = srcCep.replace(".", "");
        srcCep = srcCep.replace("-", "");
        
        Map<String,String> mapa = new HashMap<>();
        
        CEP cep = new CEP();
        if((mapa = ViaCep.buscarCep(srcCep)) == null){
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
    
    // codigos e regras de negocio para busca de CEP no Banco de Dados
    public static CEP buscarCepBD(String srcCep){
        
        srcCep = srcCep.replace(".", "");
        
        CepDao dao = new CepDao();
        CEP cep = dao.buscaCep(srcCep);
        if(cep == null){
            System.out.println("nada encontrado");
            return null;
        }
        return cep;
        
    }
}
