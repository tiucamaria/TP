package Model;
import java.util.*;
import java.util.regex.*;
public class Polinom {
    private HashMap<Integer, Double>Termeni;
    public Polinom(){
        Termeni = new HashMap<>();
    }
    public Polinom(String Pol) {
        Termeni = new HashMap<>();
        String plusMinus = Pol.replace("-", "+-");
        Pattern pattern = Pattern.compile("([+-]?[^-+]+)");
        Matcher matcher = pattern.matcher(plusMinus);
        while(matcher.find()){
            String monom =matcher.group();
            String[] coef = monom.split("([*a-zA-Z^])");
            if (coef.length == 4) {
                Termeni.put(Integer.valueOf(coef[3]), Double.valueOf(coef[0]));
            }
            if (coef.length == 3 ) {
                if (coef[0].equals("-"))
                    Termeni.put(Integer.valueOf(coef[2]), (double) -1);
                else
                    Termeni.put(Integer.valueOf(coef[2]), 1.0);
            }
            if (coef.length == 1) {
                if (coef[0].equals("")) continue;
                else {
                    char c = monom.charAt(monom.length()-1);
                    if (c == 'x'&&!(coef[0].equals("-"))&&!(coef[0].equals("+"))) {
                        Termeni.put(1,Double.valueOf(coef[0]));
                    } else {
                        if (coef[0].equals("-"))
                            Termeni.put(1, (double) -1);
                        else {
                            if (coef[0].equals("+"))
                                Termeni.put(1, (double) 1);
                            else
                                Termeni.put(0, Double.valueOf(coef[0]));
                        }
                    }
                }
            }
            if (coef.length == 0)
                    Termeni.put(1, (double) 1);
        }
    }
    public HashMap<Integer, Double> getTermeni() {
        return Termeni;
    }
    public String toString(){
        String rez="";
        List<Integer> puteriOrdonate = new ArrayList<Integer>(this.Termeni.keySet());
        Collections.sort(puteriOrdonate,Collections.reverseOrder());
        if(this.Termeni.containsKey(-1))
            rez+="undefined";
        else {
            int verFirst = 0;
            for (Integer Putere : puteriOrdonate) {
                if (rez != null && this.Termeni.get(Putere) > 0 && verFirst != 0) {
                    rez += "+";
                    verFirst++;
                }
                if (Putere != 1) {
                    if (Putere == 0 && this.Termeni.get(Putere) != 0)
                        rez += this.Termeni.get(Putere);
                    else {
                        if (this.Termeni.get(Putere) == 1 && this.Termeni.get(Putere) != 0)
                            rez += "x^" + Putere;
                        if (this.Termeni.get(Putere) == -1 && this.Termeni.get(Putere) != 0)
                            rez += "-x^" + Putere;
                        if (this.Termeni.get(Putere) != 1 && this.Termeni.get(Putere) != -1 && Putere != 0 && this.Termeni.get(Putere) != 0)
                            rez += this.Termeni.get(Putere) + "*x^" + Putere;
                    }
                } else {
                    if (this.Termeni.get(Putere) == 1 && this.Termeni.get(Putere) != 0)
                        rez += "x";
                    if (this.Termeni.get(Putere) == -1 && this.Termeni.get(Putere) != 0)
                        rez += "-x";
                    if (this.Termeni.get(Putere) != 1 && this.Termeni.get(Putere) != -1 && this.Termeni.get(Putere) != 0)
                        rez += this.Termeni.get(Putere) + "*x";
                }
                verFirst++;
            }
            boolean coefAllZero = true;
            for (Integer Putere : puteriOrdonate) {
                if (!this.Termeni.get(Putere).equals(0.0))
                    coefAllZero = false;
            }
            if (coefAllZero)
                rez += "0.0";
        }
        return rez;
    }
}




