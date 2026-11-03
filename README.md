# ShoppingCart — Java 8+ and Jenkins Lab Experiment

A small Maven-based Java shopping cart application with JUnit 4 tests and a declarative Jenkins pipeline.

## Requirements
- JDK 8 or newer
- Apache Maven 3.6+
- Git
- Jenkins with Pipeline and JUnit plugins

## Project structure
```text
ShoppingCart/
├── src/main/java/com/ecommerce/ShoppingCart.java
├── src/test/java/com/ecommerce/ShoppingCartTest.java
├── pom.xml
└── Jenkinsfile
```

## Run locally
From this directory:

```bash
mvn clean package
java -cp target/classes com.ecommerce.ShoppingCart
```

Expected application output:
```text
E-Commerce Shopping Cart
------------------------
Total Amount: Rs.1200.0
Discount: Rs.120.0
Final Amount: Rs.1080.0
```

Expected tests: 4 tests, 0 failures, 0 errors.

## Push to GitHub
Create an empty GitHub repository named `ShoppingCart`, then run:

```bash
git init
git add .
git commit -m "Initial ShoppingCart Java application"
git branch -M main
git remote add origin https://github.com/YOUR_USERNAME/ShoppingCart.git
git push -u origin main
```

Replace `YOUR_USERNAME` with your GitHub username.

## Configure Jenkins
1. Ensure Java and Maven are available to the Jenkins agent through its PATH (or configure them under Manage Jenkins → Tools).
2. Create a new **Pipeline** job named `ShoppingCart-Pipeline`.
3. Under Pipeline, choose **Pipeline script from SCM**.
4. Set SCM to **Git**, enter your repository URL, and set branch to `*/main`.
5. Set Script Path to `Jenkinsfile`, then Save.
6. Select **Build Now** and inspect Console Output and the stage view.

For a public repository, credentials can be left as none. For a private repository, add Git credentials in Jenkins and select them in the job configuration.

## Notes
- The Jenkinsfile uses `checkout scm`, so configure the job as **Pipeline script from SCM**.
- The Jenkins agent must have `mvn` on PATH. If Maven is configured as a Jenkins tool instead, update the pipeline to use that configured tool.
- The package stage runs `mvn package -DskipTests` after the Test stage has already run the tests. This avoids running the same tests twice.
