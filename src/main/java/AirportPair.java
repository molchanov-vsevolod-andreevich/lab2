import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

//import org.apache.commons.csv.CSVParser;
//import org.apache.commons.csv.CSVFormat;
//import org.apache.commons.csv.CSVRecord;
//import java.io.File;
//import java.nio.charset.StandardCharsets;
//import java.util.List;

public class AirportPair implements WritableComparable<AirportPair> {
    private Text AIRPORT_ID;
    private IntWritable INSERT_ID;

    public AirportPair(Text airportID, IntWritable insertID) {
        AIRPORT_ID = airportID;
        INSERT_ID = insertID;
    }

    public AirportPair(Text airportID, int insertID) {
        AIRPORT_ID = airportID;
        INSERT_ID = new IntWritable(insertID);
    }

    public AirportPair(String airportID, IntWritable insertID) {
        AIRPORT_ID = new Text(airportID);
        INSERT_ID = insertID;
    }

    public AirportPair(String airportID, int insertID) {
        AIRPORT_ID = new Text(airportID);
        INSERT_ID = new IntWritable(insertID);
    }

    public Text getAirportID() {
        return AIRPORT_ID;
    }

    public IntWritable getInsertID() {
        return INSERT_ID;
    }

    @Override
    public void write(DataOutput out) throws IOException {
        AIRPORT_ID.write(out);
        INSERT_ID.write(out);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        AIRPORT_ID.readFields(in);
        INSERT_ID.readFields(in);
    }

    @Override
    public int compareTo(AirportPair o) {
        int res = AIRPORT_ID.compareTo(o.AIRPORT_ID);
        if (res == 0) {
            
        }
        return 0;
    }
}
