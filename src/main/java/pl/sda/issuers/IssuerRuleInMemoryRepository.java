package pl.sda.issuers;


import pl.sda.converter.exceptions.FileConverterException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class IssuerRuleInMemoryRepository implements IssuerRuleRepository {

    private IssuerRule issuerRule;

    @Override
    public List<IssuerRule> getRules() {

        List<IssuerRule> rules = new ArrayList<>();

//        rules.add(new IssuerRule("Visa", "4", 16));
//        rules.add(new IssuerRule("MasterCard", "51", 16));
//        rules.add(new IssuerRule("MasterCard", "52", 16));
//        rules.add(new IssuerRule("MasterCard", "53", 16));
//        rules.add(new IssuerRule("MasterCard", "54", 16));
//        rules.add(new IssuerRule("MasterCard", "55", 16));
//        rules.add(new IssuerRule("AmericanExpress", "34", 15));
//        rules.add(new IssuerRule("AmericanExpress", "37", 15));

        List<Map<String, Object>> result = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\lenovo\\IdeaProjects\\SDA_J19_CreditCardValidator\\src\\main\\Resuorces\\rules.csv"))) {
            String firstLine = bufferedReader.readLine();
            String[] headers = firstLine.split(";");

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] tokens = line.split(";");

                Map<String, Object> record = new LinkedHashMap<>();
                for (int i = 0; i < headers.length; i++ ){
                    record.put(headers[i], tokens[i]);
                }
                result.add(record);
            }

        } catch (FileNotFoundException e) {
            throw new FileConverterException("Nie odnalezion pliku");
        } catch (IOException e) {
            throw new FileConverterException("Wystąpił błąd w trakcie przetwarzania pliku", e);
        }

        rules = result.stream()
                .map(x -> new IssuerRule(x.get("name").toString(),
                x.get("prefix").toString(), Integer.parseInt(x.get("length").toString())))
                .collect(Collectors.toList());

        return rules;

    }


}