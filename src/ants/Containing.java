package ants;
import core.Ant;

public interface Containing {
    public boolean EncapsulateAnt(Ant one);
    public boolean DeleteAnt(Ant one);
    public Ant ObtainInsect();
}
