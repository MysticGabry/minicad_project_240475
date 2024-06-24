package commands;

import java.util.List;


//Quest'interfaccia corrisponde al design pattern Command, insieme a tutte le classi che la implementano
public interface GenericCommand {

    //la list di String contiene i token, così ogni implementazione ha facile accesso ai dati che servono per fare i vari execute
    default void execute(List<String> tokensList) {

    }
}