package pl.sda.verifiers;

public interface Validator {
    ValidationResult validate(String cardNo);
}