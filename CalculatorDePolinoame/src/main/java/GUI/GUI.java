package GUI;
import Model.Polinom;
import Functions.Functions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GUI extends JDialog{
    private JPanel panel1;
    private JLabel titlu;
    private JLabel Polinom1;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel Polinom2;
    private JLabel Rezultat;
    private JTextField textField3;
    private JButton adunareButon;
    private JButton scadereButon;
    private JButton integrareButon;
    private JButton derivareButon;
    private JButton inmultireButon;
    private JButton impartireButon;
    private JButton srezultatButon;
    private JButton spolinom1Buton;
    private JButton restButon;
    private JButton spolinom2Buton;
    public GUI() {
        JFrame frame = new JFrame();
        frame.setTitle("Calculator de polinoame");
        frame.setMinimumSize(new Dimension(900,700));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(panel1);
        frame.pack();
        textField1.setVisible(true);
        textField2.setVisible(true);
        textField3.setVisible(true);
        textField1.setEditable(true);
        textField2.setEditable(true);
        textField3.setEditable(false);
        adunareButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Click SUMA");
                System.out.println(textField1.getText());
                Polinom p1 = new Polinom(textField1.getText()+"");
                Polinom p2 = new Polinom(textField2.getText());
                Polinom P=Functions.adunare(p1, p2);
                textField3.setText(P.toString());
            }
        });
        scadereButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Click SCADERE");
                Polinom p1 = new Polinom(textField1.getText());
                Polinom p2 = new Polinom(textField2.getText());
                Polinom P=Functions.scadere(p1, p2);
                textField3.setText(P.toString());
            }
        });
        inmultireButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Click INMULTIRE");
                Polinom p1 = new Polinom(textField1.getText());
                Polinom p2 = new Polinom(textField2.getText());
                Polinom P=Functions.inmultire(p1, p2);
                textField3.setText(P.toString());
            }
        });
        impartireButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Click IMPARTIRE");
                Polinom p1 = new Polinom(textField1.getText());
                Polinom p2 = new Polinom(textField2.getText());
                Polinom P=Functions.impartire(p1, p2);
                textField3.setText(P.toString());
            }
        });
        integrareButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Click INTEGRARE");
                textField2.setText("");
                Polinom p1 = new Polinom(textField1.getText());
                Polinom P=Functions.integrare(p1);
                textField3.setText(P.toString());
            }
        });
        derivareButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Click DERIVARE");
                textField2.setText("");
                Polinom p1 = new Polinom(textField1.getText());
                Polinom P=Functions.derivare(p1);
                textField3.setText(P.toString());
            }
        });
        restButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Click REST");
                Polinom p1 = new Polinom(textField1.getText());
                Polinom p2 = new Polinom( textField2.getText());
                Polinom P=Functions.getRest(p1, p2);
                textField3.setText(P.toString());
            }
        });
        srezultatButon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Click STERS REZULTAT");
                textField3.setText("");
            }
        });
        spolinom1Buton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Click STERS POLINOM1");
                textField1.setText("");
            }
        });
        spolinom2Buton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.out.println("Click STERS POLINOM2");
                textField2.setText("");
            }
        });
        frame.setVisible(true);
    }
}
