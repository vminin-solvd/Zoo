package com.solvd.zoo.interfaces;

import com.solvd.zoo.Zoo;
import com.solvd.zoo.exceptions.SpeakingException;

public interface IComplain {

    void complain(String complainString, Zoo zoo) throws SpeakingException;

}
