# Taco Loco Web Service (TLWS)

Taco Loco, a quick service fleet of taco trucks, is building a new mobile app to enable their customers to place orders for their delicious tacos. 

This is a web service used to calculate order totals. The service will take as input the items and quantities ordered, and respond with the order total.


## About
- Version 0.0.1 of Taco Loco's Web Service (TLWS) has been buit using the following technologies:
```
- Java SE-1.8 (Java SE 11.0.1)
- Spring MVC 
- AWS Elastic Beanstalk 
```

## Easy Access
For easy access, TLWS is hosted using AWS Elastic Beanstalk. Visit this link to test the web application, or send a request:

### Web App URL
```
http://tacoloco.us-east-2.elasticbeanstalk.com/

```
### Sample Request (via AWS or localhost): 

```
http://tacoloco.us-east-2.elasticbeanstalk.com/invoice?vegetableTacoQty=1&chickenTacoQty=33&beefTacoQty=4&chorizoTacoQty=4

```
```
http://localhost:8080/invoice?vegetableTacoQty=1&chickenTacoQty=33&beefTacoQty=4&chorizoTacoQty=4

```

## Setup for IDE (Eclipse and IntelliJ)
You can run TLWS from your IDE as a simple Java application. However, you first need to import your project. Import procedures can vary depending on IDE and operating system. Most IDEs (including Eclipse and IntelliJ) can import Maven projects directly.
```
- Eclipse users can select Import…​ → Existing Maven Projects from the File menu.
```
```
- IntelliJ IDEA users click Import Project. ...
Navigate to your Maven project and select the top-level folder and Click OK.
```
If you cannot directly import your project into your IDE, you may be able to generate IDE metadata by using a build plugin. Maven includes plugins for Eclipse and IDEA. Gradle offers plugins for various IDEs.

## Setup using Maven Plugin
Spring Boot Maven plugin has a run goal that is used to compile and run TLWS. This example shows a Maven command to run a Spring Boot application:
```
$ mvn spring-boot:run
```
You might also want to use the MAVEN_OPTS operating system environment variable, as shown in the following example:
```
$ export MAVEN_OPTS=-Xmx1024m
```

## Setup using Gradle Plugn 
Spring Boot Gradle includes a bootRun task to run TLWS in an exploded form. The bootRun task is utilized whenyou apply the org.springframework.boot and java plugins and is shown in this example:
```
$ gradle bootRun
```
You might also want to use the JAVA_OPTS operating system environment variable, as shown in the following example:
```
$ export JAVA_OPTS=-Xmx1024m
```

## JSON Response Sample 

```
{
"subTotal": 33,
"grandTotal": 26.4,
"chickenTacoQty": 3,
"vegetableTacoQty": 2,
"beefTacoQty": 4,
"chorizoTacoQty": 2,
"discountApplied": true
}
``` 

## JSON Menu Data 

### URL 
```
https://api.myjson.com/bins/1cjv7w
``` 
```
{
"tacos": [
{
"id": 0,
"price": 2.5,
"description": "Vegetable Taco"
},
{
"id": 1,
"price": 3,
"description": "Chicken Taco"
},
{
"id": 2,
"price": 3,
"description": "Beef Taco"
},
{
"id": 3,
"price": 3.5,
"description": "Chorizo Taco"
}
]
}
```

