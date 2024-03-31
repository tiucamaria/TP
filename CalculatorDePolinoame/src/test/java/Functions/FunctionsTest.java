package Functions;
import Model.Polinom;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class FunctionsTest {
    Polinom p1=new Polinom("3*x^5-x^4+3*x^3-x-2");
    Polinom p2=new Polinom("x^2+1");
    Polinom rezultat,rezultatCorect;
    @org.junit.Test
    public void adunare() {
        rezultatCorect=new Polinom("3*x^5-x^4+3*x^3+x^2-x-1");
        rezultat=new Polinom();
        rezultat=Functions.adunare(p1,p2);
        Assertions.assertEquals(rezultat.toString(),rezultatCorect.toString());
    }
    @org.junit.Test
    public void scadere() {
        rezultatCorect=new Polinom("3*x^5-x^4+3*x^3-x^2-x-3");
        rezultat=new Polinom();
        rezultat=Functions.scadere(p1,p2);
        Assertions.assertEquals(rezultat.toString(),rezultatCorect.toString());
    }
    @org.junit.Test
    public void inmultire() {
        rezultatCorect=new Polinom("3*x^7-x^6+6*x^5-x^4+2*x^3-2*x^2-x-2");
        rezultat=new Polinom();
        rezultat=Functions.inmultire(p1,p2);
        Assertions.assertEquals(rezultat.toString(),rezultatCorect.toString());
    }
    @org.junit.Test
    public void derivare() {
        rezultatCorect=new Polinom("15*x^4-4*x^3+9*x^2-1");
        rezultat=new Polinom();
        rezultat=Functions.derivare(p1);
        Assertions.assertEquals(rezultat.toString(),rezultatCorect.toString());
    }
    @org.junit.Test
    public void integrare() {
        rezultatCorect=new Polinom("0.5*x^6-0.2*x^5+0.75*x^4-0.5*x^2-2*x");
        rezultat=new Polinom();
        rezultat=Functions.integrare(p1);
        Assertions.assertEquals(rezultat.toString(),rezultatCorect.toString());
    }
    @org.junit.Test
    public void impartire() {
        rezultatCorect=new Polinom("3*x^3-x^2+1");
        rezultat=new Polinom();
        rezultat=Functions.impartire(p1,p2);
        Assertions.assertEquals(rezultat.toString(),rezultatCorect.toString());
        //TESTAT PENTRU INVERSAT DE POLINOAME
        rezultatCorect=new Polinom("3*x^3-x^2+1");
        rezultat=new Polinom();
        rezultat=Functions.impartire(p2,p1);
        Assertions.assertEquals(rezultat.toString(),rezultatCorect.toString());
    }
    @org.junit.Test
    public void getRest() {
        rezultatCorect=new Polinom("-x-3");
        rezultat=new Polinom();
        rezultat=Functions.getRest(p1,p2);
        Assertions.assertEquals(rezultat.toString(),rezultatCorect.toString());
    }
}