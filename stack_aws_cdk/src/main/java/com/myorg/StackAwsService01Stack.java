package com.myorg;

import software.amazon.awscdk.RemovalPolicy;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.ecs.AwsLogDriverProps;
import software.amazon.awscdk.services.ecs.Cluster;
import software.amazon.awscdk.services.ecs.ContainerImage;
import software.amazon.awscdk.services.ecs.LogDriver;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedFargateService;
import software.amazon.awscdk.services.ecs.patterns.ApplicationLoadBalancedTaskImageOptions;
import software.amazon.awscdk.services.logs.LogGroup;
import software.constructs.Construct;
// import software.amazon.awscdk.Duration;
// import software.amazon.awscdk.services.sqs.Queue;

public class StackAwsService01Stack extends Stack {
    public StackAwsService01Stack(final Construct scope, final String id, Cluster cluster) {
        this(scope, id, null, cluster);
    }

    public StackAwsService01Stack(final Construct scope, final String id, final StackProps props,Cluster cluster ) {
        super(scope, id, props);

        ApplicationLoadBalancedFargateService service01 =
                ApplicationLoadBalancedFargateService.Builder
                        .create(this, "ALB01")
                        .serviceName("service-01")
                        .cluster(cluster)
                        .cpu(512)
                        .memoryLimitMiB(1024)
                        .desiredCount(2) //Ao subir executa com 2 Instâncias
                        .listenerPort(8080)
                        .taskImageOptions(
                                ApplicationLoadBalancedTaskImageOptions.builder()
                                        .containerName("aws_project01")
                                        .image(ContainerImage.fromRegistry("carlosmedeiroslima/aws_project01:0.0.1-SNAPSHOT"))
                                        .containerPort(8080)
                                        .logDriver(LogDriver.awsLogs(AwsLogDriverProps.builder()
                                                        .logGroup(LogGroup.Builder.create(this, "Service01LogGroup")
                                                                .logGroupName("Service01")
                                                                .removalPolicy(RemovalPolicy.DESTROY)
                                                                .build())
                                                        .streamPrefix("Service01")
                                                        .build()))
                                       .build())
                        .publicLoadBalancer(true)
                        .build();

    }
}
