/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.controlador;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


public class Captcha {

    public void check() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Your code is correct", null));
    }

    public Captcha() {
    }
    
}
