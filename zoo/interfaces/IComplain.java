package zoo.interfaces;

import zoo.Zoo;
import zoo.exceptions.SpeakingException;

public interface IComplain {

    void complain(String complainString, Zoo zoo) throws SpeakingException;

}
