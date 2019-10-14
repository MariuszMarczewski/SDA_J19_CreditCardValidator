package pl.sda.issuers;


import java.util.*;


public class IssuerRuleInMemoryRepository implements IssuerRuleRepository {

    private IssuerRule issuerRule;

    @Override
    public List<IssuerRule> getRules() {

        List<IssuerRule> rules = new ArrayList<>();

        rules.add(new IssuerRule("Visa", "4", 16));
        rules.add(new IssuerRule("MasterCard", "51", 16));
        rules.add(new IssuerRule("MasterCard", "52", 16));
        rules.add(new IssuerRule("MasterCard", "53", 16));
        rules.add(new IssuerRule("MasterCard", "54", 16));
        rules.add(new IssuerRule("MasterCard", "55", 16));
        rules.add(new IssuerRule("AmericanExpress", "34", 15));
        rules.add(new IssuerRule("AmericanExpress", "37", 15));

        return rules;
    }


}