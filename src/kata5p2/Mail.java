/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5p2;

/**
 *
 * @author Laura
 */
public class Mail {

    private final String mail;

    public Mail(String mail) {
        this.mail = mail;
    }

    public String getDomain() {
        int index = mail.indexOf("@");
        if (index >= 0) {
            return mail.substring(index + 1);
        }
        return null;
    }

    public String getMail() {
        return mail;
    }
}
