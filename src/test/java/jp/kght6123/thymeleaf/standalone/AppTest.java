package jp.kght6123.thymeleaf.standalone;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.testing.templateengine.engine.TestExecutor;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Rule
    public TestName testName = new TestName();

    private TemplateEngine templateEngine;

    @Before
    public void init() {
        this.templateEngine = App.createTemplateEngine();
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void ThymeleafのTestingライブラリを使ったテストのサンプル() {
        final TestExecutor executor = new TestExecutor();
        executor.execute("classpath:thtest/sample.thtest");
        assertTrue(executor.isAllOK());
    }

    @Test
    public void Thymeleafの既存テンプレートを使って部分一致で正常性を判定するテストのサンプル() {
        final Context ct = new Context();
        ct.setVariable("name", "foo");
        ct.setVariable("date", LocalDateTime.now().toString());
        final String result = this.templateEngine.process("greeting.html", ct);
        assertTrue(result.contains("foo"));
        writeSnapshot(testName.getMethodName(), result);
    }

    @Test
    public void Thymeleafの既存テンプレートを使って完全一致で正常性を判定するテストのサンプル() {
        final Context ct = new Context();
        ct.setVariable("name", "foo");
        ct.setVariable("date", "2022-08-17T09:44:13.481551");
        final String result = this.templateEngine.process("greeting.html", ct);
        assertEquals(result, "<!DOCTYPE HTML>\n"
            + "<html>\n"
            + "<head>\n"
            + "    <title>Name & Date HTML example</title>\n"
            + "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\n"
            + "</head>\n"
            + "<body>\n"
            + "    <p >Hello, foo!!</p>\n"
            + "    <p>Today is 2022-08-17T09:44:13.481551.</p>\n"
            + "\t\t1\n"
            + "\t\t2\n"
            + "\t\t1\n"
            + "</body>\n"
            + "</html>");
        writeSnapshot(testName.getMethodName(), result);
    }

    /**
     * テスト結果をファイルに書き出す。
     * @param name テスト名
     * @param result テスト結果
     */
    private static void writeSnapshot(final String name, final String result) {
        try (final FileWriter filewriter =
            new FileWriter("__snapshot__/" + name + ".html");){
            filewriter.write(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
