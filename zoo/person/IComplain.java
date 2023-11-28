package zoo.person;

import zoo.exceptions.SpeakingException;

public interface IComplain {

    void complain(String complainString) throws SpeakingException;

}
