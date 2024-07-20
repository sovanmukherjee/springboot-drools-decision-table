package org.drools.example.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.drools.example.api.model.DiscountResponse;
import org.drools.example.api.model.State;
import org.drools.example.model.RuleDataset;
import org.drools.example.service.SalesOrderDiscountService;
import org.kie.api.command.Command;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.command.CommandFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SalesOrderDiscountServiceImpl implements SalesOrderDiscountService {

    private final StatelessKieSession statelessKieSession;

    @Override
    public DiscountResponse getDiscount(State state, BigDecimal totalPurchaseAmount) {
        RuleDataset ruleDataset = RuleDataset.builder()
                .stateCode(state.getCode())
                .totalPurchaseAmount(totalPurchaseAmount)
                .payableAmount(totalPurchaseAmount)
                .build();

        RuleDataset ruleOutput = execute(ruleDataset);
        return DiscountResponse.builder()
                .discountAllowed(ruleOutput.isDiscountAllowed())
                .discountRate(ruleOutput.getDiscountRate())
                .totalPurchaseAmount(totalPurchaseAmount)
                .payableAmount(ruleOutput.getPayableAmount())
                .build();
    }

    private RuleDataset execute(final RuleDataset ruleDataset) {
        try {
            ExecutionResults results = statelessKieSession.execute(CommandFactory.newBatchExecution(getCommands(ruleDataset)));
            List<RuleDataset> ruleOutputList = (List<RuleDataset>) results.getValue("output");
            if (null != ruleOutputList && !ruleOutputList.isEmpty()) {
                return ruleOutputList.getFirst();
            }
        } catch (Exception e) {
            log.error("Error while executing rules: ", e);
        }
        return ruleDataset;
    }

    private List<Command> getCommands(final RuleDataset ruleDataset) {
        List<Command> commands = new ArrayList<>();
        commands.add(CommandFactory.newInsert(ruleDataset));
        commands.add(CommandFactory.newFireAllRules());
        commands.add(CommandFactory.newGetObjects(new ClassObjectFilter(RuleDataset.class), "output"));
        return commands;
    }
}
