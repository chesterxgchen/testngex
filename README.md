<h2>
TestNGEx -- TestNG extension
</h2>

Chester Chen

<h3>
Introduction
</h3>

This project is intended to a set of extensions to the existing testNG framework.

The extension includes Listeners etc.Currently, I only have one listener: ConsoleReporter.


ConsoleReporter reports the methods being tested and print the results and exceptions directly
to the console.

This is useful when one is trying to debug a problem.


Without the ConsoleReporter, the sample test output will be like the following:
<pre><code>
run-test:
   [testng] [TestNG] Running:
   [testng]   /disk2/projects/testngex/src/test/testng.xml
   [testng]
   [testng] Sample.failureTest
   [testng] Sample.sampleTest1
   [testng] Sample.sampleTest2
   [testng] Sample.sampleTest3
   [testng]
   [testng] ===============================================
   [testng] testng-ext
   [testng] Total tests run: 4, Failures: 1, Skips: 0
   [testng] ===============================================
   [testng]
   [testng] The tests failed.
 </code></pre>

We know 4 tests were run and 1 failed, but we don't know which one failed and why failed.
To figure out the result, we need to run the report and open up the output files to example.

Here is the output of the same example with the ConsoleReporter:
 <pre><code>

  Running:
     [testng]   /disk2/projects/testngex/src/test/testng.xml
     [testng]
     [testng] Sample.failureTest
     [testng] Sample.sampleTest1
     [testng] Sample.sampleTest2
     [testng] Sample.sampleTest3
     [testng]
     [testng] ===============================================
     [testng] Suite:   testng-ext
     [testng] ===============================================
     [testng] Test: test status:
     [testng]
     [testng]  1)  method-name:com.xiaoguangchen.testngex.Sample.sampleTest3 passed
     [testng]  2)  method-name:com.xiaoguangchen.testngex.Sample.sampleTest2 passed
     [testng]  3)  method-name:com.xiaoguangchen.testngex.Sample.sampleTest1 passed
     [testng]  4)  method-name:com.xiaoguangchen.testngex.Sample.failureTest failed
     [testng]   FAILED: Sample.failureTest()[pri:0, instance:com.xiaoguangchen.testngex.Sample@7946738]
     [testng]   java.lang.RuntimeException: This should failure
     [testng] 	at com.xiaoguangchen.testngex.Sample.failureTest(Sample.java:28)
     [testng] 	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
     [testng] 	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
     [testng] 	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
     [testng] 	at java.lang.reflect.Method.invoke(Method.java:601)
     [testng] 	at org.testng.internal.MethodInvocationHelper.invokeMethod(MethodInvocationHelper.java:80)
     [testng] 	at org.testng.internal.Invoker.invokeMethod(Invoker.java:714)
     [testng] 	at org.testng.internal.Invoker.invokeTestMethod(Invoker.java:901)
     [testng] 	at org.testng.internal.Invoker.invokeTestMethods(Invoker.java:1231)
     [testng] 	at org.testng.internal.TestMethodWorker.invokeTestMethods(TestMethodWorker.java:127)
     [testng] 	at org.testng.internal.TestMethodWorker.run(TestMethodWorker.java:111)
     [testng] 	at org.testng.TestRunner.privateRun(TestRunner.java:767)
     [testng] 	at org.testng.TestRunner.run(TestRunner.java:617)
     [testng] 	at org.testng.SuiteRunner.runTest(SuiteRunner.java:334)
     [testng] 	at org.testng.SuiteRunner.runSequentially(SuiteRunner.java:329)
     [testng] 	at org.testng.SuiteRunner.privateRun(SuiteRunner.java:291)
     [testng] 	at org.testng.SuiteRunner.run(SuiteRunner.java:240)
     [testng] 	at org.testng.SuiteRunnerWorker.runSuite(SuiteRunnerWorker.java:52)
     [testng] 	at org.testng.SuiteRunnerWorker.run(SuiteRunnerWorker.java:86)
     [testng] 	at org.testng.TestNG.runSuitesSequentially(TestNG.java:1198)
     [testng] 	at org.testng.TestNG.runSuitesLocally(TestNG.java:1123)
     [testng] 	at org.testng.TestNG.run(TestNG.java:1031)
     [testng] 	at org.testng.TestNG.privateMain(TestNG.java:1338)
     [testng] 	at org.testng.TestNG.main(TestNG.java:1307)
     [testng]
     [testng]
     [testng]
     [testng] ===============================================
     [testng] testng-ext
     [testng] Total tests run: 4, Failures: 1, Skips: 0
     [testng] ===============================================
     [testng]
     [testng] The tests failed.

</code></pre>
<h3>
Setup
</h3>

    1) Put the testngex-<version>.jar into your classpath or
       put the com.xiaoguangchen.testngex.ConsoleReporter.class in your classpath.

    2) In testng ant task, add reporter:

        <testng classpathref="test.classpath"
                    outputdir="${test.output}"
                    reporter="com.xiaoguangchen.testngex.ConsoleReporter">
                <xmlfileset dir="${basedir}" includes="${test.dir}/testng.xml"/>


     that's it.

<h3>
Sample Project
</h3>

     To see how this is used in this project. You can checkout this project.
      make sure you have the java and Ant setup. Go to the project home, type
<pre><code>
      ant run-test
</code></pre>
      which will download the ivy, and then retrieve the testng, build the project
      and then run the sample testng tests.

      you should see the same output shown above.








