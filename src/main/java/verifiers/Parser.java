package verifiers;

import costants.TokenSigns;
import exceptions.UnknownCommandException;

import java.util.ArrayList;
import java.util.List;


public class Parser {
    private List<String> semiTokensList;
    private List<String> finalTokensList;

    public Parser(List<String> semiTokensList) {
        this.semiTokensList = semiTokensList;
        finalTokensList = generateFinalTokens(semiTokensList);
    }

    public List<String> generateFinalTokens(List<String> semiTokensList) {
        List<String> tokensList = new ArrayList<>();
        for (int i = 0; i < semiTokensList.size(); i++) {
            if (semiTokensList.get(i).equals(TokenSigns.LPAR)) {
                StringBuilder temp = new StringBuilder(100);
                while (!semiTokensList.get(i).equals(TokenSigns.RPAR)) {
                    temp.append(semiTokensList.get(i));
                    i++;
                }
                temp.append(TokenSigns.RPAR);
                tokensList.add(temp.toString());
            } else {
                tokensList.add(semiTokensList.get(i));
            }
            List<String> checkList = TokenSigns.commandsToken();
            try {
                if (!checkList.contains(tokensList.getFirst())
                    && !tokensList.getFirst().equalsIgnoreCase("break")
                    && !tokensList.getFirst().equalsIgnoreCase("stop"))
                        throw new UnknownCommandException(tokensList.getFirst());
            } catch (UnknownCommandException e) {
                throw new RuntimeException(e);
            }
        }
        return tokensList;
    }
}
