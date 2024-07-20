# Getting Started 🚀

## ✨ _Spring Boot 3 + Drools + Decision tables_ ✨

![N|Spring Boot](link) ![N|Java](link) ![N|Drools](link)

### Overview
Drools is an open-source business rule management system (BRMS) that helps businesses automate decision-making by defining rules that determine what actions to take in various situations. Drools is a java-based rules engine that allows you to separate business logic from the application code, making it more easier to maintain, update and reuse.

#### Drools Basics
There are several ways to define rules in Drools, making it flexible and accessible for different users, from developers to business analysts. Here are the few primary methods:
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
   Example:  [discount.xls](link)

3. [Domain-Specific Languages (DSLs)](https://docs.jboss.org/drools/release/5.3.0.Final/drools-expert-docs/html/ch05.html#d0e6317): Allows creation of a custom language tailored to specific business domains.
   Structure: A DSL file with a .dsl extension is a text file in a line-oriented format. Its entries are used for transforming a DSLR file into a file according to DRL syntax.
   Example:
   ```
   [when]There is a customer with age greater than {age}=Customer(age > {age})
   [then]Approve the customer's loan=approveLoan($customer)
   ```
-- $${\color{green} In \space this \space example \space we \space have \space used \space Decision \space Tables \space by \space creating \space excel \space file \space spreadsheet \space inside \space the \space spring \space boot \space application.}$$
##### Advantages of Using Decision Tables
1. [Clarity and Readability:]() Presents rules in a clear, tabular format that is easy to read and understand.
2. [Visualization:]() Provides a visual representation of rules, making it easier to identify gaps or overlaps in logic.
3. [Ease of Maintenance:]() Simplifies the process of updating rules, as changes can be made directly in the table without delving into complex code.
4. [Collaboration:]()  Facilitates collaboration between business analysts and developers, as both can work from the same table format.
5. [Efficiency:]() Reduces redundancy by consolidating multiple related rules into a single table.
6. [Consistency:]() Ensures consistent application of rules, as the table format reduces the likelihood of errors and omissions.

##### When to Avoid Using Decision Tables
1. [Non-Tabular Logic:]() When the rules do not fit into a tabular structure or involve complex logic that cannot be easily expressed in a table format. Decision tables are not suitable for rules that require intricate conditional logic or multiple interdependencies that are difficult to represent in rows and columns.
2. [Small Number of Rules:]() When there are only a few rules to manage. The overhead of setting up and maintaining a decision table might not be justified for a small number of rules, which can be more easily managed directly in code or through simple rule definitions.
3. [Unstructured Rules:]() Decision tables work best for rules that have a uniform structure. If the rules are too diverse or unstructured, it can be challenging to fit them into a decision table format.
4. [Preference Against Spreadsheets:]() When there is a dislike or organizational policy against using spreadsheet software like Excel or OpenOffice.org.

### Guides
In this example, we have defined the following rules using a decision table and the application will apply the highest possible discount on the purchase amount.

1. If the total purchase amount is greater than or equal to 60,000 then a maximum highest discount rate 12% will be applied.
   [image]
2. If the total purchase amount is greater than or equal to 40,000, then 6% discount(3rd maximum highest discount rate) will be applied.
   [image]
3. If the total purchase amount is greater than or equal to 30,000 and if the user is from Arunachal Pradesh, Jammu and Kashmir, Lakshadweep, or Assam then a state-specific discount (2nd maximum highest discount rate ) will be applied.
   [image]

##### Technologies used in this example
- Spring boot version: 3.3.1
- Drools
- Java version 21

Step 1: Create a spring boot application and add required dependencies
[image]

Step 2: Creating the Excel spreadsheet drools decision table
[image]

Step 3: Add the drools configuration in spring boot application
[image]

We configured 'StatelessKieSession' as a Spring bean to be used in the service layer.

Step 4: Create a REST endpoint
[image]

Step 5: Add service layer
[image]

Start the Spring Boot application and navigate to the Swagger endpoint.

http://localhost:8080/swagger-ui/index.html

Input-1:
[image]
Output:
[image]

Input-2:
[image]
Output:
[image]

Input-3:
[image]
Output:
[image]

Input-4:
[image]
Output:
[image]

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

## Features

- Import a HTML file and watch it magically convert to Markdown
- Drag and drop images (requires your Dropbox account be linked)
- Import and save files from GitHub, Dropbox, Google Drive and One Drive
- Drag and drop markdown and HTML files into Dillinger
- Export documents as Markdown, HTML and PDF

Markdown is a lightweight markup language based on the formatting conventions
that people naturally use in email.
As [John Gruber] writes on the [Markdown site][df1]

> The overriding design goal for Markdown's
> formatting syntax is to make it as readable
> as possible. The idea is that a
> Markdown-formatted document should be
> publishable as-is, as plain text, without
> looking like it's been marked up with tags
> or formatting instructions.

This text you see here is *actually- written in Markdown! To get a feel
for Markdown's syntax, type some text into the left window and
watch the results in the right.

## Tech

Dillinger uses a number of open source projects to work properly:

- [AngularJS] - HTML enhanced for web apps!
- [Ace Editor] - awesome web-based text editor
- [markdown-it] - Markdown parser done right. Fast and easy to extend.
- [Twitter Bootstrap] - great UI boilerplate for modern web apps
- [node.js] - evented I/O for the backend
- [Express] - fast node.js network app framework [@tjholowaychuk]
- [Gulp] - the streaming build system
- [Breakdance](https://breakdance.github.io/breakdance/) - HTML
  to Markdown converter
- [jQuery] - duh

And of course Dillinger itself is open source with a [public repository][dill]
on GitHub.

## Installation

Dillinger requires [Node.js](https://nodejs.org/) v10+ to run.

Install the dependencies and devDependencies and start the server.

```sh
cd dillinger
npm i
node app
```

For production environments...

```sh
npm install --production
NODE_ENV=production node app
```

## Plugins

Dillinger is currently extended with the following plugins.
Instructions on how to use them in your own application are linked below.

| Plugin | README |
| ------ | ------ |
| Dropbox | [plugins/dropbox/README.md][PlDb] |
| GitHub | [plugins/github/README.md][PlGh] |
| Google Drive | [plugins/googledrive/README.md][PlGd] |
| OneDrive | [plugins/onedrive/README.md][PlOd] |
| Medium | [plugins/medium/README.md][PlMe] |
| Google Analytics | [plugins/googleanalytics/README.md][PlGa] |

## Development

Want to contribute? Great!

Dillinger uses Gulp + Webpack for fast developing.
Make a change in your file and instantaneously see your updates!

Open your favorite Terminal and run these commands.

First Tab:

```sh
node app
```

Second Tab:

```sh
gulp watch
```

(optional) Third:

```sh
karma test
```

#### Building for source

For production release:

```sh
gulp build --prod
```

Generating pre-built zip archives for distribution:

```sh
gulp build dist --prod
```

## Docker

Dillinger is very easy to install and deploy in a Docker container.

By default, the Docker will expose port 8080, so change this within the
Dockerfile if necessary. When ready, simply use the Dockerfile to
build the image.

```sh
cd dillinger
docker build -t <youruser>/dillinger:${package.json.version} .
```

This will create the dillinger image and pull in the necessary dependencies.
Be sure to swap out `${package.json.version}` with the actual
version of Dillinger.

Once done, run the Docker image and map the port to whatever you wish on
your host. In this example, we simply map port 8000 of the host to
port 8080 of the Docker (or whatever port was exposed in the Dockerfile):

```sh
docker run -d -p 8000:8080 --restart=always --cap-add=SYS_ADMIN --name=dillinger <youruser>/dillinger:${package.json.version}
```

> Note: `--capt-add=SYS-ADMIN` is required for PDF rendering.

Verify the deployment by navigating to your server address in
your preferred browser.

