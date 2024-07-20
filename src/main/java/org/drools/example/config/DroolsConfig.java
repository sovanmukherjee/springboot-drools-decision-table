package org.drools.example.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.InputStream;

@Slf4j
@Configuration
@AllArgsConstructor
public class DroolsConfig {

    private final ResourcePatternResolver resourcePatternResolver;
    private final ConfigProps configProps;

    private static final String RULE_PATH = "/rules/";

    @Bean
    public StatelessKieSession statelessKieSession() {
        KieHelper kieHelper = new KieHelper();
        try {
            InputStream inputStream = getClass().getResourceAsStream(RULE_PATH + configProps.getDiscountRuleFileName());
            SpreadsheetCompiler spreadsheetCompiler = new SpreadsheetCompiler();
            String rule = spreadsheetCompiler.compile(inputStream, InputType.XLS);
            log.info("Rule: {}", rule);
            kieHelper.addContent(rule, ResourceType.DRL);
        } catch (Exception e) {
            log.error("Exception while creating StatelessKieSession bean:", e);
        }
        return kieHelper.getKieContainer().newStatelessKieSession();
    }
}
