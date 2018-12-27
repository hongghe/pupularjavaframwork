package com.hongghe.grpcserver.service;

import sun.jvm.hotspot.HelloWorld;

/**
 * @author hongghe 2018/12/27
 */
public class HelloWorldService extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public void welcome(HelloWorld.NameRequest request, StreamObserver<HelloWorld.EchoResponse> responseObserver) {
        HelloWorld.EchoResponseOrBuilder echoResponseOrBuilder = HelloWorld.EchoResponse.newBuilder();
        ((HelloWorld.EchoResponse.Builder) echoResponseOrBuilder).setMergename("welcome " + request.getName());
        responseObserver.onNext(((HelloWorld.EchoResponse.Builder) echoResponseOrBuilder).build());
        responseObserver.onCompleted();
    }
}
