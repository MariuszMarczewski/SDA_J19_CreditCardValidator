package pl.sda.issuers;

public class IssuerRule {
    private String name;
    private String prefix;
    private int length;

    public IssuerRule() {

    }

    public IssuerRule(String name, String prefix, int length) {
        this.name = name;
        this.prefix = prefix;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}