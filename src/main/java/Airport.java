import org.apache.hadoop.io.Writable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class Airport implements Writable {
    private int counter;
    private long timestamp;

    @Override
    public void write(DataOutput out) throws IOException {
        out.writeInt(counter);
        out.writeLong(timestamp);
    }

    @Override
    public void readFields(DataInput in) throws IOException {
        counter = in.readInt();
        timestamp = in.readLong();
    }

    public static Airport read(DataInput in) throws IOException {
        Airport w = new Airport();
        w.readFields(in);
        return w;
    }
}
