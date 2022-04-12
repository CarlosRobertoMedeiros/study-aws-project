package com.myorg;

import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ec2.Vpc;
import software.constructs.Construct;
// import software.amazon.awscdk.Duration;
// import software.amazon.awscdk.services.sqs.Queue;

public class StackAwsVpcStack extends Stack {

    private Vpc vpc;

    public StackAwsVpcStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public StackAwsVpcStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        vpc = Vpc.Builder.create(this, "Vpc01")
                .maxAzs(6)
                .natGateways(0) //Evita custo
                .build();


        // The code that defines your stack goes here

        // example resource
        // final Queue queue = Queue.Builder.create(this, "StackAwsCdkQueue")
        //         .visibilityTimeout(Duration.seconds(300))
        //         .build();
    }

    public Vpc getVpc() {
        return vpc;
    }
}
