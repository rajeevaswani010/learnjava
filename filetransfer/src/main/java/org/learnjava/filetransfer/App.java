package org.learnjava.filetransfer;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // Create Options object
        Options options = new Options();

        // Add option for input file
        Option input = new Option("i", "input", true, "input file path");
        input.setRequired(true);
        options.addOption(input);

        // Add option for output file
        Option output = new Option("o", "output", true, "output file path");
        output.setRequired(true);
        options.addOption(output);

        // Add option for verbose mode
        Option verbose = new Option("v", "verbose", false, "enable verbose mode");
        verbose.setRequired(false);
        options.addOption(verbose);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            CommandLine cmd = parser.parse(options, args);

            String inputFilePath = cmd.getOptionValue("input");
            String outputFilePath = cmd.getOptionValue("output");
            boolean isVerbose = cmd.hasOption("verbose");

            // Print parsed options
            System.out.println("Input file: " + inputFilePath);
            System.out.println("Output file: " + outputFilePath);
            if (isVerbose) {
                System.out.println("Verbose mode is enabled.");
            }

            // Add your application logic here
            // For example, read the input file, process it, and write to the output file

        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("utility-name", options);

            System.exit(1);
        }    
    }
}
