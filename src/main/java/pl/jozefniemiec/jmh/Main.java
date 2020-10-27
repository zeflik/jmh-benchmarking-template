package pl.jozefniemiec.jmh;

import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import pl.jozefniemiec.jmh.samples.Increment;

public class Main {
    public static void main(String[] args) throws IOException, RunnerException {
        Options opt = new OptionsBuilder()
                .include(Increment.class.getSimpleName())
                .warmupIterations(3)
                .measurementIterations(5)
                .measurementTime(TimeValue.seconds(2))
                .warmupTime(TimeValue.seconds(2))
                .timeUnit(TimeUnit.NANOSECONDS)
                .forks(1)
                .mode(Mode.AverageTime)
                .warmupForks(0)
                .build();
        new Runner(opt).run();
    }
}
