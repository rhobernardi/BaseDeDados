
package trab3;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


final class relatorio extends javax.swing.JFrame {
    
    String host, user, pass = null;
    int type;
    JTable tabelaRelatorio;
    Connection con;
    
    public relatorio(String host, String user, String pass, Connection con, int type) {
        this.host = host;
        this.user = user;
        this.pass = pass;
        this.con = con;
        this.type = type;
        
        this.tabelaRelatorio = exibeRelatorio(con);
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        initComponents();
        setVisible(true);
    }
    
    public relatorio() {
        initComponents();
    }
    
    public JTable exibeRelatorio(Connection conexao) {
        String input = null;
        int count = 0;
        
        switch (type) {
            case 1: 
                input = "SELECT * FROM Professor";
                /*input = "SELECT I.PERFIL AS \"Perfil Amigo Avaliador\" ,"
                + "I.LINGUA AS \"Lingua Preferida\" ,"
                + "F.TITULO AS \"Titulo Avaliado\" ,"
                + "FC.PERFILB AS \"Perfil original\" FROM FILME F, AUDIOFILME A, LEGENDAFILME L, "
                + "IDIOMAPERFIL I, ASSISTE S, FICAAMIGO FC, AVALIACAO V\n"
                + "WHERE F.TITULO = A.FILME AND\n"
                + "L.FILME = F.TITULO AND\n"
                + "(I.LINGUA = A.AUDIO OR I.LINGUA = L.LEGENDA)\n"
                + "AND FC.PERFILA = I.PERFIL\n"
                + "AND ((S.PERFIL = FC.PERFILB\n"
                + "AND S.FILME = F.TITULO)\n"
                + "OR (V.FILME = F.TITULO \n"
                + "AND V.PERFIL = FC.PERFILB))\n"
                + "GROUP BY I.PERFIL,I.LINGUA,F.TITULO,FC.PERFILB\n"
                + "ORDER BY I.PERFIL";*/
                break;
  
            case 2: 
                input = "SELECT * FROM Turma";
                /*input = "SELECT I.PERFIL AS \"Perfil Amigo Avaliador\" ,"
                + "I.LINGUA AS \"Lingua Preferida\" ,"
                + "F.TITULO AS \"Titulo Avaliado\" ,"
                + "FC.PERFILB AS \"Perfil original\" FROM FILME F, AUDIOFILME A, LEGENDAFILME L, "
                + "IDIOMAPERFIL I, ASSISTE S, FICAAMIGO FC, AVALIACAO V\n"
                + "WHERE F.TITULO = A.FILME AND\n"
                + "L.FILME = F.TITULO AND\n"
                + "(I.LINGUA = A.AUDIO OR I.LINGUA = L.LEGENDA)\n"
                + "AND FC.PERFILA = I.PERFIL\n"
                + "AND ((S.PERFIL = FC.PERFILB\n"
                + "AND S.FILME = F.TITULO)\n"
                + "OR (V.FILME = F.TITULO \n"
                + "AND V.PERFIL = FC.PERFILB))\n"
                + "GROUP BY I.PERFIL,I.LINGUA,F.TITULO,FC.PERFILB\n"
                + "ORDER BY I.PERFIL";*/
                break;
                
            case 3: 
                input = "SELECT * FROM Matricula";
                /*input = "SELECT I.PERFIL AS \"Perfil Amigo Avaliador\" ,"
                + "I.LINGUA AS \"Lingua Preferida\" ,"
                + "F.TITULO AS \"Titulo Avaliado\" ,"
                + "FC.PERFILB AS \"Perfil original\" FROM FILME F, AUDIOFILME A, LEGENDAFILME L, "
                + "IDIOMAPERFIL I, ASSISTE S, FICAAMIGO FC, AVALIACAO V\n"
                + "WHERE F.TITULO = A.FILME AND\n"
                + "L.FILME = F.TITULO AND\n"
                + "(I.LINGUA = A.AUDIO OR I.LINGUA = L.LEGENDA)\n"
                + "AND FC.PERFILA = I.PERFIL\n"
                + "AND ((S.PERFIL = FC.PERFILB\n"
                + "AND S.FILME = F.TITULO)\n"
                + "OR (V.FILME = F.TITULO \n"
                + "AND V.PERFIL = FC.PERFILB))\n"
                + "GROUP BY I.PERFIL,I.LINGUA,F.TITULO,FC.PERFILB\n"
                + "ORDER BY I.PERFIL";*/
                break;
                
            case 4: 
                input = "SELECT * FROM Disciplina";
                /*input = "SELECT I.PERFIL AS \"Perfil Amigo Avaliador\" ,"
                + "I.LINGUA AS \"Lingua Preferida\" ,"
                + "F.TITULO AS \"Titulo Avaliado\" ,"
                + "FC.PERFILB AS \"Perfil original\" FROM FILME F, AUDIOFILME A, LEGENDAFILME L, "
                + "IDIOMAPERFIL I, ASSISTE S, FICAAMIGO FC, AVALIACAO V\n"
                + "WHERE F.TITULO = A.FILME AND\n"
                + "L.FILME = F.TITULO AND\n"
                + "(I.LINGUA = A.AUDIO OR I.LINGUA = L.LEGENDA)\n"
                + "AND FC.PERFILA = I.PERFIL\n"
                + "AND ((S.PERFIL = FC.PERFILB\n"
                + "AND S.FILME = F.TITULO)\n"
                + "OR (V.FILME = F.TITULO \n"
                + "AND V.PERFIL = FC.PERFILB))\n"
                + "GROUP BY I.PERFIL,I.LINGUA,F.TITULO,FC.PERFILB\n"
                + "ORDER BY I.PERFIL";*/
                break;
        }
        
        Vector columnNames = new Vector();
        Vector data = new Vector();

        try {
            //construção da classe PreparedStatement para passagem de parâmetros
            PreparedStatement instrucao = conexao.prepareStatement(input);

            //recebe os resultados da query
            ResultSet result = instrucao.executeQuery();
            
            // Metadados dos resultados
            ResultSetMetaData resultados = result.getMetaData();
            
            // Quantidade de colunas
            int colunas = resultados.getColumnCount();

            while (result.next()) {
                count++;
            }
            if (count == 0) {
                return null;
            }
            for (int i = 1; i <= colunas; i++) {
                // Nomes das colunas ao vetor de nomes
                columnNames.addElement(resultados.getColumnName(i));
            }
            
            // Reposiciona ponteiro de leitura
            result = instrucao.executeQuery();
            
            while (result.next()) {
                
                // Cria as tuplas com os dados
                Vector row = new Vector(colunas);
                
                for (int i = 1; i <= colunas; i++) {
                    row.addElement(result.getObject(i));
                }
                
                // Adiciona  as tuplas no vetor de dados
                data.addElement(row);
            }
            
            result.close();
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro SQL: " + e.getMessage());
        }

        // Cria tabela e painel novo para exibir as consultas
        DefaultTableModel d = new DefaultTableModel(data, columnNames);
        JTable pTable = new JTable(d);
        pTable.setCellSelectionEnabled(false);
        //ListSelectionModel cellSelectionModel = pTable.getSelectionModel();
        //cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        //tablePanel = new JScrollPane(pTable);
        JScrollPane jsp = new JScrollPane(pTable);
        add(jsp);
        
        return pTable;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JPanel = new javax.swing.JPanel();
        buttonPanel = new javax.swing.JPanel();
        salvar = new javax.swing.JButton();
        sair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ICMC-USP - SCC0240 - Projeto BD");

        JPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        salvar.setText("Salvar em PDF");
        salvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarActionPerformed(evt);
            }
        });

        sair.setText("Fechar");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(salvar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 142, Short.MAX_VALUE)
                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        buttonPanelLayout.setVerticalGroup(
            buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(buttonPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvar)
                    .addComponent(sair))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JPanelLayout = new javax.swing.GroupLayout(JPanel);
        JPanel.setLayout(JPanelLayout);
        JPanelLayout.setHorizontalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        JPanelLayout.setVerticalGroup(
            JPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelLayout.createSequentialGroup()
                .addContainerGap(460, Short.MAX_VALUE)
                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarActionPerformed
        // TODO add your handling code here:
        pdfWriter pdf = new pdfWriter();
        String path = pdf.getPath();
        try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path + ".pdf"));
            doc.open();

            PdfPTable pdfTable = new PdfPTable(tabelaRelatorio.getColumnCount());

            for (int i = 0; i < tabelaRelatorio.getColumnCount(); i++) {
                pdfTable.addCell(tabelaRelatorio.getColumnName(i));
            }
            for (int row = 0; row < tabelaRelatorio.getRowCount(); row++) {
                for (int col = 0; col < tabelaRelatorio.getColumnCount(); col++) {
                    pdfTable.addCell(tabelaRelatorio.getModel().getValueAt(row, col).toString());
                }
            }
            
            pdfWriter.addTitlePage(doc, pdfTable, this.type);
            doc.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(pdfWriter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(pdfWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_salvarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_sairActionPerformed

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
            java.util.logging.Logger.getLogger(relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(relatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new relatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton sair;
    private javax.swing.JButton salvar;
    // End of variables declaration//GEN-END:variables
}
