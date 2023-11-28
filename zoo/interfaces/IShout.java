package zoo.interfaces;

import zoo.exceptions.SpeakingException;

public interface IShout {

    void shout(String shoutString) throws SpeakingException;

}
