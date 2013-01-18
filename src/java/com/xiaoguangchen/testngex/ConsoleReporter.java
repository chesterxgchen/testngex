package com.xiaoguangchen.testngex;

import org.testng.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Map;

/**
 *
 * @author Chester Chen (Xiaoguang Chen)
 * Console Reporter:  directly output to Console
 *
 */

public class ConsoleReporter implements ISuiteListener {

  public void onStart(ISuite suite) {

  }

  public void onFinish(ISuite context) {
      logResults(context);
  }

  private void logResults(ISuite context) {

      Map<String, ISuiteResult> results = context.getResults();

      StringBuilder sb = new StringBuilder();

      for (String name : results.keySet()) {

        ISuiteResult sr = results.get(name);
        ITestContext tc = sr.getTestContext();

        sb.append("\n===============================================\n");
        sb.append("Suite:   ").append(context.getName());
        sb.append("\n===============================================\n");
        sb.append("Test: ").append(tc.getName()).append(" status:").append("\n\n");

        int i =1;
        for (ITestResult m : tc.getPassedTests().getAllResults()) {

          sb.append(" ").append(i++).append(")");
		  sb.append("  method-name:").append(m.getMethod().getRealClass().getName()).append(".").append(m.getMethod().getMethodName()).append(" passed").append("\n");
        }

        for (ITestResult m : tc.getFailedTests().getAllResults()) {
          sb.append(" ").append(i++).append(")");
          sb.append("  method-name:").append(m.getMethod().getRealClass().getName()).append(".").append(m.getMethod().getMethodName()).append(" failed").append("\n");

          Throwable ex = m.getThrowable();
          sb.append("  FAILED: ").append(m.getMethod()).append("\n  ");

            if (ex != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                PrintWriter writer = new PrintWriter(baos);
                ex.printStackTrace(writer);
                writer.flush();
                writer.close();
                sb.append(baos.toString()).append("\n");
            }

        }
    }

    System.out.println(sb.toString());
 }

}
