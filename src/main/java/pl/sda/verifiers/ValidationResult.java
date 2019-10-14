package pl.sda.verifiers;

public class ValidationResult {
    private String issuerName;
    private boolean checksumVerified;

    public ValidationResult(String issuerName, boolean checksumVerified) {
        this.issuerName = issuerName;
        this.checksumVerified = checksumVerified;
    }

    public String getIssuerName() {
        return issuerName;
    }

    public void setIssuerName(String issuerName) {
        this.issuerName = issuerName;
    }

    public boolean isChecksumVerified() {
        return checksumVerified;
    }

    public void setChecksumVerified(boolean checksumVerified) {
        this.checksumVerified = checksumVerified;
    }
}
