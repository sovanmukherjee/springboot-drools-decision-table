<head><meta name="google-site-verification" content="3uv5SgM3ZZhVCagdtHTsR4RoG6v6iSb71S5LPBfZIus" /></head>
# Getting Started 🚀 

## [✨ _Spring Boot 3 + Drools + Decision tables_ ✨](https://github.com/sovanmukherjee/springboot-drools-decision-table) 

<img width="123" alt="springboot" src="https://github.com/user-attachments/assets/8dd658a0-7630-4363-8975-f642c203860f">    <img width="123" alt="drools" src="https://github.com/user-attachments/assets/9a232a90-0ef4-4400-98aa-c7632e6eafc8">









### Overview
Drools is an open-source business rule management system (BRMS) that helps businesses automate decision-making by defining rules that determine what actions to take in various situations. Drools is a java-based rules engine that allows you to separate business logic from the application code, making it more easier to maintain, update and reuse.

#### Drools Basics
There are several ways to define rules in Drools, making it flexible and accessible for different users from developers to business analysts. Here are the few primary methods:
1. [Drools Rule Language (DRL):](https://docs.drools.org/8.39.0.Final/drools-docs/docs-website/drools/language-reference/index.html#:~:text=Using%20spreadsheet%20features-,Drools%20Rule%20Language%20(DRL),defining%20and%20describing%20business%20rules.) A native language for writing rules in Drools, similar to Java syntax.
   
    Structure: Rules are written in plain text files with a .drl extension.
   
    Example:
    ```sh
    package package-name
    imports
    globals
    functions
    queries
    rule "rule name"
    // Attributes
    when
        LHS // Conditions
    then
        RHS // Actions
    end
    rule "rule2 name"

    ...
    ```
2. [Decision Tables:](https://docs.jboss.org/drools/release/5.2.0.Final/drools-expert-docs/html/ch06.html) Rules can be defined in spreadsheets, typically Excel.
   
   Advantages: Easier for non-technical users to manage rules in a tabular format. Each row represents a rule with columns for conditions and actions.
   Example:  [discount.xls](https://github.com/sovanmukherjee/springboot-drools-decision-table/blob/main/src/main/resources/rules/discount.xls)

3. [Domain-Specific Languages (DSLs)](https://docs.jboss.org/drools/release/5.3.0.Final/drools-expert-docs/html/ch05.html#d0e6317): Allows creation of a custom language tailored to specific business domains.

   Structure: A DSL file with a .dsl extension is a text file in a line-oriented format. Its entries are used for transforming a DSLR file into a file according to DRL syntax.
   Example:
   ```
   [when]There is a customer with age greater than {age}=Customer(age > {age})
   [then]Approve the customer's loan=approveLoan($customer)
   ```
   <span style="color: green"> In this example we have used Decision Tables by creating excel file spreadsheet inside the spring boot application. </span>  

##### Advantages of Using Decision Tables
1. [Clarity and Readability:](https://github.com/sovanmukherjee/springboot-drools-decision-table/tree/main?tab=readme-ov-file#advantages-of-using-decision-tables) Presents rules in a clear, tabular format that is easy to read and understand.
2. [Visualization:](https://github.com/sovanmukherjee/springboot-drools-decision-table/tree/main?tab=readme-ov-file#advantages-of-using-decision-tables) Provides a visual representation of rules making it easier to identify gaps or overlaps in logic.
3. [Ease of Maintenance:](https://github.com/sovanmukherjee/springboot-drools-decision-table/tree/main?tab=readme-ov-file#advantages-of-using-decision-tables) Simplifies the process of updating rules as changes can be made directly in the table without delving into complex code.
4. [Collaboration:](https://github.com/sovanmukherjee/springboot-drools-decision-table/tree/main?tab=readme-ov-file#advantages-of-using-decision-tables)  Facilitates collaboration between business analysts and developers as both can work from the same table format.
5. [Efficiency:](https://github.com/sovanmukherjee/springboot-drools-decision-table/tree/main?tab=readme-ov-file#advantages-of-using-decision-tables) Reduces redundancy by consolidating multiple related rules into a single table.
6. [Consistency:](https://github.com/sovanmukherjee/springboot-drools-decision-table/tree/main?tab=readme-ov-file#advantages-of-using-decision-tables) Ensures consistent application of rules as the table format reduces the likelihood of errors and omissions.

##### When to Avoid Using Decision Tables
1. [Non-Tabular Logic:](https://github.com/sovanmukherjee/springboot-drools-decision-table/tree/main?tab=readme-ov-file#when-to-avoid-using-decision-tables) When the rules do not fit into a tabular structure or involve complex logic that cannot be easily expressed in a table format. Decision tables are not suitable for rules that require intricate conditional logic or multiple interdependencies that are difficult to represent in rows and columns.
2. [Small Number of Rules:](https://github.com/sovanmukherjee/springboot-drools-decision-table/tree/main?tab=readme-ov-file#when-to-avoid-using-decision-tables) When there are only a few rules to manage. The overhead of setting up and maintaining a decision table might not be justified for a small number of rules, which can be more easily managed directly in code or through simple rule definitions.
3. [Unstructured Rules:](https://github.com/sovanmukherjee/springboot-drools-decision-table/tree/main?tab=readme-ov-file#when-to-avoid-using-decision-tables) Decision tables work best for rules that have a uniform structure. If the rules are too diverse or unstructured, it can be challenging to fit them into a decision table format.
4. [Preference Against Spreadsheets:](https://github.com/sovanmukherjee/springboot-drools-decision-table/tree/main?tab=readme-ov-file#when-to-avoid-using-decision-tables) When there is a dislike or organizational policy against using spreadsheet software like Excel or OpenOffice.org.

### Guides
In this example, we have defined the following rules using a decision table and the application will apply the highest possible discount on the purchase amount.

1. If the total purchase amount is greater than or equal to 60,000 then a maximum highest discount rate 12% will be applied.
  ![image](https://github.com/user-attachments/assets/c741a3dc-b3c0-4071-8728-0fddb8554aad)

2. If the total purchase amount is greater than or equal to 40,000 then 6% discount(3rd highest discount rate) will be applied.
  ![image](https://github.com/user-attachments/assets/2b5e2d51-babd-482d-9d62-54b380c17f77)


3. If the total purchase amount is greater than or equal to 30,000 and if the user is from Arunachal Pradesh, Jammu and Kashmir, Lakshadweep, or Assam then a state-specific discount (2nd  highest discount rate ) will be applied.
 ![image](https://github.com/user-attachments/assets/6933cafa-9178-4757-9f49-92d9b3e3d276)

#####   <span style="color: red"> Q1:  How can you stop rule execution once the first match is found in a decision table? </span>
Approach: You can add an extra ACTION column and have in it "drools.halt();". Then in the row, put some text (such as "Y" or TRUE or "stop", the specific text doesn't matter as long as there is something present)
![image](https://github.com/user-attachments/assets/016daaea-634c-4d30-bbfd-fb05d406fb45)


##### Technologies used in this example
- Spring boot version: 3.3.1
- Drools
- Java version 21

Step 1: Create a spring boot application and add required dependencies

![image](https://github.com/user-attachments/assets/ed198c2e-fc08-4ce9-bf21-0c7ccc6e8351)


Step 2: Creating the Excel spreadsheet drools decision table

![image](https://github.com/user-attachments/assets/6e1bfeb9-87b2-4db4-90b4-0323fbe62389)

DRL format of the above drools decision table:
```sh
package rules;
//generated from Decision Table
import org.drools.example.model.RuleDataset;
import java.math.BigDecimal;
import java.math.RoundingMode;
function boolean hasTotalPurchaseAmountReachedThresholdAmount(BigDecimal totalPurchaseAmount, double thresholdAmount) {
       return totalPurchaseAmount.compareTo(BigDecimal.valueOf(thresholdAmount)) >=  0;
    }

 function BigDecimal getPayableAmount( BigDecimal totalPurchaseAmount, int discountRate) {
        return totalPurchaseAmount
                .subtract(totalPurchaseAmount
                        .multiply(BigDecimal.valueOf(discountRate))
                                .divide(BigDecimal.valueOf(100),2, RoundingMode.UP));
    }

// rule values at A13, header at A8
rule "Total purchase amount  >=  60000"
	salience 65535
	when
		ruleDataset: RuleDataset(hasTotalPurchaseAmountReachedThresholdAmount(ruleDataset.getTotalPurchaseAmount(), 60000))
	then
		ruleDataset.setDiscountAllowed(true) ;
		ruleDataset.setDiscountRate(12);
		ruleDataset.setPayableAmount(getPayableAmount(ruleDataset.getTotalPurchaseAmount(), ruleDataset.getDiscountRate()));
		drools.halt();
end

// rule values at A20, header at A15
rule "Total purchase amount  >=  30000 AND State code is JK"
	salience 65534
	when
		ruleDataset: RuleDataset(hasTotalPurchaseAmountReachedThresholdAmount(ruleDataset.getTotalPurchaseAmount(), 30000), ruleDataset.getStateCode() == "JK")
	then
		ruleDataset.setDiscountAllowed(true) ;
		ruleDataset.setDiscountRate(9);
		ruleDataset.setPayableAmount(getPayableAmount(ruleDataset.getTotalPurchaseAmount(), ruleDataset.getDiscountRate()));
		drools.halt();
end

// rule values at A21, header at A15
rule "Total purchase amount  >=  30000 AND State code LD"
	salience 65533
	when
		ruleDataset: RuleDataset(hasTotalPurchaseAmountReachedThresholdAmount(ruleDataset.getTotalPurchaseAmount(), 30000), ruleDataset.getStateCode() == "LD")
	then
		ruleDataset.setDiscountAllowed(true) ;
		ruleDataset.setDiscountRate(10);
		ruleDataset.setPayableAmount(getPayableAmount(ruleDataset.getTotalPurchaseAmount(), ruleDataset.getDiscountRate()));
		drools.halt();
end

// rule values at A22, header at A15
rule "Total purchase amount  >=  30000 AND State code is  AS"
	salience 65532
	when
		ruleDataset: RuleDataset(hasTotalPurchaseAmountReachedThresholdAmount(ruleDataset.getTotalPurchaseAmount(), 30000), ruleDataset.getStateCode() == "AS")
	then
		ruleDataset.setDiscountAllowed(true) ;
		ruleDataset.setDiscountRate(8);
		ruleDataset.setPayableAmount(getPayableAmount(ruleDataset.getTotalPurchaseAmount(), ruleDataset.getDiscountRate()));
		drools.halt();
end

// rule values at A23, header at A15
rule "Total purchase amount  >=  30000 AND State code are AR"
	salience 65531
	when
		ruleDataset: RuleDataset(hasTotalPurchaseAmountReachedThresholdAmount(ruleDataset.getTotalPurchaseAmount(), 30000), ruleDataset.getStateCode() == "AR")
	then
		ruleDataset.setDiscountAllowed(true) ;
		ruleDataset.setDiscountRate(10);
		ruleDataset.setPayableAmount(getPayableAmount(ruleDataset.getTotalPurchaseAmount(), ruleDataset.getDiscountRate()));
		drools.halt();
end

// rule values at A30, header at A25
rule "Total purchase amount  >=  40000"
	salience 65530
	when
		ruleDataset: RuleDataset(hasTotalPurchaseAmountReachedThresholdAmount(ruleDataset.getTotalPurchaseAmount(), 40000))
	then
		ruleDataset.setDiscountAllowed(true) ;
		ruleDataset.setDiscountRate(6);
		ruleDataset.setPayableAmount(getPayableAmount(ruleDataset.getTotalPurchaseAmount(), ruleDataset.getDiscountRate()));
		drools.halt();
end
```



Step 3: Add the drools configuration in spring boot application

![image](https://github.com/user-attachments/assets/cd0b423d-65c6-4fd2-8c43-f5f09ee07d1b)

We configured 'StatelessKieSession' as a Spring bean to be used in the service layer.

Step 4: Create a REST endpoint

![image](https://github.com/user-attachments/assets/dc39ed86-d55c-41c0-ae40-ff94e4dc2e3f)


Step 5: Add service layer

![image](https://github.com/user-attachments/assets/68fb0e92-dfd2-4ea3-98fd-3c5227e08917)


Step 6: Start the Spring Boot application and open the Swagger endpoint.
![image](https://github.com/user-attachments/assets/45aa2b65-3cf4-426a-8b16-31daca3d0a04)

http://localhost:8080/swagger-ui/index.html
![image](https://github.com/user-attachments/assets/589444ae-85eb-4c80-9dc9-829fc02bb503)


Input-1:
![image](https://github.com/user-attachments/assets/3b793c1d-23b6-4004-9dd3-97154cb1ed46)
Output:
![image](https://github.com/user-attachments/assets/e6996ed0-9eaf-440f-a615-65131d85d2cb)


Input-2:
![image](https://github.com/user-attachments/assets/e1c15e9d-c4ac-4890-a272-65c2a7d0462b)
Output:
![image](https://github.com/user-attachments/assets/ff9372eb-e297-47cf-93b0-3499f8faf79a)


Input-3:
![image](https://github.com/user-attachments/assets/ac9e70ec-8fef-461b-8763-ee40a8d872c6)
Output:
![image](https://github.com/user-attachments/assets/5393c9cd-fca8-4775-8ba7-dd897bc642f5)


Input-4:
![image](https://github.com/user-attachments/assets/c683fa47-03e0-4d7d-a57c-297372bf4511)
Output:
![image](https://github.com/user-attachments/assets/6b091abe-55a8-4303-9e53-745f765902fe)

### Reference Documentation
For further reference, please consider the following sections:

* [Drools Expert User Guide](https://docs.drools.org/6.0.0.Beta2/drools-expert-docs/html_single/)
* [The Rule Engine](https://docs.jboss.org/drools/release/5.2.0.Final/drools-expert-docs/html/ch01.html)
* [Decision Tables](https://docs.jboss.org/drools/release/5.2.0.Final/drools-expert-docs/html/ch06.html)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)
* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)


