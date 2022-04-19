package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.amazon.awscdk.services.ecs.Cluster;
import software.constructs.Construct;
// import software.amazon.awscdk.Duration;
// import software.amazon.awscdk.services.sqs.Queue;

public class StackAwsClusterStack extends Stack {
    private Cluster cluster;

    public StackAwsClusterStack(final Construct scope, final String id, Vpc vpc) {
        this(scope, id, null, vpc);
    }

    public StackAwsClusterStack(final Construct scope, final String id, final StackProps props, Vpc vpc) {
        super(scope, id, props);

        cluster = Cluster.Builder.create(this, id)
                .clusterName("cluster-01")
                .vpc(vpc)
                .build();


        // The code that defines your stack goes here

        // example resource
        // final Queue queue = Queue.Builder.create(this, "StackAwsCdkQueue")
        //         .visibilityTimeout(Duration.seconds(300))
        //         .build();
    }

    public Cluster getCluster() {
        return cluster;
    }
}
