package org.deri.cqels.rsp4j;

import com.hp.hpl.jena.query.Query;
import org.apache.commons.rdf.api.Graph;
import org.streamreasoning.rsp4j.api.operators.r2r.RelationToRelationOperator;
import org.streamreasoning.rsp4j.api.operators.r2s.RelationToStreamOperator;
import org.streamreasoning.rsp4j.api.operators.s2r.execution.assigner.StreamToRelationOp;
import org.streamreasoning.rsp4j.api.operators.s2r.syntax.WindowNode;
import org.streamreasoning.rsp4j.api.querying.Aggregation;
import org.streamreasoning.rsp4j.api.querying.ContinuousQuery;
import org.streamreasoning.rsp4j.api.secret.time.Time;
import org.streamreasoning.rsp4j.api.stream.data.DataStream;
import org.streamreasoning.rsp4j.yasper.querying.operators.r2r.Binding;

import java.util.List;
import java.util.Map;

public class CQELSConstructQueryRSP4j extends CQELSAbstractQuery<Graph> {


    public CQELSConstructQueryRSP4j(Query query){
        super(query);
    }



}
