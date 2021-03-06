package parser.seed.transducer;

import model.seed.transducer.SeedTransducer;
import parser.seed.transducer.process.SeedTransducerParsingResult;
import parser.seed.transducer.process.SeedTransducerConverter;

import java.io.File;

/**
 * Utils class and entry point to the {@link SeedTransducer} parser extracting data from the given JSON file.
 * @author Chloe GUILBAUD &amp Maël MAINCHAIN
 */
public abstract class SeedTransducerParser {

    public static SeedTransducerParsingResult parse(String jsonFilePath) {
        return parse(new File(jsonFilePath));
    }

    public static SeedTransducerParsingResult parse(File jsonFile) {
        return SeedTransducerConverter.convert(jsonFile);
    }

}
