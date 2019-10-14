package pl.sda.issuers;

import java.util.List;

public class IssuerDetector {

    private IssuerRuleRepository repository = new IssuerRuleInMemoryRepository();


    public IssuerDetector() {
        repository = new IssuerRuleInMemoryRepository();
    }

    public IssuerDetector(IssuerRuleRepository repository) {
        this.repository = repository;
    }

    public String detect(String cardNo) {

        List<IssuerRule> rules = repository.getRules();

        String result = "UNKNOWN";
        for (IssuerRule issuerRule: rules) {
            if (cardNo.startsWith(issuerRule.getPrefix()) && cardNo.length() == issuerRule.getLength()) {
                result = issuerRule.getName();
                break;
            }
        }

        return result;
    }

}