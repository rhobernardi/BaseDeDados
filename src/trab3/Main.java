
package trab3;

import javax.swing.JFrame;

public class Main {
    
    public static void main(String[] args) {
        String host = "jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl"; //conexao com lab grad
        String user = "8066395"; //usuario
        //String pass = "database1"; //senha errada
        String pass = "database"; //senha certa
        String conexao = "oracle.jdbc.driver.OracleDriver"; //driver de conexao

        JFrame tela = new telaInicial(host, user, pass, conexao);
        tela.setVisible(true);
    }
}