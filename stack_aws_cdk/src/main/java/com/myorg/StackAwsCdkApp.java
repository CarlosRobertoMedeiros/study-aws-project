package com.myorg;

import software.amazon.awscdk.App;
import software.amazon.awscdk.Environment;
import software.amazon.awscdk.StackProps;

import java.util.Arrays;

public class StackAwsCdkApp {
    public static void main(final String[] args) {
        App app = new App();

        StackAwsVpcStack stackAwsVpcStack =  new StackAwsVpcStack(app,"Vpc");

        StackAwsClusterStack stackAwsClusterStack = new StackAwsClusterStack(app, "Cluster", stackAwsVpcStack.getVpc());
        stackAwsClusterStack.addDependency(stackAwsVpcStack);

        StackAwsService01Stack service01Stack = new StackAwsService01Stack(app, "Service01", stackAwsClusterStack.getCluster());
        service01Stack.addDependency(stackAwsClusterStack);



        app.synth();

//        new StackAwsCdkStack(app, "StackAwsCdkStack", StackProps.builder()
//                // If you don't specify 'env', this stack will be environment-agnostic.
//                // Account/Region-dependent features and context lookups will not work,
//                // but a single synthesized template can be deployed anywhere.
//
//                // Uncomment the next block to specialize this stack for the AWS Account
//                // and Region that are implied by the current CLI configuration.
//                /*
//                .env(Environment.builder()
//                        .account(System.getenv("CDK_DEFAULT_ACCOUNT"))
//                        .region(System.getenv("CDK_DEFAULT_REGION"))
//                        .build())
//                */
//
//                // Uncomment the next block if you know exactly what Account and Region you
//                // want to deploy the stack to.
//                /*
//                .env(Environment.builder()
//                        .account("123456789012")
//                        .region("us-east-1")
//                        .build())
//                */
//
//                // For more information, see https://docs.aws.amazon.com/cdk/latest/guide/environments.html
//                .build());
//
//        app.synth();
    }
}

