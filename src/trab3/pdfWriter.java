package trab3;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import javax.swing.JFileChooser;

public class pdfWriter
{
    final JFileChooser fc = new JFileChooser();
    private static final Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static final Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static final Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);

    private int type;
    
    public pdfWriter() {
    }

    public String getPath() {
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            return fc.getSelectedFile().getAbsolutePath();
        } else {
            return null;
        }
    }

    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }

    public static void addTitlePage(Document document, PdfPTable table, int type)
            throws DocumentException {
        Paragraph preface = new Paragraph();

        addEmptyLine(preface, 1);
        
        switch(type){
            case 1: 
                preface.add(new Paragraph("Relatório - Atletas", catFont));
                addEmptyLine(preface, 3);
                
                preface.add(new Paragraph("Listar os atletas " + 
                    "(nome, documento de identificação, nacionalidade e data de nascimento) " +
                    "da modalidade A, que foram atendidos pelo medico B e são treinados " +
                    "pelo treinador C, em que A, B e C são definidos pelo usuario.", smallBold));
                
                addEmptyLine(preface, 2);
                document.add(preface);
                document.add(table);
                
                break;
                
            case 2: 
                preface.add(new Paragraph("Relatório - Medicos", catFont));
                addEmptyLine(preface, 3);
                
                preface.add(new Paragraph("Liste todos os médicos que atenderam " +
                "pelo menos X atletas de uma nação N, juntamente ao numero total " + 
                "de atletas que atenderam, em que X e N são definidos pelo usuário.", smallBold));
                
                addEmptyLine(preface, 2);
                document.add(preface);
                document.add(table);
                
                break;
                
            case 3: 
                preface.add(new Paragraph("Relatório - Treinos", catFont));
                addEmptyLine(preface, 3);
                
                preface.add(new Paragraph("Liste a quantidade de todos os treinos que aconteceram " +
                "nos periodos matutino, vespertino e noturno, juntamente " +
                "ao numero de atletas que treinaram em cada periodo.", smallBold));
                
                addEmptyLine(preface, 2);
                document.add(preface);
                document.add(table);
                
                break;
                
            case 4: 
                preface.add(new Paragraph("Relatório - Dopping", catFont));
                addEmptyLine(preface, 3);
                
                preface.add(new Paragraph("Identifique os treinadores com o maior numero de atletas " +
                "em situação irregular devido ao doping, exibindo os resultados " +
                "da razão entre o numero de atletas irregulares pelo total de atletas " +
                "treinados pelo mesmo treinador.", smallBold));
                
                addEmptyLine(preface, 2);
                document.add(preface);
                document.add(table);
                
                break;
        }
    }
}