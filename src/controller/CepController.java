/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import facade.CepFacade;
import model.CEP;

/**
 *
 * @author User
 */
public class CepController {
    //Codigo para realizar a busca e/ou inserção de um CEP
    public CEP buscarCep(String srcCep){
        
        CEP cep = CepFacade.buscarCepBD(srcCep);
        if(cep == null){
            cep = CepFacade.buscarCepApi(srcCep);
            if(cep != null){
                CepFacade.inserirCepBd(cep);
            }
        }
        return cep;
    }
}
