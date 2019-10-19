import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.mapreduce.Mapper;

public class AirportMapper extends Mapper<LongWritable, Text, AirportPair, Text> {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        System.out.println("Two: " + key);
        CSVParser parser = CSVParser.parse(value.toString(), CSVFormat.RFC4180);
        for (CSVRecord csvRecord : parser) {
            context.write(new AirportPair(csvRecord.get(0), 0), new Text(csvRecord.get(1)));
        }
    }
}
