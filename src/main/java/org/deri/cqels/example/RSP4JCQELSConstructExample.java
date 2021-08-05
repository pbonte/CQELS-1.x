package org.deri.cqels.example;

import org.apache.commons.rdf.api.Graph;
import org.deri.cqels.rsp4j.CQELSEngineRSP4J;
import org.streamreasoning.rsp4j.api.querying.ContinuousQuery;
import org.streamreasoning.rsp4j.api.querying.ContinuousQueryExecution;
import org.streamreasoning.rsp4j.api.stream.data.DataStream;
import org.streamreasoning.rsp4j.debs2021.utils.StreamGenerator;
import org.streamreasoning.rsp4j.io.DataStreamImpl;
import org.streamreasoning.rsp4j.yasper.querying.operators.r2r.Binding;

public class RSP4JCQELSConstructExample {

    public static void main(String[] args) throws InterruptedException {
        // Setup the stream generator
        StreamGenerator generator = new StreamGenerator();
        DataStream<Graph> inputStream = generator.getStream("http://test/stream");
        DataStream<Graph> outputStream = new DataStreamImpl<>("http://out/stream");


        String query1 = "CONSTRUCT{?s ?p ?o} WHERE {"
                + "STREAM <http://test/stream> [RANGE 15s] {?s ?p ?o .}"
                + "}";


        CQELSEngineRSP4J cqels = new CQELSEngineRSP4J();
        cqels.register(inputStream);
        cqels.setConstructOutput(outputStream);

        ContinuousQuery<Graph, Binding, Binding, Graph> cq = cqels.parseConstruct(query1);

        ContinuousQueryExecution<Graph, Binding, Binding, Graph> cqe = cqels.parseConstruct(cq);


        outputStream.addConsumer((el,ts)->System.out.println(el + " @ " + ts));

        generator.startStreaming();
        Thread.sleep(20_000);
        generator.stopStreaming();
    }
}
