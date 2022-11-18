package org.example;
import java.math.BigInteger;
import java.util.Optional;

import conflux.web3j.Cfx;
import conflux.web3j.response.Transaction;

public class App {
    public static void main(String[] args) throws Exception {
        int retry = 3;
        int intervalMills = 1000;  // interval(milliseconds) between retry
        Cfx cfx = Cfx.create("https://test.confluxrpc.com", retry, intervalMills);
        BigInteger epoch = cfx.getEpochNumber().sendAndGet();
        Optional<Transaction> transaction = cfx.getTransactionByHash("0xd82f7373515843ec1be5385cbf67cce7b0eefca64b70721c68042563760931e7").sendAndGet();
        System.out.println("Current epoch: " + epoch);
        System.out.println(transaction.get());
    }
}


// https://developer.confluxnetwork.org/sdks-and-tools/en/conflux_sdks/
// https://github.com/conflux-chain/java-conflux-sdk#apache-maven
// https://testnet.confluxscan.io/transaction/0xd82f7373515843ec1be5385cbf67cce7b0eefca64b70721c68042563760931e7
// https://testnet.confluxscan.io/address/cfxtest:acbjc3266d1ns2p2hcw5yh3h4j4j6d93ua7zr40749
// https://mvnrepository.com/artifact/io.github.conflux-chain/conflux.web3j


