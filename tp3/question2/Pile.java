package question2;

import question1.PilePleineException;
import question1.PileVideException;

public class Pile implements PileI {
    public final static int TAILLE_PAR_DEFAUT = 5;
    private Object[] zone;
    private int ptr;

    public Pile(int taille) {
        if (taille < 0)
            taille = TAILLE_PAR_DEFAUT;
        this.zone = new Object[taille];
        this.ptr = 0;
    }

    public Pile() {
        this(TAILLE_PAR_DEFAUT);
    }

    public void empiler(Object o) throws PilePleineException {
        if (estPleine())
            throw new PilePleineException();
        this.zone[this.ptr] = o;
        this.ptr++;
    }

    public Object depiler() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        this.ptr--;
        return zone[ptr];
    }

    public Object sommet() throws PileVideException {
        if (estVide())
            throw new PileVideException();
        return this.zone[ptr-1];
    }

    public int capacite() {
        return this.zone.length;
    }

    public int taille() {
        if(estVide())
            ptr = 0;
        return this.ptr;
    }

    public boolean estVide() {
        return this.ptr == 0;
    }

    public boolean estPleine() {
        return this.ptr == this.zone.length;
    }

    public boolean equals(Object o) {
        if(this == o)
            return true;    
        if(!(o instanceof Pile))
            return false;
        Pile p1 = (Pile)o;
        if (p1.taille() == this.taille() && p1.capacite() == this.capacite()){
            boolean isEqual = false;
            for(int i=0; i<zone.length; i++)
            {
                boolean equal = false;
                Object temp = zone[i];
                for(int j=0; j<zone.length; j++)
                {
                    if(temp == p1.zone[i])
                        equal = true; 
                }
                if(equal)
                    isEqual = true;
                else
                    return false;
            }
            return true;
        }                
        return false;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public String toString() {
        StringBuffer sb = new StringBuffer("[");
        for (int i = ptr - 1; i >= 0; i--) {
            sb.append(String.valueOf(zone[i]));
            if (i > 0)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();    
    }
}