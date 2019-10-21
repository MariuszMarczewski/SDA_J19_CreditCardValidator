package pl.sda.issuers;

import java.util.Map;

public class MapToIssuerRuleAdapter extends IssuerRule {

    private Map<String, Object> ruleRaw;

    public MapToIssuerRuleAdapter(Map<String, Object> ruleRaw) {
        this.ruleRaw = ruleRaw;
    }

    @Override
    public String getName() {
        return ruleRaw.get("name").toString();
    }

    @Override
    public String getPrefix() {
        return ruleRaw.get("prefix").toString();
    }

    @Override
    public int getLength() {
        return Integer.parseInt(ruleRaw.get("length").toString());
    }

}
