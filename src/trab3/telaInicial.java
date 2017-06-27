
package trab3;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class telaInicial extends javax.swing.JFrame {
    
    String host, user, pass, conexao = null;
    Connection connection;

    public telaInicial(String host, String user, String pass, String conexao) {
        initComponents();
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.conexao = conexao;

        // Falha de conexão por credenciais
        if (!conectar()) {
            JOptionPane.showMessageDialog(null, "ERRO: verifique seu usuário e senha");
        }
        this.pack();
    }

    // Conexao com o banco de dados
    public boolean conectar() {
        try {
            Class.forName(conexao);
            connection = DriverManager.getConnection(
                    host,
                    user,
                    pass);
            
            jtAreaDeStatus1.setText("Usuário: " + user);
            jtAreaDeStatus2.setText("Status: Online");
            jtAreaDeStatus3.setForeground(new Color(102,169,50));
            jtAreaDeStatus3.setText("Conectado com sucesso!");
            
        } catch (ClassNotFoundException ex) {
            jtAreaDeStatus1.setText("Usuário: -");
            jtAreaDeStatus2.setText("Status: Offline");
            jtAreaDeStatus3.setText("ERRO: verifique o driver do banco de dados");
            jtAreaDeStatus3.setForeground(new Color(102,169,50));
        } catch (SQLException ex) {
            jtAreaDeStatus1.setText("Usuário: -");
            jtAreaDeStatus2.setText("Status: Offline");
            jtAreaDeStatus3.setText("ERRO: verifique seu usuário e senha");
            jtAreaDeStatus3.setForeground(new Color(255,27,27));
        }
        return true;
    }

    private telaInicial() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoEditarRelacao = new javax.swing.JButton();
        botaoGerarRelatorioAtletas = new javax.swing.JButton();
        botaoGerarRelatorioMedico = new javax.swing.JButton();
        botaoGerarRelatorioTreinos = new javax.swing.JButton();
        botaoGerarRelatorioDopping = new javax.swing.JButton();
        jtAreaDeStatus1 = new javax.swing.JLabel();
        jtAreaDeStatus2 = new javax.swing.JLabel();
        jtAreaDeStatus3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ICMC-USP - SCC0240 - Projeto BD");
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(650, 250));
        setName("telaInicial"); // NOI18N
        setResizable(false);

        botaoEditarRelacao.setText("Editar Relação");
        botaoEditarRelacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarRelacaoActionPerformed(evt);
            }
        });

        botaoGerarRelatorioAtletas.setText("Gerar Relatório de Atletas");
        botaoGerarRelatorioAtletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarRelatorioAtletasActionPerformed(evt);
            }
        });

        botaoGerarRelatorioMedico.setText("Gerar Relatório de Médicos");
        botaoGerarRelatorioMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarRelatorioMedicoActionPerformed(evt);
            }
        });

        botaoGerarRelatorioTreinos.setText("Gerar Relatório de Treinos");
        botaoGerarRelatorioTreinos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarRelatorioTreinosActionPerformed(evt);
            }
        });

        botaoGerarRelatorioDopping.setText("Gerar Relatório de Dopping");
        botaoGerarRelatorioDopping.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerarRelatorioDoppingActionPerformed(evt);
            }
        });

        jtAreaDeStatus1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtAreaDeStatus1.setText("ID");
        jtAreaDeStatus1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtAreaDeStatus2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtAreaDeStatus2.setText("Status");
        jtAreaDeStatus2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jtAreaDeStatus3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jtAreaDeStatus3.setText("-");
        jtAreaDeStatus3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Projeto 3 - Base de Dados");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
                    .addComponent(jtAreaDeStatus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoEditarRelacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoGerarRelatorioMedico, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtAreaDeStatus2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtAreaDeStatus3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoGerarRelatorioTreinos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoGerarRelatorioDopping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botaoGerarRelatorioAtletas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(botaoEditarRelacao, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(botaoGerarRelatorioAtletas, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoGerarRelatorioMedico, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoGerarRelatorioTreinos, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoGerarRelatorioDopping, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jtAreaDeStatus1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtAreaDeStatus2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtAreaDeStatus3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoEditarRelacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarRelacaoActionPerformed
        //chamada para a interface do historico
        //relacao relacao = new relacao(host, user, pass, connection);
    }//GEN-LAST:event_botaoEditarRelacaoActionPerformed

    private void botaoGerarRelatorioMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarRelatorioMedicoActionPerformed
        relatorio rel = new relatorio(host, user, pass, connection, 2);
        System.out.println("Turma");
        rel.setVisible(true);
    }//GEN-LAST:event_botaoGerarRelatorioMedicoActionPerformed

    private void botaoGerarRelatorioTreinosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarRelatorioTreinosActionPerformed
        relatorio rel = new relatorio(host, user, pass, connection, 3);
        System.out.println("Matricula");
        rel.setVisible(true);
    }//GEN-LAST:event_botaoGerarRelatorioTreinosActionPerformed

    private void botaoGerarRelatorioDoppingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarRelatorioDoppingActionPerformed
        relatorio rel = new relatorio(host, user, pass, connection, 4);
        System.out.println("Disciplina");
        rel.setVisible(true);
    }//GEN-LAST:event_botaoGerarRelatorioDoppingActionPerformed

    private void botaoGerarRelatorioAtletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerarRelatorioAtletasActionPerformed
        relatorio rel = new relatorio(host, user, pass, connection, 1);
        System.out.println("Professor");
        rel.setVisible(true);
    }//GEN-LAST:event_botaoGerarRelatorioAtletasActionPerformed
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoEditarRelacao;
    private javax.swing.JButton botaoGerarRelatorioAtletas;
    private javax.swing.JButton botaoGerarRelatorioDopping;
    private javax.swing.JButton botaoGerarRelatorioMedico;
    private javax.swing.JButton botaoGerarRelatorioTreinos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel jtAreaDeStatus1;
    private javax.swing.JLabel jtAreaDeStatus2;
    private javax.swing.JLabel jtAreaDeStatus3;
    // End of variables declaration//GEN-END:variables
}
