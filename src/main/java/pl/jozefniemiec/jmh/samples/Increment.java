package pl.jozefniemiec.jmh.samples;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Thread)
public class Increment {

    private int integer;

    @Benchmark
    public int increasePost(){
        return integer++;
    }

    @Benchmark
    public int increasePre(){
        return ++integer;
    }
}
