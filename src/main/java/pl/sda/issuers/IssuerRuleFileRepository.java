package pl.sda.issuers;

import pl.sda.converter.SDAFileReader;
import pl.sda.converter.factories.FileReaderFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


    public class IssuerRuleFileRepository implements IssuerRuleRepository {

        private String filePath;

        public IssuerRuleFileRepository (String filePath) {
            this.filePath = filePath;
        }

        @Override
        public List<IssuerRule> getRules() {
            FileReaderFactory factory = new FileReaderFactory();
            SDAFileReader reader = factory.produce(filePath);
            List<Map<String, Object>> rulesRaw = reader.read(filePath);

//        List<IssuerRule> result = rulesRaw.stream()
//                .map(x -> new IssuerRule(x.get("name").toString(), x.get("prefix").toString(), Integer.parseInt(x.get("length").toString())))
//                .collect(Collectors.toList());


            return rulesRaw.stream().map(x -> new MapToIssuerRuleAdapter(x)).collect(Collectors.toList());
        }

    }

