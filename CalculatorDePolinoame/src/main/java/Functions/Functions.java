package Functions;
import Model.Polinom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Functions {
    public static Polinom adunare(Polinom P1, Polinom P2) {
        Polinom Rez = new Polinom();
        for (Integer PutereP1 : P1.getTermeni().keySet()) {
            Rez.getTermeni().put(PutereP1, P1.getTermeni().get(PutereP1));
        }
        for (Integer PutereP2 : P2.getTermeni().keySet()) {
            if (Rez.getTermeni().containsKey(PutereP2)) {
                Rez.getTermeni().put(PutereP2, Rez.getTermeni().get(PutereP2) + P2.getTermeni().get(PutereP2));
            } else
                Rez.getTermeni().put(PutereP2, P2.getTermeni().get(PutereP2));
        }
        return Rez;
    }
    public static Polinom scadere(Polinom P1, Polinom P2) {
        Polinom Rez = new Polinom();
        for (Integer PutereP1 : P1.getTermeni().keySet()) {
            Rez.getTermeni().put(PutereP1, P1.getTermeni().get(PutereP1));
        }
        for (Integer PutereP2 : P2.getTermeni().keySet()) {
            if(Rez.getTermeni().get(PutereP2)!=null) {
                Rez.getTermeni().put(PutereP2, Rez.getTermeni().get(PutereP2) - P2.getTermeni().get(PutereP2));
                if(Rez.getTermeni().get(PutereP2)==0.0){
                    Rez.getTermeni().remove(PutereP2);
                }
            }else{
                Rez.getTermeni().put(PutereP2,-P2.getTermeni().get(PutereP2));
            }
        }
        return Rez;
    }
    public static Polinom inmultire(Polinom P1, Polinom P2) {
        Polinom Rez = new Polinom();
        for (Integer PutereP1 : P1.getTermeni().keySet()) {
            for (Integer PutereP2 : P2.getTermeni().keySet()) {
                Integer Putere=PutereP1+PutereP2;
                if(Rez.getTermeni().containsKey(Putere)){
                    Rez.getTermeni().put(Putere,Rez.getTermeni().get(Putere)+P1.getTermeni().get(PutereP1)*P2.getTermeni().get(PutereP2));
                }
                else
                    Rez.getTermeni().put(Putere,P1.getTermeni().get(PutereP1)*P2.getTermeni().get(PutereP2));
            }
        }
        return Rez;
    }
    public static Polinom derivare(Polinom P1) {
        Polinom Rez = new Polinom();
        for (Integer PutereP1 : P1.getTermeni().keySet()) {
            if (PutereP1 - 1 >= 0) {
                Integer Putere = PutereP1 - 1;
                if (Rez.getTermeni().containsKey(Putere)) {
                    Rez.getTermeni().put(Putere, Rez.getTermeni().get(Putere) + P1.getTermeni().get(PutereP1) * PutereP1);
                } else
                    Rez.getTermeni().put(Putere, P1.getTermeni().get(PutereP1) * PutereP1);
            }
        }
        return Rez;
    }
    public static Polinom integrare(Polinom P1) {
        Polinom Rez = new Polinom();
        for (Integer PutereP1 : P1.getTermeni().keySet()) {
            Integer Putere=PutereP1+1;
            double newval=(double)P1.getTermeni().get(PutereP1)/Putere;
            newval=(double)Math.round(newval * 1000d) / 1000d;
           if(Rez.getTermeni().containsKey(Putere))
               Rez.getTermeni().put(Putere,Rez.getTermeni().get(Putere)+newval);
            else
               Rez.getTermeni().put(Putere,newval);
        }
        return Rez;
    }
    public static int detectarePolinom(List<Integer>l1,List<Integer>l2){
        int nrPol=0;
        int contorSize=0;
        while(contorSize<l1.size()&&contorSize<l2.size()){
            if(l1.get(contorSize)<l2.get(contorSize)){
                nrPol=2;                                // pol2=P, pol1=Q
            }
            if(l1.get(contorSize)>l2.get(contorSize)){
                nrPol=1;                                // pol1=P, pol2=Q
            }
            contorSize++;
        }
        if(contorSize<l1.size()&&nrPol==0){
            while(contorSize<l1.size()){
                if(l1.get(contorSize)>-1){
                    nrPol=1;                                // pol1=P, pol2=Q
                }
                contorSize++;
            }
        }
        if(contorSize<l2.size()&&nrPol==0){
            while(contorSize<l2.size()){
                if(l2.get(contorSize)>-1){
                    nrPol=2;                                // pol2=P, pol1=Q
                }
                contorSize++;
            }
        }
        return nrPol;
    }
    public static Polinom impartire(Polinom P1,Polinom P2) {
        Polinom Rez = new Polinom();
        List<Integer> puteriOrdonate1 = new ArrayList<>(P1.getTermeni().keySet());
        Collections.sort(puteriOrdonate1,Collections.reverseOrder());
        List<Integer> puteriOrdonate2 = new ArrayList<>(P2.getTermeni().keySet());
        Collections.sort(puteriOrdonate2,Collections.reverseOrder());
        if(!puteriOrdonate2.isEmpty() && P2.getTermeni().get(puteriOrdonate2.get(0))==0.0)
            Rez.getTermeni().put(-1,0.0);
        else{
            int detectPolinom=Functions.detectarePolinom(puteriOrdonate1,puteriOrdonate2);
            if(detectPolinom==0||detectPolinom==1){
                    while(!puteriOrdonate1.isEmpty() && !puteriOrdonate2.isEmpty() && puteriOrdonate2.get(0)<=puteriOrdonate1.get(0)){
                        Integer putere=puteriOrdonate1.get(0)-puteriOrdonate2.get(0);
                        double coeficient=P1.getTermeni().get(puteriOrdonate1.get(0))/P2.getTermeni().get(puteriOrdonate2.get(0));
                        Rez.getTermeni().put(putere,coeficient);
                        puteriOrdonate1.clear();
                        Polinom Intermediar=new Polinom();
                        for(Integer p:P2.getTermeni().keySet())
                            Intermediar.getTermeni().put(putere+p,coeficient*P2.getTermeni().get(p));
                        P1=Functions.scadere(P1,Intermediar);
                        for(Integer puteriNoi:P1.getTermeni().keySet())
                            puteriOrdonate1.add(puteriNoi);
                        Collections.sort(puteriOrdonate1,Collections.reverseOrder());
                    }
            }
            if(detectPolinom==2){
               Rez=Functions.impartire(P2,P1);
            }
        }
        return Rez;
    }
    public static Polinom getRest(Polinom P1,Polinom P2){
        Polinom Rez=new Polinom();
        Polinom imparte=Functions.impartire(P1,P2);
        List<Integer> puteriOrdonate1 = new ArrayList<>(P1.getTermeni().keySet());
        Collections.sort(puteriOrdonate1,Collections.reverseOrder());
        List<Integer> puteriOrdonate2 = new ArrayList<>(P2.getTermeni().keySet());
        Collections.sort(puteriOrdonate2,Collections.reverseOrder());
        int detectPolinom=Functions.detectarePolinom(puteriOrdonate1,puteriOrdonate2);
            if (detectPolinom == 0 || detectPolinom == 1) {
                Rez = Functions.scadere(P1, inmultire(imparte, P2));
            }
            if (detectPolinom == 2) {
                Rez = Functions.scadere(P2, inmultire(imparte, P1));
            }
            if (Rez.getTermeni().isEmpty())
                Rez.getTermeni().put(0, 0.0);
        return Rez;
        }
    }
