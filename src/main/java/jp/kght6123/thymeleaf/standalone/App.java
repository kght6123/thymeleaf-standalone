package jp.kght6123.thymeleaf.standalone;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import java.time.LocalDateTime;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        final TemplateEngine templateEngine = createTemplateEngine();
        final Context ct = new Context();
        ct.setVariable("name", "foo");
        ct.setVariable("date", LocalDateTime.now().toString());
        System.out.println(templateEngine.process("greeting.html", ct));
        System.out.println( "Hello World!" );
    }

    public static TemplateEngine createTemplateEngine() {
        final TemplateEngine templateEngine = new TemplateEngine();
        final ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("/templates/");
        resolver.setSuffix(".html");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setTemplateMode(TemplateMode.HTML); // HTML5 option was deprecated in 3.0.0
        templateEngine.setTemplateResolver(resolver);
        return templateEngine;
    }
}
